package services;

import java.io.File;

import com.google.inject.ImplementedBy;

import entities.Notebook;

@ImplementedBy(NotebookServiceImpl.class)
public interface NoteService {
	public void createTextNote(String title, String text, Notebook containerNotebook);
	public void createPDFNote(String title, File pdfFile, Notebook containerNotebook) throws InvalidPDFFileException;

	public static class InvalidPDFFileException extends Exception {}
}
