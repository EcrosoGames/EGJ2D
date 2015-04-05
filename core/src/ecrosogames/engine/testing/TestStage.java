package ecrosogames.engine.testing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ecrosogames.engine.main.EGApplication;
import ecrosogames.engine.main.EGUtils;
import ecrosogames.engine.main.EGVersion;

public class TestStage extends EGApplication {

	private Stage stage;

	public TestStage(EGVersion version, String dataFolderName, LwjglApplicationConfiguration config) {
		super(version, dataFolderName, config);
	}

	@Override
	public void init() {
		stage = new Stage(new ScreenViewport(), EGUtils.getBatch());
		TextureAtlas atlas = new TextureAtlas("myskin.atlas");
		Skin skin = new Skin(Gdx.files.internal("myskin.json"), atlas);

		Label lbl = new Label("Test Label", skin);
		
		stage.addActor(lbl);
		
		Gdx.input.setInputProcessor(stage);
	}

	@Override
	protected void updateGame() {
		stage.act();
	}

	@Override
	protected void renderGame() {
		stage.draw();
	}

	public static void main(String[] args) {
		new TestStage(null, null, new LwjglApplicationConfiguration());
	}
}
