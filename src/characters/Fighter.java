package characters;

import effects.Knockdown;
import effects.WeaponAttack;

import java.util.Random;

public class Fighter extends Dude {

    public Fighter() {
        super(
                10,
                20,
                50,
                15
        );
    }

    @Override
    public void takeTurn(Dude attackTarget) {
        if (!isAlive() || actionPoints <= 0) {
            return;
        }

        applyEffects();

        actionPoints = Math.min(actionPoints + 2, 15);
        System.out.println("characters.Fighter action points: " + actionPoints);

        if (actionPoints < 5) {  // Not enough action points case
            System.out.println("Not enough action points");
            return;
        }

        Random r = new Random();
        Effect attackEffect;

        if (r.nextBoolean()) {
            attackEffect = new WeaponAttack(20);
        } else {
            attackEffect = new Knockdown();
        }

        System.out.println("characters.Fighter uses " + attackEffect.getClass().getSimpleName());
        attackEffect.onHit(attackTarget);

        actionPoints -= attackEffect.requiredActionPoints();
    }
}
