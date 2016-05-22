package assist;

import java.io.File;

import com.google.inject.Singleton;

@Singleton
public interface PDFValidator {
	public boolean isValidPDF(final File file);
}
