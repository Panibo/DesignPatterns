package state.levels;
import state.GameCharacter;

public interface Level {
    void train(GameCharacter gameCharacter);
    void meditate(GameCharacter gameCharacter);
    void fight(GameCharacter gameCharacter);
    String getLevelName();
}
