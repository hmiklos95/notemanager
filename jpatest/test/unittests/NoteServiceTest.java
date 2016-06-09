package unittests;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.runners.MockitoJUnitRunner;


import assist.PDFValidator;
import entities.Note;
import entities.Notebook;
import entities.PDFNote;
import entities.TextNote;
import repositories.FileRepository;
import repositories.GenericRepository;
import services.NoteService;
import services.NoteService.InvalidPDFFileException;
import services.NoteServiceImpl;
import static org.junit.Assert.*;
import static org.mockito.Mockito.*;


import java.io.File;

@RunWith(MockitoJUnitRunner.class)
public class NoteServiceTest {

	@InjectMocks
	private NoteService noteService = new NoteServiceImpl();

	@Mock
	private GenericRepository<Notebook> notebookRepo;

	@Mock
	private GenericRepository<Note> noteRepo;

	@Mock
	private FileRepository fileRepo;

	@Mock
	private PDFValidator pdfValidator;

	@Before
	public void setup() {
		MockitoAnnotations.initMocks(this);
	}

	@Test
	public void addTextNote() {
		Notebook notebook = new Notebook("notebook title");

		noteService.createTextNote("notetitle", "notetext very such long wow", notebook);

		assertEquals("notetitle", notebook.getNotes().get(0).getTitle());
		assertEquals("notetext very such long wow", ((TextNote)notebook.getNotes().get(0)).getText());
		verify(noteRepo, times(1)).persist(notebook.getNotes().get(0));
		verify(notebookRepo, times(1)).save(notebook);
	}

	@Test
	public void successAddPDFNote() {
		Notebook notebook = new Notebook("notebook title");
		File file = new File("asd");

		when(pdfValidator.isValidPDF(any())).thenReturn(true);
		when(fileRepo.saveFile(any())).thenReturn("copyed");

		try {
			noteService.createPDFNote("notetitle", file, notebook);
		} catch (InvalidPDFFileException e) {
			fail("should not throw exception");
		}finally{
			assertEquals("notetitle", notebook.getNotes().get(0).getTitle());
			assertEquals("copyed", ((PDFNote)notebook.getNotes().get(0)).getPdfURL());

			verify(noteRepo, times(1)).persist(notebook.getNotes().get(0));
			verify(notebookRepo, times(1)).save(notebook);
		}
	}
	@Test
	public void unsuccessAddPDFNote() {
		Notebook notebook = new Notebook("notebook title");
		File file = new File("asd");

		when(pdfValidator.isValidPDF(any())).thenReturn(false);
		when(fileRepo.saveFile(any())).thenReturn("copyed");

		try {
			noteService.createPDFNote("notetitle", file, notebook);
			fail("should throw exception");
		} catch (InvalidPDFFileException e) {

		}finally{

		}


	}

}
