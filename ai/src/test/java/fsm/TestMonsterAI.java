package fsm;

import junit.framework.TestCase;

import java.util.Random;

/**
 * Created by Fangshuai on 2016/2/26.
 */
public class TestMonsterAI extends TestCase {

    MonsterData monster;
    HeroData hero;


    public void testAI() {
        System.out.print("START THE GAME!\n");
        int monsterNum = 3;
        int heroNum = 3;

        int i = 1;
        int j = 1;
        monster = createMonster(i);
        hero = createHero(j);
        while (i <= monsterNum && j <= heroNum) {

            if (!monster.isAlive()) {
                i++;
                if (i <= monsterNum)
                    monster = createMonster(i);
            }
            if (!hero.isAlive()) {
                j++;
                if (j <= heroNum)
                    hero = createHero(j);
            }
            stateChange();
        }
        if (i <= monsterNum)
            System.out.print("monster win \n");
        else System.out.print("hero win \n");
        System.out.print("OVER");
    }

    public void stateChange() {
        switch (monster.behavior) {
            case IDLE: {
                findProcess();
                return;
            }
            case ATTACK: {
                fightProcess();
                return;
            }
            case ESCAPE: {
                return;
            }
            default: {
                return;
            }
        }
    }

    public void findProcess() {
        if (hero.isAlive())
            if (new Random().nextBoolean()) {
                System.out.print("Monster find hero.\n");
                monster.findTarget();
            } else {
                System.out.print("Monster can't find hero.\n");
                monster.noTarget();
            }
    }

    public MonsterData createMonster(int i) {
        MonsterData monster = new MonsterData(i, (new Random().nextInt(9) + 1) * 2, new Random().nextInt(9) + 1);
        System.out.print("A new monster appear.\n");
        System.out.print("Monster Name is " + monster.id + " . Life is " + monster.life + " . Attack is " + monster.attack + " .\n");
        return monster;
    }

    public HeroData createHero(int i) {
        HeroData hero = new HeroData(i, (new Random().nextInt(9) + 1) * 2, new Random().nextInt(9) + 1);
        System.out.print("A new hero appear.\n");
        System.out.print("Hero Name is " + hero.id + " . Life is " + hero.life + " . Attack is " + hero.attack + " .\n");
        return hero;
    }

    public void fightProcess() {
        if (monster.isAlive() && hero.isAlive()) {
            System.out.print("Start Fight.\n");
            hero.beAttacked(monster.attack);
            System.out.print("Monster has Attacked . Hero " + hero.id + " life is " + hero.life + ".\n");
            if (!hero.isAlive()) {
                System.out.print("Hero " + hero.id + " dead.\n");
                monster.noTarget();
                return;
            }
            monster.beAttacked(hero.attack);
            System.out.print("Hero has Attacked . Monster " + monster.id + " life is " + monster.life + ".\n");
            if (!monster.isAlive()) {
                System.out.print("Monster " + monster.id + " dead.\n");
                return;
            }
        }
    }
}
