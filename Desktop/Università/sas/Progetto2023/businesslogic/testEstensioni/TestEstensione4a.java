package catering.businesslogic.testEstensioni;
import catering.businesslogic.CatERing;
import catering.businesslogic.kitchen.KitchenTask;
import javafx.collections.ObservableList;
import java.io.BufferedInputStream;
import java.util.Scanner;
public class TestEstensione4a {
    public static void main(String[] args) {
        /* TODO : eliminaAssegnamento */
        ObservableList<KitchenTask> tasks = CatERing.getInstance().getKitchenTaskManager().getAllTasks();
        System.out.println("Ecco i task : ");
        for(KitchenTask task : tasks){
            System.out.println(task);
        }
        Scanner sc1 = new Scanner(new BufferedInputStream(System.in));
        System.out.println("Fornisci l'ID del task di cui assegnamento : ");
        int id = sc1.nextInt();
        KitchenTask t = KitchenTask.loadKitchenTaskById(id);
        System.out.println("KitchenTask selezionato : "+t);
        CatERing.getInstance().getSheetManager().deleteAssignmentById(id);
    }
}
