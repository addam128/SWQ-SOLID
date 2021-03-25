package pv260.solid.ocp.tweaked;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static java.nio.charset.StandardCharsets.UTF_8;
import static java.nio.file.StandardOpenOption.APPEND;
import static java.nio.file.StandardOpenOption.CREATE;
import static java.nio.file.StandardOpenOption.WRITE;

public class CsvPersistence implements Persistence {

    private final Path csvFile;

    public CsvPersistence(Path csvFile) {
        this.csvFile = csvFile;
    }

    private void persistCsv(Comment comment) {
        try (BufferedWriter writer = Files.newBufferedWriter(csvFile,
                UTF_8,
                CREATE,
                APPEND,
                WRITE)) {
            writer.append(formatCsv(comment));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private String formatCsv(Comment comment) {
        return comment.getAuthor() + ", " + comment.getEntered() + ", " + comment.getHeadline() + ", "
                + comment.getText() + System.lineSeparator();
    }

    @Override
    public void persist(Comment comment) {
        persistCsv(comment);
    }
}
