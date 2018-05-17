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

import dev.top.entities.ActionIhm;
import dev.top.entities.Collegue;
import dev.top.entities.CollegueIhm;
import dev.top.repos.CollegueRepo;
import dev.top.service.ActionService;

@RestController()
@CrossOrigin
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
	private RestTemplate rt;

	@Autowired
	ActionService as;

	@Autowired
	private CollegueRepo collegueRepo;

	@GetMapping
	public List<Collegue> findAll() {
		return this.collegueRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.PATCH, path = "/{pseudo}")
	public Collegue collegueScore(@PathVariable String pseudo, @RequestBody ActionIhm actionIhm) {
		collegueRepo.save(as.modifScore(this.collegueRepo.findByPseudo(pseudo), actionIhm));
		return this.collegueRepo.findByPseudo(pseudo);
	}

	@RequestMapping(method = RequestMethod.GET, path = "/{pseudo}")
	public Collegue collegueScore(@PathVariable String pseudo) {
		return this.collegueRepo.findByPseudo(pseudo);
	}

	@RequestMapping(method = RequestMethod.POST, path = "/nouveau", consumes = MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<?> ajouterCollegue(@RequestBody CollegueIhm collegueIhm) {
		Collegue[] collegue = rt.getForObject(
				"http://collegues-api.cleverapps.io/collegues?matricule=" + collegueIhm.getMatricule(),
				Collegue[].class);
		if (collegue.length != 0) {
			this.collegueRepo.save(new Collegue(collegue[0].getPhoto(), collegueIhm.getPseudo(), collegue[0].getScore(),
					collegue[0].getNom(), collegue[0].getPrenom(), collegue[0].getAdresse(), collegue[0].getEmail(),
					collegue[0].getMatricule()));
		} else {
			return ResponseEntity.badRequest().body("Le matricule spécifié n'a pas été trouvé");
		}

		Collegue col = collegue[0];
		return ResponseEntity.ok(col);
	}
}
