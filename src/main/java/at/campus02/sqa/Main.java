package at.campus02.sqa;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        CustomQueue queue = CustomQueue.fromResource("/items.txt");

        Scanner input = new Scanner(System.in);
        while (true) {
            System.out.print(": ");
            String line = input.nextLine();
            switch (line) {
                case "n":
                    if (queue.isEmpty()) {
                        System.out.println("Queue is empty");
                    } else {
                        String item = queue.pop();
                        System.out.println("> " + item);
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
