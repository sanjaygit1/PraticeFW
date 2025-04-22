package TestNg;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;

@Listeners(Generic_Utilities.ListenersImp.class)
public class DemoTest extends BaseClass {

	
	@Test
	public void m1()
	{
	//	Assert.fail();
	}
}
//im new branch2---->