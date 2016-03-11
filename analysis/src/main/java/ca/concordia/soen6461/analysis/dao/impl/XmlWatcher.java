package ca.concordia.soen6461.analysis.dao.impl;

import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;
import java.nio.file.WatchKey;
import java.nio.file.WatchService;

public class XmlWatcher implements Runnable {

	private Path dir;

	public XmlWatcher(Path dir) {
		super();
		this.dir = dir;

	}

	@Override
	public void run() {
		while (true) {
			try {
				WatchService watcher = this.dir.getFileSystem().newWatchService();

				// wait for key to be signaled
				WatchKey key;
				try {
					key = watcher.take();
				} catch (InterruptedException x) {
					return;
				}

				for (WatchEvent<?> event : key.pollEvents()) {
					poolEvent(event);
				}

				// Reset the key -- this step is critical if you want to
				// receive further watch events. If the key is no longer valid,
				// the directory is inaccessible so exit the loop.
				boolean valid = key.reset();
				if (!valid) {
					break;
				}
			} catch (IOException e) {
				e.printStackTrace();
				System.err.println("watcher could not be created");
			}

		}

	}

	private void poolEvent(WatchEvent<?> event) {
		WatchEvent.Kind<?> kind = event.kind();

		// This key is registered only for ENTRY_CREATE events, but an OVERFLOW event can
		// occur regardless if events are lost or discarded.
		if (kind != StandardWatchEventKinds.OVERFLOW) {
			// The filename is the context of the event.
			WatchEvent<Path> ev = (WatchEvent<Path>) event;
			Path filename = ev.context();
			
			// FIXME - do something
			System.out.format("Emailing file %s%n", filename);

			// Verify that the new file is a text file.
//			try {
//				// Resolve the filename against the directory.
//				// If the filename is "test" and the directory is "foo", the resolved name is "test/foo".
//				Path child = dir.resolve(filename);
//				if (!Files.probeContentType(child).equals("text/plain")) {
//					System.err.format("New file '%s' is not a plain text file.%n", filename);
//					continue;
//				}
//			} catch (IOException x) {
//				System.err.println(x);
//			}
		}
	}

}
