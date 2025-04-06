public class Fireball implements Effect {

    private int damage;
    private boolean hasActivated = false;

    public Fireball(int damage) {
        this.damage = damage;
    }

    @Override
    public void onHit(Dude effectTarget) {

    }

    @Override
    public void onTurnStart(Dude effectTarget) {

    }

    @Override
    public void onTurnEnd(Dude effectTarget) {
        if (!hasActivated) {
            effectTarget.takeDamage(damage);
            hasActivated = true;
        }
    }

    @Override
    public int requiredActionPoints() {
        return 6;
    }

    @Override
    public boolean isExpired() {
        return hasActivated;
    }

}
