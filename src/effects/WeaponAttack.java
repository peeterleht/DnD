package effects;
import characters.Dude;

public class WeaponAttack implements Effect {

    private int damage;

    public WeaponAttack(int damage) {
        this.damage = damage;
    }

    @Override
    public void onHit(Dude effectTarget) {
        effectTarget.takeDamage(damage);
    }

    @Override
    public void onTurnStart(Dude effectTarget) {

    }

    @Override
    public void onTurnEnd(Dude effectTarget) {

    }

    @Override
    public int requiredActionPoints() {
        return 3;
    }

    @Override
    public boolean isExpired() {
        return true;
    }


}
