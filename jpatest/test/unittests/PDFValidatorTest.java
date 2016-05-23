package unittests;

import java.io.File;
import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.Map;

import org.apache.commons.io.Charsets;
import org.junit.Before;
import org.junit.Test;

import com.google.common.io.Resources;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import assist.PDFValidator;
import assist.PDFValidatorImpl;
import entities.User;
import modules.Module;
import play.Application;
import play.Mode;
import play.inject.guice.GuiceApplicationBuilder;
import play.test.Helpers;
import repositories.GenericRepository;

import static org.junit.Assert.*;

public class PDFValidatorTest {
	
	PDFValidator validator = new PDFValidatorImpl();
	
	@Test
	public void testValidFile() {
		URI url;
		try {
			url = Resources.getResource("resources/konzultacio.pdf").toURI();
			
			File validFile = new File(url);
			assertEquals(true, validator.isValidPDF(validFile));
		} catch (URISyntaxException e) {
			fail();
		}
		
		
	}
	
	@Test
	public void testInvalidFile() {
		URI url;
		try {
			url = Resources.getResource("resources/ca.key").toURI();
			
			File validFile = new File(url);
			assertEquals(false, validator.isValidPDF(validFile));
		} catch (URISyntaxException e) {
			fail();
		}
	}
}
