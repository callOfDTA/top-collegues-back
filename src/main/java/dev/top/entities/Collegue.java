package dev.top.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(name = "pseudo", nullable = false, unique = true)
	private String pseudo;

	@Column(name = "imageUrl", nullable = false)
	private String imageUrl;

	@Column(name = "score", nullable = false)
	private int score;

	/**
	 * @param pseudo
	 * @param imageUrl
	 * @param score
	 */
	public Collegue(String pseudo, String imageUrl, int score) {
		this.pseudo = pseudo;
		this.imageUrl = imageUrl;
		this.score = score;
	}

	public Collegue() {

	}

	/**
	 * @return the pseudo
	 */
	public String getPseudo() {
		return pseudo;
	}

	/**
	 * @param pseudo
	 *            the pseudo to set
	 */
	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	/**
	 * @return the imageURL
	 */
	public String getImageUrl() {
		return imageUrl;
	}

	/**
	 * @param photo
	 *            the imageURL to set
	 */
	public void setImageUrl(String photo) {
		this.imageUrl = photo;
	}

	/**
	 * @return the score
	 */
	public int getScore() {
		return score;
	}

	/**
	 * @param score
	 *            the score to set
	 */
	public void setScore(int score) {
		this.score = score;
	}

}
