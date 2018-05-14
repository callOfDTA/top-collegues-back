package dev.top.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import dev.top.entities.Collegue;

// TODO: Auto-generated Javadoc
/**
 * The Interface CollegueRepository.
 */
public interface CollegueRepository extends JpaRepository<Collegue, Integer> {

	/**
	 * Find by pseudo.
	 *
	 * @param pseudo
	 *            the pseudo
	 * @return the collegue
	 */
	Collegue findByPseudo(String pseudo);
}
