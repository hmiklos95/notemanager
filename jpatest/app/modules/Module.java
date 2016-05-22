package modules;

import com.google.inject.AbstractModule;
import com.google.inject.TypeLiteral;

import entities.Note;
import entities.Notebook;
import entities.User;
import repositories.GenericRepository;
import repositories.HibernateGenericRepository;


public class Module extends AbstractModule {

	@Override
	protected void configure() {
		
		bind(new TypeLiteral<GenericRepository<User>>(){})
		  .to(new TypeLiteral<HibernateGenericRepository<User>>(){});
		bind(new TypeLiteral<GenericRepository<Notebook>>(){})
		  .to(new TypeLiteral<HibernateGenericRepository<Notebook>>(){});
		bind(new TypeLiteral<GenericRepository<Note>>(){})
		  .to(new TypeLiteral<HibernateGenericRepository<Note>>(){});
		
		/*bind(GenericRepository.class).to(HibernateGenericRepository.class);*/
	}

}
