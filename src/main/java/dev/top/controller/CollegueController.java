package dev.top.controller;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import dev.top.entities.Action;
import dev.top.entities.Avis;
import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepo;

@RestController()
@RequestMapping("/collegues")
public class CollegueController {
	@Autowired
	private CollegueRepo collRepo;

	@GetMapping
	public List<Collegue> findAll() {
		return this.collRepo.findAll();
	}

	@RequestMapping(method = RequestMethod.PATCH, value = "/{pseudo}")
	public Collegue editScore(@PathVariable String pseudo, @RequestBody Action act) {
		Collegue collPseudo = this.collRepo.findByPseudo(pseudo);
		if (act.getAction().equals(Avis.AIMER)) {
			collPseudo.setScore(collPseudo.getScore().add(new BigDecimal(10)));
		}
		if (act.getAction().equals(Avis.DETESTER)) {
			collPseudo.setScore(collPseudo.getScore().subtract(new BigDecimal(5)));
		}
		collRepo.save(collPseudo);
		return collPseudo;
	}
}
