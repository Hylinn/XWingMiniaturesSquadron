package io.github.hylinn.xwing.constraint;

public interface Constraint<L, R> {
    boolean validate(L left, R right);
}
