package pv260.solid.ocp.tweaked;

import java.util.Vector;

public class MasterPersistence implements Persistence {

    private final Vector<Persistence> persistenceEngines;

    public MasterPersistence() {
        this.persistenceEngines = new Vector<>();
    }

    public MasterPersistence addPersistence(Persistence persistence) {
        persistenceEngines.add(persistence);
        return this;
    }


    @Override
    public void persist(Comment comment) {

        for (Persistence pers: persistenceEngines) {
            pers.persist(comment);
        }
    }
}
