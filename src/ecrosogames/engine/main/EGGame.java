package ecrosogames.engine.main;

import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;

import ecrosogames.engine.main.gamestate.GameState;
import ecrosogames.engine.main.gamestate.IGameState;

/**
 * An EGJ2D version of the {@link Game} class, so more of EGJ2D's utilities are
 * used.
 * 
 * @author Michael Musgrove
 */
public abstract class EGGame extends Game {

	protected IGameState screen;

	/**
	 * Returns a {@link GameState}, which is just a sub-class of {@link Screen}.
	 */
	@Override
	public GameState getScreen() {
		return (GameState) screen;
	}

	@Deprecated
	@Override
	public void setScreen(Screen screen) {
		if (!(screen instanceof IGameState)) {
			Gdx.app.error("WARNING", "The provided Screen object must be a subclass of an IGameState object!");
		} else setScreen((IGameState) screen);
	}

	/**
	 * Sets the screen to the provided IGameState.
	 * 
	 * @param screen
	 *            The IGameState to set the screen to.
	 */
	public void setScreen(IGameState screen) {
		if (this.screen != null) {
			this.screen.hide();
			this.screen.dispose();
		}
		this.screen = screen;
		this.screen.show();
		if (screen != null) screen.load();
	}
	
	public static EGGame getApplicationListener() {
		return (EGGame) Gdx.app.getApplicationListener();
	}
}
