package core.application.gui.builderFx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.ContextMenu;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;

/**
 * builder for creating any type of ContextMenu
 */
public class ContextMenuFxBuilder  extends AbstractBaseFxBuilder<ContextMenu> {

    public ContextMenuFxBuilder() {
        this.value = new ContextMenu();
    }

    public Menu withMenu(String text, Menu parentMenu){
        Menu menu = new Menu(text);
        if(parentMenu !=null){
            parentMenu.getItems().add(menu);
        }else {
            value.getItems().add(menu);
        }
        return menu;
    }

    public MenuItem withMenuItem(String text, Menu parentMenu, EventHandler<ActionEvent> handler){
        MenuItem menuItem = new MenuItem(text);
        menuItem.setOnAction(handler);
        if(parentMenu !=null){
            parentMenu.getItems().add(menuItem);
        }else {
            this.value.getItems().add(menuItem);
        }
        return menuItem;
    }

}
