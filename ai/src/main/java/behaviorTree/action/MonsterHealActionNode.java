package behaviorTree.action;

import behaviorTree.AbstractActionNode;
import behaviorTree.ConstantUtil;
import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

import java.util.Random;

/**
 * Created by Fangshuai on 2016/3/1.
 */
public class MonsterHealActionNode extends AbstractActionNode {
    public MonsterHealActionNode(String name) {
        super(name);
    }

    @Override
    public boolean execute(Hero hero, Monster monster) {
        if (new Random().nextInt(10) > 8) {
            monster.heal();
            ConstantUtil.logPrint("monster " + monster.id + " 加了一滴血");
            return true;
        } else
            return false;
    }
}
