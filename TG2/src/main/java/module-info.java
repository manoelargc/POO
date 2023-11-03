module com.example.tg2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.tg2 to javafx.fxml;
    exports com.example.tg2;
}