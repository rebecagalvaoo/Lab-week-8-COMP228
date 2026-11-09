package Main;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;


    public class Main extends Application {

        // Form fields
        private TextField studentIdField;
        private TextField fullNameField;
        private TextField emailField;
        private ComboBox<String> programBox;

        private Label statusLabel;

        @Override
        public void start(Stage stage) {

            BorderPane root = new BorderPane();

            HBox header = new HBox();

            header.setPadding(new Insets(20));
            header.setAlignment(Pos.CENTER_LEFT);
            header.setStyle("-fx-background-color: #e9e9f5;");

            Label title = new Label("College Student Services");
            title.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

            header.getChildren().add(title);

            root.setTop(header);

            VBox menu = new VBox(12);

            menu.setPadding(new Insets(20));
            menu.setPrefWidth(170);
            menu.setStyle("-fx-background-color: #f2f2f2;");

            Label menuTitle = new Label("MENU");

            Button dashboardButton = new Button("Dashboard");
            Button registrationButton = new Button("Registration");
            Button coursesButton = new Button("Courses");
            Button helpButton = new Button("Help");

            menu.getChildren().addAll(
                    menuTitle,
                    dashboardButton,
                    registrationButton,
                    coursesButton,
                    helpButton
            );

            root.setLeft(menu);

            VBox center = new VBox(20);

            center.setPadding(new Insets(30));

            Label formTitle = new Label("Student Registration");
            formTitle.setStyle("-fx-font-size: 20px; -fx-font-weight: bold;");

            GridPane form = new GridPane();

            form.setHgap(15);
            form.setVgap(15);

            studentIdField = new TextField();
            studentIdField.setPromptText("Enter Student ID");

            fullNameField = new TextField();
            fullNameField.setPromptText("Enter Full Name");

            emailField = new TextField();
            emailField.setPromptText("Enter Email");

            programBox = new ComboBox<>();

            programBox.getItems().addAll(
                    "Software Engineering",
                    "Computer Programming",
                    "Business",
                    "Marketing"
            );

            programBox.setPromptText("Select Program");

            form.add(new Label("Student ID:"), 0, 0);
            form.add(studentIdField, 1, 0);

            form.add(new Label("Full Name:"), 0, 1);
            form.add(fullNameField, 1, 1);

            form.add(new Label("Email:"), 0, 2);
            form.add(emailField, 1, 2);

            form.add(new Label("Program:"), 0, 3);
            form.add(programBox, 1, 3);

            HBox actions = new HBox(10);

            Button registerButton = new Button("Register");
            Button clearButton = new Button("Clear");

            actions.getChildren().addAll(registerButton, clearButton);

            statusLabel = new Label("Complete the form and click Register.");

            registerButton.setOnAction(event -> registerStudent());

            clearButton.setOnAction(event -> clearForm());

            center.getChildren().addAll(
                    formTitle,
                    form,
                    actions,
                    statusLabel
            );

            root.setCenter(center);

            Scene scene = new Scene(root, 850, 520);

            stage.setTitle("JavaFX Layout Managers Lab");
            stage.setScene(scene);
            stage.show();
        }

        private void registerStudent() {

            String id = studentIdField.getText().trim();
            String name = fullNameField.getText().trim();
            String email = emailField.getText().trim();
            String program = programBox.getValue();

            if (id.isEmpty() || name.isEmpty()
                    || email.isEmpty() || program == null) {

                statusLabel.setText("Error: Please complete all fields.");
                return;
            }

            if (!email.contains("@") || !email.contains(".")) {

                statusLabel.setText("Error: Invalid email address.");
                return;
            }

            statusLabel.setText(
                    "Registration successful! Welcome, " + name + "!"
            );
        }

        private void clearForm() {

            studentIdField.clear();
            fullNameField.clear();
            emailField.clear();
            programBox.setValue(null);

            statusLabel.setText("Complete the form and click Register.");
        }

        public static void main(String[] args) {
            launch(args);
        }
    }


