package ecrosogames.engine;

import java.util.HashMap;
import java.util.Map;

import com.badlogic.gdx.audio.Sound;
import com.badlogic.gdx.graphics.g2d.Sprite;

/**
 * A handler for all game resources. They're stored with a key as a String, and
 * returns the specified resource by the key.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 *
 */
public class GameResource {

	private static Map<String, Sprite> sprites = new HashMap<String, Sprite>();
	private static Map<String, Sound> sounds = new HashMap<String, Sound>();

	/**
	 * An instance of the class isn't needed.
	 */
	private GameResource() {
	}

	/**
	 * Adds a Sprite to the Sprite resource collection map.
	 * 
	 * @param name
	 *            The key to identify the sprite.
	 * @param sprite
	 *            The sprite to be returned by the key.
	 * @return Whether or not this resource was added to the map.
	 */
	public static boolean addSprite(String name, Sprite sprite) {
		if (sprites.containsKey(name)) return false;
		sprites.put(name, sprite);
		return true;
	}

	/**
	 * Returns the Sprite with the specified name for the key, or null if not
	 * found.
	 * 
	 * @param name
	 * @return
	 */
	public static Sprite getSprite(String name) {
		Sprite sprite = sprites.get(name);
		if (sprite == null) return null;
		return new Sprite(sprite);
	}

	/**
	 * Adds a new Sound to the Sound recource collection map.
	 * 
	 * @param name
	 *            The key to identify the sound.
	 * @param sound
	 *            The sound to be returned by the key.
	 * @return Whether or not this resource was added to the map.
	 */
	public static boolean addSound(String name, Sound sound) {
		if (sounds.containsKey(name)) return false;
		sounds.put(name, sound);
		return true;
	}

	/**
	 * Returns the Sound with the specified name for the key, or null if not
	 * found.
	 * 
	 * @param name
	 * @return
	 */
	public static Sound getSound(String name) {
		Sound sound = sounds.get(name);
		return sound;
	}
}
