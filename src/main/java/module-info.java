module com.devmate.registrationform {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.devmate.registrationform to javafx.fxml;
    exports com.devmate.registrationform;
}