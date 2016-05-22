package services;

import static org.mockito.Matchers.anyString;

import java.util.List;
import java.util.Set;

import com.google.inject.Inject;

import entities.User;
import entities.User_;
import repositories.GenericRepository;


public class UserServiceImpl implements UserService{

	@Inject GenericRepository<User> userRepo;

	@Override
	public void registerUser(User user) throws UserAlreadyExistsException {
		User found = userRepo.findFirstByPredicate((cb, root) -> cb.equal(root.get(User_.name), user.getName()));
		if (found != null) {
			throw new UserAlreadyExistsException();
		}else{
			userRepo.persist(user);
		}
	}

	@Override
	public User logonUser(String username, String password) throws InvalidCredentialsException{
		User found = userRepo.findFirstByPredicate((cb, root) -> cb.equal(root.get(User_.name), username));
		if(found == null || !password.equals(found.getPassword())) {
			throw new InvalidCredentialsException();
		}
		return found;
	}
}
