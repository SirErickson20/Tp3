
public class Cola {

	private int tail;
	private int head;
	private int capacidad;
	private Character[] contenedor;
	
	public Cola() {
		this.tail = 0;
		this.head = 0;
		this.contenedor = new Character[10];
	}
	
	public Cola(int capacidad) {
		this.tail = 0;
		this.head = 0;
		this.capacidad = capacidad;
		this.contenedor = new Character[capacidad];
	}
	
	public boolean estaVacia() {
		return (this.tail == this.head);
	}
	
	public boolean estaLlena() {
		return (siguiente(this.tail) == this.head);
	}
	
	public int siguiente(int posicion) {
		++posicion;
		if(posicion >= capacidad) {
			posicion = 0;
		}
		return posicion;
	}
	
	public void encolar(Character caracter) {
		if(estaLlena()) {
			throw new RuntimeException("Error... la cola esta llena.");
		}
		contenedor[this.tail] = caracter;
		this.tail = siguiente(this.tail);
	}
	
	public Character desencolar() {
		if(estaVacia()) {
			throw new RuntimeException("Error... la cola esta vacia");
		}
		Character caracter = this.contenedor[this.head];
		this.head = siguiente(head);
		return caracter;
	}
	
	public Character peek() {
		if(estaVacia()) {
			throw new IllegalStateException("Cola vacia...");
		}
		return this.contenedor[this.head];
	}
	
	public int cantidad() {
		int resultado = this.tail - this.head;
		if (resultado < 0) {
			resultado = resultado * -1;
		}
		return resultado;
	}
}
