package facade;

import static org.junit.Assert.*;

import org.junit.*;

public class CartFacadeTest {
	CartFacade cartFacadeObject;
	@Before
	public void createObject()
	{
		cartFacadeObject=CartFacade.getInstance();
	}

	@Test
	public void singletonClassObjectPositiveTestCase()
	{
		CartFacade cartFacadeNewObject=CartFacade.getInstance();
		boolean actualOutput=cartFacadeNewObject.hashCode()==cartFacadeObject.hashCode();
		assertEquals(true,actualOutput);
	}
	
	@Test
	public void addElementPositiveTestCase()
	{
		
	}
}
