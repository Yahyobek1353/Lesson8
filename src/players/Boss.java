package players;

import general.RPG_game;

public class Boss extends GameEntity{

    /**
     * Класс Босс конкретны игрово Босс у которого есть защита и Босс влетс игрово сущностью.
     * Поэтому наследуетс от класса GmeEntity и делаетс свка по конструктору.
     *
     * Защита Босса выбираетс от энам класса через вспомогательны метод SuperAbility.values()
     */

    private SuperAbility defence;

    public Boss(int health, int damage, String name) {
        super(health, damage, name);
    }


    public SuperAbility getDefence() {
        return defence;
    }

    public void chooseDefence(){
        SuperAbility[] values = SuperAbility.values();
        int index = RPG_game.random.nextInt(values.length);
        this.defence = values[index];
    }

    public void attack(Hero[] heroes){
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i] instanceof Berserk){
                int blocked;
                if (RPG_game.random.nextBoolean()){
                    blocked = this.getDamage() / 2;
                } else {
                    blocked = this.getDamage() / 5;
                }
                ((Berserk)heroes[i]).setBlockedDamage(blocked);
                heroes[i].setHealth(heroes[i].getHealth() - (this.getDamage() - blocked));
            } else {
                heroes[i].setHealth(heroes[i].getHealth() - this.getDamage());
            }
        }
    }
}
