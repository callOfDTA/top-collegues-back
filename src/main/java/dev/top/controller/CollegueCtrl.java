package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import dev.top.controller.viewmodel.ActionVM;
import dev.top.controller.viewmodel.CollegueVM;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class CollegueCtrl {

	private final String URI_COL = "http://collegues-api.cleverapps.io/collegues";
	@Autowired
	private CollegueRepo collegueRepo;

	@GetMapping
	public List<Collegue> findAll() {
		return this.collegueRepo.findAll();
	}

	@RequestMapping(value = "{pseudo}", method = RequestMethod.GET)
	public ResponseEntity<?> getCollegueByPseudo(@PathVariable("pseudo") String pseudo) {

		Collegue collegue = collegueRepo.findByPseudo(pseudo);
		if (collegue == null) {
			return ResponseEntity.notFound().build();
		}
		return ResponseEntity.ok(collegue);
	}

	@RequestMapping(value = "{pseudo}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> updateScore(@RequestBody ActionVM actionVM, @PathVariable("pseudo") String pseudo) {
		Collegue collegue = collegueRepo.findByPseudo(pseudo);
		if (collegue == null) {
			return ResponseEntity.notFound().build();
		}

		if (actionVM.getAction().equals(Avis.AIMER)) {
			collegue.setScore(collegue.getScore() + 10);
		} else if (actionVM.getAction().equals(Avis.DETESTER)) {
			collegue.setScore(collegue.getScore() - 5);
		}
		collegueRepo.save(collegue);

		return ResponseEntity.ok(collegue);
	}

	@RequestMapping(path = "/nouveau", method = RequestMethod.POST, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> newCollegue(@RequestBody CollegueVM collegueVM) {
		RestTemplate restTemplate = new RestTemplate();

		/**
		 * On verifie ici que le matricule et le pseudo sont bien present dans
		 * la requete
		 */
		if (collegueVM.getMatricule() == null || collegueVM.getMatricule().equals("")) {
			return ResponseEntity.badRequest().body("Le paramètre matricule est requis");
		} else if (collegueRepo.findByMatricule(collegueVM.getMatricule()) != null) {
			return ResponseEntity.badRequest().body("Le matricule spécifié est deja présent dans la base de données");
		}

		if (collegueVM.getPseudo() == null || collegueVM.getPseudo().equals("")) {
			return ResponseEntity.badRequest().body("Le paramètre pseudo est requis");
		} else if (collegueRepo.findByPseudo(collegueVM.getPseudo().toLowerCase()) != null) {
			return ResponseEntity.badRequest().body("Le pseudo spécifié est deja présent dans la base de données");
		}

		Collegue[] tab = restTemplate.getForObject(URI_COL + "?matricule=" + collegueVM.getMatricule(),
				Collegue[].class);

		if (tab.length == 0) {
			return ResponseEntity.badRequest().body("Le matricule spécifié n'a pas été trouvé");
		}
		Collegue col = tab[0];
		col.setPseudo(collegueVM.getPseudo());
		if (collegueVM.getUrlImage() != null && !collegueVM.getUrlImage().equals("")) {
			col.setPhoto(collegueVM.getUrlImage());
		}
		collegueRepo.save(col);
		return ResponseEntity.ok(col);

	}
}
