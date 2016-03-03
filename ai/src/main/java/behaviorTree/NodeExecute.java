package behaviorTree;

import behaviorTree.action.MonsterAttackActionNode;
import behaviorTree.action.MonsterHealActionNode;
import behaviorTree.action.MonsterStayActionNode;
import behaviorTree.condition.BeStayingConditionNode;
import behaviorTree.condition.FindHeroConditionNode;
import behaviorTree.condition.MonsterIsFearedConditionNode;
import behaviorTree.condition.MonsterLevelAdvantageConditionNode;
import behaviorTree.entity.Hero;
import behaviorTree.entity.Monster;
import behaviorTree.selector.AttackSelectorNode;
import behaviorTree.selector.IdleSelectorNode;
import behaviorTree.selector.RetreatSelectorNode;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public class NodeExecute {

    /**
     * 条件节点
     */
    public static String CONDITION_FIND_HERO = "c_find_hero";
    public static String CONDITION_BE_STAYING = "c_be_staying";
    public static String CONDITION_MONSTER_FREARED = "c_monster_feared";
    public static String CONDITION_MONSTER_LEVEL_ADVAN = "c_monster_level_higher";

    /**
     * 选择节点
     */
    public static String SELECTOR_ATTACK = "s_attack";
    public static String SELECTOR_IDLE = "s_idle";
    public static String SELECTOR_RETREAT = "s_retreat";

    /**
     * 动作节点
     */
    public static String ACTION_MONSTER_ATTACK = "a_monster_attack";
    public static String ACTION_MONSTER_STAY = "a_monster_stay";
    public static String ACTION_MONSTER_HEAL = "a_monster_heal";


    public static boolean nodeExecute(AbstractNode ob, Hero hero, Monster monster) {
        ConstantUtil.logPrint("现在是" + ob.name + "节点在执行");
        switch (ob.nodeType) {
            case SELECTOR: {
                if (ob.name.equals(SELECTOR_ATTACK) && ob instanceof AttackSelectorNode) {
                    AttackSelectorNode node = (AttackSelectorNode) ob;
                    return node.execute(hero, monster);
                } else if (ob.name.equals(SELECTOR_IDLE) && ob instanceof IdleSelectorNode) {
                    IdleSelectorNode node = (IdleSelectorNode) ob;
                    return node.execute(hero, monster);
                } else if (ob.name.equals(SELECTOR_RETREAT) && ob instanceof RetreatSelectorNode) {
                    RetreatSelectorNode node = (RetreatSelectorNode) ob;
                    return node.execute(hero, monster);
                }
                return false;
            }
            case ACTION: {
                if (ob.name.equals(ACTION_MONSTER_ATTACK) && ob instanceof MonsterAttackActionNode) {
                    MonsterAttackActionNode node = (MonsterAttackActionNode) ob;
                    return node.execute(hero, monster);
                } else if (ob.name.equals(ACTION_MONSTER_STAY) && ob instanceof MonsterStayActionNode) {
                    MonsterStayActionNode node = (MonsterStayActionNode) ob;
                    return node.execute(hero, monster);
                } else if (ob.name.equals(ACTION_MONSTER_HEAL) && ob instanceof MonsterHealActionNode) {
                    MonsterHealActionNode node = (MonsterHealActionNode) ob;
                    return node.execute(hero, monster);
                }
                return false;
            }
            case CONDITION: {
                if (ob.name.equals(CONDITION_FIND_HERO) && ob instanceof FindHeroConditionNode) {
                    FindHeroConditionNode node = (FindHeroConditionNode) ob;
                    return node.choice(hero, monster) && node.execute(hero, monster);
                } else if (ob.name.equals(CONDITION_BE_STAYING) && ob instanceof BeStayingConditionNode) {
                    BeStayingConditionNode node = (BeStayingConditionNode) ob;
                    return node.choice(hero, monster) && node.execute(hero, monster);
                } else if (ob.name.equals(CONDITION_MONSTER_FREARED) && ob instanceof MonsterIsFearedConditionNode) {
                    MonsterIsFearedConditionNode node = (MonsterIsFearedConditionNode) ob;
                    return node.choice(hero, monster) && node.execute(hero, monster);
                } else if (ob.name.equals(CONDITION_MONSTER_LEVEL_ADVAN) && ob instanceof MonsterLevelAdvantageConditionNode) {
                    MonsterLevelAdvantageConditionNode node = (MonsterLevelAdvantageConditionNode) ob;
                    return node.choice(hero, monster) && node.execute(hero, monster);
                }
                return false;
            }
        }
        return false;
    }
}
