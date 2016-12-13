package ua.com.library.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import editor.QuestionEditor;
import editor.TestEditor;
import ua.com.library.dto.DtoUtilMapper;
import ua.com.library.entity.Answer;
import ua.com.library.entity.Question;
import ua.com.library.entity.Test;
import ua.com.library.entity.User;
import ua.com.library.service.AnswerService;
import ua.com.library.service.QuestionService;
import ua.com.library.service.TestService;

@Controller
public class AnswerController {
	@Autowired
	private QuestionService questionService;
	@Autowired
	private AnswerService answerService;

	
	
	@InitBinder
	public void InitBinder(WebDataBinder binder){
               binder.registerCustomEditor(Question.class, new QuestionEditor(questionService));
    }
	
	
	
	
	@RequestMapping(value="/saveGetAnswer", method=RequestMethod.POST)
		public @ResponseBody boolean saveGetAnswer(@RequestBody Answer answer){
		answerService.save(answer);
		return true;
	}
	
	
	
	
	@RequestMapping(value = "/addAnswers",method=RequestMethod.GET )
	public String newQuestion(Model model){

	//	model.addAttribute("questions", questionService.findAll());
		
		model.addAttribute("questions", DtoUtilMapper.questionToQuestionDto(questionService.findAll()));
		
		model.addAttribute("answer", new Answer());
	
		return "addAnswers";
	}

	
	@RequestMapping(value="/saveAnswer", method=RequestMethod.POST)
	public String click(@ModelAttribute Answer answer, Model model)
	{
		answerService.save(answer);
		return "redirect:/addAnswers";
		
	}
	
	
}
