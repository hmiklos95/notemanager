package services;

import java.io.File;

import com.google.inject.Inject;

import assist.PDFValidator;
import entities.Note;
import entities.Notebook;
import entities.PDFNote;
import entities.TextNote;
import repositories.FileRepository;
import repositories.GenericRepository;
import services.NoteService.InvalidPDFFileException;

public class NoteServiceImpl implements NoteService {

	
	@Inject FileRepository fileRepo;
	@Inject PDFValidator pdfValidator;
	@Inject GenericRepository<Note> noteRepo;
	@Inject GenericRepository<Notebook> notebookRepo;
	
	@Override
	public void createTextNote(String title, String text, Notebook containerNotebook) {
		TextNote textNote = new TextNote(title, text);
		containerNotebook.addNote(textNote);
		
		noteRepo.persist(textNote);
		notebookRepo.save(containerNotebook);

	}

	@Override
	public void createPDFNote(String title, File pdfFile, Notebook containerNotebook) throws InvalidPDFFileException {
		if(!pdfValidator.isValidPDF(pdfFile)) {
			throw new InvalidPDFFileException();
		}
		
		PDFNote pdfNote = new PDFNote(title, fileRepo.saveFile(pdfFile));
		
		containerNotebook.addNote(pdfNote);
		noteRepo.persist(pdfNote);
		notebookRepo.save(containerNotebook);
	}
}
