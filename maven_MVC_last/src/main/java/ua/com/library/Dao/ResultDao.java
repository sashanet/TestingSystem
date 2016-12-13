package ua.com.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;

import ua.com.library.entity.User;

public interface ResultDao extends JpaRepository<User, Integer>{

}
