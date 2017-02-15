package io.github.hylinn.xwing.constraint.validation;

public class ValidationResultFactory {
    public ValidationResult createValidResult() {
        return new ValidResult();
    }

    public ValidationResult createInvalidResult(String message) {
        return new InvalidResult(message);
    }
}
