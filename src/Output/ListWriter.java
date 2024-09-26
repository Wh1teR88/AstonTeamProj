package Output;

import Entity.Animal;
import Entity.Barrel;
import Entity.Person;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.List;

public class ListWriter {

    public static <T> void writeAll(List<T> list) {
        writeReadable(list);
        writeReusable(list);
    }

    public static <T> void writeReadable(List<T> list) {

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter("Readable.txt"));) {
            int index = 0;
            for (T t : list) {
                bWriter.write(index++ + ". ");
                bWriter.write(t.toString());
                bWriter.write("\n");
            }
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
        }

    }

    public static <T> void writeReusable(List<T> list) {

        try (BufferedWriter bWriter = new BufferedWriter(new FileWriter("Output.txt"));) {
            for (T t : list) {
                if (t instanceof Animal) {
                    bWriter.write(((Animal) t).prepareToWrite());
                }
                if (t instanceof Barrel) {
                    bWriter.write(((Barrel) t).prepareToWrite());
                }
                if (t instanceof Person) {
                    bWriter.write(((Person) t).prepareToWrite());
                }
                bWriter.write("\n");
            }
        } catch (
                IOException ioe) {
            ioe.printStackTrace();
        }

    }
}
