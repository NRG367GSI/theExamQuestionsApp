package org.skypro.examQuestions.service;

import org.skypro.examQuestions.exception.DuplicateQuestionException;
import org.skypro.examQuestions.exception.NullQuestionException;
import org.skypro.examQuestions.exception.QuestionNotFoundException;
import org.skypro.examQuestions.model.Question;

import java.util.*;

public class JavaQuestionService implements QuestionService {

    private final Set<Question> questions = new HashSet<>();
    private final Random random = new Random();

    @Override
    public Question add(Question question) {
        if (question == null || question.getQuestion() == null || question.getAnswer() == null) {
            throw new NullQuestionException("Вопрос не может быть null.");
        }
        boolean exists = questions.stream()
                .anyMatch(q -> q.getQuestion().equalsIgnoreCase(question.getQuestion()) &&
                        q.getAnswer().equals(question.getAnswer())); // Учитываем и ответ при дублировании
        if (exists) {
            throw new DuplicateQuestionException("Такой вопрос уже существует.");
        }
        questions.add(question);
        return question;
    }

    @Override
    public Question find(String questionText) {
        return questions.stream()
                .filter(q -> q.getQuestion().equalsIgnoreCase(questionText))
                .findFirst()
                .orElseThrow(() -> new QuestionNotFoundException("Вопрос с текстом '" + questionText + "' не найден."));
    }

    @Override
    public Question remove(String questionText) {
        Question questionToRemove = find(questionText); // Используем метод find для поиска
        questions.remove(questionToRemove); // Удаляем найденный вопрос
        return questionToRemove;
    }

    @Override
    public Question getRandomQuestion() {
        if (questions.isEmpty()) {
            return null;
        }
        int randomIndex = random.nextInt(questions.size());
        Iterator<Question> iterator = questions.iterator();
        Question randomQuestion = null;
        for (int i = 0; i <= randomIndex; i++) {
            randomQuestion = iterator.next();
        }
        return randomQuestion;
    }

    @Override
    public Collection<Question> getAll() {
        return Collections.unmodifiableSet(questions);
    }
}
