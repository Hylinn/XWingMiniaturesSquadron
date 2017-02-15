package io.github.hylinn.xwing.constraint.ship;

import io.github.hylinn.xwing.constraint.Constraint;
import io.github.hylinn.xwing.constraint.validation.ValidationResult;
import io.github.hylinn.xwing.constraint.validation.ValidationResultFactory;
import io.github.hylinn.xwing.ship.Ship;
import io.github.hylinn.xwing.squadron.Squadron;
import io.github.hylinn.xwing.upgrade.Upgrade;

import java.util.Collection;

public class ShipConstraint implements Constraint<Ship, Upgrade> {
    private final Collection<Constraint<Ship, Upgrade>> upgradeConstraints;
    private final ValidationResultFactory resultFactory;

    protected ShipConstraint(ShipConstraintBuilder builder) {
        this.upgradeConstraints = builder.upgradeConstraints;
        this.resultFactory = builder.factory;
    }

    @Override
    public ValidationResult validate(Ship ship, Upgrade upgrade) {
        for (Constraint<Ship, Upgrade> constraint : upgradeConstraints) {
            ValidationResult result = constraint.validate(ship, upgrade);
            if (!result.isValid())
                return result;
        }

        return resultFactory.createValidResult();
    }
}
