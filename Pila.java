package EdD.Tp4;
public class Pila<E> {
    private final static Integer maximoTamanio=100;
    private SimpleLinkedList<E> list;
    public Pila(){
        this.list = new SimpleLinkedList<>();
    }
    //Añade elemento al principio de la pila
    public void Push(E elemento) {
		if (list.size()>= maximoTamanio) {
			throw new RuntimeException("La pila esta llena...");
		}
		list.addFirst(elemento);
	}
    //Extrae y borra el elemento al principio de la pila
    public E Pop() {
		if (this.isEmpty()) {
			throw new RuntimeException("La pila esta vacia...");
		}
		E elemento = list.removeFirst();
        return elemento;
	}
    //Extrae el elemento al principio de la pila
    public E Peek() {
		if (this.isEmpty()) {
			throw new RuntimeException("La pila esta vacia...");
		}
		E elemento = list.removeFirst();
        list.addFirst(elemento);
        return elemento;
	}
    //Verifica si la pila esta vacia
    public boolean isEmpty(){
        return list.size()<=0;
    }
}
