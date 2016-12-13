package ua.com.library.service;

import java.util.List;

import ua.com.library.entity.Question;
import ua.com.library.entity.Test;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public interface TestService {
	void save(Test test );

	List<Test> findAll();

	Test findOne(int id);

	void delete(int id);
	
	public void addGroupsToTest(String [] tests, String [] groups);
	
	
	Test findTestQuestionsAndAnswers(int id);
	Cookie cookieAdd(int id, HttpServletRequest request, HttpServletResponse response);
	List<Test> returnCoockie(HttpServletRequest request, HttpServletResponse response);
}
