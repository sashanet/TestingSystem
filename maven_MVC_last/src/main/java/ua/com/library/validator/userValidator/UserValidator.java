package ua.com.library.validator.userValidator;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import ua.com.library.Dao.UserDao;
import ua.com.library.entity.User;
import ua.com.library.validator.Validator;

@Component("userValidator")
public class UserValidator implements Validator{

	@Autowired
	private UserDao userDao;
	
	
	public void validate(Object object) throws Exception {
		User user =(User) object; 
		
		
		if(user.getEmail().isEmpty()){
			throw new UserValidationExeption(UserValidationMessage.EMPTY_EMAIL_MESSAGE);
		}
		if(userDao.userExistByEmail(user.getEmail())){
			throw new UserValidationExeption(UserValidationMessage.EMAIL_EXIST);
		}
		if(user.getPassword().isEmpty()){
			throw new UserValidationExeption(UserValidationMessage.EMPTY_PASSWORD_MESSAGE);
		}
		
		
	}

}
