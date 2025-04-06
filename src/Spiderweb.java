public class Spiderweb implements Effect {

    private int turnsRemaining = 2;

    @Override
    public void onHit(Dude effectTarget) {

    }

    @Override
    public void onTurnStart(Dude effectTarget) {
        if (turnsRemaining > 0) {
            effectTarget.reduceActionPoints(7);
            turnsRemaining--;
        }
    }

    @Override
    public void onTurnEnd(Dude effectTarget) {

    }

    @Override
    public int requiredActionPoints() {
        return 10;
    }

    @Override
    public boolean isExpired(){
        return turnsRemaining <= 0;
    }
}
