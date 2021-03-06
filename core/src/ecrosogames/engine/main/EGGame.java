package ecrosogames.engine.main;

import com.badlogic.gdx.Application;
import com.badlogic.gdx.ApplicationListener;
import com.badlogic.gdx.Game;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Screen;
import com.badlogic.gdx.backends.lwjgl.LwjglApplication;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.GL20;

import ecrosogames.engine.main.gamestate.GameState;
import ecrosogames.engine.main.gamestate.IGameState;

/**
 * An EGJ2D version of the {@link Game} class, so more of EGJ2D's utilities are
 * used.
 * 
 * @author Michael Musgrove
 */
public abstract class EGGame extends Game implements Updatable {

	protected final EGVersion version;
	protected int fps;
	protected int fpsCounter;
	protected long fpsTimer = System.currentTimeMillis();
	protected int updates;
	protected float deltaTime;
	protected int updateRate = 60;

	protected IGameState screen;

	/**
	 * Creates a new {@link Application}.
	 * 
	 * @param version
	 *            The version of the game.
	 * @param dataFolderName
	 *            The name of the data folder that the data will be stored in
	 *            (preferably starting with a period) example: .MyGame
	 * @param config
	 *            The {@link LwjglApplicationConfiguration} that will influence
	 *            the information of the window.
	 */
	public EGGame(EGVersion version, String dataFolderName, LwjglApplicationConfiguration config) {
		this.version = version;
		if (dataFolderName != null) SystemData.setDataFolderName(dataFolderName);
		new LwjglApplication(this, config);
	}

	@Override
	public void create() {
		Gdx.gl.glClearColor(0f, 0f, 0f, 1f);
		init();
	}

	/**
	 * An initialization method. This should be called only once for the
	 * application.
	 */
	protected abstract void init();

	/**
	 * A separate method that should only be used for updating the game.
	 */
	protected abstract void updateGame();

	/**
	 * A separate method that should only be used for rendering the game.
	 */
	protected abstract void renderGame();

	/**
	 * This method is now obsolete in the EGJ2D library. Use
	 * {@link #getGameState()} instead. If this method is used, it will attempt
	 * to cast <code>screen</code> to a {@link GameState}.
	 */
	@Deprecated
	@Override
	public GameState getScreen() {
		return (GameState) screen;
	}

	/**
	 * Returns a {@link GameState}, which is just a sub-class of {@link Screen}.
	 */
	public GameState getGameState() {
		return (GameState) screen;
	}

	/**
	 * Obsolete for EGJ2D. Use {@link #setGameState(IGameState)} instead.
	 */
	@Deprecated
	@Override
	public void setScreen(Screen screen) {
		if (!(screen instanceof IGameState)) {
			Gdx.app.error("WARNING", "The provided Screen object must be a subclass of an IGameState object!");
		} else setGameState((IGameState) screen);
	}

	/**
	 * Sets the screen to the provided IGameState.
	 * 
	 * @param screen
	 *            The IGameState to set the screen to.
	 */
	public void setGameState(IGameState screen) {
		if (this.screen != null) {
			this.screen.hide();
		}
		this.screen = screen;
		this.screen.show();
	}

	@Override
	public void update() {
		deltaTime += Gdx.graphics.getDeltaTime() * updateRate;
		while (deltaTime > 1) {
			deltaTime--;
			updates++;
		}
		updateGame();
	}

	/**
	 * The overridden render() method from {@link ApplicationListener} that does
	 * basic things at the beginning, then calls {@link #renderGame()} and then
	 * {@link #update()}.
	 */
	@Override
	public void render() {
		long systemTime = System.currentTimeMillis();
		if (systemTime - fpsTimer >= 1000) {
			fpsTimer = systemTime;
			fps = fpsCounter;
			oneSecond();
			fpsCounter = 0;
			updates = 0;
		} else fpsCounter++;
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		renderGame();
		update();
	}

	/**
	 * This method is called from {@link #render()} when there is a complete
	 * second difference from the fpsTimer compared to the current
	 * {@link System#currentTimeMillis()}, right before <code>fpsCounter</code>
	 * and <code>updates</code> are set to 0. This could be used to print out
	 * the FPS and Updates, or set their values somewhere.
	 */
	protected void oneSecond() {
		;
	}

	/**
	 * Sets the update rate for the game. This can be changed during the
	 * activity of the application. The default and preferred is 60.
	 * 
	 * @param updateRate
	 *            the rate at which to update.
	 */
	public void setUpdateRate(int updateRate) {
		this.updateRate = updateRate;
	}

	/**
	 * Returns the current version of the game.
	 * 
	 * @return
	 */
	public EGVersion getVersion() {
		return version;
	}

	/**
	 * Returns the current FPS (Frames Per Second) of the game.
	 * 
	 * @return
	 */
	public int getFPS() {
		return fps;
	}

	/**
	 * Returns the current update rate of the game.
	 * 
	 * @return
	 */
	public int getUpdateRate() {
		return updateRate;
	}
}
