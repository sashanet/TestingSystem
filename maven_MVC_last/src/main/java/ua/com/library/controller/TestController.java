package ua.com.library.controller;

import java.util.List;
import java.util.Timer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import editor.GroupsEditor;
import editor.QuestionEditor;
import editor.TestEditor;

import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.WebDataBinder;

import ua.com.library.entity.Groups;
import ua.com.library.entity.Question;
import ua.com.library.entity.Test;
import ua.com.library.entity.User;
import ua.com.library.service.AnswerService;
import ua.com.library.service.GroupsService;
import ua.com.library.service.QuestionService;
import ua.com.library.service.TestService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
public class TestController {

	@Autowired
	private TestService testService;
	@Autowired
	private QuestionService questionService;
	@Autowired
	private GroupsService groupsService;
	@Autowired
	private AnswerService answerService;

	@InitBinder
	public void InitBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Question.class, new QuestionEditor(questionService));
		binder.registerCustomEditor(Test.class, new TestEditor(testService));
	}

	@RequestMapping(value = "/testAdd", method = RequestMethod.GET)
	public String newGroups(Model model) {
		model.addAttribute("tests", testService.findAll());
		model.addAttribute("groupsList", groupsService.getAll());
		model.addAttribute("groups", groupsService.getAll());
		model.addAttribute("questionsList", questionService.findAll());
		int i = 0;

		model.addAttribute("testin", new Test());

		return "testAdd";
	}

	@RequestMapping(value = "/starttest/{id}", method = RequestMethod.GET)
	public String starttest(Model model, @PathVariable int id, HttpServletRequest request,
			HttpServletResponse response) {

		model.addAttribute("test", testService.findTestQuestionsAndAnswers(id));
			
		testService.cookieAdd(id,request,response);

		return "starttest";
	}

	@RequestMapping(value = "/starttest/GiveAnswer", method = RequestMethod.POST)
	public String GiveAnswer(@RequestParam String answerid) {

		if (answerService.findOne(Integer.parseInt(answerid)).isCorrect()) {

			System.out.println("correct");
		}
		return "starttest";

	}
	
	@RequestMapping(value = "starttest/GiveAnswer", method = RequestMethod.GET)
	public String GiveAnswer() {

		System.out.println("some");
		return "starttest";

	}

	@RequestMapping(value = "/testSave", method = RequestMethod.POST)
	public String click(@RequestParam String name) {

		Test test = new Test(name);
		testService.save(test);

		return "redirect:/testAdd";

	}

	@RequestMapping(value = "/saveNewTest", method = RequestMethod.POST)
	public String saveNewTest(@ModelAttribute Test testin) {

		testService.save(testin);
		return "redirect:/testAdd";

	}

	@RequestMapping(value = "/deleteTest/{id}", method = RequestMethod.GET)
	public String newBook(@PathVariable int id) {

		testService.delete(id);

		return "redirect:/testAdd";
	}

	@RequestMapping(value = "/AddGroupsToTest", method = RequestMethod.POST)
	public String AddGroupsToTest(@RequestParam String[] tests, @RequestParam String[] groups) {

		testService.addGroupsToTest(tests, groups);

		return "redirect:/testAdd";
	}

}
