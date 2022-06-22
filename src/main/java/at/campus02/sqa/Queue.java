package at.campus02.sqa;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Scanner;

public class Queue {

    static ArrayDeque<String> queue = new ArrayDeque<>();

    public static void main(String[] args) throws URISyntaxException, FileNotFoundException {
        URL filePath = Queue.class.getResource("/items.txt");
        assert filePath != null;
        File initF = new File(filePath.toURI());

        Scanner items = new Scanner(initF);
        while (items.hasNext()) {
            queue.add(items.nextLine());
        }

        Scanner input = new Scanner(System.in);
    InputLoop:
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
                    break InputLoop;
                default:
                    queue.add(line);
                    break;
            }
        }
    }

}
