package ecrosogames.engine.main.gamestate;

import com.badlogic.gdx.Gdx;

/**
 * A GameState is a controller for the current state of the game.
 * 
 * @author Michael Musgrove
 */
public abstract class GameState implements IGameState {

	/**
	 * Creates a new GameState with the width and height of the window.
	 */
	public GameState() {
		this(Gdx.graphics.getWidth(), Gdx.graphics.getHeight());
	}

	/**
	 * Creates a new GameState.
	 * 
	 * @param width
	 *            The width of the GameState.
	 * @param height
	 *            The height of the GameState.
	 */
	public GameState(int width, int height) {
		resize(width, height);
		init();
	}

	/**
	 * In the EGJ2D method, LibGDX's <code>render(float)</code> method is
	 * obsolete. It is recommended that the <code>render()</code> and
	 * <code>update()</code> methods are used, and that the
	 * <code>render()</code> and <code>update()</code> method speeds are set in
	 * the main application's <code>renderGame()</code> and
	 * <code>updateGame()</code> methods.
	 */
	@Deprecated
	@Override
	public void render(float delta) {
		return;
	}
}
