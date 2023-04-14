package at.campus02.sqa;

import java.io.PrintWriter;
import java.util.Scanner;

public class Input {

    private final Scanner input;
    private final PrintWriter out;

    public Input(Scanner input, PrintWriter out) {
        this.input = input;
        this.out = out;
    }

    public void handle(CustomQueue queue) {
        while (true) {
            out.print(": ");
            out.flush();
            String line = input.nextLine();
            switch (line) {
                case "n":
                    if (queue.isEmpty()) {
                        out.println("Queue is empty");
                    } else {
                        String item = queue.pop();
                        out.println("> " + item);
                    }
                    break;
                case "q":
                    return;
                default:
                    queue.push(line);
                    break;
            }
        }
    }
}
