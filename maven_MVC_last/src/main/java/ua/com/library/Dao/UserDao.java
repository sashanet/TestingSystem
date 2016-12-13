package ua.com.library.Dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.Test;
import ua.com.library.entity.User;

public interface UserDao extends JpaRepository<User, Integer>{
	User findByEmail(String name);

	
@Query("select distinct u from User u left join fetch u.groups g left join fetch g.testsList where u.id =:id")	
User findUserTest(@Param("id") int id);
	
@Query("SELECT CASE WHEN COUNT(u) > 0 THEN true else false END FROM User u WHERE u.email =:email")
boolean userExistByEmail(@Param("email") String email);


@Query("select u from User u where u.UUID=:uuid")
User findByUUID(@Param("uuid") String uuid);
	
}
