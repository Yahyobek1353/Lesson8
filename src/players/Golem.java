package players;

public class Golem extends Hero{

    public Golem(int health, int damage, String name) {
        super(health, damage, SuperAbility.RETURN_SOME, name);
    }


    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        System.out.println("Антонио преминил супсобность");
    }
}
