package at.campus02.sqa;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayDeque;
import java.util.Scanner;

public class CustomQueue {
    private final ArrayDeque<String> queue = new ArrayDeque<>();

    /**
     * @return True if queue is empty, false otherwise
     */
    boolean isEmpty() {
        return queue.isEmpty();
    }

    /**
     * Return next item from queue
     * @return next item or null if queue is empty
     */
    String pop() {
        if (queue.isEmpty()) {
            return null;
        } else {
            return queue.pop();
        }
    }

    /**
     * Add an item to the queue.
     * If the item is a blank string or contains a "!" anywhere, then
     * the item is not added to the queue.
     * @param item Item to push to queue
     * @return true if adding was successful, false if item was not added
     */
    boolean push(String item) {
        if (item.isBlank() || item.contains("!")) {
            return false;
        }
        queue.add(item);
        return true;
    }

    /**
     * Create a CustomQueue and populate it with items from the specified resource file.
     * @param resource Path to resource file
     * @return Initialized CustomQueue
     * @throws URISyntaxException If resource path was not a valid path
     * @throws FileNotFoundException If resource was not found
     */
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
