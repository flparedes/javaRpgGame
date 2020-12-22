package es.uhu.mp.rpg;

public class Weapon {
    public static final char TYPE_DEX = 'D';
    public static final char TYPE_STR = 'S';

    private char type = TYPE_STR;
    private String name;
    private int damage;

    public Weapon(char type, String name, int damage) {
        switch (type) {
            case TYPE_DEX:
            case TYPE_STR:
                this.type = type;
                break;
            default:
                System.out.println("Tipo incorrecto");
        }
        this.name = name;
        this.damage = damage;
    }

    public char getType() {
        return type;
    }

    public int getDamage() {
        return damage;
    }

    @Override
    public String toString() {
        return "Weapon{type=" + type +
                ", name='" + name + '\'' +
                ", damage=" + damage + '}';
    }
}
