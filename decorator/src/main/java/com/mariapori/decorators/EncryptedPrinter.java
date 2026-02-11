package com.mariapori.decorators;

import java.util.Base64;

import com.mariapori.printers.Printer;

public class EncryptedPrinter extends PrinterDecorator {

    public EncryptedPrinter(Printer printer) {
        super(printer);
    }

    @Override
    public void print(String message) {
        String encryptedMessage = encrypt(message);
        printer.print(encrypt(encryptedMessage));
    }

    private String encrypt(String message) {
        return Base64.getEncoder().encodeToString(message.getBytes());
    }

}
