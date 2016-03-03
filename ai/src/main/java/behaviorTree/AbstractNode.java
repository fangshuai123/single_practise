package behaviorTree;

import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;

import java.util.ArrayList;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public abstract class AbstractNode {

    protected String name;

    protected Hero hero;
    protected Monster monster;

    private AbstractNode parentNode;

    private ArrayList<AbstractNode> childNodeList = new ArrayList<AbstractNode>();

    /**
     * SELECT 选择节点
     * PARALLEL 并行节点
     * CONDITION 条件节点
     * ACTION 动作节点，叶节点
     * SEQUENCE 顺序节点
     */
    protected enum NodeType {
        SELECTOR, PARALLEL, CONDITION, ACTION, SEQUENCE
    }

    public NodeType nodeType;

    public AbstractNode(String name) {
        this.name = name;
    }

    protected void setHero(Hero hero) {
        this.hero = hero;
    }

    protected void setMonster(Monster monster) {
        this.monster = monster;
    }

    protected void setHeroAndMonster(Hero hero, Monster monster) {
        this.hero = hero;
        this.monster = monster;
    }

    public abstract boolean execute(Hero hero, Monster monster);

    public void setParentNode(AbstractNode node) {
        parentNode = node;
    }

    public void addChildNode(AbstractNode node) {
        childNodeList.add(node);
        node.setParentNode(this);
    }

    public ArrayList<AbstractNode> getChildNodeList() {
        return childNodeList;
    }

    public AbstractNode getParentNode() {
        return parentNode;
    }

}
