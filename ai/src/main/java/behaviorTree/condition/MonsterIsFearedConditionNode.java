package behaviorTree.condition;

import behaviorTree.AbstractConditionNode;
import behaviorTree.ConstantUtil;
import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

/**
 * Created by Fangshuai on 2016/3/1.
 */
public class MonsterIsFearedConditionNode extends AbstractConditionNode {
    public MonsterIsFearedConditionNode(String name) {
        super(name);
    }

    @Override
    public boolean choice(Hero hero, Monster monster) {
        if (monster.isFeared()) {
            ConstantUtil.logPrint("monster " + monster.id + " 好害怕");
            return true;
        }
        return false;
    }
}
