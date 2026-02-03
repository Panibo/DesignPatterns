package com.mariapori.components;

public class CheckboxB extends Checkbox {
    public CheckboxB(String text) {
        super(text);
    }

    @Override
    public void display() {
        System.out.println("====");
        System.out.println("|  | " + text);
        System.out.println("====");
    }

}
