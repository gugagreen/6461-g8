package ca.concordia.soen6461.analysis.service.impl;

import java.io.File;
import java.io.FileReader;
import java.io.FilenameFilter;
import java.io.IOException;

import ca.concordia.soen6461.analysis.service.FileService;
import ca.concordia.soen6461.entities.entity.GoogleAppList;
import ca.concordia.soen6461.entities.service.MarshallerService;
import ca.concordia.soen6461.entities.service.impl.JaxbMarshallerService;

public class XmlFileService implements FileService {
	private String SUFFIX = ".xml"; // TODO - add to properties
	
	private MarshallerService<GoogleAppList> marshallerService = new JaxbMarshallerService<GoogleAppList>();
	
	/**
	 * private constructor to enforce singleton
	 */
	private XmlFileService() {}
	
	/**
	 * Singleton Holder to enforce load on first call of getInstance() in a thread-safe way, without need of manual synchronization. 
	 */
	private static class SingletonHolder {
        private static final XmlFileService INSTANCE = new XmlFileService();
	}
	
	public static XmlFileService getInstance() {
        return SingletonHolder.INSTANCE;
	}
	
	public File[] listFilesInFolder(final String folder) {
		File dir = new File(folder);
		
		return dir.listFiles(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(SUFFIX);
		    }
		});
	}
	
	public GoogleAppList loadApps(final String filePath) {
		GoogleAppList apps = null;
		if (filePath != null && !filePath.trim().isEmpty()) {
			try {
			File testFile = new File(getClass().getResource(filePath).getFile());
			if (testFile != null && testFile.isFile()) {
				FileReader reader = new FileReader(testFile);
				apps = marshallerService.unmarshall(GoogleAppList.class, reader);
			}
			} catch (IOException e) {
				System.err.println("Unable to read file: "+ filePath);
			}
		}
		return apps;
	}
}
