package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.repos.CollegueRepository;

@Component
public class StartupDataInit {

	@Autowired
	CollegueRepository collegueRepo;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		if (this.collegueRepo.count() <= 0) {
			this.collegueRepo.save(new Collegue(
					"http://wac.2f9ad.chicdn.net/802F9AD/u/joyent.wme/public/wme/assets/ec050984-7b81-11e6-96e0-8905cd656caf.jpg?v=46",
					"cquere", 100, "Cquere", "Cyril", "cquere.cyril@gmail.com", "789 rue de Rennes"));
			this.collegueRepo.save(new Collegue(
					"http://wac.2f9ad.chicdn.net/802F9AD/u/joyent.wme/public/wme/assets/ec050984-7b81-11e6-96e0-8905cd656caf.jpg?v=46",
					"zahour", -100, "Zahour", "Mehdi", "Zahour.Mehdi@gmail.com", "979 rue du Havre"));
			this.collegueRepo.save(new Collegue(
					"http://wac.2f9ad.chicdn.net/802F9AD/u/joyent.wme/public/wme/assets/ec050984-7b81-11e6-96e0-8905cd656caf.jpg?v=46",
					"maxime", 500, "Daniel", "Maxime", "daniel.maxime@gmail.com", "479 rue de Nantes"));
			this.collegueRepo.save(new Collegue(
					"http://wac.2f9ad.chicdn.net/802F9AD/u/joyent.wme/public/wme/assets/ec050984-7b81-11e6-96e0-8905cd656caf.jpg?v=46",
					"alexis", -500, "Daniel", "Alexis", "alexis@gmail.com", "679 rue de Grenoble"));
		}

	}
}
