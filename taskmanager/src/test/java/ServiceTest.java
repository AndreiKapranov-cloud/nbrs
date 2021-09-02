import org.junit.Assert;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import service.ServiceImpl;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

public class ServiceTest {
    private final PrintStream standardOut = System.out;
    private final ByteArrayOutputStream outputStreamCaptor = new ByteArrayOutputStream();
    @Test
    public void givenSystemOutRedirection_whenInvokePrintln_thenOutputCaptorSuccess() {
        System.setOut(new PrintStream(outputStreamCaptor));
        List<Integer> numbers = new ArrayList<>();
        ServiceImpl serviceImpl = new ServiceImpl();
        numbers.add(2);
        numbers.add(4);
        numbers.add(6);
        serviceImpl.ShowTheResult(numbers);

        Assert.assertEquals("[2, 4, 6]\r\n" +
                        "Max= 6\r\n" +
                        "Min= 2\r\n" +
                        "Average= 4.0",
                outputStreamCaptor.toString()
                        .trim());

    }
    @AfterEach
    public void tearDown() {
        System.setOut(standardOut);
    }
}


