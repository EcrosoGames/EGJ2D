package ecrosogames.engine.testing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Preferences;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;

import ecrosogames.engine.main.EGGame;
import ecrosogames.engine.main.EGVersion;

public class TestPreferences extends EGGame {

	public TestPreferences(EGVersion version, String dataFolderName, LwjglApplicationConfiguration config) {
		super(version, dataFolderName, config);
	}

	@Override
	protected void init() {
		Preferences preferences = Gdx.app.getPreferences("TestPreferences.xml");
		preferences.putBoolean("ThisIsATest", true);
		preferences.flush();
		Gdx.app.exit();
	}

	@Override
	protected void updateGame() {

	}

	@Override
	protected void renderGame() {

	}

	public static void main(String... args) {
		new TestPreferences(null, null, new LwjglApplicationConfiguration());
	}
}
