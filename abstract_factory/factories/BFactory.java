package factories;

import components.Button;
import components.ButtonB;
import components.Checkbox;
import components.CheckboxB;
import components.TextField;
import components.TextFieldB;

public class BFactory extends UIFactory {

    @Override
    public Button createButton(String text) {
        return new ButtonB(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldB(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxB(text);
    }

}
