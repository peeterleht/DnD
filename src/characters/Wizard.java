package characters;

import effects.Fireball;
import effects.Spiderweb;

import java.util.Random;

public class Wizard extends Dude {

    public Wizard() {
        super(
                20,
                10,
                40,
                25
        );
    }

    @Override
    public void takeTurn(Dude attackTarget) {
        if (!isAlive() || actionPoints <= 0) {
            return;
        }

        applyEffects();

        actionPoints = Math.min(actionPoints + 4, 25);
        System.out.println("characters.Wizard action points: " + actionPoints);

        Random r = new Random();
        Effect attackEffect;

        if(r.nextBoolean()) {
            attackEffect = new Fireball(20);
        } else {
            attackEffect = new Spiderweb();
        }

        System.out.println("characters.Wizard uses " + attackEffect.getClass().getSimpleName());
        attackEffect.onTurnStart(attackTarget);
        attackEffect.onTurnEnd(attackTarget);

        actionPoints -= attackEffect.requiredActionPoints();

        attackTarget.addEffect(attackEffect);
    }

}
