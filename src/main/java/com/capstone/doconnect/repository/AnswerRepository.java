package com.capstone.doconnect.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.doconnect.entity.Answers;

@Repository
public interface AnswerRepository extends JpaRepository<Answers, Integer> {

	// List<Answers> findAllByQuestions(String question);
	Answers findByAnsid(int aid);

	List<Answers> findByQuestionsLike(int que);

	List<Answers> deleteAllByQuestionsQidLike(int qid);

}
