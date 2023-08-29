package catering.businesslogic.testEstensioni;

import catering.businesslogic.CatERing;
import catering.businesslogic.kitchen.KitchenTask;
import catering.businesslogic.user.User;
import javafx.collections.ObservableList;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class TestEstensione4b {
    public static void main(String[] args) {
        /* TODO : modificaAssegnamento */
        ObservableList<KitchenTask> tasks = CatERing.getInstance().getKitchenTaskManager().getAllTasks();
        System.out.println("Ecco i task dalla tabella : ");
        for(KitchenTask task : tasks){
            System.out.println(task);
        }
        Scanner sc1 = new Scanner(new BufferedInputStream(System.in));
        System.out.println("Fornisci l'ID del task di cui assegnamento : ");
        int id = sc1.nextInt();
        KitchenTask t = KitchenTask.loadKitchenTaskByIdFromUserTasks(id);
        if(t.getId() == 0){
            System.out.println("KitchenTask selezionato : INESISTENTE");
            System.out.println("Impossibile modificare Task di cucina!");
        }
        else{
            int vecchio_userID = CatERing.getInstance().getKitchenTaskManager().getUserByIDTask(t.getId());
            System.out.println("Id del vecchio cuoco : "+vecchio_userID);
            System.out.println("Fornisci l'ID nuovo del cuoco : ");
            int idCooker = sc1.nextInt();
            System.out.println("ID utente 'cuoco' fornito : "+idCooker);
            CatERing.getInstance().getSheetManager().modifyAssignmentById(vecchio_userID, idCooker);
        }
    }
}
