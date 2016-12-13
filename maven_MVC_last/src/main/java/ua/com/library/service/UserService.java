package ua.com.library.service;

import java.security.Principal;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import ua.com.library.entity.Book;
import ua.com.library.entity.Test;
import ua.com.library.entity.User;

public interface UserService {

	

	void save(User user) throws Exception;

	List<User> findAll();

	User findOne(int id);

	void delete(int id);
	void addUsertoGroups(User user, int idGroup);
	
	void addUsersTogroups(String groupsId, String [] usersId);
	public void saveImage(Principal principal, MultipartFile multipartFile);
	
	public User findUserTest(int id);
	
	void update(User user);
	User findByUUID (String uuid);
}

