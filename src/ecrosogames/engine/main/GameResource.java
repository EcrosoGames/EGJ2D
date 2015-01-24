package ecrosogames.engine.main;

import java.util.HashMap;
import java.util.Map;

/**
 * A handler for all game resources. They're stored with a key as a String, and
 * returns the specified resource by the key.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 *
 */
public class GameResource {

	private static Map<String, Object> resources = new HashMap<String, Object>();

	/**
	 * An instance of the class isn't needed.
	 */
	private GameResource() {
	}

	/**
	 * Adds an Object to the resource collection map.
	 * 
	 * @param name
	 *            The key to identify the object.
	 * @param obj
	 *            The object to be returned by the key.
	 * @return Whether or not this resource was added to the map.
	 */
	public static boolean addSprite(String name, Object obj) {
		if (resources.containsKey(name)) return false;
		resources.put(name, obj);
		return true;
	}

	/**
	 * Returns the Object with the specified name for the key, or null if not
	 * found.
	 * 
	 * @param name
	 *            The key for the object.
	 * @return
	 */
	public static Object get(String name) {
		return resources.get(name);
	}
}
