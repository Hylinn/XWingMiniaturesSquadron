package io.github.hylinn.xwing.constraint.upgrade;

import io.github.hylinn.xwing.constraint.Constraint;
import io.github.hylinn.xwing.constraint.squadron.SquadronConstraintBuilder;
import io.github.hylinn.xwing.constraint.validation.ValidationResult;
import io.github.hylinn.xwing.constraint.validation.ValidationResultFactory;
import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.squadron.Squadron;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;

public class UpgradeConstraint implements Constraint<Upgrade, Object> {
    private final Collection<Constraint<Upgrade, Squadron>> squadronConstraints;
    private final Collection<Constraint<Upgrade, Ship>> shipConstraints;
    private final ValidationResultFactory resultFactory;

    protected UpgradeConstraint(UpgradeConstraintBuilder builder) {
        this.squadronConstraints = builder.squadronConstraints;
        this.shipConstraints = builder.shipConstraints;
        this.resultFactory = builder.factory;
    }

    @Override
    public ValidationResult validate(Upgrade upgrade, Object object) {
        if (object instanceof Squadron)
            return validate(upgrade, (Squadron)object);
        if (object instanceof Ship)
            return validate(upgrade, (Ship)object);

        return invalidClass(object.getClass());
    }

    public ValidationResult validate(Upgrade upgrade, Squadron squadron) {
        for (Constraint<Upgrade, Squadron> constraint : squadronConstraints) {
            ValidationResult result = constraint.validate(upgrade, squadron);
            if (!result.isValid())
                return result;
        }

        return resultFactory.createValidResult();
    }

    public ValidationResult validate(Upgrade upgrade, Ship ship) {
        for (Constraint<Upgrade, Ship> constraint : shipConstraints) {
            ValidationResult result = constraint.validate(upgrade, ship);
            if (!result.isValid())
                return result;
        }

        return resultFactory.createValidResult();
    }

    protected ValidationResult invalidClass(Class clazz) {
        return resultFactory.createInvalidResult(clazz + " is not a supported validation class");
    }
}
