package catering.businesslogic.kitchen;

import catering.businesslogic.event.EventInfo;
import catering.businesslogic.event.ServiceInfo;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.user.User;

import java.util.ArrayList;
import java.util.List;

public class SummarySheet {
    private KitchenTask task;
    public List<KitchenTask> listTask = new ArrayList<>();

    private User user;

    @Override
    public String toString(){
        String result = "";
        result += "Summary sheet contiene compiti:\n";
        for(KitchenTask task: listTask){
            result += task.toString();
            result += "\n";
        }
        return result;
    }

    private EventInfo event;
    private ServiceInfo service;
    public String eventName;


    public int id_Sh, id_user, id_task;

    public SummarySheet(int id_Sh, int id_user, int id_task, String nomeEvento){
        this.id_Sh = id_Sh;
        this.id_user = id_user;
        this.id_task = id_task;
        this.eventName = nomeEvento;
    }

    public SummarySheet(int id_Sh, int id_user, EventInfo event, ServiceInfo service){
        this.id_Sh = id_Sh;
        this.id_user = id_user;
        this.event = event;
        this.service = service;
    }

    public SummarySheet() {

    }

    public void createSheetByUser(User owner){
        this.user = owner;
    }
    public void addTask(KitchenTask kitchenTask){
        listTask.add(kitchenTask);
    }

    public List<KitchenTask> getListTasks(){
        return listTask;
    }

    void deleteAllTask(){

    }

    public SummarySheet modify() {
        Recipe nuova_ric = new Recipe("Spaghetti alla puttanesca");
        KitchenTask task_3 = listTask.get(2);
        if(!task_3.equals(null)){
            task = new KitchenTask(nuova_ric);
            listTask.remove(task_3);
            listTask.add(2, task);
        }
        else System.out.println("Errore, non esiste questa task!");
        return this;
    }
}
