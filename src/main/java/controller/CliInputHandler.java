package controller;

import java.io.IOException;
import org.jline.terminal.Terminal;
import org.jline.terminal.TerminalBuilder;
import org.jline.utils.NonBlockingReader;

public class CliInputHandler implements InputHandler {
    private final NonBlockingReader reader;

    public CliInputHandler() throws IOException {
        Terminal terminal = TerminalBuilder.builder()
                                           .system(true)
                                           .jna(false)
                                           .jansi(true)
                                           .build();
        terminal.enterRawMode();
        this.reader = terminal.reader();
    }

    @Override
    public String getInput() {
        try {
            int code = reader.read();
            if (code < 0) return null;
            return Character.toString((char) code);
        } catch (IOException e) {
            e.printStackTrace();
            return null;
        }
    }
}
