package general;

import players.*;

import java.util.Random;

public class RPG_game {
    public static Boss boss = new Boss(1000, 50, "Faraon");
    public static Warrior warrior = new Warrior(290, 10, "Alok");
    public static Warrior warrior2 = new Warrior(270, 15, "Scayler");
    public static Medic doc = new Medic(250, 5, 15, "Masim");
    public static Magic magic = new Magic(280, 20, "Kamil");
    public static Berserk berserk = new Berserk(260, 10, "Timur");
    public static Medic assistant = new Medic(300, 5, 5, "Olivia");
    public static Golem golem = new Golem(350, 15, "Antonio");
    public static Hero[] heroes = {warrior, warrior2, doc, magic, berserk, assistant, golem};

    public static Random random = new Random();

    private static int roundNumber;


    public static void startGame() {
        showStatistics(boss, heroes);
        roundNumber++;
        if (boss.getHealth() > 0) {
            bossAttack(boss, heroes);
            heroesAttack(boss, heroes);
            boss.chooseDefence();
            showStatistics(boss, heroes);
            roundNumber++;
        }
        showStatistics(boss, heroes);
        pleyRound();

    }

    public static void bossAttack(Boss boss, Hero[] heroes) {
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                heroes[i].setHealth(heroes[i].getHealth()-boss.getDamage());
                } else {
                System.out.println("Boss won !!!");
                }
            }
        }
    public static void heroesAttack(Boss boss, Hero[] heroes) {
        if (boss.getHealth() > 0) {
            for (int i = 0; i < heroes.length; i++) {
                if (heroes[i].getHealth() > 0 && boss.getHealth() > 0) {
                    int damage = heroes[i].getDamage();
                    boss.setHealth(boss.getHealth()-damage);
                    if (heroes[i].getAbility() == boss.getDefence()) {
                        Random random = new Random();
                        int coeff = random.nextInt(9) + 2;
                        damage = damage * coeff;
                        System.out.println("Critical damage: " + damage);
                        if (heroes[i].getHealth() <= 0) {
                            allHeroesDead = true;
                        } else {
                            break;
                        }
                    } else {

                    }
                    if (boss.getHealth() - damage < 0) {
                        boss.setHealth(5);
                    } else {
                        boss.setHealth(boss.getHealth() - damage);
                    }
                }else{
                    break;
                }
                break;
            }
        }
    }
    public static void showStatistics(Boss boss, Hero[] heroes) {
        System.out.println("ROUND " + roundNumber + " -----------------");
        System.out.println(boss);
        for (int i = 0; i < heroes.length; i++) {
            System.out.println(heroes[i]);
        }
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0 ) {
                System.out.println(  heroes[i].getDamage() + " health: " + heroes[i].getHealth() + " Ability: " + heroes[i].getAbility());
            }else if (heroes[i].getHealth() <= 0){
                heroes[i].getHealth();

                System.out.println(heroes[i] + "rip");


            }else {

            }

        }
    }

   public static boolean allHeroesDead = true;

    public static boolean isGameOver() {
        if (boss.getHealth() <= 0) {
            System.out.println("Heroes won");
            return true;
        }

        boolean allHeroesDead = true;
        for (int i = 0; i < heroes.length; i++) {
            if (heroes[i].getHealth() > 0) {
                allHeroesDead = false;

            }


        }
        if (allHeroesDead) {
            System.out.println("Boss won");
        }
        return allHeroesDead;
    }

    public static void pleyRound() {
        roundNumber++;
        if (boss.getHealth() < 0) {
            roundNumber++;
            boss.chooseDefence();
            bossAttack(boss, heroes);
            heroesAttack(boss, heroes);
            isGameOver();
        }else {
            showStatistics(boss, heroes);
            roundNumber++;
        }
        System.out.println("\nDraw !!!");
    }
}