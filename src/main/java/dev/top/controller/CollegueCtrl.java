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

import dev.top.controller.viewmodel.ActionVM;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@CrossOrigin
@RestController
@RequestMapping("/collegues")
public class CollegueCtrl {

	@Autowired
	private CollegueRepo collegueRepo;

	@GetMapping
	public List<Collegue> findAll() {
		return this.collegueRepo.findAll();
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
}
