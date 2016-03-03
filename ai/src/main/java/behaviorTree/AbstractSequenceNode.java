package behaviorTree;

import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

/**
 * Created by Fangshuai on 2016/3/1.
 */
public abstract class AbstractSequenceNode extends AbstractNode {
    public AbstractSequenceNode(String name) {
        super(name);
        this.nodeType = NodeType.SEQUENCE;
    }

    @Override
    public boolean execute(Hero hero, Monster monster) {
        if (getChildNodeList().size() < 1) {
            ConstantUtil.logPrint("居然没有子节点");
            return false;
        }
        for (AbstractNode node : getChildNodeList()) {
            NodeExecute.nodeExecute(node, hero, monster);
        }
        return true;
    }
}
