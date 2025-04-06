package characters;

import effects.Effect;
import effects.Knockdown;
import effects.WeaponAttack;

import java.util.List;
import java.util.Random;

public class Fighter extends Dude {

    public Fighter() {
        super(
                10,
                20,
                50,
                15
        );
        skills = List.of(new Knockdown(), new WeaponAttack(20));
    }

    @Override
    public void takeTurn(Dude attackTarget) {
        if (!isAlive() || actionPoints <= 0) {
            return;
        }

        applyEffects();

        actionPoints = Math.min(actionPoints + 2, 15);
        System.out.println("Fighter action points: " + actionPoints);

        Effect randomEffect = getRandomEffect();

        System.out.println("Fighter uses " + randomEffect.getClass().getSimpleName());
        randomEffect.onHit(attackTarget);

        actionPoints -= randomEffect.requiredActionPoints();
    }
}
