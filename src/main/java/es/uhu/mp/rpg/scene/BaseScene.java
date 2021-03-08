package es.uhu.mp.rpg.scene;

import es.uhu.mp.rpg.character.ICharacter;
import es.uhu.mp.rpg.exception.SceneException;

import java.util.Scanner;

public abstract class BaseScene implements Scene {
    protected String code;
    protected String name;
    protected String text;

    protected Scanner inputScaner = new Scanner(System.in);

    public BaseScene(String code, String name, String text) {
        this.code = code;
        this.name = name;
        this.text = text;
    }

    /**
     * Plays the scene with the character data. When the scene finishes
     * it returns the next scene code.
     * @param player the player who plays the scene.
     * @return the next scene code.
     */
    public abstract String play(ICharacter player);

    public void showText() {
        System.out.println(text);
    }

    public String getCode() { return code; }

    public void setCode(String code) { this.code = code; }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
