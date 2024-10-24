module es.aketzagonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    opens es.aketzagonzalez.aeropuertosL to javafx.fxml;
    exports es.aketzagonzalez.aeropuertosL;
}