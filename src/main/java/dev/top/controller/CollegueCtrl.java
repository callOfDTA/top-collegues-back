package dev.top.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

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

	@RequestMapping(method = RequestMethod.POST, path = "/nouveau")
	public void ajouterCollegue(@RequestBody CollegueIhm collegueIhm) {
		this.collegueRepo
				.save(new Collegue(collegueIhm.getPseudo(), collegueIhm.getUrlImage(), collegueIhm.getMatricule()));
	}
}
