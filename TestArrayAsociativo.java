package prArrayAsociativo;

import static org.junit.Assert.*;

import org.junit.*;

public class TestArrayAsociativo {
	private ArrayAsociativo a;
	private String [] claves = {"nombre","apellido","dni","pais"};
	private String [] valores = {"luis","martin","12345567P","España"};
	
	@Before
	public void inicializar() {
		a = new ArrayAsociativo();
		System.out.println("Before");
	}

	@After
	public void finalizar() {
		a = null;
		System.out.println("After");

	}
	
	@Test
	public void sizeArrayVacio() {
		
		assertTrue(0 == a.size());
	
	}
	
	@Test
	public void sizeArrayNoVacio(){
		a = new ArrayAsociativo(claves,valores);
		assertTrue(4 == a.size());
	
	}

}
