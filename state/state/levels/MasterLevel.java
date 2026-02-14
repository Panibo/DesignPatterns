package state.levels;
import state.GameCharacter;

public class MasterLevel implements Level{

    @Override
    public void train(GameCharacter gameCharacter) {
        System.out.println("Master doesn't need to train");
    }

    @Override
    public void meditate(GameCharacter gameCharacter) {
        System.out.println("Master doesn't need to meditate");
    }

    @Override
    public void fight(GameCharacter gameCharacter) {
        System.out.println("Master doesn't need to fight");
    }

    @Override
    public String getLevelName() {
        return "Master";
    }

  
}
