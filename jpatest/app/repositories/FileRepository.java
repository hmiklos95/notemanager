package repositories;

import java.io.File;

import com.google.inject.ImplementedBy;

@ImplementedBy(FileRepositoryImpl.class)
public interface FileRepository {
	public String saveFile(File toSave);
	
	public File fetchFile(String path);
	
	public void deleteFiles();
}
