package ca.concordia.soen6461.analysis.service.impl;

import java.io.File;
import java.io.FilenameFilter;

import ca.concordia.soen6461.analysis.service.FileService;

public class XmlFileService implements FileService {
	private String SUFFIX = ".xml";
	
	public File[] listFilesInFolder(final String folder) {
		File dir = new File(folder);
		
		return dir.listFiles(new FilenameFilter() {
		    @Override
		    public boolean accept(File dir, String name) {
		        return name.endsWith(SUFFIX);
		    }
		});
	}
}
