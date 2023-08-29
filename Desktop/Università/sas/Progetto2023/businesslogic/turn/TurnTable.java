package catering.businesslogic.turn;

import java.util.ArrayList;
import java.util.List;

public class TurnTable {

    public List<Turn> listTurn = new ArrayList<>();

    public TurnTable(List<Turn> listTurn) {
        this.listTurn = listTurn;
    }

    @Override
    public String toString() {
        String res = "";
        for(Turn t : listTurn){
            res+="Turno : {"+t.toString()+"}\n";
        }
        return res;
    }
}
