package dev.top;

import java.math.BigDecimal;

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
	CollegueRepo collRepo;

	@EventListener(ContextRefreshedEvent.class)
	public void init() {

		if (this.versionRepo.count() <= 0) {
			this.versionRepo.save(new Version("v1"));
			this.versionRepo.save(new Version("v2"));
			this.versionRepo.save(new Version("v3"));
			this.versionRepo.save(new Version("v4"));
		}
		if (this.collRepo.count() <= 0) {
			this.collRepo.save(new Collegue(
					"http://www.journeefemmeafricaine.com/wp-content/uploads/2017/06/journee-femme-africaine-inspiration-citation-fin-debut-250x250.jpg",
					"MARIE", new BigDecimal(100)));
			this.collRepo.save(
					new Collegue("http://beauteronde.fr/wp-content/uploads/2018/04/adult-beard-blur-713521-250x250.jpg",
							"YVES", new BigDecimal(100)));
			this.collRepo.save(
					new Collegue("http://geneticancer.org/wp-content/uploads/2016/06/vivre-avec-femme-250x250.jpg",
							"NADEJE", new BigDecimal(100)));
			this.collRepo.save(new Collegue(
					"https://upload.wikimedia.org/wikipedia/commons/thumb/f/f3/Nicolas_Cage_-_66%C3%A8me_Festival_de_Venise_%28Mostra%29.jpg/220px-Nicolas_Cage_-_66%C3%A8me_Festival_de_Venise_%28Mostra%29.jpg",
					"NICOLAS", new BigDecimal(100)));
		}

	}
}
