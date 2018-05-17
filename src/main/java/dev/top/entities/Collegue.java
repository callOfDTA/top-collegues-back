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

	private String nom;

	private String prenom;

	private String adresse;

	private String email;

	private String matricule;

	public Collegue() {
	}

	public Collegue(String pseudo, String photo, int score, String nom, String prenom, String adresse) {
		super();
		this.photo = photo;
		this.pseudo = pseudo;
		this.score = score;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = prenom + "." + nom + "@gmail.com";
		this.matricule = "M" + this.id;
	}

	public Collegue(String pseudo, String photo, int score, String nom, String prenom, String adresse,
			String matricule) {
		super();
		this.photo = photo;
		this.pseudo = pseudo;
		this.score = score;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = prenom + "." + nom + "@gmail.com";
		this.matricule = matricule;
	}

	public Collegue(String pseudo, String photo, String matricule) {
		super();
		this.photo = photo;
		this.pseudo = pseudo;
		this.score = 0;
		this.nom = "";
		this.prenom = "";
		this.adresse = "";
		this.email = prenom + "." + nom + "@gmail.com";
		this.matricule = matricule;
	}

	public Collegue(String photo, String pseudo, int score, String nom, String prenom, String adresse, String email,
			String matricule) {
		super();
		this.photo = photo;
		this.pseudo = pseudo;
		this.score = score;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
		this.email = email;
		this.matricule = matricule;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPhoto() {
		return photo;
	}

	public void setPhoto(String photo) {
		this.photo = photo;
	}

	public String getPseudo() {
		return pseudo;
	}

	public void setPseudo(String pseudo) {
		this.pseudo = pseudo;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getMatricule() {
		return matricule;
	}

	public void setMatricule(String matricule) {
		this.matricule = matricule;
	}

}