package ecrosogames.engine;

/**
 * The current Development Status of the game.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 */
public enum DevelopmentStatus {
	/**
	 * The development of the game has just begun, and it's in very early stages.
	 */
	Indev("I"),
	/**
	 * The game is still in development, but it has been in development a while
	 * and has made progress.
	 */
	Alpha("A"),
	/**
	 * The game is still in development, but it is nearing an official, or
	 * complete, release.
	 */
	Beta("B"),
	/**
	 * An official, or complete, release of the game.
	 */
	Official("O");

	private String abbreviation;

	private DevelopmentStatus(String abbreviation) {
		this.abbreviation = abbreviation;
	}

	/**
	 * Returns the abbreviation used by the development status.
	 * 
	 * @return
	 */
	public String getAbbreviation() {
		return abbreviation;
	}
}
