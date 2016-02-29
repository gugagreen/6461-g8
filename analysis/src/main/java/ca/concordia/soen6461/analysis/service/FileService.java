package ca.concordia.soen6461.analysis.service;

import java.io.File;

import ca.concordia.soen6461.entities.entity.GoogleAppList;

public interface FileService {
	File[] listFilesInFolder(final String folder);
	
	GoogleAppList loadApps(final String filePath);
}
