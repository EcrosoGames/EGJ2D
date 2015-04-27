package ecrosogames.engine.main;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public final class EGUtils {

	private static final SpriteBatch batch = new SpriteBatch();
	public static final EGGame app;
	
	static {
		app = (EGGame) Gdx.app.getApplicationListener();
	}

	/**
	 * Returns the universal {@link SpriteBatch}.
	 * 
	 * @return
	 */
	public static SpriteBatch getBatch() {
		return batch;
	}
}
