module gerspach.superttt {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;
    requires com.google.gson;

    opens gerspach.superttt to javafx.fxml;
    exports gerspach.superttt;
}