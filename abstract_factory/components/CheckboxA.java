package components;

public class CheckboxA extends Checkbox {
    public CheckboxA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("----");
        System.out.println("|  | " + text);
        System.out.println("----");
    }

}
