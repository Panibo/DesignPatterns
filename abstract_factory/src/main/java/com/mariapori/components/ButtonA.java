package com.mariapori.components;

public class ButtonA extends Button {

    public ButtonA(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("-".repeat(text.length() + 6));
        System.out.println("|  " + text + "  |");
        System.out.println("-".repeat(text.length() + 6));
    }

}
