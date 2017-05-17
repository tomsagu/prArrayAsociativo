package prArrayAsociativo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class TestArrayAsociativo {
	private ArrayAsociativo a;
	private static String [] claves = {"nombre","apellido","dni","pais"};
	private static String [] valores = {"luis","martin","12345567P","España"};
	private static String clave = "nombre";
	
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
	@Rule
	public ExpectedException posibleExcepcion = ExpectedException.none();
	
	@Test
	public void valorArrayVacio(){
		posibleExcepcion.expect(NoSuchElementException.class);
		posibleExcepcion.expectMessage("Falla");
		a.get(clave);
	}
	
	@Test
	public void valorExisteClave(){
		a = new ArrayAsociativo(claves,valores);
		assertTrue(a.get(clave) == "luis");
	}
	
	@Test
	public void valorNoExisteClave(){
		a = new ArrayAsociativo(claves,valores);
		posibleExcepcion.expect(NoSuchElementException.class);
		posibleExcepcion.expectMessage("Falla");
		a.get("telefono");
	}

}
