package ca.concordia.soen6461.analysis.service;

import java.io.File;

public interface FileService {
	File[] listFilesInFolder(final String folder);
}
