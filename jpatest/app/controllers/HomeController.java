package controllers;

import com.google.inject.Inject;

import entities.Notebook;
import entities.User;
import play.mvc.*;
import services.NotebookService;
import services.UserService;
import services.UserService.InvalidCredentialsException;
import services.UserService.UserAlreadyExistsException;
import services.UserServiceImpl;
import views.html.*;

/**
 * This controller contains an action to handle HTTP requests
 * to the application's home page.
 */
public class HomeController extends Controller {

	@Inject 
	UserService userService;
	
	@Inject 
	NotebookService notebookService;
    /**
     * An action that renders an HTML page with a welcome message.
     * The configuration in the <code>routes</code> file means that
     * this method will be called when the application receives a
     * <code>GET</code> request with a path of <code>/</code>.
     */
	
	
    public Result index() {

    	System.out.println("this is a very important feature");
    	return ok(index.render("Your new application is ready."));
    }

}
