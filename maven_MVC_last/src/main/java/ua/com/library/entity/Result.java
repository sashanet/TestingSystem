package ua.com.library.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;

@Entity
public class Result {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@ManyToMany
	@JoinTable(name="result_users", joinColumns=@JoinColumn(name="id_results"), inverseJoinColumns=@JoinColumn(name="id_users"))
	private List<User> userList;
}
