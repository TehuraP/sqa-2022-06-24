package at.campus02.sqa;

import org.junit.Before;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.*;

public class TestInput {

    private CustomQueue queue;
    private PrintWriter output;

    @Before
    public void setup() {
        queue = new CustomQueue();
        output = mock(PrintWriter.class);
    }

    @Test
    public void testNextItemOnEmptyQueue() {
        // given
        Scanner scanner = new Scanner("");
        Input input = new Input(scanner, output);
        // when
        input.nextItem(queue);
        // then
        verify(output, times(1)).println("Queue is empty");
    }

    @Test
    public void testHandleNext() {
        // given
        Scanner scanner = new Scanner("n\nn\nq\n");
        Input input = new Input(scanner, output);
        queue.push("one");
        queue.push("two");
        // when
        input.handle(queue);
        // then
        ArgumentCaptor<String> capture = ArgumentCaptor.forClass(String.class);
        verify(output, atLeast(2)).println(capture.capture());
        List<String> result = capture.getAllValues();
        assertEquals("> one", result.get(0));
        assertEquals("> two", result.get(1));
    }

    @Test
    public void testHandleAddingNewItems() {
        // given
        queue.push("one");
        Scanner scanner = new Scanner("two\nthree\nn\nn\nn\nq");
        Input input = new Input(scanner, output);
        // when
        input.handle(queue);
        // then
        ArgumentCaptor<String> printed = ArgumentCaptor.forClass(String.class);
        verify(output, times(3)).println(printed.capture());
        List<String> result = printed.getAllValues();
        assertEquals("> one", result.get(0));
        assertEquals("> two", result.get(1));
        assertEquals("> three", result.get(2));
    }
}
