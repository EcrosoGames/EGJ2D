package ecrosogames.engine;

/**
 * Expresses the version of the game.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 *
 */
public class EGVersion {

	private String version;
	private int release;
	private int update;
	private int snapshot;
	private DevelopmentStatus status;

	/**
	 * Constructs a new Version
	 * 
	 * @param release
	 *            The release number.
	 * @param update
	 *            The update number.
	 * @param snapshot
	 *            The snapshot number.
	 * @param status
	 *            The development status.
	 */
	public EGVersion(int release, int update, int snapshot, DevelopmentStatus status) {
		this.release = release;
		this.update = update;
		this.snapshot = snapshot;
		this.status = status;
		this.version = release + "." + update + "." + snapshot + "_" + status;
	}

	/**
	 * Returns the release number.
	 * 
	 * @return
	 */
	public int getRelease() {
		return release;
	}

	/**
	 * Returns the update number.
	 * 
	 * @return
	 */
	public int getUpdate() {
		return update;
	}

	/**
	 * Returns the snapshot number.
	 * 
	 * @return
	 */
	public int getSnapshot() {
		return snapshot;
	}

	/**
	 * Returns the development status.
	 * 
	 * @return
	 */
	public DevelopmentStatus getDevelopmentStatus() {
		return status;
	}

	/**
	 * Returns the complete String of the Version in the format of: <br>
	 * <em>release</em>.<em>update</em>.<em>snapshot</em>_
	 * <em>developmentStatus</em><br>
	 * <strong>NOTE:</strong> developmentStatus uses the
	 * {@link DevelopmentStatus#getAcronym()}.
	 * 
	 * @return
	 */
	public String getVersion() {
		return version;
	}
}
