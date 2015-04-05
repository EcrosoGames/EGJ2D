package ecrosogames.engine.main.gamestate;

import com.badlogic.gdx.Screen;

import ecrosogames.engine.main.Renderable;
import ecrosogames.engine.main.Updatable;

/**
 * A part of the game.
 * 
 * @author Michael Musgrove
 */
public abstract interface IGameState extends Screen, Updatable, Renderable {

	/**
	 * This initializes the IGameState. This should be called only once during
	 * runtime.
	 */
	abstract void init();

	/**
	 * A method that should be used to release any unnecessary resources when
	 * the GameState is changed.
	 */
	public default void dispose() {
		return;
	}
}
