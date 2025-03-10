package application;


import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


/**
 * This class represents GFA test cases for a CryptoManager object.
 * 
 * @author Farnaz Eivazi
 * @version 7/12/2022
 * 
 */
public class CryptoManagerTestStudentTwo {

	CryptoManager cryptoManager = new CryptoManager();
	
	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testStringInBounds() {
		assertTrue(cryptoManager.stringInBounds("THIS TEST SHOULD SUCCEED"));
	}

	@Test
	public void testEncryptCaesar() {
		assertEquals("IFMMP!XPSME", cryptoManager.caesarEncryption("HELLO WORLD", 1));
	}

	@Test
	public void testDecryptCaesar() {
		assertEquals("HELLO WORLD", cryptoManager.caesarDecryption("IFMMP!XPSME", 1));
	}
}
