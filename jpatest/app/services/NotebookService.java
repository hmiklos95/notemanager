package services;

import com.google.inject.ImplementedBy;

import entities.Note;
import entities.Notebook;
import entities.User;
@ImplementedBy(NotebookServiceImpl.class)
public interface NotebookService {
	public void createNotebook(User creator, Notebook notebook);
	public void addNoteToNotebook(Notebook notebook, Note note);
	public void addUserToNotebook(Notebook notebook, User user);
}
