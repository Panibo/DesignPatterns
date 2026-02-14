package factories;

import components.Button;
import components.ButtonA;
import components.Checkbox;
import components.CheckboxA;
import components.TextField;
import components.TextFieldA;

public class AFactory extends UIFactory {
    @Override
    public Button createButton(String text) {
        return new ButtonA(text);
    }

    @Override
    public TextField createTextField(String text) {
        return new TextFieldA(text);
    }

    @Override
    public Checkbox createCheckbox(String text) {
        return new CheckboxA(text);
    }

}
