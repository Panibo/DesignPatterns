package com.mariapori.components;

public class TextFieldB extends TextField {
    public TextFieldB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("=".repeat(text.length() + 6));
        System.out.println("|  " + text + "  |");
        System.out.println("=".repeat(text.length() + 6));
    }

}
