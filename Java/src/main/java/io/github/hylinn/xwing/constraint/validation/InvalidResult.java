package io.github.hylinn.xwing.constraint.validation;

public class InvalidResult implements ValidationResult {
    private final String message;

    public InvalidResult(String message) {
        this.message = message;
    }

    @Override
    public boolean isValid() {
        return false;
    }

    @Override
    public String message() {
        return message;
    }
}
