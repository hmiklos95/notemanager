package integrationtests;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import static play.test.Helpers.running;

import java.io.File;
import java.net.URI;
import java.net.URISyntaxException;
import java.util.Map;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Resources;

import modules.Module;
import play.Application;
import play.Mode;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.Helpers;
import repositories.FileRepository;

public class FileRepoTest {
	private Application application;
	
	private FileRepository repo;
	
	@SuppressWarnings("unchecked")
	@Before
	public void setup() {
		application = new GuiceApplicationBuilder()
		.configure((Map) Helpers.inMemoryDatabase())
		.overrides(new Module())
		.in(Mode.TEST)         
		.build();
		
		repo = application.injector().instanceOf(FileRepository.class);
		
	}
	
	@Test
	public void testSaveFile() {
		running(application, () -> {
			URI url;
			try {
				url = Resources.getResource("resources/ca.key").toURI();
				
				File validFile = new File(url);
				
				repo.saveFile(validFile);
				
				File file = new File("C:\\Miklós\\ca.key");
				
				assertEquals(true, file.exists());
				
			} catch (URISyntaxException e) {
				fail();
			}
		});
	}
	
	@After
	public void teardown() {
		repo.deleteFiles();
	}
}
