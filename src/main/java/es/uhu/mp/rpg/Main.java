package es.uhu.mp.rpg;

public class Main {
    public static void main(String[] args) {
        ICharacter player = new Character("Player", 5, 6, 7, 10);
        System.out.println(player);

        Weapon wp1 = new Weapon('W', "Bomba", 100);
        System.out.println(wp1);

        ((Character)player).setWeapon(wp1);
        System.out.println(player);
    }
}
