package catering.businesslogic.testEstensioni;

import catering.businesslogic.CatERing;
import catering.businesslogic.kitchen.KitchenTask;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

import java.io.BufferedInputStream;
import java.util.Scanner;

public class TestEstensione2a {

    public static void main(String[] args){
        /* TODO : modificaCompito */
        ObservableList<KitchenTask> tasks = CatERing.getInstance().getKitchenTaskManager().getAllTasks();
        System.out.println("Lista dei task attuali : "+tasks);
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        System.out.println("Fornire ID task da modificare : ");
        int id = sc.nextInt();
        System.out.println("Adesso chiamo la load...");
        KitchenTask t = KitchenTask.loadKitchenTaskById(id);
        System.out.println("KitchenTask selezionato : "+t);
        /* TODO : modificare durata del task! */
        System.out.println("Inserire nuova durata");
        int durata_new = sc.nextInt();
        System.out.println("Inserire nuova azione");
        Scanner sc2 = new Scanner(new BufferedInputStream(System.in));
        String azione_new = sc2.nextLine();
        CatERing.getInstance().getSheetManager().updateTask(durata_new,azione_new,id);
    }
}
