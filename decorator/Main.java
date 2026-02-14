import decorators.EncryptedPrinter;
import decorators.XMLPrinter;
import printers.BasicPrinter;
import printers.Printer;

public class Main {
    public static void main(String[] args) {
        Printer printer = new BasicPrinter();
        printer.print("Hello World!");

        Printer printer2 = new EncryptedPrinter(new XMLPrinter(new BasicPrinter()));
        printer2.print("Hello World!");

        Printer printer3 = new XMLPrinter(new EncryptedPrinter(new BasicPrinter()));
        printer3.print("Hello World!");

        Printer printer4 = new XMLPrinter(new BasicPrinter());
        printer4.print("Hello World!");
    }
}