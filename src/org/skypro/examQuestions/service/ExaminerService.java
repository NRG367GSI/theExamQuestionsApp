package org.skypro.examQuestions.service;

import org.skypro.examQuestions.model.Question;

import java.util.Collection;

public interface ExaminerService {
    Collection<Question> getQuestions(int amount);
}
