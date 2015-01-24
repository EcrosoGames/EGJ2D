package ecrosogames.engine.main.gfx;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.graphics.g2d.Sprite;

import ecrosogames.engine.main.EGApplication;
import ecrosogames.engine.main.interfaces.Renderable;
import ecrosogames.engine.main.interfaces.Updatable;

/**
 * A {@link Sprite} with an animation. This class extends Sprite so that it will
 * be a subclass of Sprite, but the inherited methods are currently useless.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 */
public class AnimatedSprite extends Sprite implements Updatable, Renderable {

	private Sprite[] sprites;
	private int rate;
	private int frame;
	private int counter;
	private Sprite sprite;

	/**
	 * Creates a new Animated Sprite.
	 * 
	 * @param sprites
	 *            The array of sprites to use.
	 * @param rate
	 *            The rate at which the sprites should change.
	 */
	public AnimatedSprite(Sprite[] sprites, int rate) {
		this.sprites = sprites;
		this.rate = rate;
	}

	@Override
	public void update() {
		if (counter >= rate) {
			if (frame < sprites.length - 1) frame++;
			else frame = 0;
			counter = 0;
		} else counter++;
		this.sprite = sprites[counter];
	}

	/**
	 * Draws the current Sprite that the AnimatedSprite is currently using.
	 */
	@Override
	public void render() {
		sprite.draw(EGApplication.getBatch());
	}

	@Override
	public void setColor(Color color) {
		super.setColor(color);
		for (int i = 0; i < sprites.length; i++) {
			sprites[i].setColor(color);
		}
	}

	@Override
	public void setColor(float r, float g, float b, float a) {
		setColor(new Color(r, g, b, a));
	}

	@Override
	public void setColor(float color) {
		super.setColor(color);
		for (int i = 0; i < sprites.length; i++) {
			sprites[i].setColor(color);
		}
	}

	/**
	 * This method is useless for the AnimatedSprite class, thus it does
	 * nothing.
	 * 
	 * @see #set(AnimatedSprite)
	 */
	@Override
	public void set(Sprite sprite) {
		return;
	}

	/**
	 * Makes this AnimatedSprite a copy of the specified AnimatedSprite in every
	 * way.
	 * 
	 * @param sprite
	 */
	public void set(AnimatedSprite sprite) {
		this.sprites = sprite.sprites;
		this.rate = sprite.rate;
		this.frame = sprite.frame;
		this.counter = sprite.counter;
		this.sprite = sprite.sprite;
	}

	/**
	 * @see #render()
	 */
	@Override
	public void draw(Batch batch) {
		render();
	}

	/**
	 * Returns the array of Sprites used for this AnimatedSprite.
	 * 
	 * @return
	 */
	public Sprite[] getSprites() {
		return sprites;
	}

	/**
	 * Returns the current rate at which the sprites are changed.
	 * 
	 * @return
	 */
	public int getRate() {
		return rate;
	}

	/**
	 * Sets the rate at which the sprites should change.
	 * 
	 * @param rate
	 */
	public void setRate(int rate) {
		this.rate = rate;
	}

	/**
	 * Returns the current frame that the animation is on.
	 * 
	 * @return
	 */
	public int getFrame() {
		return frame;
	}

	/**
	 * Returns the counter for the animation. Every time this is greater than or
	 * equal to rate, it will reset to 0 and frame will increment.
	 * 
	 * @return
	 */
	public int getCounter() {
		return counter;
	}
}
