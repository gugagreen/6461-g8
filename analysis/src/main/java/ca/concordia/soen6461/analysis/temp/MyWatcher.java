package ca.concordia.soen6461.analysis.temp;

import java.io.File;
import java.net.URL;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;
import java.util.List;

public class MyWatcher {

	public static void main(String[] args) {
//		String resourcesFolder = "./target/classes";
//		String xmlFolder = resourcesFolder + File.separator + "scrapResults";
//		Path myDir = Paths.get(xmlFolder);
//		System.out.println(myDir);
//		System.out.println(myDir.toFile().exists());
		
		folderWatcher("./target/classes");
		//findFolder();
	}
	
	public static void findFolder() {
		String TEST_FILE_PATH = "/jaxbGoogleAppTest.xml";
		File testFile = new File(MyWatcher.class.getResource(TEST_FILE_PATH).getFile());
		File parentFolder = testFile.getParentFile();
		System.out.println(parentFolder);
		Path myDir = Paths.get(parentFolder.toURI());
		System.out.println(myDir);
		for (File f : parentFolder.listFiles()) {
			System.out.println("> " + f);
		}
	}
	
	public static void folderWatcher(final String folder) {
		Path myDir = Paths.get(folder);

		try {
			WatchService watcher = myDir.getFileSystem().newWatchService();
			myDir.register(watcher, StandardWatchEventKinds.ENTRY_CREATE, StandardWatchEventKinds.ENTRY_DELETE,
					StandardWatchEventKinds.ENTRY_MODIFY);

			WatchKey watckKey = watcher.take();

			List<WatchEvent<?>> events = watckKey.pollEvents();
			for (WatchEvent<?> event : events) {
				if (event.kind() == StandardWatchEventKinds.ENTRY_CREATE) {
					System.out.println("Created: " + event.context().toString());
				}
				if (event.kind() == StandardWatchEventKinds.ENTRY_DELETE) {
					System.out.println("Delete: " + event.context().toString());
				}
				if (event.kind() == StandardWatchEventKinds.ENTRY_MODIFY) {
					System.out.println("Modify: " + event.context().toString());
				}
			}

		} catch (Exception e) {
			System.out.println("Error: " + e.toString());
		}
	}
}
