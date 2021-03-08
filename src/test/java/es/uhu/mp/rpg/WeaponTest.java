package es.uhu.mp.rpg;

import static org.junit.Assert.assertEquals;

import es.uhu.mp.rpg.character.Weapon;
import org.junit.Test;

public class WeaponTest extends BaseTest {

    @Test
    public void testNewWeapon() {
        // Arma con tipo correcto y válido
        Weapon wpn = new Weapon(Weapon.TYPE_DEX, "test", 10);
        assertEquals(Weapon.TYPE_DEX, wpn.getType());
        assertEquals("test", wpn.getName());
        assertEquals(10, wpn.getDamage());

        // Arma con tipo incorrecto y no válido
        Weapon wpn2 = new Weapon('-', "invalid-type", 10);
        assertEquals(Weapon.TYPE_STR, wpn2.getType());
        testSystemErrPrintln("Tipo incorrecto");
    }

    @Test
    public void testToString() {
        Weapon wpn = new Weapon(Weapon.TYPE_DEX, "test", 10);
        assertEquals("Weapon{type=D, name='test', damage=10}", wpn.toString());
    }
}
