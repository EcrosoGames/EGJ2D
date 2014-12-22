package ecrosogames.engine.main;

import java.io.File;

/**
 * Information used by the program.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 */
public class SystemData {

	private static final String EGFolderName = ".EcrosoGames";
	private static File folder;
	private static String folderName;
	private static String osName;

	/**
	 * An instance of this class isn't needed.
	 */
	private SystemData() {
		;
	}

	static {
		init();
	}

	private static void init() {
		osName = System.getProperty("os.name");
	}

	/**
	 * Initializes the data folder.
	 */
	private static void initDataFolder() {
		String os = osName.toLowerCase();
		String path = new String();
		if (os.contains("win")) {
			path = System.getenv("AppData") + "/" + EGFolderName + "/" + folderName;
		} else {
			path = System.getProperty("user.home");
			if (os.contains("mac")) path += "/Library";
			path += "/" + EGFolderName + "/" + folderName;
		}
		folder = new File(path);
		if (!folder.exists()) folder.mkdirs();
	}

	/**
	 * Returns the data folder of the game.<br>
	 * <br>
	 * If you're in Windows, your folder will be in:
	 * %AppData%/.EcrosoGames/&lt;Game Name&gt; <br>
	 * If on Mac, it will be in: ~/Library/.EcrosoGames/&lt;Game Name&gt;. <br>
	 * On Linux it will be in:
	 * System.getProperty("user.home")/.EcrosoGames/&lt;Game Name&gt;.
	 * 
	 * @return
	 */
	public static File getDataFolder() {
		if (folderName == null) throw new NullPointerException("The Folder Name has not been set! Use SystemData.setDataFolderName(String)");
		return folder;
	}

	/**
	 * This should be a simple name. Preferably, it should start with a period
	 * "."<br>
	 * <br>
	 * If you're in Windows, your folder will be in:
	 * %AppData%/.EcrosoGames/&lt;Game Name&gt; <br>
	 * If on Mac, it will be in: ~/Library/.EcrosoGames/&lt;Game Name&gt;. <br>
	 * On Linux it will be in:
	 * System.getProperty("user.home")/.EcrosoGames/&lt;Game Name&gt;.
	 * 
	 * @param name
	 */
	public static void setDataFolderName(String name) {
		folderName = name;
		initDataFolder();
	}
}
