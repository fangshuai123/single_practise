package behaviorTree.condition;

import behaviorTree.AbstractConditionNode;
import behaviorTree.ConstantUtil;
import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

/**
 * Created by Fangshuai on 2016/3/1.
 */
public class MonsterLevelAdvantageConditionNode extends AbstractConditionNode {
    public MonsterLevelAdvantageConditionNode(String name) {
        super(name);
    }

    @Override
    public boolean choice(Hero hero, Monster monster) {
        setHeroAndMonster(hero, monster);
        if (monster.level > hero.level + 5) {
            ConstantUtil.logPrint("Monster " + monster.id + "等级碾压");
            return true;
        } else
            return false;
    }
}
