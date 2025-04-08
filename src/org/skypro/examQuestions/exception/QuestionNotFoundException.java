package org.skypro.examQuestions.exception;

public class QuestionNotFoundException extends IllegalArgumentException {
    public QuestionNotFoundException(String message) {
        super(message);
    }

    public QuestionNotFoundException() {
        super("Вопрос не найден.");
    }
}
