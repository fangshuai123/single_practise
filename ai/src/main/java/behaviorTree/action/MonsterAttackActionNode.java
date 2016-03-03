package behaviorTree.action;

import behaviorTree.AbstractActionNode;
import behaviorTree.ConstantUtil;
import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

import java.util.Random;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public class MonsterAttackActionNode extends AbstractActionNode {

    public MonsterAttackActionNode(String name) {
        super(name);
    }

    public boolean execute(Hero hero, Monster monster) {
        setHeroAndMonster(hero, monster);
//        try {
//            Thread.currentThread().sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (new Random().nextBoolean()) {
            hero.beAttacked(monster.attack);
            ConstantUtil.logPrint("Monster has Attacked . Hero " + hero.id + " life is " + hero.curLife + "");
            if (!hero.isAlive()) {
                ConstantUtil.logPrint("Hero " + hero.id + " dead.");
                return true;
            }
            monster.beAttacked(hero.attack);
            ConstantUtil.logPrint("Hero has Attacked . Monster " + monster.id + " life is " + monster.curLife);
            if (!monster.isAlive()) {
                ConstantUtil.logPrint("Monster " + monster.id + " dead");
                return true;
            }
        } else {
            monster.beAttacked(hero.attack);
            ConstantUtil.logPrint("Hero has Attacked . Monster " + monster.id + " life is " + monster.curLife);
            if (!monster.isAlive()) {
                ConstantUtil.logPrint("Monster " + monster.id + " dead");
                hero.LevelUp(monster.exp);
                return true;
            }
            hero.beAttacked(monster.attack);
            ConstantUtil.logPrint("Monster has Attacked . Hero " + hero.id + " life is " + hero.curLife + "");
            if (!hero.isAlive()) {
                ConstantUtil.logPrint("Hero " + hero.id + " dead.");
                return true;
            }
        }
        return true;
    }
}
