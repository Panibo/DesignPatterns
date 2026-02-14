package components;

public class ButtonB extends Button {
    public ButtonB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("=".repeat(text.length() + 6));
        System.out.println("|  " + text + "  |");
        System.out.println("=".repeat(text.length() + 6));
    }

}
