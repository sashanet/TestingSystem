package ua.com.library.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;

import ua.com.library.Dao.AnswerDao;
import ua.com.library.Dao.GroupsDao;
import ua.com.library.Dao.TestDao;
import ua.com.library.entity.Answer;
import ua.com.library.entity.Groups;
import ua.com.library.entity.Question;
import ua.com.library.entity.Test;
import ua.com.library.service.AnswerService;
import ua.com.library.service.QuestionService;
import ua.com.library.service.TestService;

@Service
public class TestServiceImpl implements TestService{

	
	@Autowired
	private TestDao testDao;
	
	@Autowired
	private GroupsDao groupsDao;
	@Autowired
	private AnswerService answerService;
	@Autowired
	private QuestionService questionService;
	
	
	public void save(Test test) {
		testDao.save(test);
		
	}

	public List<Test> findAll() {
		return testDao.findAll();
	}

	public Test findOne(int id) {
		
		return testDao.findOne(id);
	}

	public void delete(int id) {
		Test test =testDao.findTestQuestionsAndAnswers(id);
		List<Question> qList =  test.getQuestionsList();

		for (Question question : qList) {
			List<Answer> answers = question.getAnswers();
			  for (Answer answer : answers) {
				answerService.delete(answer.getId());
			}
			 questionService.delete(question.getId());
		}
	
		testDao.delete(id);
		
	}
	
	public void addGroupsToTest(String [] tests, String [] groups){
		
		for (int i = 0; i < tests.length; i++) {
				Test test = testDao.findOne(Integer.parseInt(tests[i]));
				test.setGroupsList(null);
				testDao.save(test);
				List<Groups> groupList = new ArrayList<Groups>();
				for (int j = 0; j < groups.length; j++) {
					groupList.add(groupsDao.findOne(Integer.parseInt(groups[j])));
				}		
				test.setGroupsList(groupList);
				testDao.save(test);
		}				
						
	}

	public Test findTestQuestionsAndAnswers(int id) {
		
		return testDao.findTestQuestionsAndAnswers(id);
	}

	public Cookie cookieAdd(int id, HttpServletRequest request, HttpServletResponse response) {
		request.getSession(false);
		Test test = testDao.findOne(id);
		Cookie testshow = new Cookie(test.getName(), String.valueOf(test.getId()));
		testshow.setMaxAge(24*60*60*60);
		testshow.setHttpOnly(true);
		testshow.setPath("/");
		response.addCookie(testshow);
		return testshow;
	}

	public List<Test> returnCoockie(HttpServletRequest request, HttpServletResponse response) {
		Cookie[] cookies = request.getCookies();
		List<Test> tests = new ArrayList<Test>();
		
	try {
		
	for (Cookie cookie : request.getCookies()) {
			if (cookie.getName().equals("JSESSIONID")) {
				
			} else {
				
				try {
					tests.add(testDao.findOne(Integer.parseInt(cookie.getValue())));
				} catch (Exception e) {
					System.out.println("wrong");
				} 
			}
		
		
		
	}
	} catch (Exception e) {
		// TODO: handle exception
	}
		return tests;

	}
}