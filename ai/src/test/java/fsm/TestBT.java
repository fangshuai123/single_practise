package fsm;

import behaviorTree.NodeExecute;
import behaviorTree.RootNode;
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
import junit.framework.TestCase;

import javax.xml.soap.Node;
import java.util.Random;

/**
 * Created by Fangshuai on 2016/2/29.
 */
public class TestBT extends TestCase {
    Monster monster;
    Hero hero;

    public Monster createMonster(int i) {
        //        System.out.print("A new monster appear.\n");
//        System.out.print("Monster Name is " + monster.id + " . Life is " + monster.life + " . Attack is " + monster.attack + " .\n");
        return new Monster(i, new Random().nextInt(19) + 1,
                new Random().nextInt(9) + 1, new Random().nextInt(9) + 5);
    }

    public Hero createHero(int i) {
        //        System.out.print("A new hero appear.\n");
//        System.out.print("Hero Name is " + hero.id + " . Life is " + hero.life + " . Attack is " + hero.attack + " .\n");
        return new Hero(i, new Random().nextInt(19) + 1,
                new Random().nextInt(9) + 1, new Random().nextInt(9) + 1);
    }

    public RootNode createBT() {
        AttackSelectorNode attackSelectorNode = new AttackSelectorNode(NodeExecute.SELECTOR_ATTACK);

        FindHeroConditionNode findHeroConditionNode = new FindHeroConditionNode(NodeExecute.CONDITION_FIND_HERO);

        MonsterLevelAdvantageConditionNode monsterLevelAdvantageConditionNode = new MonsterLevelAdvantageConditionNode(NodeExecute.CONDITION_MONSTER_LEVEL_ADVAN);

        MonsterAttackActionNode monsterAttackActionNode = new MonsterAttackActionNode(NodeExecute.ACTION_MONSTER_ATTACK);


        findHeroConditionNode.addChildNode(monsterAttackActionNode);
        monsterLevelAdvantageConditionNode.addChildNode(monsterAttackActionNode);
        attackSelectorNode.addChildNode(monsterLevelAdvantageConditionNode);
        attackSelectorNode.addChildNode(findHeroConditionNode);

        IdleSelectorNode idleSelectorNode = new IdleSelectorNode(NodeExecute.SELECTOR_IDLE);

        BeStayingConditionNode beStayingConditionNode = new BeStayingConditionNode(NodeExecute.CONDITION_BE_STAYING);

        MonsterStayActionNode monsterStayActionNode = new MonsterStayActionNode(NodeExecute.ACTION_MONSTER_STAY);

        beStayingConditionNode.addChildNode(monsterStayActionNode);
        idleSelectorNode.addChildNode(beStayingConditionNode);

        RetreatSelectorNode retreatSelectorNode = new RetreatSelectorNode(NodeExecute.SELECTOR_RETREAT);
        MonsterIsFearedConditionNode monsterIsFearedConditionNode = new MonsterIsFearedConditionNode(NodeExecute.CONDITION_MONSTER_FREARED);
        MonsterHealActionNode monsterHealActionNode = new MonsterHealActionNode(NodeExecute.ACTION_MONSTER_HEAL);
        monsterIsFearedConditionNode.addChildNode(monsterHealActionNode);
        retreatSelectorNode.addChildNode(monsterIsFearedConditionNode);

        RootNode node = new RootNode("初始节点");

        node.addChildNode(retreatSelectorNode);
        node.addChildNode(idleSelectorNode);
        node.addChildNode(attackSelectorNode);

        return node;
    }

    public void testAI() {
        System.out.print("START THE GAME!\n");
        int monsterNum = 1000;
        int heroNum = 10;

        int i = 1;
        int j = 1;
        monster = createMonster(i);
        hero = createHero(j);
        RootNode rootNode = createBT();
        while (i <= monsterNum && j <= heroNum) {

            if (!monster.isAlive()) {
                i++;
                if (i <= monsterNum)
                    monster = createMonster(i);
            }
            if (!hero.isAlive()) {
                j++;
                if (j <= heroNum)
                    hero = createHero(j);
            }
            rootNode.execute(hero, monster);
        }
        if (i <= monsterNum)
            System.out.print("monster win \n" + "monster name is " + monster.id);
        else System.out.print("hero win \n" + "hero name is " + hero.id +
                "\nhero level is " + hero.level + "\nhero attack is " +
                hero.attack + "\nhero life is " + hero.curLife);
        System.out.print("\nOVER");
    }
}
