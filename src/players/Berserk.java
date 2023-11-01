package players;

public class Berserk extends Hero{
    private int blockedDamage;
    public Berserk(int health, int damage, String name) {
        super(health, damage, SuperAbility.BLOCK_DAMAGE_AND_REVERT, name);
    }

    @Override
    public void applySuperAbility(Boss boss, Hero[] heroes) {

    }

    public void setBlockedDamage(int blockedDamage) {
        this.blockedDamage = blockedDamage;
    }
}
