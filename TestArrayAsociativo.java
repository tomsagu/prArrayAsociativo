package prArrayAsociativo;

import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.*;
import org.junit.rules.ExpectedException;

public class TestArrayAsociativo {
	private ArrayAsociativo a;
	private static String [] claves = {"nombre","apellido","dni","pais"};
	private static String [] valores = {"luis","martin","12345567P","España"};
	
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
		a.get(claves[0]);
	}
	
	@Test
	public void valorExisteClave(){
		a = new ArrayAsociativo(claves,valores);
		assertTrue(a.get(claves[0]) == "luis");
	}
	
	@Test
	public void valorNoExisteClave(){
		a = new ArrayAsociativo(claves,valores);
		posibleExcepcion.expect(NoSuchElementException.class);
		posibleExcepcion.expectMessage("Falla");
		a.get("telefono");
	}
	
	@Test
	public void insertarArrayVacio(){
		a.put(claves[0], valores[0]);
		assertTrue(a.get(claves[0]) == valores[0]);
	}
	
	@Test
	public void insertarArrayNoVacio(){
		a = new ArrayAsociativo(claves,valores);
		a.put("telefono", "658654651");
		assertTrue(a.get("telefono") == "658654651");
	}
	
	@Test
	public void insertarClaveAlmacenada(){
		a = new ArrayAsociativo(claves,valores);
		a.put(claves[1], "martinez");
		assertTrue(a.get(claves[1]) == "martinez");
	}
	
	@Test
	public void getOrElseArrayVacio(){
		assertTrue(a.getOrElse(claves[0],"desconocido") == "desconocido");
	}
	
	@Test
	public void getOrElseClaveExiste(){
		a = new ArrayAsociativo(claves,valores);
		assertTrue(a.getOrElse(claves[0],"desconocido") == valores[0]);
	}
	
	@Test
	public void getOrElseClaveNoExiste(){
		a = new ArrayAsociativo(claves,valores);
		assertTrue(a.getOrElse("telefono","desconocido") == "desconocido");
	}
}
