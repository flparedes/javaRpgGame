package es.uhu.mp.rpg;

import es.uhu.mp.rpg.character.Character;
import es.uhu.mp.rpg.scene.Option;
import es.uhu.mp.rpg.scene.OptionsScene;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class OptionsSceneTest extends BaseTest {
    private static final String OPT1_SCENE_CODE = "opt1_scn";
    private static final String OPT2_SCENE_CODE = "opt2_scn";
    private static final String OPT3_SCENE_CODE = "opt3_scn";

    @Test
    public void testSelectValidOptions() {
        // Indicar las entradas de teclado
        setMultiplesInputs("0", "4", "1", "2", "3"); // Dos opciones no válidas y las 3 últimas correctas y consecutivas

        // Crear scena
        OptionsScene scene = new OptionsScene("Test", "Test name", "TestText");

        // Añadir opciones
        scene.addOption(new Option("Option 1", OPT1_SCENE_CODE));
        scene.addOption(new Option("Option 2", OPT2_SCENE_CODE));
        scene.addOption(new Option("Option 3", OPT3_SCENE_CODE));

        // Crear al jugador
        Character player = new Character("Hero", 20, 20, 20, 20);

        // Ejecutar la escena
        String nextSceneCode = scene.play(player);

        // Comprobar que la escena seleccionada es la 1
        assertEquals(nextSceneCode, OPT1_SCENE_CODE);

        // Repetir para las opciones 2 y 3
        nextSceneCode = scene.play(player);
        assertEquals(nextSceneCode, OPT2_SCENE_CODE);

        nextSceneCode = scene.play(player);
        assertEquals(nextSceneCode, OPT3_SCENE_CODE);
    }
}
