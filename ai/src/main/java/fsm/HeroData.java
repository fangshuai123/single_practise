package fsm;

/**
 * Created by Fangshuai on 2016/2/26.
 */
public class HeroData {

    public int life;
    public int attack;
    public int id;

    HeroData(int id, int life, int attack) {
        this.attack = attack;
        this.id = id;
        this.life = life;
    }

    public int beAttacked(int attack) {
        life = life - attack > 0 ? life - attack : 0;
        return life;
    }

    public boolean isAlive() {
        return life > 0;
    }
}
