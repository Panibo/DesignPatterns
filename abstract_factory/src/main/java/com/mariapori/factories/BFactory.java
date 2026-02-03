package com.mariapori.factories;

import com.mariapori.components.Button;
import com.mariapori.components.ButtonB;
import com.mariapori.components.Checkbox;
import com.mariapori.components.CheckboxB;
import com.mariapori.components.TextField;
import com.mariapori.components.TextFieldB;

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
