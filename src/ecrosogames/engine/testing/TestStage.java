package ecrosogames.engine.testing;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.Input.Buttons;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.g2d.TextureAtlas;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.scenes.scene2d.ui.Label;
import com.badlogic.gdx.scenes.scene2d.ui.Label.LabelStyle;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar;
import com.badlogic.gdx.scenes.scene2d.ui.ProgressBar.ProgressBarStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Skin;
import com.badlogic.gdx.scenes.scene2d.ui.Slider;
import com.badlogic.gdx.scenes.scene2d.ui.Slider.SliderStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextArea;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton;
import com.badlogic.gdx.scenes.scene2d.ui.TextButton.TextButtonStyle;
import com.badlogic.gdx.scenes.scene2d.ui.TextField;
import com.badlogic.gdx.scenes.scene2d.ui.TextField.TextFieldStyle;
import com.badlogic.gdx.scenes.scene2d.ui.Tree;
import com.badlogic.gdx.scenes.scene2d.ui.Tree.Node;
import com.badlogic.gdx.scenes.scene2d.ui.Tree.TreeStyle;
import com.badlogic.gdx.scenes.scene2d.utils.ClickListener;
import com.badlogic.gdx.utils.viewport.ScreenViewport;

import ecrosogames.engine.main.EGApplication;
import ecrosogames.engine.main.EGVersion;

public class TestStage extends EGApplication {

	private Stage stage;

	public TestStage(EGVersion version, String dataFolderName, LwjglApplicationConfiguration config) {
		super(version, dataFolderName, config);
	}

	@Override
	public void init() {
		stage = new Stage(new ScreenViewport(), getBatch());
		TextureAtlas atlas = new TextureAtlas("uiskin.atlas");
		Skin skin = new Skin(Gdx.files.internal("uiskin.json"), atlas);

		TextButtonStyle btnStyle = skin.get("default", TextButtonStyle.class);
		TextButton btn = new TextButton("Test Button", btnStyle);

		TextFieldStyle txtFieldStyle = skin.get("default", TextFieldStyle.class);
		TextField txtField = new TextField("", txtFieldStyle);
		txtField.setHeight(50);
		txtField.setWidth(Gdx.graphics.getWidth());
		txtField.setPosition(0, Gdx.graphics.getHeight() - txtField.getHeight());

		TextArea txtArea = new TextArea("", skin);
		txtArea.setSize(200, 200);
		txtArea.setPosition(0, Gdx.graphics.getHeight() / 2 - txtArea.getHeight() / 2);

		ProgressBar prgBar = new ProgressBar(0, 100, 1, false, skin.get("default-horizontal", ProgressBarStyle.class));
		prgBar.setX(btn.getWidth() + 5);
		prgBar.setValue(50);

		Slider slider = new Slider(0, 100, 1, false, skin.get("default-horizontal", SliderStyle.class));
		slider.setX(prgBar.getX() + prgBar.getWidth() + 5);
		
		Tree tree = new Tree(skin.get("default", TreeStyle.class));
		tree.setPosition(Gdx.graphics.getWidth() / 2, Gdx.graphics.getHeight() - txtField.getHeight() - 5);

		LabelStyle lblStyle = skin.get("default", LabelStyle.class);
		Label lblAlamo = new Label("Alamo", lblStyle);

		Label lblRemember = new Label("Remember", lblStyle);
		Node subNode0 = new Node(lblRemember);
		
		Node node = new Node(lblAlamo);
		node.add(subNode0);
		
		Label lblTest = new Label("Test", lblStyle);
		
		Node node2 = new Node(lblTest);
		
		tree.add(node);
		tree.add(node2);
		
		node.getActor().addListener(new ClickListener() {
			@Override
			public void clicked(InputEvent e, float x, float y) {
				node.expandTo();
			}
		});

		btn.addListener(new ClickListener(Buttons.LEFT) {
			@Override
			public void clicked(InputEvent e, float x, float y) {
				prgBar.setValue(prgBar.getValue() + 1);
			}
		});

		stage.addActor(btn);
		stage.addActor(txtField);
		stage.addActor(txtArea);
		stage.addActor(prgBar);
		stage.addActor(slider);
		stage.addActor(tree);

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
