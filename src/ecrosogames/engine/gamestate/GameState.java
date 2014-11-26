package ecrosogames.engine.gamestate;

/**
 * A part of the game
 * 
 * @author Michael Musgrove (CoderMusgrove)
 */
public abstract class GameState {

	/**
	 * Creates a new GameState.
	 */
	public GameState() {
		init();
	}

	/**
	 * This initializes the GameState. This should be called only once during
	 * runtime.
	 */
	protected void init() {
		return;
	}

	/**
	 * This method will be called every time the GameState is switched to.
	 */
	public void load() {
		return;
	}

	/**
	 * A method used to update information for the GameState. No rendering
	 * should be done inside of this.
	 */
	public abstract void update();

	/**
	 * A method used to render this GameState.
	 */
	public abstract void render();

	/**
	 * A method that should be used to release any unnecessary resources when
	 * the GameState is changed.
	 */
	public void dispose() {
		return;
	}
}
