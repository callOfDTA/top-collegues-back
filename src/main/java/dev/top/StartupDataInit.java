package dev.top;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.context.event.EventListener;
import org.springframework.stereotype.Component;

import dev.top.entities.Collegue;
import dev.top.entities.Version;
import dev.top.repos.CollegueRepo;
import dev.top.repos.VersionRepo;

@Component
public class StartupDataInit {

	@Autowired
	VersionRepo versionRepo;

	@Autowired
	CollegueRepo collegueRepo;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		if (this.versionRepo.count() <= 0) {
			this.versionRepo.save(new Version("v1"));
			this.versionRepo.save(new Version("v2"));
			this.versionRepo.save(new Version("v3"));
			this.versionRepo.save(new Version("v4"));
		}

		if (this.collegueRepo.count() <= 0) {
			this.collegueRepo.save(new Collegue("Alexis",
					"https://vignette.wikia.nocookie.net/finalfantasy/images/e/e6/DoC_-_Cait_Sith.png/revision/latest?cb=20120303120336",
					700));
			this.collegueRepo.save(new Collegue("Maxime",
					"https://ds1.static.rtbf.be/jeunesse/heroes/images/banner/65a376f5ad1c0c845162.png", 200));
			this.collegueRepo.save(
					new Collegue("Mehdi", "http://nerdemia.com/wp-content/uploads/2017/02/ff8-squall-close.jpg", 600));
			this.collegueRepo.save(
					new Collegue("Clément", "https://cdn.ndtv.com/tech/images/gadgets/pikachu_hi_pokemon.jpg", -100));

		}

	}
}
