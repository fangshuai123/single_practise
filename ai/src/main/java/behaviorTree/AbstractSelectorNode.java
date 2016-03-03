package behaviorTree;

import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public abstract class AbstractSelectorNode extends AbstractNode {

    public AbstractSelectorNode(String name) {
        super(name);
        this.nodeType = NodeType.SELECTOR;
    }


    public boolean execute(Hero hero, Monster monster) {
        if (getChildNodeList().size() == 0)
            ConstantUtil.logPrint(name + "居然没有子节点？");
        for (AbstractNode node : getChildNodeList()) {
            if (node instanceof AbstractConditionNode) {
                if(NodeExecute.nodeExecute(node, hero, monster))
                    return true;
            }
        }
        return false;
    }
}
