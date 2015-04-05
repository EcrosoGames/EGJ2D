package ecrosogames.engine.main.task;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;

/**
 * A handler for tasks that is designed to host tasks. This would be used to
 * update, run, and remove the tasks when finished.
 * 
 * @author Michael Musgrove
 */
public class TaskManager {

	private static Map<UUID, Task> tasks = new HashMap<>();

	/**
	 * Updates every task. If the task is finished, it is removed.
	 */
	public static void update() {
		Set<UUID> keys = tasks.keySet();
		for (UUID uuid : keys) {
			Task t = tasks.get(uuid);
			t.update();
			if (t.isFinished()) tasks.remove(uuid);
		}
	}

	/**
	 * Adds a new Task.
	 * 
	 * @param task
	 * @return The UUID key used in the map.
	 */
	public static UUID add(Task task) {
		UUID uuid = UUID.randomUUID();
		tasks.put(uuid, task);
		return uuid;
	}

	/**
	 * Removes the task with the specified UUID
	 * 
	 * @param uuid
	 * @return The task if found and removed, or null.
	 */
	public static Task remove(UUID uuid) {
		return tasks.remove(uuid);
	}

	/**
	 * Returns the map for the tasks.
	 * 
	 * @return
	 */
	public Map<UUID, Task> getTasks() {
		return tasks;
	}
}
