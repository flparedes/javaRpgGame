package es.uhu.mp.rpg;

public interface ICharacter {
    String getName();

    void addExperience(int exp);

    int getStr();
    void setStr(int str);

	int getDex();
	void setDex(int dex);

	int getCons();
	void setCons(int cons);

	int getHp();
	void setHp(int hp);

    String toString();

    int attack(ICharacter opponent);
    void receiveDamage(int damage);

    boolean isDead();
}
