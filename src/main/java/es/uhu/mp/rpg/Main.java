package es.uhu.mp.rpg;

import es.uhu.mp.rpg.character.Character;
import es.uhu.mp.rpg.character.ICharacter;
import es.uhu.mp.rpg.character.Weapon;
import es.uhu.mp.rpg.exception.GameException;
import es.uhu.mp.rpg.exception.SceneException;
import es.uhu.mp.rpg.scene.CombatScene;
import es.uhu.mp.rpg.scene.Option;
import es.uhu.mp.rpg.scene.OptionsScene;

public class Main {
    public static void main(String[] args) {
        try {
            Game game = loadGame();
            game.run();
        } catch (GameException | SceneException e) {
            System.out.println("Error loading game");
            e.printStackTrace();
        }
    }

    private static Game loadGame() throws GameException, SceneException {
        ICharacter player = loadPlayer();
        Game game = new Game(player);
        loadScenes(game);

        return game;
    }

    private static ICharacter loadPlayer() {
        ICharacter player = new Character("Player", 5, 6, 7, 10);
        System.out.println(player);

        Weapon wp1 = new Weapon('W', "Bomba", 100);
        System.out.println(wp1);

        ((Character)player).setWeapon(wp1);
        System.out.println(player);

        return player;
    }

    private static void loadScenes(Game game) throws GameException, SceneException {
        OptionsScene sc1 = new OptionsScene("START", "Inicio", "Esta es una escena de prueba");
        sc1.addOption(new Option("OP1", "SC_02"));
        sc1.addOption(new Option("OP2", "SC_03"));
        game.addScene(sc1);
        game.setCurrentSceneByCode(sc1.getCode());

        OptionsScene sc2 = new OptionsScene("SC_02", "Toca elegir", "Esta es la segunda escena escena de pruebas");
        sc2.addOption(new Option("OP2-1", "SC_03"));
        sc2.addOption(new Option("OP2-2", "START"));
        game.addScene(sc2);

        CombatScene sc3 = new CombatScene("SC_03", "Ataque Goblin","Aparecen dos Goblins que se interponen en tu camino, toca pelear.");
        sc3.setWinSceneCode("WIN_SC");
        sc3.setLoseSceneCode("LOSE_SC");
        sc3.addEnemy(new Character("Goblin 1", 3, 3, 2, 5));
        sc3.addEnemy(new Character("Goblin 2", 3, 3, 2, 5));
        game.addScene(sc3);

        OptionsScene winScene = new OptionsScene("WIN_SC", "Tenemos ganador", "Enhorabuena, has ganado. ¿Quieres intentarlo de nuevo?");
        winScene.addOption(new Option("Sí", "START"));
        winScene.addOption(new Option("No", null));
        game.addScene(winScene);

        OptionsScene loseScene = new OptionsScene("LOSE_SC", "Has morio", "¡Qué mala suerte, has perdido! ¿Quieres intentarlo de nuevo?");
        loseScene.addOption(new Option("Sí", "START"));
        loseScene.addOption(new Option("No", null));
        game.addScene(loseScene);
    }
}
