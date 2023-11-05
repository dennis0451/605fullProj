module com.example.movietheatreproj {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.movietheatreproj to javafx.fxml;
    exports com.example.movietheatreproj;
}