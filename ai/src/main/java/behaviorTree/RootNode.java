package behaviorTree;

import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public class RootNode extends AbstractSequenceNode {
    public RootNode(String name) {
        super(name);
    }

    public boolean execute(Hero hero, Monster monster) {
        for (AbstractNode node : getChildNodeList()) {
            if (monster.isAlive()) {
                if(NodeExecute.nodeExecute(node, hero, monster))
                    return true;
            }
        }
        return false;
    }
}
