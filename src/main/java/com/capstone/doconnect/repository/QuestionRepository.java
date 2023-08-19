package com.capstone.doconnect.repository;

import java.util.List;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.capstone.doconnect.entity.Questions;

@Repository
public interface QuestionRepository extends JpaRepository<Questions, Integer> {

	List<Questions> findByQueLike(String que);

	Questions findByQid(int qid);

	List<Questions> findAllByTopic(String topic);

}
