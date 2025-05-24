import characters.Fighter;
import characters.Wizard;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Fighter fighter = new Fighter();
        Wizard wizard = new Wizard();

        int round = 1;
        while (fighter.isAlive() && wizard.isAlive()) {
            System.out.println("Round " + round);

            wizard.takeTurn(fighter);
            if(!fighter.isAlive()) {
                System.out.println("Fighter is dead");
                break;
            }

            fighter.takeTurn(wizard);
            if(!wizard.isAlive()) {
                System.out.println("Wizard is dead");
                break;
            }

            round++;
        }

        System.out.println("battle over");
    }
}