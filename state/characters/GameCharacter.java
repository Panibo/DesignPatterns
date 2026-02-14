package characters;

import levels.Level;
import levels.MasterLevel;
import levels.NoviceLevel;

public class GameCharacter {

    private String name;
    private int experiencePoints;
    private int healthPoints;
    private Level currentLevel;

    public GameCharacter(String name){
        this.name = name;
        this.experiencePoints = 0;
        this.healthPoints = 100;
        this.currentLevel = new NoviceLevel();
    }

    // CurrentLevel hoitaa metodien ajamisen
    public void train() {
        currentLevel.train(this);
    }

    public void meditate() {
        currentLevel.meditate(this);
    }

    public void fight() {
        currentLevel.fight(this);
    }

    public void setLevel(Level level){
        this.currentLevel = level;
    }

    public void addExperiencePoints(int exp){
        this.experiencePoints += exp;
    }

    public void addHealthPoints(int hp){
        this.healthPoints += hp;
    }

    public String getName(){ return name; }
    public int getExperiencePoints(){ return this.experiencePoints; }
    public int getHealthPoints(){ return this.healthPoints; }
    public String getLevelName (){ return this.currentLevel.getLevelName(); }

    public void displayStatus(){
        System.out.println("\n--------------");
        System.out.println(String.format("Name: %s", this.name));
        System.out.println(String.format("Level: %s", this.getLevelName()));
        System.out.println(String.format("Experience Points: %d", this.experiencePoints));
        System.out.println(String.format("Health Points: %d", this.healthPoints));
        System.out.println("--------------");
    }

    public boolean isMaster(){
        return currentLevel instanceof MasterLevel;
    }
}
