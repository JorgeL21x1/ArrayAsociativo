

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
	
	//M�todos de instancia
	
	// Devuelve el n�mero de entradas del arry asociativo.
	public int size(){
		return 0;
		
	}
	
	//Para una clave devuelve el valor asociado
	public String get(String clave){
		return clave;
		
	}
	
	//crea una  nueva entrada en la tabla en caso de existir la clave cambia al nuevo valor
	public void put(String clave, String valor){
		
	}
	
	/*para una clave dada devuelve el valor asociado en caso de 
	no haber devuelve valor por defecto*/
	public String getOrElse(String clave, String valorPorDefecto){
		return valorPorDefecto;
		
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
