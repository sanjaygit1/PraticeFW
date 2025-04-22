package TestNg;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;

@Test
public class SampleTest extends BaseClass {

	
	public void createContact() {

		System.out.println("ContactCreated");
	}

	
	public void modifyContact() {
		
		
		System.out.println("ContactModified");
	}

	
	public void deleteContact()
	{
		System.out.println("ContactDeleted");
	
	}}
