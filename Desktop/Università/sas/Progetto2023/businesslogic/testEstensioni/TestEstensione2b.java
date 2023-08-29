package catering.businesslogic.testEstensioni;

import catering.businesslogic.CatERing;
import catering.businesslogic.kitchen.KitchenTask;
import javafx.collections.ObservableList;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class TestEstensione2b {
    public static void main(String[] args){
        /* TODO : EliminaCompito */
        ObservableList<KitchenTask> tasks = CatERing.getInstance().getKitchenTaskManager().getAllTasks();
        System.out.println("Lista dei task attuali : ");
        for(KitchenTask task : tasks){
            System.out.println(task);
        }
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        System.out.println("Fornire ID task da eliminare : ");
        int id = sc.nextInt();
        System.out.println("Adesso chiamo la load...");
        KitchenTask t = KitchenTask.loadKitchenTaskById(id);
        System.out.println("KitchenTask selezionato : "+t);
        /* TODO : modificare durata del task! */
        CatERing.getInstance().getSheetManager().deleteTask(id);
    }
}
