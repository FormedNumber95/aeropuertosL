module es.aketzagonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    opens ctrl to javafx.fxml;
    exports es.aketzagonzalez.aeropuertosL;
}