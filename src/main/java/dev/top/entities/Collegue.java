package dev.top.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Collegue {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	private String photo;

	private String pseudo;

	private int score;

	public Collegue() {
	}

	public Collegue(String pseudo, String photo, int score) {
		this.pseudo = pseudo;
		this.photo = photo;
		this.score = score;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getphoto() {
		return photo;
	}

	public void setphoto(String photo) {
		this.photo = photo;
	}

	public String getpseudo() {
		return pseudo;
	}

	public void setpseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getscore() {
		return score;
	}

	public void setscore(int score) {
		this.score = score;
	}
}
