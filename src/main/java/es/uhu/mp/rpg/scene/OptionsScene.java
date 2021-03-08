package es.uhu.mp.rpg.scene;

import es.uhu.mp.rpg.character.ICharacter;
import es.uhu.mp.rpg.exception.SceneException;

import java.util.ArrayList;
import java.util.List;

public class OptionsScene extends BaseScene {
    private List<Option> options = new ArrayList<Option>();

    public OptionsScene(String code, String name, String text) {
        super(code, name, text);
    }

    public void addOption(Option option) {
        options.add(option);
    }

    private Option selectOption() {
        int optionSelected = -1;
        do {
            System.out.println("Selecciona una opción");
            for (int i = 0; i < options.size(); i++) {
                System.out.println((i + 1) + " - " + options.get(i).getText());
            }

            optionSelected = inputScaner.nextInt();
            optionSelected--;
        } while (optionSelected < 0 || optionSelected >= options.size());

        return options.get(optionSelected);
    }

    @Override
    public String play(ICharacter player) {
        // 1.- Mostrar el texto de la escena
        showText();

        Option optionSelected = selectOption();

        return optionSelected.getNextSceneCode();
    }
}
