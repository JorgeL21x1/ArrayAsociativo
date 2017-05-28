import java.util.NoSuchElementException;

public class ArrayAsociativo {
	//Clases internas
	private class Nodo{
		private String clave;
		private String valor;
		private Nodo sig; //siguiente nodo
		
		public Nodo(String c, String v, Nodo s){
			clave = c;
			valor = v;
			sig = s;
		}
	}
	
	//Variables de instancia
	private Nodo primero;
	
	
	//Constructores
	public ArrayAsociativo(){
		primero = null;
	}
	
	public ArrayAsociativo(String[] claves, String[] valores){
		this();
		if (claves.length > 0){
			primero = new Nodo(claves[0], valores[0],null);
			for (int i = 1; i< claves.length; i++){
				Nodo nuevo = new Nodo(claves[i], valores[i],primero);
				primero = nuevo;
			}
		}
	}
	
	//Métodos de instancia
	
	// Devuelve el número de entradas del arry asociativo.
	public int size(){
		
		int size = 0;
		Nodo aux = primero;
		while (aux != null) {
			size++;
			aux = aux.sig;
		}
		return size;
		
	}
	
	//Para una clave devuelve el valor asociado
	public String get(String clave){
		Nodo aux= primero;
		String valor;
		
	while(aux!=null && aux.clave!=clave){
		aux=aux.sig;
	}
		
		if(aux==null){
			throw new NoSuchElementException("No se encuentra la clave");
		}else{
			valor=aux.valor;
		}
		
	return valor;	
	}
	
	//crea una  nueva entrada en la tabla en caso de existir la clave cambia al nuevo valor
	public void put(String clave, String valor) {
		Nodo anterior = null;
		Nodo actual = primero;
		
		if (primero == null) {
			actual.clave = clave;
			actual.valor = valor;
			actual.sig = null;
			primero = actual;
		} else {
			while (actual != null && actual.clave != clave){
				anterior = actual;
				actual = actual.sig;
			}
				
			boolean encontrado = (actual.clave == clave);
				
			if (encontrado) {
				actual.valor = valor;
			} else {
				actual= new Nodo(clave,valor,null);
				anterior.sig=actual;
			}
		}
	}
	
	/*para una clave dada devuelve el valor asociado en caso de 
	no haber devuelve valor por defecto*/
	public String getOrElse(String clave, String valorPorDefecto){
		Nodo aux = primero;
		String res;
		
		while(aux != null && clave != aux.clave){
			aux = aux.sig;
		}
		
		if (aux == null){
			return valorPorDefecto;
		} else{
			res = aux.valor;
			return res;
		}
	}
	
	//Devuelve true si existe la clave o false si no
	public boolean containsKey(String clave){
		return false;
		
	}

	//borra el par asociado en caso de realizarse  con exito devuelve true o false si no
	public boolean remove(String clave){
		return false;
		
	}
	
}
