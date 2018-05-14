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
			this.collegueRepo.save(new Collegue("", "Cyril", 100));
			this.collegueRepo.save(new Collegue("", "Mehdi", -100));
			this.collegueRepo.save(new Collegue("", "Maxime", 500));
			this.collegueRepo.save(new Collegue("", "Alexis", -500));
		}

	}
}
