package levels;

import characters.GameCharacter;

public class IntermediateLevel implements Level {

    private final int TRAIN_XP = 30;
    private final int EXP_TO_NEXT = 200;
    private final int MEDITATE_HEALTH_POINTS = 10;

    @Override
    public void train(GameCharacter gameCharacter) {
        System.out.println(String.format("%s +%d EXP", gameCharacter.getName(), TRAIN_XP));
        gameCharacter.addExperiencePoints(TRAIN_XP);
        if(gameCharacter.getExperiencePoints() >= EXP_TO_NEXT){
            gameCharacter.setLevel(new ExpertLevel());
            System.out.println(String.format("%s LEVEL UP [Expert]", gameCharacter.getName()));
        }
    }

    @Override
    public void meditate(GameCharacter gameCharacter) {
        System.out.println(String.format("%s +%d HP", gameCharacter.getName(), MEDITATE_HEALTH_POINTS));
        gameCharacter.addHealthPoints(MEDITATE_HEALTH_POINTS);
    }

    @Override
    public void fight(GameCharacter gameCharacter) {
       System.out.println("Intermediate can't fight");
    }

    @Override
    public String getLevelName() {
        return "Intermediate";
    }
    
}
