package ecrosogames.engine.main;

import java.util.HashMap;
import java.util.Map;

/**
 * A handler for all game resources. They're stored with a key as a String, and
 * returns the specified resource by the key.
 * 
 * @author Michael Musgrove
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
	public static <T> T add(String name, T obj) {
		if (resources.containsKey(name)) return null;
		resources.put(name, obj);
		return obj;
	}

	/**
	 * Returns the Object with the specified name for the key, or null if not
	 * found.
	 * 
	 * If the resource is not of the type of the provided
	 * <code>Class&lt;T&gt;</code>, an error will be thrown.
	 * 
	 * @param name
	 *            The key for the object.
	 * @param clazz
	 *            Type <code>Class</code> that should be returned.
	 * @return
	 */
	@SuppressWarnings("unchecked")
	public static <T> T get(String name, Class<T> clazz) {
		Object resource = resources.get(name);
		return (T) resource;
	}
}
