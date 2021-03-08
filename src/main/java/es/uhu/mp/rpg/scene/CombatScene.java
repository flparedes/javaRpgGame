package es.uhu.mp.rpg.scene;

import es.uhu.mp.rpg.character.Character;
import es.uhu.mp.rpg.character.ICharacter;

import java.util.List;
import java.util.ArrayList;

public class CombatScene extends BaseScene {
    private List<Character> enemies = new ArrayList<Character>();
    private String winSceneCode;
    private String loseSceneCode;

    public CombatScene(String code, String name, String text) {
        super(code, name, text);
    }

    public void addEnemy(Character enemy) {
        enemies.add(enemy);
    }

    private Character selectEnemy() {
        int enemySelected = -1;
        do {
            System.out.println("Selecciona a que enemigo atacar");
            for (int i = 0; i < enemies.size(); i++) {
                System.out.println((i + 1) + " - " + enemies.get(i).getName());
            }

            enemySelected = inputScaner.nextInt();
            enemySelected--;
        } while (enemySelected < 0 || enemySelected >= enemies.size());

        return enemies.get(enemySelected);
    }

    @Override
    public String play(ICharacter player) {
        boolean inCombat = true;
        int deadEnemies;

        // 1.- Mostrar el texto de la escena
        showText();

        do {
            deadEnemies = 0;

            // De momento no vamos a permitir huir del combate

            // 2.- Seleccionar enemigo
            Character enemySelected = selectEnemy();

            // 3.- Atacar al enemigo
            enemySelected.receiveDamage(player.attack(enemySelected));

            // 4.- Ahora atacan los enemigos (si siguen vivos)
            for (Character enemy: enemies) {
                if (enemy.isDead()) {
                    deadEnemies++;
                } else {
                    player.receiveDamage(enemy.attack(player));
                }
            }

            // 5.- Comprobar si el combate sigue
            inCombat = deadEnemies < enemies.size() && !player.isDead();
        } while (inCombat);

        return player.isDead() ? loseSceneCode : winSceneCode;
    }

    public String getWinSceneCode() {
        return winSceneCode;
    }

    public void setWinSceneCode(String winSceneCode) {
        this.winSceneCode = winSceneCode;
    }

    public String getLoseSceneCode() {
        return loseSceneCode;
    }

    public void setLoseSceneCode(String loseSceneCode) {
        this.loseSceneCode = loseSceneCode;
    }
}