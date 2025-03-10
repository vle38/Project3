package application;

public class CryptoManager {

	// Non-argument constructor. 
	CryptoManager() {
		
	}
	
	// Lowest bounding range to gather for the value of ASCII values. (32 to account for any upper case letters due to 'A' having the value of 65 in ASCII).
	// int defined as a constant to signify the value for LOWERBOUND which will not be changed throughout the program.
	final int LOWERBOUND = 32;
	// Highest bounding range to gather for the value of ASCII values. (Up to 123 to account for lower case letters such as 'a' with an ASCII value of 97.
	// int defined as a constant to signify the value for HIGHERBOUND which will not be changed throughout the program.
	// Note to self: When doing JUnit tests, set the HIGHERBOUND limit to 95 to allow only for capital letters. 
	final int HIGHERBOUND = 123;
	
	// Function/method that determines whether the user has input a correct string value (gathered from the parameter "inputText") with each char ASCII value being checked to see if it is in range between 32 to 123.
	public boolean stringInBounds(String inputText) {
		
		// char variable declared, not yet initialized. 
		char currentCharValue;
		
		// For loop which gather's each char the user's has input in their string by incrementing and gathering each char and its ASCII value, stops when the for loop has incremented through all char values of the string.
		for(int i = 0; i < inputText.length(); i++) {
			// char variable "currentCharValue" initialized to gather each individual char and its ASCII value from the user's input in "inputText". 
			currentCharValue = inputText.charAt(i);
			// Checks ASCII value of each individual character the user has input (This is also to check and understand logic errors).
			// Not mandatory in the project directions, it is only here to understand any occurring logic errors and ASCII values of each character.
			System.out.println("Character: " + currentCharValue + "\nASCII: " + (int)currentCharValue);
			// If statement that checks each ASCII value of each char from the user's string input stored in "currentCharValue", if the if statement is true, meaning if any char value is less than 32 or greater than 123, the boolean determining if the ASCII value of each char is returned as false.
			if (currentCharValue < LOWERBOUND || currentCharValue > HIGHERBOUND) {
				// Boolean returned as false if the if statement is proven true, meaning either an ASCII value of a char is under the lower bound limit (LOWERBOUND) or above the higher bound limit (HIGHERBOUND).
				return false;
			}
		}
		
		// Otherwise, if all char ASCII values are within the bounding limits between 32 - 123, the boolean statement will return as true.
		return true;
		
	}
	
	// Function/method "caesarEncryption" which allows the user to utilize caesar ciphering to encrypt their inputed string through the parameters "inputText" (gets the value from the "inputTextfield" GUI element, and "caesarKey" (gets the value from the "key" GUI textfield element).
	public String caesarEncryption(String inputText, int caesarKey) {
		
		// Object "encryptedText" which is created but not yet initialized, this would store the encrypted message that the user has inputed.
		StringBuilder encryptedText = new StringBuilder();
		
		// char variable declared, not yet initialized. 
		char currentCharValue;
		
		// If statement which calls the function "stringInBounds" to run and check if the user has inputed an incorrect string value into the textfield "inputTextfield" which connects its data into the parameter "inputText". If the function results to being returned to a value of false, then the if statement will be executed as true, returning to the user that an error has occurred and the user must reinput another string correctly.
		if(stringInBounds(inputText) == false) {
			return "Error: String inputted is not in bounds, please reinput another string.";
		}
		
		// For loop which loops through each char value of the user's inputed string "inputText" by incrementing through each letter (length of the string). 
		for(int i = 0; i < inputText.length(); i++) {
			// By using "charAt(i)", this initializes the variable "currentCharValue" to store the current letter that is being analyzed in the for loop, each letter will be stored and checked in the variable and loop until the for loop increments beyond the size of the string the user has input.
			currentCharValue = inputText.charAt(i);
			// int value "shiftCharValue" which gathers the general shift in which the inputed string will be encrypted by adding each ASCII value of each char in the string by the key (the number the user has input for encryption).
			int shiftCharValue = currentCharValue + caesarKey;
			
			// If statement that checks the value of shiftCharValue, if an value of the char is greater than the constant variable "HIGHERBOUND" (123), then the value will be looped back to the lowest bound plus the encryption value (By subtracting "shiftCharValue", HIGHERBOUND and 1 all together). 
			if(shiftCharValue > HIGHERBOUND) {
				// If the if statement is true, the following code will run, setting the encryption to continue from the lowest bound if the string's encryption goes above 123. 
				shiftCharValue = LOWERBOUND + (shiftCharValue - HIGHERBOUND - 1);
			}
			
			// Likewise, if the value of shiftCharValue (any individual char ASCII) is lower than "LOWERBOUND" (ASCII of 32), then the encryption will be looped to the highest point (123) subtracted by the encryption value (By subtracting "LOWERBOUND", "shiftCharValue, and 1 all together).
			if(shiftCharValue < LOWERBOUND) {
				// If the if statement is true, the following code will run, setting the encryption to continue from the highest bound if the string's encryption goes under 32.
				shiftCharValue = HIGHERBOUND - (LOWERBOUND - shiftCharValue - 1);
			}
			
			// "encryptedText" applied with the method "append" to allow the ASCII value of shiftCharValue to be converted into its actual char, changing the current char the for loop has incremented into to become the encrypted char value before moving on to the next char value of the user's string input.
			encryptedText.append((char) shiftCharValue);
			
		}
		
		// As the function is created as a datatype of "string", a string must be returned, thus, the StringBuilder object "encryptedText" is returned with all char values put together as one string via using the "toString" method.
		return encryptedText.toString();
		
	}
	
	// Function/method "caesarDecryption" which allows the user to reverse the caesar encryption back to its original from in which the user has input from the beginning through the parameters "encryptedText" stringbuilder from the previous method and gathered from "encryptionTextfield" and "caesarKey", the key the user has inputted for caesar encryption.
	public String caesarDecryption(String encryptedText, int caesarKey) {
		
		// Object "decryptedText" which is created but not yet initialized, this would store the decrypted message after the encryption has been reversed.
		StringBuilder decryptedText = new StringBuilder();
		// char variable declared, not yet initialized. 
		char currentCharValue;
		
		// If statement which calls the function "stringInBounds" to run and check if the encrypted text is in the correct bounding range (32 - 123) into the textfield "encryptionTextfield" which connects its data into the parameter "encryptedText". If the function results to being returned to a value of false, then the if statement will be executed as true, returning to the user that an error has occurred and the user must reinput another string correctly.
		if(stringInBounds(encryptedText) == false) {
			return "Error: String inputted is not in bounds, please reinput another string.";
		}
		
		// For loop which loops through each char value of the inputed string "encryptedText" by incrementing through each letter (length of the string). 
		for(int i = 0; i < encryptedText.length(); i++) {
			// By using "charAt(i)", this initializes the variable "currentCharValue" to store the current letter that is being analyzed in the for loop, each letter will be stored and checked in the variable and loop until the for loop increments beyond the size of the encrypted string.
			currentCharValue = encryptedText.charAt(i);
			// int value "shiftCharValue" which gathers the general shift in which the inputed string will be decrypted by subtracting each ASCII value of each char in the string by the key (the number the user has input for encryption).
			int shiftCharValue = currentCharValue - caesarKey;
			
			// If statement that checks the value of shiftCharValue, if an value of the char is greater than the constant variable "HIGHERBOUND" (123), then the value will be looped back to the lowest bound plus the decryption value (By subtracting "shiftCharValue", HIGHERBOUND and 1 all together).
			if(shiftCharValue > HIGHERBOUND) {
				shiftCharValue = LOWERBOUND + (shiftCharValue - HIGHERBOUND - 1);
			}
			
			// Similarly, if the value of shiftCharValue (any individual char ASCII) is lower than "LOWERBOUND" (ASCII of 32), then the decryption will be looped to the highest point (123) subtracted by the decryption value (By subtracting "LOWERBOUND", "shiftCharValue, and 1 all together).
			if(shiftCharValue < LOWERBOUND) {
				shiftCharValue = HIGHERBOUND - (LOWERBOUND - shiftCharValue - 1);
			}
			
			// "decryptedText" applied with the method "append" to allow the ASCII value of shiftCharValue to be converted into its actual char, changing the current char the for loop has incremented into to become the decrypted char value before moving on to the next char value of the encrypted string.
			decryptedText.append((char) shiftCharValue);
			
		}
		
		// As the function is created as a datatype of "string", a string must be returned, thus, the StringBuilder object "decryptedText" is returned with all char values put together as one string via using the "toString" method.
		return decryptedText.toString();
		
	}
	
	// Function/method "bellasoEncryption" which allows for the user to use bellaso cipher to encrypt their inputed string through the parameters "inputText" (gets the value from the "inputTextfield" GUI element, and "bellasoKey" (gets the value from the "key" GUI textfield element).
	public String bellasoEncryption(String inputText, String bellasoKey) {
		
		// Object "encryptedText" which is created but not yet initialized, this would store the encrypted message that the user has inputed.
		StringBuilder encryptedText = new StringBuilder();
		// char variable declared, not yet initialized. 
		char currentCharValue;
		// int variable "bellasoKeyLength" which gather's the length of the key the user has input for bellaso encryption (string input with more than one letter). 
		int bellasoKeyLength = bellasoKey.length();
		
		// If statement which calls the function "stringInBounds" to run and check if the user has inputed an incorrect string value into the textfield "inputTextfield" which connects its data into the parameter "inputText". If the function results to being returned to a value of false, then the if statement will be executed as true, returning to the user that an error has occurred and the user must reinput another string correctly.
		if(stringInBounds(inputText) == false) {
			return "Error: String inputted is not in bounds, please reinput another string.";
		}
		
		// For loop which loops through each char value of the user's inputed string "inputText" by incrementing through each letter (length of the string).
		for(int i = 0; i < inputText.length(); i++) {
			// By using "charAt(i)", this initializes the variable "currentCharValue" to store the current letter that is being analyzed in the for loop, each letter will be stored and checked in the variable and loop until the for loop increments beyond the size of the string the user has input.
			currentCharValue = inputText.charAt(i);
			// Char variable "keyCharacter" which gets the specific char in the string throughout the entire string (if more than one letter) that the user has inputed, this stores the current char inside the variable. 
			char keyCharacter = bellasoKey.charAt(i % bellasoKeyLength);
			// int "keyCharacterIntValue" which gets the integer ASCII value of each char value from the variable "keyCharacter".
			int keyCharacterIntValue = keyCharacter;
			// int value "shiftCharValue" which gathers the general shift in which the inputed string will be encrypted by adding each ASCII value of each char in the string by the key (the ASCII value of each character the user has input for the key when selecting the radio button for bellaso encryption).
			int shiftCharValue = currentCharValue + keyCharacterIntValue;
			
			// If statement that checks the value of shiftCharValue, if an value of the char is greater than the constant variable "HIGHERBOUND" (123), then the value will be looped back to the lowest bound plus the encryption value (By subtracting "shiftCharValue", HIGHERBOUND and 1 all together). 
			if(shiftCharValue > HIGHERBOUND) {
				shiftCharValue = LOWERBOUND + (shiftCharValue - HIGHERBOUND - 1);
			}
			
			// If statement that checks the value of shiftCharValue (any individual char ASCII) is lower than "LOWERBOUND" (ASCII of 32), then the encryption will be looped to the highest point (123) subtracted by the encryption value (By subtracting "LOWERBOUND", "shiftCharValue, and 1 all together).
			if(shiftCharValue < LOWERBOUND) {
				shiftCharValue = HIGHERBOUND - (LOWERBOUND - shiftCharValue - 1);
			}
			
			// "encryptedText" applied with the method "append" to allow the ASCII value of shiftCharValue to be converted into its actual char, changing the current char the for loop has incremented into to become the encrypted char value before moving on to the next char value of the user's string input.
			encryptedText.append((char) shiftCharValue);
			
		}
		
		// As the function is created as a datatype of "string", a string must be returned, thus, the StringBuilder object "encryptedText" is returned with all char values put together as one string via using the "toString" method.
		return encryptedText.toString();
		
	}
	
	// Function/method "bellasoDecryption" which allows the user to reverse the bellaso encryption back to its original from in which the user has input from the beginning through the parameters "encryptedText" stringbuilder from the previous method and gathered from "encryptionTextfield" and "bellasoKey", the key the user has inputted for bellaso encryption.
	public String bellasoDecryption(String encryptedText, String bellasoKey) {
		
		// Object "decryptedText" which is created but not yet initialized, this would store the decrypted message after the encryption has been reversed.
		StringBuilder decryptedText = new StringBuilder();
		// char variable declared, not yet initialized. 
		char currentCharValue;
		// int variable "bellasoKeyLength" which gather's the length of the key the user has input for bellaso decryption (string input with more than one letter).
		int bellasoKeyLength = bellasoKey.length();
		
		// If statement which calls the function "stringInBounds" to run and check if the encrypted text is in the correct bounding range (32 - 123) into the textfield "encryptionTextfield" which connects its data into the parameter "encryptedText". If the function results to being returned to a value of false, then the if statement will be executed as true, returning to the user that an error has occurred and the user must reinput another string correctly.
		if(stringInBounds(encryptedText) == false) {
			return "Error: String inputted is not in bounds, please reinput another string.";
		}
		
		// For loop which loops through each char value of the inputed string "encryptedText" by incrementing through each letter (length of the string). 
		for(int i = 0; i < encryptedText.length(); i++) {
			// By using "charAt(i)", this initializes the variable "currentCharValue" to store the current letter that is being analyzed in the for loop, each letter will be stored and checked in the variable and loop until the for loop increments beyond the size of the encrypted string.
			currentCharValue = encryptedText.charAt(i);
			// Char variable "keyCharacter" which gets the specific char in the string throughout the entire string (if more than one letter) that was stored in "ecnryptedText", this stores the current char inside the variable. 
			char keyCharacter = bellasoKey.charAt(i % bellasoKeyLength);
			// int "keyCharacterIntValue" which gets the integer ASCII value of each char value from the variable "keyCharacter".
			int keyCharacterIntValue = keyCharacter;
			// int value "shiftCharValue" which gathers the general shift in which the inputed string will be decrypted by adding each ASCII value of each char in the string by the key (the ASCII value of each character the user has input for the key when selecting the radio button for bellaso encryption).
			int shiftCharValue = currentCharValue - keyCharacterIntValue;
			
			// If statement that checks the value of shiftCharValue, if an value of the char is greater than the constant variable "HIGHERBOUND" (123), then the value will be looped back to the lowest bound plus the decryption value (By subtracting "shiftCharValue", HIGHERBOUND and 1 all together).
			if(shiftCharValue > HIGHERBOUND) {
				shiftCharValue = LOWERBOUND + (shiftCharValue - HIGHERBOUND - 1);
			}
			
			// If statement that checks the value of shiftCharValue, if an value of the char is greater than the constant variable "HIGHERBOUND" (123), then the value will be looped back to the lowest bound plus the decryption value (By subtracting "shiftCharValue", HIGHERBOUND and 1 all together).
			if(shiftCharValue < LOWERBOUND) {
				shiftCharValue = HIGHERBOUND - (LOWERBOUND - shiftCharValue - 1);
			}
			
			// "decryptedText" applied with the method "append" to allow the ASCII value of shiftCharValue to be converted into its actual char, changing the current char the for loop has incremented into to become the decrypted char value before moving on to the next char value of the encrypted string.
			decryptedText.append((char) shiftCharValue);
		}
		
		// As the function is created as a datatype of "string", a string must be returned, thus, the StringBuilder object "decryptedText" is returned with all char values put together as one string via using the "toString" method.
		return decryptedText.toString();
		
	}
	
}
