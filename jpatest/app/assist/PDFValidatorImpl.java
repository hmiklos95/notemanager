package assist;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import com.google.inject.Singleton;

@Singleton
public class PDFValidatorImpl implements PDFValidator {
	@Override
	public boolean isValidPDF(File file) {
		try {
			byte[] data = Files.readAllBytes(file.toPath());
			
			boolean valid = true;
			
	        valid &= data.length >= 4;

	        // header 
	        valid &= data[0] == 0x25; // %
	        valid &= data[1]==0x50; // P
	        valid &= data[2]==0x44; // D
	        valid &= data[3]==0x46; // F
	        valid &= data[4]==0x2D; // -

	        return valid;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
