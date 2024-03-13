module org.example.animacja {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.animacja to javafx.fxml;
    exports org.example.animacja;
}