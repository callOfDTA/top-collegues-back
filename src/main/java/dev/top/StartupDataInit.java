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
			this.collegueRepo.save(new Collegue("Rod",
					"https://images.pexels.com/photos/265036/pexels-photo-265036.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb",
					100, "Doudou", "Robert", "robert.doudou@toto.net", "Impasse des Lilas"));
			this.collegueRepo.save(new Collegue("Alice",
					"https://images.pexels.com/photos/265036/pexels-photo-265036.jpeg?w=1260&h=750&auto=compress&cs=tinysrgb",
					800, "Cepage", "Aline", "alice.cepage@titi.org", "Avenue des Hortensias"));
		}

	}
}
