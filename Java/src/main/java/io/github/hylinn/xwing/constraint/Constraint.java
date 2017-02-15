package io.github.hylinn.xwing.constraint;

import io.github.hylinn.xwing.constraint.validation.ValidationResult;

@FunctionalInterface
public interface Constraint<L, R> {
    ValidationResult validate(L left, R right);
}
