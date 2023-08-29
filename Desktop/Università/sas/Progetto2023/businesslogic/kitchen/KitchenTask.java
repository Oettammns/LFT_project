package catering.businesslogic.kitchen;

import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.turn.Turn;
import catering.businesslogic.user.User;
import catering.persistence.PersistenceManager;
import catering.persistence.ResultHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class KitchenTask {

    private Recipe r;
    private Turn t;
    int id;
    private int id_prep;
    private int duration;
    String azionePrep;
    private boolean done;
    private static Map<Integer, KitchenTask> tasks = new HashMap<>();

    public KitchenTask(Recipe my_r) {
        r = my_r;
    }

    public KitchenTask(int id, int idPrep, String azionePrep, int duration, boolean done) {
        this.id = id;
        this.id_prep = idPrep;
        this.azionePrep = azionePrep;
        this.duration = duration;
        this.done = done;
    }

    private KitchenTask() {

    }

    public static ObservableList<KitchenTask> getAllTasks() {
        return FXCollections.observableArrayList(tasks.values());
    }

    public void create(Recipe r){

    }

    public void deleteAllKitchenJobs(){

    }

    public int getId() {
        return id;
    }

    @Override
    public String toString(){
        return "\nID:"+id+", ID_PREP:"+id_prep+", AZIONE_PREP:"+azionePrep+", DURATION:"+duration+", DONE:"+done+"";
    }

    public Turn modifyAssignment(Turn turn, User cooker) {
        /* Creazione nuovo turno */
        t.setStartTime(12);
        t.setEndTime(14);
        t.setCooker(cooker);
        t.setComplete(true);
        return t;
    }

    public static ObservableList<KitchenTask> loadAllTasks() {

        String query = "SELECT * FROM Tasks";
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                int id = rs.getInt("id_task");
                int id_prep = rs.getInt("id_prep");
                String azione_prep = rs.getString("azione_prep");
                int duration = rs.getInt("duration");
                boolean done = rs.getBoolean("done");
                KitchenTask task = new KitchenTask(id, id_prep, azione_prep, duration, done);
                tasks.put(id,task);
            }
        });
        ObservableList<KitchenTask> ret = FXCollections.observableArrayList(tasks.values());
        return ret;
    }
    public static KitchenTask loadKitchenTaskById(int id) {
        if (tasks.containsKey(id)) return tasks.get(id);
        KitchenTask kt = new KitchenTask();
        String query = "SELECT * FROM Tasks WHERE id = " + id;
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                kt.azionePrep = rs.getString("azione_prep");
                kt.id = id;
                tasks.put(id, kt);
            }
        });
        return kt;
    }

    public static KitchenTask loadKitchenTaskByIdFromUserTasks(int id) {
        /*if (tasks.containsKey(id)) return tasks.get(id);
        */
        KitchenTask kt = new KitchenTask();
        String query = "SELECT * FROM UserTasks WHERE id_task = " + id;
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                kt.id = rs.getInt("id_task");
                tasks.put(id, kt);
            }
        });
        return kt;
    }
}
