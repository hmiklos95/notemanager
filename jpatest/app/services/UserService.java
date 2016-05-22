package services;

import com.google.inject.ImplementedBy;

import entities.User;
import services.UserService.InvalidCredentialsException;

@ImplementedBy(UserServiceImpl.class)
public interface UserService {
	public void registerUser(User user) throws UserAlreadyExistsException;
	public User logonUser(String username, String password) throws InvalidCredentialsException;
	
	public static class UserAlreadyExistsException extends Exception {}
	public static class InvalidCredentialsException extends Exception {}
}