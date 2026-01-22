module gerspach.superttt {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens gerspach.superttt to javafx.fxml;
    exports gerspach.superttt;
}