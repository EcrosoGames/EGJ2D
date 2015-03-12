package ecrosogames.engine.main.gamestate;

import java.util.HashMap;
import java.util.Map;

/**
 * A manager for every {@link IGameState}.
 * 
 * @author Michael Musgrove
 */
public class GameStateManager {

	private static Map<String, IGameState> gameStates = new HashMap<>();

	/**
	 * Adds a new GameState Screen to the list for management.
	 * 
	 * @param name
	 *            The name (key) to retrieve the IGameState.
	 * @param state
	 *            The IGameState that is linked with the name (key).
	 * @return
	 */
	public static IGameState add(String name, IGameState state) {
		return gameStates.put(name, state);
	}

	/**
	 * Removes the IGameState with the specified name (key).
	 * 
	 * @param name
	 *            The name of the IGameState.
	 * @return The removed IGameState, or null if it didn't exist.
	 */
	public static IGameState remove(String name) {
		return gameStates.remove(name);
	}

	/**
	 * Gets the IGameState specified by the name (key)
	 * 
	 * @param name
	 * @return The IGameState, or null if not found.
	 */
	public static IGameState get(String name) {
		return gameStates.get(name);
	}
}
