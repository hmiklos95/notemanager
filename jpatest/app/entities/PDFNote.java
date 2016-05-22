package entities;

import javax.persistence.DiscriminatorValue;
import javax.persistence.PrimaryKeyJoinColumn;

@PrimaryKeyJoinColumn(referencedColumnName="id")

@DiscriminatorValue( value="PDFN" )
public class PDFNote extends Note {
	private final String pdfURL;
	private String title;
	
	public PDFNote(String title, String pdfURL) {
		super(title);
		this.pdfURL = pdfURL;
	}

	public String getPdfURL() {
		return pdfURL;
	}
}
