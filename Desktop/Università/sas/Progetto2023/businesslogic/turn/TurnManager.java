package catering.businesslogic.turn;

import catering.businesslogic.user.User;
import catering.persistence.PersistenceManager;

import java.util.ArrayList;

public class TurnManager {

    ArrayList<Turn> trList = new ArrayList<>();


    public ArrayList<Turn> getTurnList(ArrayList<Turn> trList){
        return trList;
    }


    public Turn modifyTurn(Turn tMod, User cooker) {
        if(tMod.hasCooker()){
                return tMod;
        }else{
            if(!tMod.isComplete()) {
                //assegnamo il cooker al turno da modificare
                tMod.setCooker(cooker);
                tMod.setComplete(true);
            }
            return tMod;
        }
    }

    public void updateTurn(int startTime, int endTime, int idTurn) {
        String update = "UPDATE Turn SET start_time = "+startTime+", end_time = "+endTime+" WHERE id = "+idTurn;
        int updateSuccess = PersistenceManager.executeUpdate(update);
        if(updateSuccess == 0){
            System.out.println("Update fallito!");
        }else{
            System.out.println("Update avvenuto con successo!");
        }
    }
}
