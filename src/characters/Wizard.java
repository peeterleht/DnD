package characters;

import effects.Effect;
import effects.Fireball;
import effects.Spiderweb;

import java.util.List;
import java.util.Random;

public class Wizard extends Dude {

    public Wizard() {
        super(
                20,
                10,
                40,
                25
        );
        skills = List.of(new Fireball(30),new Spiderweb());
    }

    @Override
    public void takeTurn(Dude attackTarget) {
        if (!isAlive() || actionPoints <= 0) {
            return;
        }

        applyEffects();

        actionPoints = Math.min(actionPoints + 4, 25);
        System.out.println("characters.Wizard action points: " + actionPoints);

       Effect randomEffect = getRandomEffect();
       

        System.out.println("characters.Wizard uses " + randomEffect.getClass().getSimpleName());
        randomEffect.onTurnStart(attackTarget);
        randomEffect.onTurnEnd(attackTarget);

        actionPoints -= randomEffect.requiredActionPoints();

        attackTarget.addEffect(randomEffect);
    }

}
