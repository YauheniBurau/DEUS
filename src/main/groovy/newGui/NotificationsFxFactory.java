package newGui;

import org.controlsfx.control.Notifications;

public class NotificationsFxFactory {

    public static void showError(String title, String error, Exception e){
        e.printStackTrace();
        Notifications.create()
                .title(title)
                .text(error)
                .showError();
    }

    public static void showNotImplemented(){
        Notifications.create()
                .title("Runtime exception")
                .text("Not implemented Functionality")
                .showError();
    }


}
