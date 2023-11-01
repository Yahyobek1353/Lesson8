package players;

public abstract class GameEntity {
    /**
     * Этот класс, абстрактны класс Игрова сущность от которо будут наследоватьс все игровые сущности
     * поэтому в этот класс добавлем все обобщенное.
     *
     * Так же добавлем геттеры и сеттеры во все пол
     */
    private String name;
    private int health;
    private int damage;

    protected GameEntity(int health, int damage, String name) {
        this.health = health;
        this.damage = damage;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public void setHealth(int health) {
        this.health = health;
    }

    public int getDamage() {
        return damage;
    }

    public void setDamage(int damage) {
        this.damage = damage;
    }

    @Override
    public String toString() {
        return this.name + " HEALTH " + this.health + " DAMAGE " + this.damage;
    }
}
