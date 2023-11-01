package players;

public class Medic extends Hero{

    private int healPoints;
    public Medic(int health, int damage, int healPoints, String name) {
        super(health, damage, SuperAbility.HEAL, name);
        this.healPoints = healPoints;
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        System.out.println();
    }
}
