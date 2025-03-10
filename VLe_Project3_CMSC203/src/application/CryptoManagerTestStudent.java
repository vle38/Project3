package application;


import static org.junit.Assert.*;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;

public class CryptoManagerTestStudent {
	CryptoManager cryptoManager;

	@BeforeEach
	public void setUp() throws Exception {
		cryptoManager = new CryptoManager();
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(cryptoManager.stringInBounds("JAVA"));
		assertTrue(cryptoManager.stringInBounds("\"JAVA IS FUN\""));
		assertFalse(cryptoManager.stringInBounds("java"));
		assertFalse(cryptoManager.stringInBounds("{JAVA"));
		assertFalse(cryptoManager.stringInBounds("\"THIS TEST THAT SHOULD FAIL BECAUSE { IS OUTSIDE THE RANGE\""));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("The selected string is not in bounds, Try again.", cryptoManager.caesarEncryption("bye", 3));
		assertEquals("DEF", cryptoManager.caesarEncryption("ABC", 3));
		assertEquals("!\"#", cryptoManager.caesarEncryption("ABC", 96));
		assertEquals("1.558", cryptoManager.caesarEncryption("HELLO", 105));
		assertEquals("UFTUJOH", cryptoManager.caesarEncryption("TESTING", 1));
		assertEquals("WKLV#LV#DQRWKHU#WHVW", cryptoManager.caesarEncryption("THIS IS ANOTHER TEST", 3));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("TESTING", cryptoManager.caesarDecryption("UFTUJOH", 1));
		assertEquals("TESTING ANOTHER STRING", cryptoManager.caesarDecryption(";,:;05.G(56;/,9G:;905.", 999));
		assertEquals("HELLO WORLD", cryptoManager.caesarDecryption("4188;LC;>80", 300));
		assertEquals("THIS IS ANOTHER TEST", cryptoManager.caesarDecryption("WKLV#LV#DQRWKHU#WHVW", 3));
	}

	@Test
	public void testEncryptBellaso() {
		assertEquals("WN#\\N &", cryptoManager.bellasoEncryption("TESTING", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("UJ^^((HT^X[YYM\"", cryptoManager.bellasoEncryption("MERRY CHRISTMAS", "HELLO"));
		assertEquals("WU\\VR9F#N!RF88U-'HED", cryptoManager.bellasoEncryption("THIS IS ANOTHER TEST", "CMSC203"));

	}

	@Test
	public void testDecryptBellaso() {
		assertEquals("TESTING", cryptoManager.bellasoDecryption("WN#\\N &", "CIPHER_IS_LONGER_THAN_THE_PLAIN_TEXT"));
		assertEquals("MERRY CHRISTMAS", cryptoManager.bellasoDecryption("UJ^^((HT^X[YYM\"", "HELLO"));
		assertEquals("THIS IS ANOTHER TEST", cryptoManager.bellasoDecryption("WU\\VR9F#N!RF88U-'HED", "CMSC203"));

	}

}

