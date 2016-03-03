package behaviorTree.entity;

import behaviorTree.ConstantUtil;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public class Hero {
    public int maxLife;
    public int attack;
    public int id;
    public int curLife;
    public int level;
    public int exp = 0;

    public Hero(int id, int life, int attack, int level) {
        this.attack = attack;
        this.id = id;
        this.maxLife = life;
        this.curLife = life;
        this.level = level;
    }

    public int beAttacked(int attack) {
        curLife = curLife - attack > 0 ? curLife - attack : 0;
        return curLife;
    }

    public boolean isAlive() {
        return curLife > 0;
    }

    public boolean isFeared() {
        return (float) curLife / maxLife > 0.2;
    }

    public void LevelUp(int exp) {
        this.exp = (this.exp + exp) > 100 ? 0 : this.exp + exp;
        if (this.exp == 0) {
            level++;
            attack = attack + 5;
            maxLife = attack + 5;
            curLife = maxLife;
            ConstantUtil.logPrint("hero " + id + " level up ");
            ConstantUtil.logPrint("level is " + level);
            ConstantUtil.logPrint("attack is " + attack);
            ConstantUtil.logPrint("maxLife is " + maxLife);
        }
    }


}
