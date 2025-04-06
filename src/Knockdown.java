public class Knockdown implements Effect{
    @Override
    public void onHit(Dude effectTarget) {
        effectTarget.reduceActionPoints(effectTarget.getActionPoints());
    }

    @Override
    public void onTurnStart(Dude effectTarget) {

    }

    @Override
    public void onTurnEnd(Dude effectTarget) {

    }

    @Override
    public int requiredActionPoints() {
        return 5;
    }

    @Override
    public boolean isExpired() {
        return true;
    }
}
