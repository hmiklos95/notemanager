package integrationtests;

import org.junit.Before;
import org.junit.Test;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import entities.User;
import entities.User_;
import modules.Module;
import play.Mode;
import play.Application;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.Helpers;
import repositories.GenericRepository;
import static play.test.Helpers.*;

import static org.junit.Assert.*;
import java.util.Map;

public class UserRepositoryTest {

	Application application;
	GenericRepository<User> userRepo;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		application = new GuiceApplicationBuilder()
		.configure((Map) Helpers.inMemoryDatabase())
		.overrides(new Module())
		.in(Mode.TEST)         
		.build();
		userRepo = application.injector().instanceOf(Injector.class).getInstance(Key.get(new TypeLiteral<GenericRepository<User>>(){}));
	}

	@Test
	public void persistUser() {
		running(application, () -> {
			User user = new User("user", "pw", "My Name", 10);
			userRepo.persist(user);
			
			User found = userRepo.findFirstByPredicate((cb, root) -> cb.equal(root.get(User_.name), "user"));
			
			assertNotEquals(null, found);
			assertEquals("user", found.getName());
		});
	}
}
