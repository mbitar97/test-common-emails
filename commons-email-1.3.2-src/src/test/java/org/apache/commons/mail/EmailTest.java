package org.apache.commons.mail;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class EmailTest {
	
	private static String[] emailList = {"email1@gmail.com", "email2@gmail.com", "email3@gmail.com", "email4@gmail.com", "email5@gmail.com"};
	private static String[] emptyEmailList = {};
	private EmailConcrete email;
	
	@Before
	public void setUpEmailTest() throws Exception
	{
		email = new EmailConcrete();
	}
	
	@After
	public void tearDownEmailTest() throws Exception
	{

	}
	
	@Test
	public void testAddBcc() throws Exception
	{
		email.addBcc(emailList);
		assertNotNull(email.getBccAddresses());
		assertEquals(5, email.getBccAddresses().size());	
	}
	
	@Test
	public void testAddCc() throws Exception
	{
		email.addCc("email@gmail.com");
		assertNotNull(email.getCcAddresses());
		assertEquals(1, email.getCcAddresses().size());	
	}
	
	@Test
	public void testAddHeader() throws Exception
	{
		String Headername = "headername";
		String Headervalue = "headervaluetxt";
		email.addHeader(Headername, Headervalue);
	}	
	@Test (expected = IllegalArgumentException.class)
	public void testAddHeaderNullVal() throws Exception{
		String Headername = "headername";
		email.addHeader(Headername, null);
	}
	@Test (expected = IllegalArgumentException.class)
	public void testAddHeaderNullName() throws Exception{
		String Headervalue = "headervaluetxt";
		email.addHeader(null, Headervalue);
	}
	
	@Test
	public void testAddReplyTo() throws Exception
	{
		String an_email = "email@gmail.com";
		String name = "name";
		email.addReplyTo(an_email, name);
		assertNotNull(email.getReplyToAddresses());
	}
	
	
	
}
