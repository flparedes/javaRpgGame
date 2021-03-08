package es.uhu.mp.rpg.scene;

public class Option {
    private String text;
    private String nextSceneCode;

    public Option(String text, String nextSceneCode) {
        this.text = text;
        this.nextSceneCode = nextSceneCode;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getNextSceneCode() {
        return nextSceneCode;
    }

    public void setNextSceneCode(String nextSceneCode) {
        this.nextSceneCode = nextSceneCode;
    }
}
