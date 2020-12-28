package es.uhu.mp.rpg;

import java.util.List;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class BaseScene {
    protected String name;
    protected String text;
    protected BaseScene nextScene;

    protected Scanner inputScaner = new Scanner(System.in);

    public abstract void play(Character player);

    public void showText() {
        System.out.println(text);
    }

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

    public BaseScene getNextScene() {
        return nextScene;
    }

    public void setNextScene(BaseScene nextScene) {
        this.nextScene = nextScene;
    }
}
