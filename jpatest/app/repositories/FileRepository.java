package repositories;

import java.io.File;

public interface FileRepository {
	public String saveFile(File toSave);
	
	public File fetchFile(String path);
}
