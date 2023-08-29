package catering.businesslogic.testEstensioni;

import catering.businesslogic.CatERing;
import catering.businesslogic.kitchen.KitchenTask;
import catering.businesslogic.kitchen.SheetManager;
import catering.businesslogic.kitchen.SummarySheet;
import catering.businesslogic.recipe.Recipe;
import catering.businesslogic.user.User;
import javafx.collections.ObservableList;

import java.io.BufferedInputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestEstensione1A{
    /* Estenzione ModificaFoglio */
    public static void main(String[] args) {
        /* Facciamo login dell'utente per vedere se è Chef */
        System.out.println("TEST FAKE LOGIN");
        CatERing.getInstance().getUserManager().fakeLogin("Lidia");
        User currentUser = CatERing.getInstance().getUserManager().getCurrentUser();
        System.out.println("Utente corrente : "+CatERing.getInstance().getUserManager().getCurrentUser());
        SummarySheet sm = new SummarySheet();
        System.out.println("Elenco delle ricette già caricate : ");
        ObservableList<Recipe> recipes = CatERing.getInstance().getRecipeManager().getRecipes();
        System.out.println("Ricette in db : \n"+recipes);
        /* TODO : Fare richiesta di ID della ricetta da modificare tramite query. */
        Scanner sc = new Scanner(new BufferedInputStream(System.in));
        Scanner sc2 = new Scanner(new BufferedInputStream(System.in));
        System.out.println("Inserire ID Ricetta : ");
        int id = sc.nextInt();
        System.out.println("L'id della ricetta da modificare e' : "+id);
        Recipe toMod = Recipe.loadRecipeById(id);
        System.out.println("Ricetta da modificare : "+toMod);
        /* Cambiamo il nome alla ricetta selezionata tramite ID...*/
        System.out.println("Nome nuovo della ricetta : ");
        String newname = sc2.nextLine();
        CatERing.getInstance().getSheetManager().updateRecipe(id, newname);
        /*List<Recipe> ricette = new ArrayList<>();
        Recipe r1 = new Recipe("Prepara sfoglia cornetto");
        Recipe r2 = new Recipe("Prepara cioccolato per sacher");
        Recipe r3 = new Recipe("Prepara pane acciughe e burro");
        ricette.add(r1);
        ricette.add(r2);
        ricette.add(r3);
        System.out.println("Prima della modifica...");
        for(Recipe r : ricette){
            System.out.println("Ricetta : "+r);
            //CatERing.getInstance().getSheetManager().updateRecipes(id, r.getName());
        }
        System.out.println("Dopo la modifica...");
        KitchenTask mytask;
        for(Recipe r : recipes) {
            mytask = new KitchenTask(r);
            sm.addTask(mytask);
        }
        if(currentUser.isChef()){
            SheetManager shm = new SheetManager();
            shm.modifySheet(sm);
            System.out.println("Caratteristiche SummarySheet : \n"+sm.toString());
        }
        */
    }

}
