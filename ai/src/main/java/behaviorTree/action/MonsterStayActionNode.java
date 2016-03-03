package behaviorTree.action;

import behaviorTree.AbstractActionNode;
import behaviorTree.ConstantUtil;
import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public class MonsterStayActionNode extends AbstractActionNode {
    public MonsterStayActionNode(String name) {
        super(name);
    }


    public boolean execute(Hero hero, Monster monster) {
        setHeroAndMonster(hero, monster);
        this.monster = monster;
        ConstantUtil.logPrint("怪物" + monster.id + "回家去");
//        try {
//            Thread.currentThread().sleep(500);
//        } catch (InterruptedException e) {
//            return false;
//        }
        return true;
    }
}
