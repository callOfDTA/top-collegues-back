package dev.top.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

// TODO: Auto-generated Javadoc
/**
 * The Class Collegue.
 *
 * @author Zahour Mehdi Classe Collegue
 */
@Entity
public class Collegue {

	/** The id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int id;

	/** The url photo. */
	@Column(name = "url_photo")
	private String urlPhoto;

	/** The pseudo. */
	@Column(name = "pseudo")
	private String pseudo;

	/** The score. */
	@Column(name = "score")
	private int score;

	/**
	 * Instantiates a new collegue.
	 *
	 * @param urlPhoto
	 *            the url photo
	 * @param pseudo
	 *            the pseudo
	 * @param score
	 *            the score
	 */
	public Collegue(String urlPhoto, String pseudo, int score) {
		this.urlPhoto = urlPhoto;
		this.pseudo = pseudo;
		this.score = score;
	}

	/**
	 * Instantiates a new collegue.
	 */
	public Collegue() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Gets the url photo.
	 *
	 * @return the photo
	 */
	public String getUrlPhoto() {
		return urlPhoto;
	}

	/**
	 * Sets the url photo.
	 *
	 * @param urlPhoto
	 *            the new url photo
	 */
	public void setUrlPhoto(String urlPhoto) {
		this.urlPhoto = urlPhoto;
	}

	/**
	 * Gets the pseudo.
	 *
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * Sets the pseudo.
	 *
	 * @param pseudo
	 *            the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * Gets the score.
	 *
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * Sets the score.
	 *
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
