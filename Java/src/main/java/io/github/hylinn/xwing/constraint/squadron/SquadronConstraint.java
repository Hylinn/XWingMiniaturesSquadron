package io.github.hylinn.xwing.constraint.squadron;

import io.github.hylinn.xwing.constraint.Constraint;
import io.github.hylinn.xwing.constraint.validation.ValidationResult;
import io.github.hylinn.xwing.constraint.validation.ValidationResultFactory;
import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.squadron.Squadron;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;
import java.util.HashSet;

public class SquadronConstraint implements Constraint<Squadron, Object> {
    private final Collection<Constraint<Squadron, Upgrade>> upgradeConstraints;
    private final Collection<Constraint<Squadron, Ship>> shipConstraints;
    private final ValidationResultFactory resultFactory;

    protected SquadronConstraint(SquadronConstraintBuilder builder) {
        this.upgradeConstraints = builder.upgradeConstraints;
        this.shipConstraints = builder.shipConstraints;
        this.resultFactory = builder.factory;
    }

    @Override
    public ValidationResult validate(Squadron squadron, Object object) {
        if (object instanceof Upgrade)
            return validate(squadron, (Upgrade)object);
        if (object instanceof Ship)
            return validate(squadron, (Ship)object);

        return invalidClass(object.getClass());
    }

    public ValidationResult validate(Squadron squadron, Upgrade upgrade) {
        for (Constraint<Squadron, Upgrade> constraint : upgradeConstraints) {
            ValidationResult result = constraint.validate(squadron, upgrade);
            if (!result.isValid())
                return result;
        }

        return resultFactory.createValidResult();
    }

    public ValidationResult validate(Squadron squadron, Ship ship) {
        for (Constraint<Squadron, Ship> constraint : shipConstraints) {
            ValidationResult result = constraint.validate(squadron, ship);
            if (!result.isValid())
                return result;
        }

        return resultFactory.createValidResult();
    }

    protected ValidationResult invalidClass(Class clazz) {
        return resultFactory.createInvalidResult(clazz + " is not a supported validation class");
    }
}
