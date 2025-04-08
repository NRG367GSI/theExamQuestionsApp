package org.skypro.examQuestions.exception;

public class EmptyQuestionStorageException extends RuntimeException {
    public EmptyQuestionStorageException() {
        super("Хранилище вопросов пусто.");
    }

    public EmptyQuestionStorageException(String message) {
        super(message);
    }
}
