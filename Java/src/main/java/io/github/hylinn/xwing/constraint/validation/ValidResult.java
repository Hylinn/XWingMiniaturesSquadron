package io.github.hylinn.xwing.constraint.validation;

public class ValidResult implements ValidationResult {

    @Override
    public boolean isValid() {
        return true;
    }

    @Override
    public String message() {
        return "";
    }
}
