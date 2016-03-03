package fsm;

/**
 * Created by Fangshuai on 2016/2/26.
 */
public class MonsterData {

    public int life;
    public int attack;
    public int id;

    public MonsterState.Behavior behavior;

    MonsterData(int id, int life, int attack) {
        this.attack = attack;
        this.id = id;
        this.life = life;
        behavior = MonsterState.Behavior.IDLE;
    }

    public int beAttacked(int attack) {
        life = life - attack > 0 ? life - attack : 0;
        return life;
    }

    public boolean isAlive() {
        return life > 0;
    }

    public void findTarget() {
        behavior = MonsterState.Behavior.ATTACK;
    }

    public void cantFight() {
        behavior = MonsterState.Behavior.ESCAPE;
    }

    public void loseTarget() {
        behavior = MonsterState.Behavior.RETURN;
    }

    public void noTarget() {
        behavior = MonsterState.Behavior.IDLE;
    }
}
