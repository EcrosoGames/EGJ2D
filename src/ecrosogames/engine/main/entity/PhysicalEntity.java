package ecrosogames.engine.main.entity;

import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.physics.box2d.Body;
import com.badlogic.gdx.physics.box2d.World;

public abstract class PhysicalEntity extends Entity {

	protected Body body;
	protected Sprite sprite;

	public PhysicalEntity(World world) {
		super(world);
		createBody();
	}
	
	protected abstract void createBody();

	public void setBody(Body body) {
		this.body = body;
	}
	public void setSprite(Sprite sprite) {
		this.sprite = sprite;
	}
	
	public Body getBody() {
		return body;
	}
	
	public Sprite getSprite() {
		return sprite;
	}
}
