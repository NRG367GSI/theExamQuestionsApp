package org.skypro.examQuestions.model;

import java.util.Collection;

public interface QuestionService {
    Question add(String question, String answer);
    Question remove(String question, String answer);
    Question find(String question, String answer);
    Question getRandomQuestion();
    Collection<Question> getAll();
}
