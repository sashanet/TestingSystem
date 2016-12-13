package ua.com.library.Dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import ua.com.library.entity.Test;

public interface TestDao  extends JpaRepository<Test,Integer>{

	
	

	@Query("select distinct t from Test t left join fetch t.questionsList q left join q.answers a where t.id =:id")	
	Test findTestQuestionsAndAnswers(@Param("id") int id);
	
}
