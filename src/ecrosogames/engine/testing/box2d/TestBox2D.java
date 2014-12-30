package ecrosogames.engine.testing.box2d;

import java.util.Random;

import box2dLight.ConeLight;
import box2dLight.PointLight;
import box2dLight.RayHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.BodyDef.BodyType;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.PolygonShape;
import com.badlogic.gdx.physics.box2d.World;

import ecrosogames.engine.main.EGApplication;
import ecrosogames.engine.main.EGVersion;

public class TestBox2D extends EGApplication {

	OrthographicCamera camera;
	World world;
	Box2DDebugRenderer debugRenderer;
	float width;
	float height;

	RayHandler handler;
	int counter = 0;
	Random random;

	public TestBox2D(EGVersion version, String dataFolderName, LwjglApplicationConfiguration config) {
		super(version, dataFolderName, config);
	}

	@Override
	protected void init() {
		width = Gdx.graphics.getWidth() / 5;
		height = Gdx.graphics.getHeight() / 5;

		camera = new OrthographicCamera(width, height);
		camera.position.set(width * 0.5f, height * 0.5f, 0);
		camera.update();

		world = new World(new Vector2(0, -9.8f), false);

		debugRenderer = new Box2DDebugRenderer();

		random = new Random();

		spawnCircleFixture();

		BodyDef groundBodyDef = new BodyDef();
		groundBodyDef.type = BodyType.StaticBody;
		groundBodyDef.position.set(0, 3);

		Body groundBody = world.createBody(groundBodyDef);

		PolygonShape groundBox = new PolygonShape();
		groundBox.setAsBox(camera.viewportWidth, 3f);

		groundBody.createFixture(groundBox, 0f);

		BodyDef tileBodyDef = new BodyDef();
		tileBodyDef.type = BodyType.StaticBody;
		tileBodyDef.position.set(Gdx.graphics.getHeight() - 1, 5);

		Body tileBody = world.createBody(tileBodyDef);

		PolygonShape tileBox = new PolygonShape();
		tileBox.setAsBox(5, 1);

		tileBody.createFixture(tileBox, 0f);

		handler = new RayHandler(world);
		handler.setCombinedMatrix(camera.combined);

		new PointLight(handler, 1000, Color.CYAN, 300, width / 2 - 50, height / 2 + 15);
		new PointLight(handler, 1000, Color.RED, 300, width / 2 + 50, height / 2 + 15);
		new ConeLight(handler, 1000, Color.WHITE, 200, width / 2 + 50, height / 2 - 20, 270, 20);
	}

	private void spawnCircleFixture() {
		BodyDef circleDef = new BodyDef();
		circleDef.type = BodyType.DynamicBody;
		circleDef.position.set(random.nextInt((int) width), random.nextInt((int) height - 20) + 20);
		Body circleBody = world.createBody(circleDef);

		CircleShape circleShape = new CircleShape();
		circleShape.setRadius(3f);

		FixtureDef circleFixture = new FixtureDef();
		circleFixture.shape = circleShape;
		circleFixture.density = 1.2f;
		circleFixture.friction = 0f;
		circleFixture.restitution = 0.99f;

		circleBody.createFixture(circleFixture);
	}

	@Override
	protected void updateGame() {
		world.step(1 / 30f, 6, 2);
		handler.update();

		counter++;
		if (counter >= 10) {
			counter = 0;
			spawnCircleFixture();
		}
	}

	@Override
	protected void renderGame() {
		Gdx.gl.glClearColor(0, 0, 0, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);

		debugRenderer.render(world, camera.combined);
		handler.render();
	}

	@Override
	public void dispose() {
		world.dispose();
	}

	public static void main(String[] args) {
		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
		new TestBox2D(null, null, config);
	}
}
