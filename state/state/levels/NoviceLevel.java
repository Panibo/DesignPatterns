package state.levels;
import state.GameCharacter;

public class NoviceLevel implements Level{

    private final int TRAIN_XP = 20;
    private final int EXP_TO_NEXT = 100;

    @Override
    public void train(GameCharacter gameCharacter) {
        System.out.println(String.format("%s +%d EXP", gameCharacter.getName(), TRAIN_XP));
        gameCharacter.addExperiencePoints(TRAIN_XP);
        if(gameCharacter.getExperiencePoints() >= EXP_TO_NEXT){
            gameCharacter.setLevel(new IntermediateLevel());
            System.out.println(String.format("%s LEVEL UP [Intermediate]", gameCharacter.getName()));
        }
    }
// 🧙‍♂️
    @Override
    public void meditate(GameCharacter gameCharacter) {
        System.out.println("Novice can't meditate");
    }

    @Override
    public void fight(GameCharacter gameCharacter) {
        System.out.println("Novice can't fight");
    }

    @Override
    public String getLevelName() {
        return "Novice";
    }
    
}
