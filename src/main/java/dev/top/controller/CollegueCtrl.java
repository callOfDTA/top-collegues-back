package dev.top.controller;

import java.util.List;
import java.util.stream.Stream;

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

import dev.top.controller.viewmodel.CollegueVM;
import dev.top.entities.Action;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepository;

// TODO: Auto-generated Javadoc
/**
 * The Class CollegueCtrl.
 */
@RestController()
@CrossOrigin
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
	RestTemplate rt;
	final String API_URL = "http://collegues-api.cleverapps.io/collegues";

	/** The collegue repo. */
	@Autowired
	private CollegueRepository collegueRepo;

	/**
	 * Find all.
	 *
	 * @return the list
	 */
	@GetMapping
	public List<Collegue> findAll() {
		return this.collegueRepo.findAll();
	}

	/**
	 * Gets the collegue by pseudo.
	 *
	 * @param pseudo
	 *            the pseudo
	 * @return the collegue by pseudo
	 */
	@RequestMapping(value = "{pseudo}", method = RequestMethod.GET)
	public ResponseEntity<?> getCollegueByPseudo(@PathVariable("pseudo") String pseudo) {

		Collegue collegueUp = collegueRepo.findByPseudo(pseudo);

		return ResponseEntity.ok(collegueUp);
	}

	/**
	 * Partial update score.
	 *
	 * @param action
	 *            the action
	 * @param pseudo
	 *            the pseudo
	 * @return the collegue
	 */
	@RequestMapping(value = "{pseudo}", method = RequestMethod.PATCH, consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> partialUpdateScore(@RequestBody Action action, @PathVariable("pseudo") String pseudo) {

		Collegue collegueUp = collegueRepo.findByPseudo(pseudo);

		if (action.getAction().equals(Avis.AIMER)) {
			collegueUp.setScore(collegueUp.getScore() + 10);

		} else if (action.getAction().equals(Avis.DETESTER)) {
			collegueUp.setScore(collegueUp.getScore() - 5);

		}

		collegueRepo.save(collegueUp);
		return ResponseEntity.ok(collegueUp);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> postCollegue(@RequestBody CollegueVM collegueVM) {

		if (collegueVM.getMatricule().equals("") || collegueVM.getMatricule() == null) {
			return ResponseEntity.badRequest().body("Vous n'avez pas entré de Matricule");
		} else if (collegueRepo.findByMatricule(collegueVM.getMatricule()) != null) {
			return ResponseEntity.badRequest().body("Le matricule existe déjà !");
		}

		if (collegueVM.getPseudo().equals("") || collegueVM.getPseudo() == null) {
			return ResponseEntity.badRequest().body("Vous n'avez pas entré de Pseudo");
		} else if (collegueRepo.findByPseudo(collegueVM.getPseudo()) != null) {
			return ResponseEntity.badRequest().body("Le pseudo existe déjà !");
		}

		// + "?matricule=" + collegueVM.getMatricule()

		Collegue[] response = rt.getForObject(API_URL + "?matricule=" + collegueVM.getMatricule(), Collegue[].class);

		if (response.length == 0) {
			return ResponseEntity.badRequest().body("Le matricule n'existe pas !");
		}
		Collegue col = Stream.of(response).filter(c -> c.getMatricule().equals(collegueVM.getMatricule())).findAny()
				.get();

		col.setPseudo(collegueVM.getPseudo());

		if (collegueVM.getUrlImage() != null && !(collegueVM.getUrlImage().equals(""))) {
			col.setPhoto(collegueVM.getUrlImage());
		}

		collegueRepo.save(col);
		return ResponseEntity.ok(col);
	}

}
