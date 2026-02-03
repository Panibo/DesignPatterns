package com.mariapori.factories;

import com.mariapori.components.Button;
import com.mariapori.components.Checkbox;
import com.mariapori.components.TextField;

public abstract class UIFactory {
    public abstract Button createButton(String text);

    public abstract TextField createTextField(String text);

    public abstract Checkbox createCheckbox(String text);
}
