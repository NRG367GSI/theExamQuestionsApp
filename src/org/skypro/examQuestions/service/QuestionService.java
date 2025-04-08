package org.skypro.examQuestions.service;

import org.skypro.examQuestions.model.Question;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question add(Question question);
    Question remove(String question, String answer);
    Question remove(Question question);
    Question find(String question, String answer);
    Question getRandomQuestion();
    Collection<Question> getAll();
}
