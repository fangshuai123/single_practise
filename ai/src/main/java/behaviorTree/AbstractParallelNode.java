package behaviorTree;

import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

/**
 * Created by Fangshuai on 2016/3/2.
 */
public abstract class AbstractParallelNode extends AbstractNode{
    public AbstractParallelNode(String name) {
        super(name);
    }

    @Override
    public boolean execute(Hero hero, Monster monster) {
        return false;
    }
}
