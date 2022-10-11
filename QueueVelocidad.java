public class QueueVelocidad <E>{

    private Integer defaultDimension=10;
    private E [] datos;
    private int head;
    private int tail;

    @SuppressWarnings("unchecked")
    public QueueVelocidad(){
        this.datos = (E[]) new Object [this.defaultDimension];
        this.head = 0;
        this.tail = 0;
    }
    
    @SuppressWarnings("unchecked")
    public QueueVelocidad(Integer dimension){
        this.datos= (E[]) new Object [dimension];
        this.defaultDimension = dimension;
        this.head=0;
        this.tail=0;
    }

    
    public boolean isEmpty(){
        return this.head == this.tail;
    }
    
    public boolean isFull() {
    	return this.head == next(this.tail);
    }

    public boolean add(E element){
        if(this.next(this.tail) == this.head){
            throw new IllegalStateException("Cola llena..");
        }

        this.datos[this.tail]=element;
        this.tail=this.next(this.tail);
        return true;
    }

    public void enqueue(E element) {
		if(isFull()) {
			throw new IllegalStateException("Cola llena..");
		}
		this.datos[this.tail] = element;
		this.tail = next(this.tail);
	}
	
	public E dequeue() {
		if(isEmpty()) {
			throw new IllegalStateException("Cola vacia..");
		}
		E element = this.datos[this.head];
		this.head = next(this.head);
		return element;
	}


    public int next(int pos){
    	++pos;
        if(pos>=this.defaultDimension){
            pos=0;
        }
        return pos;
    }

    public boolean offer(E element){
        if(isFull()){
            return false;
        }
        this.datos[this.tail]=element;
        this.tail= next(this.tail);
        return true;
    }

    public E pool(){
        if(isEmpty()){
            return null;
        }
        E result=this.datos[this.head];
        this.head=next(this.head);

        return result;
    }  

    public E remove(){
        if(isEmpty()){
            throw new IllegalStateException("Cola vacia...");
        }

        E result= this.datos[this.head];
        this.head= next(this.head);

        return result;
    }

    public E element(){
        if(isEmpty()){
            throw new IllegalStateException("Cola vacia...");
        }
        return this.datos[this.head];
    }
    
    public int cantidad() {
		int resultado = this.tail - this.head;
		if (resultado < 0) {
			resultado = resultado * -1;
		}
		return resultado;
	}

}
