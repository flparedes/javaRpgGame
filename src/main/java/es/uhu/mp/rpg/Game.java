package es.uhu.mp.rpg;

import es.uhu.mp.rpg.character.ICharacter;
import es.uhu.mp.rpg.exception.GameException;
import es.uhu.mp.rpg.exception.SceneException;
import es.uhu.mp.rpg.scene.Scene;

import java.util.HashMap;
import java.util.Map;

public class Game {
    private Map<String, Scene> scenes;
    private ICharacter player;
    private Scene currentScene;

    /**
     * Game constructor with the player character
     * @param player The new scene to add
     * @throws GameException If the player is null.
     */
    public Game(ICharacter player) throws GameException {
        if (player == null) {
            throw new GameException("The player cannot be null");
        }

        this.player = player;
    }

    /**
     * Sets the current scene with the loaded scene with the specified code
     * @param sceneCode The scene code
     * @throws SceneException If the scene code is null or empty.
     * @throws GameException If the game hasn't got a scene with the given code.
     */
    public void setCurrentSceneByCode(String sceneCode) throws SceneException, GameException {
        if (sceneCode == null || "".equals(sceneCode.trim())) {
            throw new SceneException("The scene code is null or empty");
        }

        if (!scenes.containsKey(sceneCode)) {
            throw new GameException("There is NO scene loaded in the game with the code: " + sceneCode);
        }

        this.currentScene = scenes.get(sceneCode);
    }

    /**
     * Adds a new Scene to the scenes map, using the scene name as the map key
     * @param scene The new scene to add
     * @throws GameException If the scene is null or there is already one with the same code.
     * @throws SceneException If the scene code is null or empty.
     */
    public void addScene(Scene scene) throws GameException, SceneException {
        if (scenes == null) {
            scenes = new HashMap<String, Scene>();
        }

        if (scene == null) {
            throw new GameException("Cannot add a null scene");
        }

        String sceneCode = scene.getCode();
        if (sceneCode == null || "".equals(sceneCode.trim())) {
            throw new SceneException("The scene must have a valid code");
        }

        if (scenes.containsKey(sceneCode)) {
            throw new GameException("There is already a game scene with this code: " + sceneCode);
        }

        scenes.put(sceneCode, scene);
    }

    /**
     * Runs the game until there is no next scene to run.
     * @throws GameException If the first scene is null and the game cannot be started.
     */
    public void run() throws GameException {
        String nextSceneCode = null;

        if (currentScene == null) {
            throw new GameException("The current scene is null");
        }

        do {
            nextSceneCode = currentScene.play(player);
            currentScene = scenes.get(nextSceneCode);
        } while(currentScene != null);
    }
}
