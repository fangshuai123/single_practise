package behaviorTree.condition;

import behaviorTree.AbstractConditionNode;
import behaviorTree.ConstantUtil;
import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

import java.util.Random;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public class BeStayingConditionNode extends AbstractConditionNode{
    public BeStayingConditionNode(String name) {
        super(name);
    }


    public boolean choice(Hero hero, Monster monster) {
//        try {
//            Thread.currentThread().sleep(500);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        if (new Random().nextBoolean()) {
            ConstantUtil.logPrint("没有待在原地");
            return true;
        } else {
            ConstantUtil.logPrint("待在原地");
            return false;
        }
    }
}
