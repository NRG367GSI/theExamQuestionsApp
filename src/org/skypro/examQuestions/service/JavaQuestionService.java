package org.skypro.examQuestions.service;

import org.skypro.examQuestions.model.Question;

import java.util.*;

public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(String question, String answer) {
        Question newQuestion = new Question(question, answer);
        questions.add(newQuestion);
        return newQuestion;
    }

    @Override
    public Question add(Question question) {
        questions.add(question);
        return question;
    }

    @Override
    public Question remove(String question, String answer) {
        Question questionToRemove = new Question(question, answer);
        if (questions.remove(questionToRemove)) {
            return questionToRemove;
        }
        return null;
    }

    @Override
    public Question remove(Question question) {
        if (questions.remove(question)) {
            return question;
        }
        return null;
    }

    @Override
    public Question find(String question, String answer) {
        Question questionToFind = new Question(question, answer);
        for (Question q : questions) {
            if (q.equals(questionToFind)) {
                return q;
            }
        }
        return null;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(questions.size());
        int currentIndex = 0;
        for (Question q : questions) {
            if (currentIndex == randomIndex) {
                return q;
            }
            currentIndex++;
        }
        return null;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
