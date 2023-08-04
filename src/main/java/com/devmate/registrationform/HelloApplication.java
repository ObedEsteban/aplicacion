package com.devmate.registrationform;

import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import java.lang.String;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;

public class HelloApplication extends Application {
    @Override
    public void start(Stage stage) {

        //Label for name
        Label nameLabel = new Label("Name");

        //Text Field for Name
        TextField nameText = new TextField();

        //Label para fecha de nacimiento
        Label dobLabel = new Label("Fecha de Nacimiento");

        //date selector para elegir la fecha
        DatePicker datePicker = new DatePicker();

        //Label para el genero
        Label genderLabel = new Label("Genero");

        //Toggle group para radio button
        ToggleGroup groupGender = new ToggleGroup();
        RadioButton maleRadio = new RadioButton("Masculino");
        maleRadio.setToggleGroup(groupGender);
        RadioButton femaleRadio = new RadioButton("Femenino");
        femaleRadio.setToggleGroup(groupGender);

        //Label para technologies
        Label technologiesLabel = new Label("Tecnologias 2023");

        //Check box for education
        CheckBox javaCheckBox = new CheckBox("Java");
        javaCheckBox.setIndeterminate(false);
        CheckBox dotnetCheckBox = new CheckBox("MYSQL");
        dotnetCheckBox.setIndeterminate(false);

        //Label para education
        Label educationLabel = new Label("PROGRAMADOR JAVA");

        //list vista para calificación educativa
        ListView<String> eduList = new ListView<>();
        ObservableList<String> data = FXCollections.observableArrayList();
        data.addAll("Basico Junior", "Intermedio", "Master's", "SENIOR");
        eduList.setItems(data);
        eduList.setPrefSize(100, 100);

        //Label for Location
        Label locationLabel = new Label("Location");

        //Choice box for location
        ChoiceBox<String> locationChoiceBox = new ChoiceBox<>();
        locationChoiceBox.getItems().addAll("Atescatempa", "Jutipa", "Guatemala");

        //Label for ComboBox
        Label comboBoxLabel = new Label("Seleccione una opción");

        //ComboBox
        ComboBox<String> comboBox = new ComboBox<>();
        comboBox.getItems().addAll("Opción 1", "Opción 2", "Opción 3");
        comboBox.setPromptText("Seleccione una opción");

        //Label for register
        Button buttonRegister = new Button("Registrar");

        //Crear un panel de cuadrícula
        GridPane gridPane = new GridPane();

        //Configuración del tamaño del panel
        gridPane.setMinSize(500, 300);

        //Configuración del relleno fondo
        gridPane.setPadding(new Insets(10, 10, 10, 10));

        //Establecer los espacios verticales y horizontales entre las columnas
        gridPane.setVgap(5);
        gridPane.setHgap(5);

        //Configuración de la alineación de la cuadrícula
        gridPane.setAlignment(Pos.CENTER);

        //Organizar todos los nodos en la grilla
        gridPane.add(nameLabel, 0, 0);
        gridPane.add(nameText, 1, 0);

        gridPane.add(dobLabel, 0, 1);
        gridPane.add(datePicker, 1, 1);

        gridPane.add(genderLabel, 0, 2);
        gridPane.add(maleRadio, 1, 2);
        gridPane.add(femaleRadio, 2, 2);

        gridPane.add(technologiesLabel, 0, 3);
        gridPane.add(javaCheckBox, 1, 3);
        gridPane.add(dotnetCheckBox, 2, 3);

        gridPane.add(educationLabel, 0, 4);
        gridPane.add(eduList, 1, 4);

        gridPane.add(locationLabel, 0, 5);
        gridPane.add(locationChoiceBox, 1, 5);

        gridPane.add(comboBoxLabel, 0, 6);
        gridPane.add(comboBox, 1, 6);

        gridPane.add(buttonRegister, 2, 7);

        //Styling nodes
        buttonRegister.setStyle(
                "-fx-background-color: darkslateblue; -fx-text-fill: white;"
        );
        nameLabel.setStyle("-fx-font: normal bold 15px 'serif';");
        dobLabel.setStyle("-fx-font: normal bold 15px 'serif';");
        genderLabel.setStyle("-fx-font: normal bold 15px 'serif';");
        technologiesLabel.setStyle("-fx-font: normal bold 15px 'serif';");
        educationLabel.setStyle("-fx-font: normal bold 15px 'serif';");
        locationLabel.setStyle("-fx-font: normal bold 15px 'serif';");
        comboBoxLabel.setStyle("-fx-font: normal bold 15px 'serif';");

        //configurar el background color
        gridPane.setStyle("-fx-background-color: BEIGE;");

        // Etiqueta para mostrar la hora actual
        Label timeLabel = new Label("Hora actual: ");

        // Establecer el formato de hora
        DateTimeFormatter timeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");

        // Actualizar la hora cada segundo usando un Timeline
        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), e -> {
            LocalTime currentTime = LocalTime.now();
            timeLabel.setText("Hora actual: " + currentTime.format(timeFormatter));
        }));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();

        // Event handler para el botón Register
        buttonRegister.setOnAction(e -> {
            // Lógica de registro aquí
            // Por ejemplo, puedes recolectar los datos del usuario y guardarlos en una base de datos
        });

        // Crear un Tooltip para el botón Register
        Tooltip tooltip = new Tooltip("Haz clic para registrar");

        // Asignar el Tooltip al botón Register
        buttonRegister.setTooltip(tooltip);

        // Crear el menú File
        Menu fileMenu = new Menu("File");

        // Crear los MenuItem para el menú File
        MenuItem openItem = new MenuItem("Open");
        MenuItem saveItem = new MenuItem("Save");

        // Agregar los MenuItem al menú File
        fileMenu.getItems().addAll(openItem, saveItem);

        // Crear la barra de menú y agregar el menú File a ella
        MenuBar menuBar = new MenuBar();
        menuBar.getMenus().addAll(fileMenu);

        // Agregar la barra de menú al GridPane
        gridPane.add(menuBar, 0, 15, 3, 1);

        //Agregar la etiqueta de la hora actual al GridPane
        gridPane.add(timeLabel, 0, 16, 3, 1);

        //Crear una escena y agregarla al escenario
        Scene scene = new Scene(gridPane);

        //Setting the title of stage
        stage.setTitle("Registration Form");

        //Adding scene to the stage
        stage.setScene(scene);

        //Displaying the contents of the stage
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}

