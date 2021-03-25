package pv260.solid.ocp.tweaked;

import java.nio.file.Paths;
import java.util.Date;

public class Main {

    public static void main(String[] args) {
        Comment comment = new Comment("My comment",
                                      "This is interesting...",
                                      new Date(),
                                      "Pepa Zdepa");


        MasterPersistence masterPersistence = createPersistences();
        masterPersistence.persist(comment);
    }

    private static MasterPersistence createPersistences() {
        return new MasterPersistence()
                    .addPersistence(new XmlPersistence(Paths.get("comments.xml")))
                    .addPersistence(new CsvPersistence(Paths.get("comments.csv")))
                    .addPersistence(new JsonPersistence(Paths.get("comments.json")));
    }
}
