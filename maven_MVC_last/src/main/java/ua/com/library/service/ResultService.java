package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Result;

public interface ResultService {

	void save(Result result);
	List<Result> findAll();
	void delete(int id);
	Result findOne(int id);
}
