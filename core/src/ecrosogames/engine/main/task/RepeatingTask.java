package ecrosogames.engine.main.task;

/**
 * A task that Repeats after a given period of time. This type of task has to be
 * manually set to finished.
 * 
 * @author Michael Musgrove
 */
public class RepeatingTask extends Task {

	protected int period;
	protected int counter;

	/**
	 * Creates a new RepeatingTask that will start immediately.
	 * 
	 * @param r
	 * @param period
	 *            The period (in updates) until the task should run again.
	 */
	public RepeatingTask(Runnable r, int period) {
		super(r, 0);
		this.period = period;
	}

	/**
	 * Creates a new Repeating task that will start after <code>n</code>
	 * updates.
	 * 
	 * @param r
	 * @param delay
	 *            The delay (in updates) until the task should start.
	 * @param period
	 *            The period (in updates) until the task should run again.
	 */
	public RepeatingTask(Runnable r, int delay, int period) {
		super(r, delay);
		this.period = period;
	}

	@Override
	public void update() {
		if (finished) return;
		if (delay > 0) {
			delay--;
			return;
		}
		if (counter >= period) {
			r.run();
			counter = 0;
		} else counter++;
	}

	/**
	 * Returns the period of updates until the task should run again.
	 * 
	 * @return
	 */
	public int getPeriod() {
		return period;
	}
}
