package es.uhu.mp.rpg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class Character implements ICharacter {
    protected static Map<Integer, Integer> LEVELS = new HashMap<Integer, Integer>();
    static {
        for (int i = 1; i <= 10; i++) {
            LEVELS.put(i, i * 500);
        }
    }

    private Random rand = new Random();
    private String name;
    private int str;
    private int dex;
    private int cons;
    private int hp;
    private int level = 1;
    private int experience = 0;

    private Weapon weapon;

    public Character(String name, int str, int dex, int cons, int hp) {
        this(name, str, dex, cons, hp, 1, 0);
    }

    public Character(String name, int str, int dex, int cons, int hp, int level, int experience) {
        this.name = name;
        this.str = str;
        this.dex = dex;
        this.cons = cons;
        this.hp = hp;
        this.level = level;
        this.experience = experience;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getStr() {
        return str;
    }

    public void setStr(int str) {
        this.str = str;
    }

    public int getDex() {
        return dex;
    }

    public void setDex(int dex) {
        this.dex = dex;
    }

    public int getCons() {
        return cons;
    }

    public void setCons(int cons) {
        this.cons = cons;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public void addExperience(int exp) {
        this.experience += exp;
        if (this.experience >= LEVELS.get(level)) {
            this.level++;
            // TODO - Incrementa las stats
        }
    }

    public int attack(ICharacter opponent) {
        int damage = 0;

        // 1 - Hacer una "tirada" para ver si el ataque surte efecto
        int attack = rand.nextInt(10) + 1 + this.dex;
        int defense = rand.nextInt(10) + 1 + opponent.getDex();

        // 2 - Mostrar la info del ataque
        System.out.println(this.name + " ataca con " + attack);
        System.out.println(opponent.getName() + " se defiende con " + defense);

        // 3 - Si el ataque impacta se calcula el daño en función del arma usada
        if (attack >= defense) {
            // TODO - Incluir el daño del arma, de momento supondremos un random de 5
            damage = rand.nextInt(5) + 1 + this.str;
            System.out.println(opponent.getName() + " recibe " + damage + " puntos de daño.");
        } else {
            System.out.println(opponent.getName() + " esquiva el ataque.");
        }

        return damage;
    }

    public void receiveDamage(int damage) {
        this.hp -= damage;
    }

    public boolean isDead() {
        return this.hp <= 0;
    }

    @Override
    public String toString() {
        return "Character{" +
                "name='" + name + '\'' +
                ", str=" + str +
                ", dex=" + dex +
                ", cons=" + cons +
                ", hp=" + hp +
                ", level=" + level +
                ", experience=" + experience +
                ", weapon=" + weapon +
                '}';
    }

    public Weapon getWeapon() {
        return weapon;
    }

    public void setWeapon(Weapon weapon) {
        this.weapon = weapon;
    }
}
