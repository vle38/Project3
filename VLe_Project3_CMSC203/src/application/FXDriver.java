package application;

import java.io.IOException;
import javafx.application.Application;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.scene.control.Tooltip;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

/*
 * Class: CMSC203
 * Instructor: Ahmed Tarek
 * Description: A program that uses GUI to display and allow the user to interact with the 
 * interface and enter a string input to decide whether to apply Caesar or Bellaso cipher 
 * to encrypt and decrypt text.
 * Due: 10/3/25 (D/M/Y)
 * I pledge that I have completed the programming assignment
 * independently. I have not copied the code from a student or 
 * any source. I have not given my code to any student.
 * Print name here: Vincent Le
 */

public class FXDriver extends Application {
	
	public static void main(String[] args) {
		launch(args);   
	}
	
	@Override
	public void start(Stage stage) throws IOException {
		
		FXMainPane root = new FXMainPane();
		stage.setScene(new Scene(root, 800, 600));
		stage.setTitle("Encryption Application");
		stage.show();
	}
	
}