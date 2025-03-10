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


public class FXMainPane extends VBox {
	
	RadioButton caesarButton, bellasoButton;
	TextField inputTextfield, encryptedTextfield, decryptedTextfield, key;
	Label inputTextLabel, encryptedTextLabel, decryptedTextLabel, keyLabel;
	Button encryptionButton, decryptionButton, clearButton, exitButton;
	HBox firstBox, thirdBox;
	VBox secondBox;
	
	CryptoManager cryptoManager;
	
	int shiftInt = 0;
	
	FXMainPane(){
		
		caesarButton = new RadioButton("Use Caesar Cypher Encryption");
		bellasoButton = new RadioButton("Use Bellaso Cypher Encryption");
		
		inputTextLabel = new Label("Enter plain-text string to encrypt (Can be in upper or lower case): ");
		inputTextfield = new TextField();
		
		encryptedTextLabel = new Label("Encrypted text: ");
		encryptedTextfield = new TextField();
		
		decryptedTextLabel = new Label("Decrypted text: ");
		decryptedTextfield = new TextField();
		
		keyLabel = new Label("Key: ");
		key = new TextField();
		
		encryptionButton = new Button("Encrypt inputted string");
		decryptionButton = new Button("Decrypt inputted string");
		clearButton = new Button("Clear");
		exitButton = new Button("Exit");
		
		firstBox = new HBox(20);
		secondBox = new VBox(20);
		thirdBox = new HBox(20);
		
		cryptoManager = new CryptoManager();
		
		firstBox.getChildren().addAll(caesarButton, bellasoButton);
		firstBox.setStyle("-fx-border-color: blue;");
		secondBox.getChildren().addAll(inputTextLabel, inputTextfield, encryptedTextLabel, encryptedTextfield, decryptedTextLabel, decryptedTextfield, keyLabel, key);
		secondBox.setStyle("-fx-border-color: red;");
		thirdBox.getChildren().addAll(encryptionButton, decryptionButton, clearButton, exitButton);
		thirdBox.setStyle("-fx-border-color: teal;");
		
		this.getChildren().addAll(firstBox, secondBox, thirdBox);
		
		Insets inset = new Insets(10);
		
		firstBox.setAlignment(Pos.CENTER);
		secondBox.setAlignment(Pos.CENTER);
		thirdBox.setAlignment(Pos.CENTER);
		
		encryptionButton.setAlignment(Pos.CENTER);
		decryptionButton.setAlignment(Pos.CENTER);
		clearButton.setAlignment(Pos.CENTER);
		exitButton.setAlignment(Pos.CENTER);
		
		HBox.setMargin(caesarButton, inset);
		HBox.setMargin(bellasoButton, inset);
		HBox.setMargin(inputTextLabel, inset);
		HBox.setMargin(encryptedTextLabel, inset);
		HBox.setMargin(decryptedTextLabel, inset);
		HBox.setMargin(keyLabel, inset);
		HBox.setMargin(inputTextfield, inset);
		HBox.setMargin(encryptedTextfield, inset);
		HBox.setMargin(decryptedTextfield, inset);
		HBox.setMargin(key, inset);
		HBox.setMargin(encryptionButton, inset);
		HBox.setMargin(decryptionButton, inset);
		HBox.setMargin(clearButton, inset);
		HBox.setMargin(exitButton, inset);
		
		ButtonHandler buttonHandler = new ButtonHandler();
		// RadioButtonHandler radioButtonHandler = new RadioButtonHandler();
		encryptionButton.setOnAction(buttonHandler);
		decryptionButton.setOnAction(buttonHandler);
		clearButton.setOnAction(buttonHandler);
		exitButton.setOnAction(buttonHandler);
		
		
	}
	
	class ButtonHandler implements EventHandler<ActionEvent> {
		
		public void handle(ActionEvent event) {
			
			String encryptedText, decryptedText;
			
			Object source = event.getSource();
			
			// These two sources don't work, resorted to creating source as an Object instance. 
			// RadioButton radioButtonSource = (RadioButton) event.getSource();
			// Button source = (Button) event.getSource();
			
			// Function of the radio button "caesarButton"
			if(caesarButton.isSelected() == true) {
				
				// If statement that checks if the user clicks on the encryptionButton.
				if(source == encryptionButton) {
					
					// If the if statement is true, the program will run the try method which gathers the user's text input and key for encryption.
					try {
						
						int shiftKeyElement = Integer.parseInt(key.getText());
						encryptedText = cryptoManager.caesarEncryption(inputTextfield.getText(), shiftKeyElement);
						encryptedTextfield.setText(encryptedText);
						
					}
					// If an error occurs, an error will be displayed. 
					catch (NumberFormatException e) {
						encryptedTextfield.setText("Error, please reinput text to encrypt or key.");
					}
				}
				
				// If statement that checks if the user clicks on the decryptionButton.
				if(source == decryptionButton) {
					
					// If the if statement is true, the program will run the try method which gathers the user's text input and key for decryption.
					try {
						
						int shiftKeyElement = Integer.parseInt(key.getText());
						decryptedText = cryptoManager.caesarDecryption(encryptedTextfield.getText(), shiftKeyElement);
						decryptedTextfield.setText(decryptedText);
						
					}
					// If an error occurs, an error will be displayed. 
					catch (NumberFormatException e) {
						decryptedTextfield.setText("Error, please reinput text to decrypt or key.");
					}
					
				}
				
			}
			
			// Function of the radio button "bellasoButton"
			if(bellasoButton.isSelected() == true) {
				
				// If statement that checks if the user clicks on the encryptionButton.
				if(source == encryptionButton) {
					
					// If the if statement is true, the program will run the try method which gathers the user's text input and key for encryption.
					try {
						
						encryptedText = cryptoManager.bellasoEncryption(inputTextfield.getText(), key.getText());
						encryptedTextfield.setText(encryptedText);
						
					}
					// If an error occurs, an error will be displayed. 
					catch (NumberFormatException e) {
						encryptedTextfield.setText("Error, please reinput text to encrypt or key.");
					}
					
				}
				
				// If statement that checks if the user clicks on the decryptionButton.
				if(source == decryptionButton) {
					
					// If the if statement is true, the program will run the try method which gathers the user's text input and key for decryption.
					try {
						
						decryptedText = cryptoManager.bellasoDecryption(encryptedTextfield.getText(), key.getText());
						decryptedTextfield.setText(decryptedText);
						
					}
					// If an error occurs, an error will be displayed. 
					catch (NumberFormatException e) {
						decryptedTextfield.setText("Error, please reinput text to decrypt or key.");
					}
					
				}
				
			}
			
			// Clears all text from all textfields when the button "clearButton" is clicked.
			if(source == clearButton) {
				inputTextfield.clear();
				encryptedTextfield.clear();
				decryptedTextfield.clear();
				key.clear();
			}
			
			// Exits the GUI application and ends the program when the button "exitButton" is clicked.
			if(source == exitButton) {
				Platform.exit();
				System.exit(0);
			}
			
		}
		
	}

}
