package catering.businesslogic.turn;

import catering.businesslogic.kitchen.KitchenTask;
import catering.businesslogic.user.User;
import catering.persistence.PersistenceManager;
import catering.persistence.ResultHandler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class Turn {
    private boolean complete;
    private int startTime;
    private int endTime;
    private int id;
    private int id_user;
    private User cooker;

    private static Map<Integer, Turn> turn = new HashMap<>();
    public Turn(){

    }

    public Turn(int startTime, int endTime, int id) {
        this.complete = false;
        this.startTime = startTime;
        this.endTime = endTime;
        this.id = id;
    }
    public User getCooker() {
        return cooker;
    }

    public void setCooker(User cooker) {
        this.cooker = cooker;
    }

    public void setComplete(boolean complete) {
        this.complete = complete;
    }

    public boolean isComplete() {
        return complete;
    }

    public boolean hasCooker() throws NullPointerException{
        if(this.getCooker() == null) return false;
        return true;
    }

    public int getId() {
        return this.id;
    }

    public int getStartTime() {
        return startTime;
    }

    public int getEndTime() {
        return endTime;
    }

    public void setStartTime(int startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(int endTime) {
        this.endTime = endTime;
    }

    @Override
    public String toString(){
        return "[ Cooker : "+this.cooker+" | Ora_Inizio : "+this.startTime+" | Ora_Fine : "+this.endTime+" | Exausted = "+this.complete+" ]";
    }

    /* Query di inserimento in tabella del turno creato */
    public static Turn loadTurnById(int id) {
        Turn t = new Turn();
        String query = "SELECT * FROM Turn WHERE id = " + id;
        PersistenceManager.executeQuery(query, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                t.startTime = rs.getInt("start_time");
                t.endTime = rs.getInt("end_time");
                t.id = id;
                turn.put(t.id, t);
            }
        });
        return t;
    }

}
