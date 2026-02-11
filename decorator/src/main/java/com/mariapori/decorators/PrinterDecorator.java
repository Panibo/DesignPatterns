package com.mariapori.decorators;

import com.mariapori.printers.Printer;

public abstract class PrinterDecorator implements Printer {

    protected Printer printer;

    public PrinterDecorator(Printer printer) {
        this.printer = printer;
    }
}
