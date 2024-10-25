module es.aketzagonzalez {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.media;
    requires java.sql;
    opens ctrl to javafx.fxml;
    opens model to javafx.base;
    exports es.aketzagonzalez.aeropuertosL;
}