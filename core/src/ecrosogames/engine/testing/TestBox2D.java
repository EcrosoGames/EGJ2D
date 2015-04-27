package ecrosogames.engine.testing;

import box2dLight.RayHandler;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.backends.lwjgl.LwjglApplicationConfiguration;
import com.badlogic.gdx.graphics.OrthographicCamera;
import com.badlogic.gdx.math.Vector2;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.BodyDef;
import com.badlogic.gdx.physics.box2d.Box2DDebugRenderer;
import com.badlogic.gdx.physics.box2d.CircleShape;
import com.badlogic.gdx.physics.box2d.FixtureDef;
import com.badlogic.gdx.physics.box2d.World;
import com.badlogic.gdx.utils.Array;

import ecrosogames.engine.main.EGGame;
import ecrosogames.engine.main.EGVersion;

//public class TestBox2D extends EGGame {
//
//	OrthographicCamera camera;
//	World world;
//	Box2DDebugRenderer debugRenderer;
//	float width;
//	float height;
//
//	RayHandler handler;
//	Random random;
//	// Body circleBody;
//	Body groundBody;
//	boolean allowJump;
//
//	public TestBox2D(EGVersion version, String dataFolderName, LwjglApplicationConfiguration config) {
//		super(version, dataFolderName, config);
//	}
//
//	@Override
//	protected void init() {
//		width = Gdx.graphics.getWidth() / 5;
//		height = Gdx.graphics.getHeight() / 5;
//
//		camera = new OrthographicCamera(width, height);
//		camera.position.set(width / 2, height / 2, 0);
//		camera.update();
//
//		world = new World(new Vector2(0, -9.8f), true);
//
//		debugRenderer = new Box2DDebugRenderer();
//
//		random = new Random();
//
//		// spawnCircleFixture();
//
//		BodyDef groundBodyDef = new BodyDef();
//		groundBodyDef.type = BodyType.StaticBody;
//		groundBodyDef.position.set(0, 3);
//
//		groundBody = world.createBody(groundBodyDef);
//
//		PolygonShape groundBox = new PolygonShape();
//		groundBox.setAsBox(camera.viewportWidth, 3f);
//
//		FixtureDef groundFixture = new FixtureDef();
//		groundFixture.friction = 100f;
//		groundFixture.shape = groundBox;
//		groundBody.createFixture(groundFixture);
//
//		BodyDef tileBodyDef = new BodyDef();
//		tileBodyDef.type = BodyType.StaticBody;
//		tileBodyDef.position.set(Gdx.graphics.getHeight() - 1, 5);
//
//		Body tileBody = world.createBody(tileBodyDef);
//
//		PolygonShape tileBox = new PolygonShape();
//		tileBox.setAsBox(5, 1);
//
//		tileBody.createFixture(tileBox, 0f);
//
//		handler = new RayHandler(world);
//		handler.setCombinedMatrix(camera.combined);
//
//		// Remove these, see nothing.
//		new PointLight(handler, 1000, Color.CYAN, 300, width / 2 - 50, height / 2 + 15);
//		new PointLight(handler, 1000, Color.RED, 300, width / 2 + 50, height / 2 + 15);
//		new ConeLight(handler, 1000, Color.WHITE, 200, width / 2 + 50, height / 2 - 20, 270, 20);
//	}
//
//	// private void spawnCircleFixture() {
//	// BodyDef circleDef = new BodyDef();
//	// circleDef.type = BodyType.DynamicBody;
//	// circleDef.position.set(random.nextInt((int) width), random.nextInt((int)
//	// height - 20) + 20);
//	// circleBody = world.createBody(circleDef);
//	//
//	// CircleShape circleShape = new CircleShape();
//	// circleShape.setRadius(2f);
//	//
//	// FixtureDef circleFixture = new FixtureDef();
//	// circleFixture.shape = circleShape;
//	// circleFixture.density = 1f;
//	// circleFixture.friction = 10f;
//	// circleFixture.restitution = 0.5f;
//	//
//	// circleBody.createFixture(circleFixture);
//	//
//	// world.setContactListener(new ContactListener() {
//	// @Override
//	// public void preSolve(Contact contact, Manifold oldManifold) {
//	//
//	// }
//	//
//	// @Override
//	// public void postSolve(Contact contact, ContactImpulse impulse) {
//	//
//	// }
//	//
//	// @Override
//	// public void endContact(Contact contact) {
//	// Fixture fixtureA = contact.getFixtureA();
//	// Fixture fixtureB = contact.getFixtureB();
//	// if (circleBody.getFixtureList().contains(fixtureA, true) ||
//	// circleBody.getFixtureList().contains(fixtureB, true)) {
//	// allowJump = false;
//	// }
//	// }
//	//
//	// @Override
//	// public void beginContact(Contact contact) {
//	// Fixture fixtureA = contact.getFixtureA();
//	// Fixture fixtureB = contact.getFixtureB();
//	// if (circleBody.getFixtureList().contains(fixtureA, true) ||
//	// circleBody.getFixtureList().contains(fixtureB, true)) {
//	// allowJump = true;
//	// }
//	// }
//	// });
//	// }
//
//	@Override
//	protected void updateGame() {
//		world.step(1 / 30f, 6, 2);
//		handler.update();
//		// if (counter >= 10) {
//		// counter = 0;
//		// spawnCircleFixture();
//		// }
//		// circleBody.setLinearVelocity(new Vector2(0,
//		// circleBody.getLinearVelocity().y));
//		// checkInput();
//	}
//
//	// private void checkInput() {
//	// Input input = Gdx.input;
//	//
//	// if (input.isKeyPressed(Keys.LEFT)) {
//	// circleBody.applyForceToCenter(new Vector2(-250 * circleBody.getMass(),
//	// 0), false);
//	// } else if (input.isKeyPressed(Keys.RIGHT)) {
//	// circleBody.applyForceToCenter(new Vector2(250 * circleBody.getMass(), 0),
//	// false);
//	// }
//	// if (input.isKeyPressed(Keys.SPACE)) {
//	// if (allowJump) circleBody.applyForceToCenter(new Vector2(0, 250 *
//	// circleBody.getMass()), false);
//	// }
//	// }
//
//	@Override
//	protected void renderGame() {
//		Gdx.gl.glClearColor(0, 0, 0, 1);
//		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
//
//		debugRenderer.render(world, camera.combined);
//		handler.render();
//	}
//
//	@Override
//	public void dispose() {
//		world.dispose();
//	}
//
//	public static void main(String[] args) {
//		LwjglApplicationConfiguration config = new LwjglApplicationConfiguration();
//		new TestBox2D(null, null, config);
//	}
//}

public class TestBox2D extends EGGame {

	int width;
	int height;

	static final Vector2 ZERO_GRAVITY = new Vector2(0f, 0f);

	OrthographicCamera camera;
	World world;
	Body body;
	Box2DDebugRenderer box2dDebugRenderer;
	RayHandler rayHandler;
	Array<Body> bodies;

	public TestBox2D(EGVersion version, String dataFolderName, LwjglApplicationConfiguration config) {
		super(version, dataFolderName, config);
	}

	@Override
	protected void init() {
		width = Gdx.graphics.getWidth()/4;
		height = Gdx.graphics.getHeight()/4;
		camera = new OrthographicCamera(width, height);
		camera.position.set(width / 2, height / 2, 0);
		camera.update();

		world = new World(ZERO_GRAVITY, true);
		box2dDebugRenderer = new Box2DDebugRenderer();
		rayHandler = new RayHandler(world);
		rayHandler.setCombinedMatrix(camera.combined);

		BodyDef bodyDef = new BodyDef();
		bodyDef.type = BodyDef.BodyType.StaticBody;
		 bodyDef.position.set(width / 2, height / 2);

		body = world.createBody(bodyDef);

		CircleShape shape = new CircleShape();
		shape.setRadius(1f);

		FixtureDef fixtureDef = new FixtureDef();
		fixtureDef.shape = shape;
		body.createFixture(fixtureDef);

		bodies = new Array<>();
		
//		new PointLight(rayHandler, 500, Color.GREEN, 50, 20, 20);
	}

	@Override
	protected void updateGame() {
		world.step(1f / 30f, 6, 2);
		world.getBodies(bodies);
		rayHandler.update();
	}

	@Override
	protected void renderGame() {
//		rayHandler.render();
		box2dDebugRenderer.render(world, camera.combined);
	}

	@Override
	public void dispose() {
		world.dispose();
	}

	public static void main(String... args) {
		new TestBox2D(null, null, new LwjglApplicationConfiguration());
	}
}
