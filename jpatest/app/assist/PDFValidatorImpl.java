package assist;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

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

	        /*if(data[5]==0x31 && data[6]==0x2E && data[7]==0x33) // version is 1.3 ?
	        {                  
	            // file terminator
	            valid &= data[data.length-7]==0x25; // %
	            valid &= data[data.length-6]==0x25; // %
	            valid &= data[data.length-5]==0x45; // E
	            valid &= data[data.length-4]==0x4F; // O
	            valid &= data[data.length-3]==0x46; // F
	            valid &= data[data.length-2]==0x20; // SPACE
	            valid &= data[data.length-1]==0x0A; // EOL
	            return valid;
	        }

	        if(data[5]==0x31 && data[6]==0x2E && data[7]==0x34) // version is 1.4 ?
	        {
	            // file terminator
	            valid &= data[data.length-6]==0x25; // %
	            valid &= data[data.length-5]==0x25; // %
	            valid &= data[data.length-4]==0x45; // E
	            valid &= data[data.length-3]==0x4F; // O
	            valid &= data[data.length-2]==0x46; // F
	            valid &= data[data.length-1]==0x0A; // EOL
	            return valid;
	        }*/

	        return valid;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
		
	}

}
