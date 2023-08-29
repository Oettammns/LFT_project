package catering.businesslogic.testEstensioni;

import catering.businesslogic.CatERing;
import catering.businesslogic.kitchen.SheetManager;
import catering.businesslogic.turn.Turn;
import catering.businesslogic.turn.TurnTable;
import catering.businesslogic.user.User;

import java.util.ArrayList;
import java.util.List;

public class TestEstensione3a {

    public static void main(String[] args) {
        List<Turn> tabellone = new ArrayList<>();
        System.out.println("TEST FAKE LOGIN");
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");
        User currentUser = CatERing.getInstance().getUserManager().getCurrentUser();
        Turn turn = new Turn(10,12,1);
        Turn turn2 = new Turn(12,13,2);
        Turn turn3 = new Turn(9,11,3);

        /* Così formiamo il tabellone turni */
        tabellone.add(turn);
        tabellone.add(turn2);
        tabellone.add(turn3);
        User cooker = User.loadUserById(4);
        turn.setCooker(cooker);
        turn2.setCooker(cooker);

        TurnTable turnTable = new TurnTable(tabellone);

        System.out.println("Prima della modifica...");
        System.out.println("Caratteristiche turnTable [prima della modifica] : "+turnTable.toString());
        if(currentUser.isChef()){
            SheetManager sheetMgr = new SheetManager();
            turnTable = sheetMgr.modifyTurnTable(turnTable, turn3, cooker);
            System.out.println("Dopo modifica...");
            System.out.println("Caratteristiche turnTable : "+turnTable.toString());
        }
    }
}
