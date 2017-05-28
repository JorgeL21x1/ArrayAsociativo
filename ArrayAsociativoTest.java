import static org.junit.Assert.*;

import java.util.NoSuchElementException;

import org.junit.After;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class ArrayAsociativoTest {
	private ArrayAsociativo a;
	
	private String[] claves = {"nombre","apellido","dni","pais"};
	private String[] valores = {"luis","martin","12345567P","Espana"};

	private String[] claves1 = {"nombre"};
	private String[] valores1 = {"luis"};
	
	private String[] claves2 = {"nombre","apellido","dni","pais","nombre"};
	private String[] valores2 = {"luis","martin","12345567P","Espana","luis"};

	@Before
	public void inicializar(){
	a= new ArrayAsociativo(claves,valores);
	}
	@After 
	public void finalizar(){
	a=null;
	}

	
	//1
	@Test
	public void ArrayVacio() {
		a= new ArrayAsociativo();
		assertTrue(a.size()==0);
	}
	//2
	@Test
	public void ArrayNoVacio() {
		assertTrue(a.size()==4);
	}
	//3
	@Rule
	public ExpectedException posibleExcepcion = ExpectedException.none();
	@Test
	public void BuscaValorArrayVacio() {
		a = new ArrayAsociativo();
		posibleExcepcion.expect(NoSuchElementException.class);
		a.get(claves[0]);//Busca la primera clave
	}
	//4
	@Test
	public void BuscaValorArrayExiste() {
		assertTrue(a.get(claves[0])==valores[0]);
	}
	//5
	@Test
	public void BuscaValorArrayNoExiste() {
		posibleExcepcion.expect(NoSuchElementException.class);
		a.get("prueba");
	}
	
	//6
	@Test
	public void InsertarNuevoArrayVacio() {
		int tam=a.size();
		a= new ArrayAsociativo();
		a.put(claves1[0],valores1[0]);
		assertTrue(tam+1==a.size());
	}
	
	//7
	@Test
	public void InsertarNuevoArrayNoVacio() {
		int tam=a.size();
		System.out.println(tam);
		a.put(claves1[0], valores1[0]);
		
		assertTrue(a.get(claves1[0]) == valores[0]);
		System.out.println(tam);
		assertTrue(tam+1 == a.size());
	}
	
	//8
	@Test
	public void InsertarExistenteArrayNoVacio() {
		int tam=a.size();
		a.put(claves[2], valores1[0]);
		
		assertTrue(a.get(claves[2]) == valores1[0]);
		assertTrue(tam == a.size());
	}
	
	//9
	@Test
	public void BuscargetOrElseArrayVacio() {
		assertTrue(a.getOrElse(claves[0], "ValorPorDefecto") == "ValorPorDefecto");
	}
	
}
