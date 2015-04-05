package ecrosogames.engine.main.task;

import ecrosogames.engine.main.Updatable;

/**
 * An event that should take place at a later time.
 * 
 * @author Michael Musgrove
 */
public class Task implements Updatable {

	protected Runnable r;
	protected int delay;
	protected boolean finished;

	/**
	 * Creates a new Task with no delay.
	 * 
	 * @param r
	 */
	public Task(Runnable r) {
		this.r = r;
	}

	/**
	 * Creates a new Task that will run after <code>n</code> updates.
	 * 
	 * @param r
	 * @param delay
	 *            The delay (in updates) before the task should run.
	 */
	public Task(Runnable r, int delay) {
		this.r = r;
		this.delay = delay;
	}

	@Override
	public void update() {
		if (finished) return;
		if (delay > 0) delay--;
		else {
			r.run();
			finished = true;
		}
	}

	/**
	 * Returns the delay of the task.
	 * 
	 * @return
	 */
	public int getDelay() {
		return delay;
	}

	/**
	 * Returns if the task has finished or not.
	 * 
	 * @return
	 */
	public boolean isFinished() {
		return finished;
	}
}
