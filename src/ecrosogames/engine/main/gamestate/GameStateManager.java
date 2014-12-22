package ecrosogames.engine.main.gamestate;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * A manager for every {@link GameState}.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 */
public class GameStateManager {

	private static Map<Integer, GameState> gameStates = new HashMap<>();
	private static GameState currentGameState;

	/**
	 * Calls {@link GameState#update()} if the current GameState is not null.
	 */
	public static void update() {
		if (currentGameState != null) currentGameState.update();
	}

	/**
	 * Calls {@link GameState#render()} if the current GameState is not null.
	 */
	public static void render() {
		if (currentGameState != null) currentGameState.render();
	}

	/**
	 * Sets the current GameState. If the state is currently not null, it will
	 * first call {@link GameState#dispose()}.
	 * 
	 * @param state
	 *            The new GameState
	 */
	public static void setGameState(GameState state) {
		if (currentGameState != null) currentGameState.dispose();
		currentGameState = state;
	}

	/**
	 * Adds a new GameState to the list of Game States.
	 * 
	 * @param id
	 *            The id to grab the GameState from.
	 * @param state
	 *            The GameState to retreive with the id.
	 * @return The added GameState.
	 */
	public static GameState addGameState(int id, GameState state) {
		return gameStates.put(id, state);
	}

	/**
	 * Removes the GameState with the specified id.
	 * 
	 * @param id
	 *            The id of the GameState.
	 * @return The removed GameState, or null if not found.
	 */
	public static GameState removeGameState(int id) {
		return gameStates.remove(id);
	}

	/**
	 * Returns the GameState with the specified id.
	 * 
	 * @param id
	 *            The id of the GameState.
	 * @return The GameState with the specified id, or null if not found.
	 */
	public static GameState getGameState(int id) {
		return gameStates.get(id);
	}

	/**
	 * Returns the complete {@link Map} of the GameStates as &lt;Integer,
	 * GameState&gt;
	 * 
	 * @return
	 */
	public static Map<Integer, GameState> getGameStateMap() {
		return gameStates;
	}

	/**
	 * Returns the list of the keys from the Map.
	 * 
	 * @return
	 */
	public static List<Integer> getKeys() {
		return new ArrayList<Integer>(gameStates.keySet());
	}

	/**
	 * Returns the list of the values from the Map.
	 * 
	 * @return
	 */
	public static List<GameState> getGameStates() {
		return new ArrayList<GameState>(gameStates.values());
	}
}
