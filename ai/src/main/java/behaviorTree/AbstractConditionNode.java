package behaviorTree;

import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public abstract class AbstractConditionNode extends AbstractNode {

    public AbstractConditionNode(String name) {
        super(name);
        this.nodeType = NodeType.CONDITION;
    }

    public abstract boolean choice(Hero hero, Monster monster);

    public boolean execute(Hero hero, Monster monster) {
        if (getChildNodeList().size() == 0)
//            System.out.println(name + "居然没有子节点？");
            ConstantUtil.logPrint(name + "居然没有子节点？");
        for (AbstractNode node : getChildNodeList()) {
            if (NodeExecute.nodeExecute(node, hero, monster))
                return true;
        }
        return false;
    }

}
