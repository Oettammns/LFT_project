package catering.businesslogic;

import catering.businesslogic.event.EventManager;
import catering.businesslogic.kitchen.KitchenTaskManager;
import catering.businesslogic.kitchen.SheetManager;
import catering.businesslogic.menu.MenuManager;
import catering.businesslogic.recipe.RecipeManager;
import catering.businesslogic.turn.TurnManager;
import catering.businesslogic.user.UserManager;
import catering.persistence.MenuPersistence;


public class CatERing {
    private static CatERing singleInstance;

    public static CatERing getInstance() {
        if (singleInstance == null) {
            singleInstance = new CatERing();
        }
        return singleInstance;
    }

    private MenuManager menuMgr;
    private RecipeManager recipeMgr;
    private UserManager userMgr;
    private EventManager eventMgr;
    private SheetManager sheetMgr;
    private MenuPersistence menuPersistence;
    private KitchenTaskManager kitchenTaskMgr;
    private TurnManager turnMgr;
    private CatERing() {
        menuMgr = new MenuManager();
        recipeMgr = new RecipeManager();
        userMgr = new UserManager();
        eventMgr = new EventManager();
        menuPersistence = new MenuPersistence();
        menuMgr.addEventReceiver(menuPersistence);
        sheetMgr = new SheetManager();
        kitchenTaskMgr = new KitchenTaskManager();
        turnMgr = new TurnManager();
    }


    public MenuManager getMenuManager() {
        return menuMgr;
    }

    public RecipeManager getRecipeManager() {
        return recipeMgr;
    }

    public UserManager getUserManager() {
        return userMgr;
    }

    public EventManager getEventManager() { return eventMgr; }

    public SheetManager getSheetManager(){
        return sheetMgr;
    }

    public KitchenTaskManager getKitchenTaskManager() {
        return kitchenTaskMgr;
    }

    public TurnManager getTurnManager() {
        return turnMgr;
    }
}
