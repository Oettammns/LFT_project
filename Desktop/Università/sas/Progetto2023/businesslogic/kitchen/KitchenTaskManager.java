package catering.businesslogic.kitchen;

import catering.businesslogic.event.EventInfo;
import catering.businesslogic.event.ServiceInfo;
import catering.businesslogic.user.User;
import catering.persistence.PersistenceManager;
import catering.persistence.ResultHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;

public class KitchenTaskManager {
    private SummarySheet sheet;
    private EventInfo evt;
    private ServiceInfo srv;

    public void notifySheetGenerated(SummarySheet sheet){

    }

    public KitchenTaskManager() {
        KitchenTask.loadAllTasks();
    }

    public ObservableList<KitchenTask> getAllTasks() {
        return FXCollections.unmodifiableObservableList(KitchenTask.getAllTasks());
    }

    public SummarySheet generateSummarySheet(EventInfo event, ServiceInfo serv){
        return sheet;
    }

    public int getUserByIDTask(int id) {
        String selectTask = "SELECT id_user FROM `UserTasks` WHERE id_task = "+id;
        final int[] idUser = new int[1];
        PersistenceManager.executeQuery(selectTask, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                int idUser2 = rs.getInt("id_user");
                idUser[0] = idUser2;
            }
        });
        return idUser[0];
    }
}
