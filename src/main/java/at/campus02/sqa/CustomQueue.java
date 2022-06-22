package at.campus02.sqa;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Scanner;

public class CustomQueue {
    private final ArrayDeque<String> queue = new ArrayDeque<>();

    boolean isEmpty() {
        return queue.isEmpty();
    }

    String pop() {
        if (queue.isEmpty()) {
            return null;
        } else {
            return queue.pop();
        }
    }

    boolean push(String item) {
        if (item.isBlank() || item.contains("!")) {
            return false;
        }
        queue.add(item);
        return true;
    }

    static CustomQueue fromResource(String resource) throws URISyntaxException, FileNotFoundException {
        URL filePath = CustomQueue.class.getResource(resource);
        assert filePath != null;
        File initFile = new File(filePath.toURI());

        Scanner items = new Scanner(initFile);
        CustomQueue queue = new CustomQueue();

        while (items.hasNext()) {
            queue.push(items.nextLine());
        }

        return queue;
    }
}
