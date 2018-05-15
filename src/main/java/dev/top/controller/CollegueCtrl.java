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

	@RequestMapping(value = "{pseudo}", method = RequestMethod.GET)
	public ResponseEntity<?> getCollegueByPseudo(@PathVariable("pseudo") String pseudo) {

		Collegue collegueUp = collegueRepo.findByPseudo(pseudo);

		return ResponseEntity.ok(collegueUp);
	}

	/**
	 * Partial update score.
	 *
	 * @param updates
	 *            the updates
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
}
