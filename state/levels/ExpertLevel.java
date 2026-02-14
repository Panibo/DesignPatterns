package levels;

import characters.GameCharacter;

public class ExpertLevel implements Level{
    
    private final int TRAIN_XP = 40;
    private final int FIGHT_XP = 60;
    private final int FIGHT_HEALT_LOSS = -50;
    private final int EXP_TO_NEXT = 300;
    private final int MEDITATE_HEALTH_POINTS = 20;

    private void CheckNextLevel(GameCharacter gameCharacter){
        if(gameCharacter.getExperiencePoints() >= EXP_TO_NEXT){
            gameCharacter.setLevel(new MasterLevel());
            System.out.println(String.format("%s LEVEL UP [Master]", gameCharacter.getName()));
        }
    }

    @Override
    public void train(GameCharacter gameCharacter) {
        System.out.println(String.format("%s +%d EXP", gameCharacter.getName(), TRAIN_XP));
        gameCharacter.addExperiencePoints(TRAIN_XP);
        CheckNextLevel(gameCharacter);
    }

    @Override
    public void meditate(GameCharacter gameCharacter) {
        System.out.println(String.format("%s +%d HP", gameCharacter.getName(), MEDITATE_HEALTH_POINTS));
        gameCharacter.addHealthPoints(MEDITATE_HEALTH_POINTS);
    }

    @Override
    public void fight(GameCharacter gameCharacter) {
        if(gameCharacter.getHealthPoints() - FIGHT_HEALT_LOSS <= 0){
            System.out.println("Too little HP to fihght!");
            return;
        }
        System.out.println(String.format("%s won the monster +%d EXP -%d HP", gameCharacter.getName(), FIGHT_XP, FIGHT_HEALT_LOSS));
        gameCharacter.addHealthPoints(FIGHT_HEALT_LOSS);
        gameCharacter.addExperiencePoints(FIGHT_XP);
        CheckNextLevel(gameCharacter);
    }

    @Override
    public String getLevelName() {
        return "Expert";
    }
}
