module com.fourmisses.fourmies {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.fourmisses.fourmies to javafx.fxml;
    exports com.fourmisses.fourmies;
}