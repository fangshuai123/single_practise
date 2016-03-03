package behaviorTree;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public abstract class AbstractActionNode extends AbstractNode {

    public AbstractActionNode(String name) {
        super(name);
        this.nodeType = NodeType.ACTION;
    }

}
