package org.skypro.examQuestions.service;

import org.skypro.examQuestions.model.Question;

import java.util.Collection;
import java.util.HashSet;
import java.util.Random;
import java.util.Set;

public class ExaminerServiceImpl implements ExaminerService {

    private final QuestionService javaQuestionService;
    private final Random random = new Random();

    public ExaminerServiceImpl(QuestionService javaQuestionService) {
        this.javaQuestionService = javaQuestionService;
    }

    @Override
    public Collection<Question> getQuestions(int amount) {
        int totalQuestions = javaQuestionService.getAll().size();
        if (amount > totalQuestions || amount <= 0) {
            throw new IllegalArgumentException("BAD_REQUEST");
        }

        Set<Question> selectedQuestions = new HashSet<>();
        while (selectedQuestions.size() < amount) {
            selectedQuestions.add(javaQuestionService.getRandomQuestion());
        }
        return selectedQuestions;
    }
}

