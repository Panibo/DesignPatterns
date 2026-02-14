package factories;

import components.Button;
import components.Checkbox;
import components.TextField;

public abstract class UIFactory {
    public abstract Button createButton(String text);

    public abstract TextField createTextField(String text);

    public abstract Checkbox createCheckbox(String text);
}
