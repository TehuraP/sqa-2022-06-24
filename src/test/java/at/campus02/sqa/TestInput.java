package at.campus02.sqa;

import org.junit.Assert;
import org.junit.Test;
import org.mockito.ArgumentCaptor;

import static org.mockito.Mockito.*;

import java.io.PrintWriter;
import java.util.List;
import java.util.Scanner;

public class TestInput {

    @Test
    public void testNextItemOnEmptyQueue() {
        // given
        Scanner scanner = new Scanner("");
        PrintWriter output = mock(PrintWriter.class);
        Input input = new Input(scanner, output);
        CustomQueue queue = new CustomQueue();
        // when
        input.nextItem(queue);
        // then
        verify(output, times(1)).println("Queue is empty");
    }

    @Test
    public void testHandleNext() {
        // given
        Scanner scanner = new Scanner("n\nn\nq\n");
        PrintWriter output = mock(PrintWriter.class);
        Input input = new Input(scanner, output);
        CustomQueue queue = new CustomQueue();
        queue.push("one");
        queue.push("two");
        // when
        input.handle(queue);
        // then
        ArgumentCaptor<String> capture = ArgumentCaptor.forClass(String.class);
        verify(output, atLeast(2)).println(capture.capture());
        List<String> result = capture.getAllValues();
        Assert.assertEquals("> one", result.get(0));
        Assert.assertEquals("> two", result.get(1));
    }


}
