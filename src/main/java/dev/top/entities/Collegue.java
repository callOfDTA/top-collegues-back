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
	@Column(name = "photo")
	private String photo;

	/** The pseudo. */
	@Column(name = "pseudo")
	private String pseudo;

	/** The score. */
	@Column(name = "score")
	private int score;

	@Column(name = "nom")
	private String nom;

	@Column(name = "prenom")
	private String prenom;

	@Column(name = "email")
	private String email;

	@Column(name = "adresse")
	private String adresse;

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
		this.photo = urlPhoto;
		this.pseudo = pseudo;
		this.score = score;
	}

	/**
	 * @param urlPhoto
	 * @param pseudo
	 * @param score
	 * @param nom
	 * @param prenom
	 * @param email
	 * @param adresse
	 */
	public Collegue(String urlPhoto, String pseudo, int score, String nom, String prenom, String email,
			String adresse) {
		super();
		this.photo = urlPhoto;
		this.pseudo = pseudo.toLowerCase();
		this.score = score;
		this.nom = nom;
		this.prenom = prenom;
		this.email = email;
		this.adresse = adresse;
	}

	/**
	 * Instantiates a new collegue.
	 */
	public Collegue() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @return the photo
	 */
	public String getPhoto() {
		return photo;
	}

	/**
	 * @param photo
	 *            the photo to set
	 */
	public void setPhoto(String photo) {
		this.photo = photo;
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

	/**
	 * @return the nom
	 */
	public String getNom() {
		return nom;
	}

	/**
	 * @param nom
	 *            the nom to set
	 */
	public void setNom(String nom) {
		this.nom = nom;
	}

	/**
	 * @return the prenom
	 */
	public String getPrenom() {
		return prenom;
	}

	/**
	 * @param prenom
	 *            the prenom to set
	 */
	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	/**
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * @param email
	 *            the email to set
	 */
	public void setEmail(String email) {
		this.email = email;
	}

	/**
	 * @return the adresse
	 */
	public String getAdresse() {
		return adresse;
	}

	/**
	 * @param adresse
	 *            the adresse to set
	 */
	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

}
