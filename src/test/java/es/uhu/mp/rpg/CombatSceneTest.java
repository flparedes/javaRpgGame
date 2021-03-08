package es.uhu.mp.rpg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import es.uhu.mp.rpg.character.Character;
import es.uhu.mp.rpg.scene.CombatScene;
import org.junit.Test;

public class CombatSceneTest extends BaseTest {
    private static final String WIN_SCENE_CODE = "win_scn";
    private static final String LOSE_SCENE_CODE = "lose_scn";

    @Test
    public void testCombatWinner() {
        // Indicar las entradas de teclado
        setMultiplesInputs("1", "2", "1", "2", "1", "2", "1", "2", "1", "2"); // 10 ataques, 5 al enemigo 1 y 5 al enemigo 2

        // Crear scena
        CombatScene scene = new CombatScene("Test", "Test name", "TestText");

        // Añadir enemigos
        scene.addEnemy(new Character("Goblin 1", 1, 1, 1, 1));
        scene.addEnemy(new Character("Goblin 2", 1, 1, 1, 1));

        // Añadir códigos de escenas de victoria y derrota
        scene.setWinSceneCode(WIN_SCENE_CODE);
        scene.setLoseSceneCode(LOSE_SCENE_CODE);

        // Ejecutar escena
        Character player = new Character("Hero", 20, 20, 20, 20);
        String nextSceneCode = scene.play(player);

        // Comprobar que ha ganado el jugador
        assertTrue("El jugador debería estar vivo", !player.isDead());
        assertEquals(nextSceneCode, WIN_SCENE_CODE);
    }

    @Test
    public void testCombatLoser() {
        // Indicar las entradas de teclado
        setMultiplesInputs("1", "2", "1", "2", "1", "2", "1", "2", "1", "2"); // 10 ataques, 5 al enemigo 1 y 5 al enemigo 2

        // Crear scena
        CombatScene scene = new CombatScene("Test", "Test name", "TestText");

        // Añadir enemigos
        scene.addEnemy(new Character("Gigante 1", 20, 20, 20, 20));
        scene.addEnemy(new Character("Gigante 2", 20, 20, 20, 20));

        // Añadir códigos de escenas de victoria y derrota
        scene.setWinSceneCode(WIN_SCENE_CODE);
        scene.setLoseSceneCode(LOSE_SCENE_CODE);

        // Ejecutar escena
        Character player = new Character("Hero", 1, 1, 1, 1);
        String nextSceneCode = scene.play(player);

        // Comprobar que ha perdido el jugador
        assertTrue("El jugador debería estar muerto", player.isDead());
        assertEquals(nextSceneCode, LOSE_SCENE_CODE);
    }
}
