package io.github.hylinn.xwing.constraint.validation;

public interface ValidationResult {
    boolean isValid();
    String message();
}
