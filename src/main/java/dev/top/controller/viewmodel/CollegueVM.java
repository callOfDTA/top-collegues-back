package dev.top.controller.viewmodel;

// TODO: Auto-generated Javadoc
/**
 * The Class CollegueVM.
 * 
 * @author Zahour Mehdi
 */
public class CollegueVM {

	/** The matricule. */
	private String matricule;

	/** The pseudo. */
	private String pseudo;

	/** The url image. */
	private String urlImage;

	/**
	 * Instantiates a new collegue VM.
	 */
	public CollegueVM() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * Instantiates a new collegue VM.
	 *
	 * @param matricule
	 *            the matricule
	 * @param pseudo
	 *            the pseudo
	 * @param urlImage
	 *            the url image
	 */
	public CollegueVM(String matricule, String pseudo, String urlImage) {
		super();
		this.matricule = matricule;
		this.pseudo = pseudo;
		this.urlImage = urlImage;
	}

	/**
	 * Gets the matricule.
	 *
	 * @return the matricule
	 */
	public String getMatricule() {
		return matricule;
	}

	/**
	 * Sets the matricule.
	 *
	 * @param matricule
	 *            the matricule to set
	 */
	public void setMatricule(String matricule) {
		this.matricule = matricule;
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
	 * Gets the url image.
	 *
	 * @return the urlImage
	 */
	public String getUrlImage() {
		return urlImage;
	}

	/**
	 * Sets the url image.
	 *
	 * @param urlImage
	 *            the urlImage to set
	 */
	public void setUrlImage(String urlImage) {
		this.urlImage = urlImage;
	}

}
