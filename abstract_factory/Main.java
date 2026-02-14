
import components.Button;
import components.Checkbox;
import components.TextField;
import factories.AFactory;
import factories.BFactory;
import factories.UIFactory;

public class Main {
    public static void main(String[] args) {
        UIFactory factoryA = new AFactory();
        UIFactory factoryB = new BFactory();

        // Create UI elements with Factory A
        Button buttonA = factoryA.createButton("OK");
        TextField textFieldA = factoryA.createTextField("Enter name");
        Checkbox checkboxA = factoryA.createCheckbox("Accept Terms");

        // Create UI elements with Factory B
        Button buttonB = factoryB.createButton("OK");
        TextField textFieldB = factoryB.createTextField("Enter name");
        Checkbox checkboxB = factoryB.createCheckbox("Accept Terms");

        // Display elements in Style A
        System.out.println("Style A:");
        buttonA.display();
        textFieldA.display();
        checkboxA.display();

        // Display elements in Style B
        System.out.println("\nStyle B:");
        buttonB.display();
        textFieldB.display();
        checkboxB.display();

        // Dymamic change of text
        System.out.println("\nDynamic change of text:");
        buttonA.setText("Cancel");
        buttonA.display();
    }
}