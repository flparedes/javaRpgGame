package es.uhu.mp.rpg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Test;

public class CombatSceneTest extends BaseTest {

    @Test
    public void testCombatWinner() {
        // Indicar las entradas de teclado
        setMultiplesInputs("1", "2", "1", "2", "1", "2", "1", "2", "1", "2"); // 10 ataques, 5 al enemigo 1 y 5 al enemigo 2

        // Crear scena
        CombatScene scene = new CombatScene();

        // Añadir enemigos
        scene.addEnemy(new Character("Goblin 1", 1, 1, 1, 1));
        scene.addEnemy(new Character("Goblin 2", 1, 1, 1, 1));

        // Ejecutar escena
        Character player = new Character("Hero", 20, 20, 20, 20);
        setMultiplesInputs("1", "2", "1", "2", "1", "2", "1", "2", "1", "2"); // 10 ataques, 5 al enemigo 1 y 5 al enemigo 2
        scene.play(player);

        // Comprobar que ha ganado el jugador
        assertTrue("El jugador debería estar vivo", !player.isDead());
    }

    @Test
    public void testCombatLoser() {
        // Indicar las entradas de teclado
        setMultiplesInputs("1", "2", "1", "2", "1", "2", "1", "2", "1", "2"); // 10 ataques, 5 al enemigo 1 y 5 al enemigo 2

        // Crear scena
        CombatScene scene = new CombatScene();

        // Añadir enemigos
        scene.addEnemy(new Character("Gigante 1", 20, 20, 20, 20));
        scene.addEnemy(new Character("Gigante 2", 20, 20, 20, 20));

        // Ejecutar escena
        Character player = new Character("Hero", 1, 1, 1, 1);
        scene.play(player);

        // Comprobar que ha perdido el jugador
        assertTrue("El jugador debería estar muerto", player.isDead());
    }
}
