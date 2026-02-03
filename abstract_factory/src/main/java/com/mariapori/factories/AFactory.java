package com.mariapori.factories;

import com.mariapori.components.Button;
import com.mariapori.components.ButtonA;
import com.mariapori.components.Checkbox;
import com.mariapori.components.CheckboxA;
import com.mariapori.components.TextField;
import com.mariapori.components.TextFieldA;

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
