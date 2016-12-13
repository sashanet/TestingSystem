package ua.com.library.serviceImpl;

import java.io.File;
import java.io.IOException;
import java.security.Principal;
import java.time.LocalDate;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import ua.com.library.Dao.BookDao;
import ua.com.library.Dao.GroupsDao;
import ua.com.library.Dao.UserDao;
import ua.com.library.entity.Groups;
import ua.com.library.entity.Role;
import ua.com.library.entity.Test;
import ua.com.library.entity.User;
import ua.com.library.service.UserService;
import ua.com.library.validator.Validator;

@Service("userDetailsService")
public class UserServiceImp implements UserService,UserDetailsService {
	@Autowired
	private UserDao userDao;
	@Autowired
	private GroupsDao groupsDao;
	@Autowired
    private BCryptPasswordEncoder encoder;
	
	@Autowired
	@Qualifier("userValidator")
	private Validator validator;
	
	public void save(User user) throws Exception
	{
	validator.validate(user);
	
		user.setRole(Role.ROLE_USER);
		user.setPassword(encoder.encode(user.getPassword()));

		LocalDate dateof;
		dateof = LocalDate.now();
		user.setDateofRegister(dateof);
		userDao.save(user);
		
	}
	

	public List<User> findAll() {
	return userDao.findAll();
	}

	public User findOne(int id) {
	
		return userDao.findOne(id);
	}

	public void delete(int id) {
		userDao.delete(id);
		
	}
	@Transactional
	public void addUsertoGroups(User user, int idGroup) {
		userDao.saveAndFlush(user);
		Groups groups= groupsDao.findOne(idGroup);
		
		
		
//			List<User> users= groups.getUsers();
//			
//			users.add(user);
		
		
		 user.setGroups(groups);
		 userDao.save(user);
	}

	@Transactional
	public void addUsersTogroups(String groupsId, String[] usersId) {
		Groups groups= groupsDao.findOne(Integer.parseInt(groupsId));
		
		for (int i = 0; i < usersId.length; i++) {
			User user = userDao.findOne(Integer.parseInt(usersId[i]));
			user.setGroups(groups);
			userDao.save(user);
		}
		
		
	}


	public UserDetails loadUserByUsername(String name) throws UsernameNotFoundException {
		return userDao.findByEmail(name);
	}
	public User findByName(String name) {
		return userDao.findByEmail(name);
	}


	@Transactional
	public void saveImage(Principal principal, MultipartFile multipartFile) {

	    User user = userDao.findOne(Integer.parseInt(principal.getName()));

	    String path = System.getProperty("catalina.home") + "/resources/"
	            + user.getName() + "/" + multipartFile.getOriginalFilename();

	    user.setPathImage("resources/" + user.getName() + "/" + multipartFile.getOriginalFilename());

	    File file = new File(path);

	    try {
	        file.mkdirs();
	        try {
	            FileUtils.cleanDirectory
	                    (new File(System.getProperty("catalina.home") + "/resources/" + user.getName() + "/"));
	        } catch (IOException e) {
	            e.printStackTrace();
	        }
	        multipartFile.transferTo(file);
	    } catch (IOException e) {
	        System.out.println("error with file");
	    }
	    userDao.save(user);
	}


	public User findUserTest(int id) {
	return userDao.findUserTest(id);
	}


	public void update(User user) {
		userDao.save(user);
		
	}


	public User findByUUID(String uuid) {
		
		return userDao.findByUUID(uuid);
	}



	
	
}
