package es.uhu.mp.rpg.scene;

import es.uhu.mp.rpg.character.ICharacter;

public interface Scene {
    /**
     * Plays the scene with the character data. When the scene finishes
     * it returns the next scene code.
     * @param player the player who plays the scene.
     * @return the next scene code.
     */
    String play(ICharacter player);

    /**
     * Shows the scene text in the console.
     */
    void showText();

    String getCode();

    void setCode(String code);

    String getName();

    void setName(String name);

    String getText();

    void setText(String text);
}
