package at.campus02.sqa;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        CustomQueue queue = CustomQueue.fromResource("/items.txt");
        Scanner input = new Scanner(System.in);
        PrintWriter output = new PrintWriter(System.out, true);
        Input inputHandler = new Input(input, output);
        inputHandler.handle(queue);
    }

}
