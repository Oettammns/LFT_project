package catering.businesslogic.testEstensioni;

import catering.businesslogic.CatERing;
import catering.businesslogic.kitchen.KitchenTask;
import catering.businesslogic.kitchen.SheetManager;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.turn.Turn;
import catering.businesslogic.user.User;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class TestEstensione6a {
    public static void main(String[] args) {
        System.out.println("TEST FAKE LOGIN");
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");
        User currentUser = CatERing.getInstance().getUserManager().getCurrentUser();
        Scanner scanTurn = new Scanner(new BufferedInputStream(System.in));
        int startTime, endTime;
        int idTurn;
        System.out.println("Inserire vecchio id turno : ");
        idTurn = scanTurn.nextInt();
        /* Creiamo metodo loadTurnById(idTurn)*/
        Turn turnoToMod = Turn.loadTurnById(idTurn);
        System.out.println("Contenuto di Turno : "+turnoToMod);
        System.out.println("Inserire nuovo tempo d'inizio : ");
        startTime = scanTurn.nextInt();
        System.out.println("Inserire nuovo tempo di fine : ");
        endTime = scanTurn.nextInt();
        CatERing.getInstance().getTurnManager().updateTurn(startTime,endTime,idTurn);
        /* TODO : verifica disponibilità del cuoco */
        /* Sappiamo che cooker è un cuoco */
    }
}
