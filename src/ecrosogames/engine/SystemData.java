package ecrosogames.engine;

import java.io.File;

/**
 * Information used by the program.
 * 
 * @author Michael Musgrove (CoderMusgrove)
 */
public class SystemData {

	private static final String EGDataFolderName = ".EcrosoGames";
	private static String appFolderName;
	private static File dataFolder;

	/**
	 * Initializes the data folder.
	 */
	private static void initDataFolder() {
		String os = System.getProperty("os.name").toLowerCase();
		String path = new String();
		if (os.contains("win")) {
			path = System.getenv("AppData") + "/" + EGDataFolderName + "/" + appFolderName;
		} else {
			path = System.getProperty("user.home");
			if (os.contains("mac")) path += "/Library";
			path += "/" + EGDataFolderName + "/" + appFolderName;
		}
		dataFolder = new File(path);
		if (!dataFolder.exists()) dataFolder.mkdirs();
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
		if (dataFolder == null) initDataFolder();
		return dataFolder;
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
		appFolderName = name;
	}
}
