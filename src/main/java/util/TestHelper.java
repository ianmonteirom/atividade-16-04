package util;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

public class TestHelper {
    public static void simulateInput(String input) {
        InputStream inputStream = new ByteArrayInputStream(input.getBytes());
        System.setIn(inputStream);
    }
}
