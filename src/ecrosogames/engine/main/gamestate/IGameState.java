package ecrosogames.engine.main.gamestate;

import com.badlogic.gdx.Screen;

/**
 * A part of the game.
 * 
 * @author Michael Musgrove
 */
public abstract interface IGameState extends Screen {

	/**
	 * This initializes the GameState. This should be called only once during
	 * runtime.
	 */
	abstract void init();

	/**
	 * This method will be called every time the GameState is switched to.
	 */
	public abstract void load();

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
	public default void dispose() {
		return;
	}
}
