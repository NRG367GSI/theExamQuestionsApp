package org.skypro.examQuestions.service;

import org.skypro.examQuestions.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(Question question);
    Question remove(String question);
    Question find(String question);
    Question getRandomQuestion();
    Collection<Question> getAll();
}
