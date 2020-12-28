package es.uhu.mp.rpg;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;

/**
 * Clase base de test que se debe heredar para poder testear la salida por pantalla.
 */
public class BaseTest {
    protected final ByteArrayOutputStream outContent = new ByteArrayOutputStream();
    protected final ByteArrayOutputStream errContent = new ByteArrayOutputStream();

    private final PrintStream originalOut = System.out;
    private final PrintStream originalErr = System.err;
    private final InputStream originalIn = System.in;

    @Before
    public void setUpStreams() {
        System.setOut(new PrintStream(outContent));
        System.setErr(new PrintStream(errContent));
    }

    @After
    public void restoreStreams() {
        System.setOut(originalOut);
        System.setErr(originalErr);
        System.setIn(originalIn);
    }

    @Test
    public void testSystemPrintOutAndErr() {
        System.out.print("output");
        testSystemOutPrint("output");

        System.err.print("error");
        testSystemErrPrint("error");
    }

    @Test
    public void testSystemPrintlnOutAndErr() {
        System.out.println("output one line");
        testSystemOutPrintln("output one line");

        System.err.println("error one line");
        testSystemErrPrintln("error one line");
    }

    protected void testSystemOutPrint(String expectedText) {
        assertEquals(expectedText, outContent.toString());
    }

    protected void testSystemErrPrint(String expectedText) {
        assertEquals(expectedText, errContent.toString());
    }

    protected void testSystemOutPrintln(String expectedText) {
        assertTrue(outContent.toString() + " doesn't contains '" + expectedText + "'",
                outContent.toString().contains(expectedText));
    }

    protected void testSystemErrPrintln(String expectedText) {
        assertTrue(errContent.toString() + " doesn't contains '" + expectedText + "'",
                errContent.toString().contains(expectedText));
    }

    protected void setInput(String input) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
    }

    protected void setMultiplesInputs(String... inputs) {
        StringBuilder sb = new StringBuilder();
        for (String input: inputs) {
            sb.append(input).append(System.lineSeparator());
        }
        System.setIn(new ByteArrayInputStream(sb.toString().getBytes()));
    }
}
