package behaviorTree.entity;

import java.util.Random;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public class Monster {
    public int maxLife;
    public int attack;
    public int id;
    public int curLife;
    public int level;
    public int exp;


    public Monster(int id, int life, int attack, int level) {
        this.attack = attack + id / 20;
        this.id = id;
        maxLife = life + id / 20;
        this.curLife = maxLife;
        this.level = level;
        exp = new Random().nextInt(49) + 51;
    }

    public int beAttacked(int attack) {
        curLife = curLife - attack > 0 ? curLife - attack : 0;
        return curLife;
    }

    public boolean isAlive() {
        return curLife > 0;
    }

    public boolean isFeared() {
        return (float) curLife / maxLife < 0.2;
    }

    public void heal() {
        curLife = curLife + 1;
    }
}
