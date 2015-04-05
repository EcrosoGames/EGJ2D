package ecrosogames.engine.main;

import com.badlogic.gdx.graphics.g2d.SpriteBatch;

public final class EGUtils {

	private static final SpriteBatch batch = new SpriteBatch();

	/**
	 * Returns the universal {@link SpriteBatch}.
	 * 
	 * @return
	 */
	public static SpriteBatch getBatch() {
		return batch;
	}
}
