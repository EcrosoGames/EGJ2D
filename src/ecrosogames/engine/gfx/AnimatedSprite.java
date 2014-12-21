package ecrosogames.engine.gfx;

import com.badlogic.gdx.graphics.g2d.Sprite;

import ecrosogames.engine.EGApplication;

/**
 * A {@link Sprite} with an animation. This class extends Sprite so that it will
 * be a subclass of Sprite, but the inherited methods are currently useless.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 */
public class AnimatedSprite extends Sprite {

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

	public void update() {
		if (counter >= rate) {
			if (frame < sprites.length - 1) frame++;
			else frame = 0;
			counter = 0;
		} else counter++;
		this.sprite = sprites[counter];
	}

	public void render() {
		sprite.draw(EGApplication.getBatch());
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
