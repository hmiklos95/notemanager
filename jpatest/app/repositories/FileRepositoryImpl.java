package repositories;

import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;

import com.google.inject.Inject;

import assist.RootPathProvider;

public class FileRepositoryImpl implements FileRepository {
	
	@Inject RootPathProvider provider;
	
	@Override
	public String saveFile(File toSave) {
		String path = provider.getRootPath();
		
		try {
			FileUtils.copyFileToDirectory(toSave, new File(path));
			
			return path + File.separator + toSave.getName();
		} catch (IOException e) {
			return "";
		}
	}

	@Override
	public File fetchFile(String path) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFiles() {
		// TODO Auto-generated method stub
		
	}

}
