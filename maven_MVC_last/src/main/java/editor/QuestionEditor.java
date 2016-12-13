package editor;
import java.beans.PropertyEditorSupport;

import org.springframework.beans.factory.annotation.Autowired;

import ua.com.library.service.GroupsService;
import ua.com.library.service.QuestionService;

public class QuestionEditor  extends PropertyEditorSupport{




	 private final QuestionService questionService;
			
	


		
		public QuestionEditor(QuestionService questionService) {
		super();
		this.questionService = questionService;
	}





		@Override
		public void setAsText(String text) throws IllegalArgumentException {
			setValue(questionService.findOne(Integer.parseInt(text)));
		}
		
	}

