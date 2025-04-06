package characters;

import java.util.ArrayList;
import java.util.List;

public abstract class Dude {
    protected int accuracy;
    protected int armor;
    protected int health;
    protected int actionPoints;
    private List<Effect> activeEffects = new ArrayList<>();

    public Dude(
            int accuracy,
            int armor,
            int health,
            int actionPoints
    ) {
        this.accuracy = accuracy;
        this.armor = armor;
        this.health = health;
        this.actionPoints = actionPoints;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public abstract void takeTurn(Dude attackTarget);

    public int getAccuracy() {
        return accuracy;
    }

    public int getArmor() {
        return armor;
    }

    public int getHealth() {
        return health;
    }

    public int getActionPoints() {
        return actionPoints;
    }

    public void takeDamage(int damage) {
        int effectiveDamage = Math.max(0, damage - armor);
        health -= effectiveDamage;
        System.out.println(getClass().getSimpleName() + " takes " + effectiveDamage + " damage" );
    }

    public void reduceActionPoints(int amount) {
        actionPoints = Math.max(0, actionPoints -  amount);
        System.out.println(getClass().getSimpleName() + " loses " + amount + " action points");
    }

    public void addEffect(Effect effect) {
        activeEffects.add(effect);
    }

    public void applyEffects() {
        for (Effect effect : activeEffects) {
            effect.onHit(this);
        }
        activeEffects.removeIf(Effect::isExpired);
    }

}
