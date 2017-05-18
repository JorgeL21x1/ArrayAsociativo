import static org.junit.Assert.*;

import org.junit.Test;

public class ArrayAsociativoTest {
	private ArrayAsociativo a;
	
	
	
	
	@Test
	public void ArrayVacio() {
		a= new ArrayAsociativo();
		assertTrue(a.size()==0);
		a=null;
	}

}
