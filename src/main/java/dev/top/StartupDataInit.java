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
			this.collegueRepo
					.save(new Collegue("Alexis", "http://www.vetopedia.fr/wp-content/uploads/2017/06/chat_surpris.jpg",
							500, "Vernay", "Alexis", "grenoble"));
			this.collegueRepo.save(new Collegue("Maxime",
					"https://static.wamiz.fr/images/animaux/chiens/large/berger-blanc-suisse.jpg", 850, "DANIEL",
					"Maxime", "NANTES"));
			this.collegueRepo.save(new Collegue("Cyril",
					"https://lolstatic-a.akamaihd.net/frontpage/apps/prod/LolGameInfo-Harbinger/fr_FR/8588e206d560a23f4d6dd0faab1663e13e84e21d/assets/assets/images/gi-landing-top.jpg",
					-150, "QUERRE", "Cyril", "RENNES"));
		}

	}
}
