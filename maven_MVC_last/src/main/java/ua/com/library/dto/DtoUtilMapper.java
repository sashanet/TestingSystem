package ua.com.library.dto;

import java.util.ArrayList;
import java.util.List;

import ua.com.library.entity.Groups;
import ua.com.library.entity.Question;
import ua.com.library.entity.User;

public class DtoUtilMapper {
	
	
	public static List<UserDto> usersToUserDtop(List<User> users){
				
		List<UserDto> userDtos = new ArrayList<UserDto>();
		for (User user : users) {
			
		UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPhone(user.getPhone());
		
		userDtos.add(userDto);
		}
		
		return userDtos;
		
		}
	
	public static List<GroupDto> groupsToGroupDdto(List<Groups> groups){
		List<GroupDto> groupDtos = new ArrayList<GroupDto>();
			for (Groups group : groups) {
				GroupDto groupDto = new GroupDto();
				groupDto.setName(group.getName());
				groupDto.setId(group.getId());
				groupDtos.add(groupDto);
			}
		return groupDtos;
		
	}
	
	
	public static List<QuestionDto> questionToQuestionDto(List<Question> questions){
	List<QuestionDto> questionDtos = new ArrayList<QuestionDto>();
	for (Question q : questions) {
		QuestionDto questionDto = new QuestionDto();
		questionDto.setId(q.getId());
		questionDto.setName(q.getName());
		questionDto.setPoints(q.getPoints());
		questionDto.setQuestion(q.getQuestion());
		questionDtos.add(questionDto);
		
	}
		return questionDtos;
	}
	
}
