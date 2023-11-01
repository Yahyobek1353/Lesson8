package players;

public class Magic extends Hero{
    public Magic(int health, int damage, String name) {
        super(health, damage, SuperAbility.BOOST, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {
        System.out.println("Kамил приминил: Клонирование");//Способность создавать свои точные материальные копии, которыми вы телепатически управляете, клоны неможет нанести урон боссу.
    }
}
