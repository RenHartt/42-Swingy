package controller;

import org.jline.reader.*;
import org.jline.utils.*;

public class ConsoleInputHandler implements InputHandler {
    private LineReader reader;

    public ConsoleInputHandler() {
        this.reader = LineReaderBuilder.builder().build();
    }

    @Override
    public String getInput() {
        try {
            return reader.readLine(">> ");
        } catch (Exception e) {
            e.printStackTrace();
            return "";
        }
    }
}
