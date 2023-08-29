package catering.businesslogic.kitchen;

import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.turn.Turn;
import catering.businesslogic.turn.TurnManager;
import catering.businesslogic.turn.TurnTable;
import catering.businesslogic.user.User;
import catering.persistence.PersistenceManager;
import catering.persistence.ResultHandler;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SheetManager {

    boolean verified = false;
    private SummarySheet sm;
    private static Map<Integer, KitchenTask> tasks = new HashMap<>();
    public SummarySheet modifySheet(SummarySheet sm){
        SummarySheet newOne = sm.modify();
        return newOne;
    }

    public Turn modifyAssignment(Turn turn, KitchenTask task, User cooker) {
        Turn newTurn = task.modifyAssignment(turn, cooker);
        newTurn.setComplete(true);
        return newTurn;
    }

    public TurnTable modifyTurnTable(TurnTable turnTable, Turn t_mod, User cooker) {
        TurnManager turnMgr = new TurnManager();
        Turn new_t_mod = turnMgr.modifyTurn(t_mod, cooker);;
        if(turnTable.listTurn.contains(t_mod)){
            int index = turnTable.listTurn.indexOf(t_mod);
            turnTable.listTurn.remove(t_mod);
            turnTable.listTurn.add(index, new_t_mod);
        }
        else{
                turnTable.listTurn.add(new_t_mod);
        }
        return turnTable;
    }

    public void updateRecipe(int id, String newname) {
        String update = "UPDATE Recipes SET name = '"+newname+"' WHERE id = "+id;
        int success = PersistenceManager.executeUpdate(update);
        if(success == 1) System.out.println("Aggiornamento avvenuto con successo!");
        else System.out.println("Impossibile aggiornare : id o nome inesistente!");
    }

    public void updateTask(int durata_new, String azione_new, int id){
        String update;
        if(durata_new == 0){
            update = "UPDATE Tasks SET azione_prep = '"+azione_new+"' WHERE id_task="+id;
        }
        if(azione_new.equals("")){
            update = "UPDATE Tasks SET duration = "+durata_new+" WHERE id_task="+id;
        }
        else{
            update = "UPDATE Tasks SET duration = "+durata_new+",  azione_prep = '"+azione_new+"' WHERE id_task="+id;
        }

        int success = PersistenceManager.executeUpdate(update);
        if(success == 1) System.out.println("Aggiornamento avvenuto con successo!");
        else System.out.println("Impossibile aggiornare : id o nome inesistente!");
    }

    public void deleteAssignmentById(int id){
        String delete = "DELETE FROM UserTasks WHERE id_task = "+id;
        int success = PersistenceManager.executeUpdate(delete);
        if(success == 0) System.out.println("Errore : id non valido!");
        else System.out.println("Eliminazione in tabella 'UserTasks' avvenuta con successo!");
    }

    public void deleteTask(int id){
        String delete = "DELETE from Tasks WHERE id_task = "+id;
        int success = PersistenceManager.executeUpdate(delete);
        if(success == 1) System.out.println("Eliminazione avvenuta con successo!");
        else System.out.println("Impossibile eliminare : id o nome inesistente!");
    }

    public void modifyAssignmentById(int idVecchio, int idCooker){
        String verifyIfCooker = "SELECT role_id FROM UserRoles WHERE user_id = "+idCooker+" AND role_id='c'";
        PersistenceManager.executeQuery(verifyIfCooker, new ResultHandler() {
            @Override
            public void handle(ResultSet rs) throws SQLException {
                char role = rs.getString("role_id").charAt(0);
                if(role == 'c'){
                    verified = true;
                    System.out.println("L'utente con id scelto è un cuoco!");
                }
                else{
                    System.out.println("L'utente con id scelto non è cuoco!");
                }
            }
        });
        if(verified){
            System.out.println("Modifichiamo...");
            String modify = "UPDATE UserTasks SET id_user = "+idCooker+" WHERE id_user="+idVecchio;
            int success = PersistenceManager.executeUpdate(modify);
            if(success == 1) System.out.println("Update del cuoco nuovo avvenuto con successo!");
            else System.out.println("Fallimento durante la query : idTask inserito potrebbe non esistere!");
        }
    }
}
