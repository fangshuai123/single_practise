package behaviorTree.condition;

import behaviorTree.AbstractConditionNode;
import behaviorTree.ConstantUtil;
import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

import java.util.Random;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public class FindHeroConditionNode extends AbstractConditionNode {


    public FindHeroConditionNode(String name) {
        super(name);
    }


    public boolean choice(Hero hero, Monster monster) {
        setHero(hero);
//        try {
//            Thread.currentThread().sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (hero.isAlive())
            if (new Random().nextInt(10) > 2) {
                ConstantUtil.logPrint("找到该死的英雄");
                return true;
            } else {
                ConstantUtil.logPrint("这次没找到");
                return false;
            }
        ConstantUtil.logPrint("英雄" + hero.id + "已经挂了，等着刷新");
        return false;
    }
}
