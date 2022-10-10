public class QueueVelocidad <E>{

    private final static Integer defaultDimension=10;

    private E [] datos;
    private int head;
    private int tail;
    private int count;

    public QueueVelocidad(){
        this(QueueVelocidad.defaultDimension);
    }
    
    @SuppressWarnings("unchecked")
    public QueueVelocidad(Integer dimension){
        this.datos= (E[]) new Object [dimension];;
        this.head=0;
        this.tail=0;
        this.count=0;
    }

    public int size(){
        return this.count;
    }

    public boolean isEmpty(){
        return this.count<=0;
    }

    public boolean add(E element){
        if(this.next(this.tail) == this.head){
            throw new IllegalStateException("Cola llena..");
        }

        this.datos[this.tail]=element;
        this.tail=this.next(this.tail);
        ++this.count;
        return true;
    }

    public void enqueue(E element) {
		if(this.next(this.tail) == this.head) {
			throw new IllegalStateException("Cola llena..");
		}
		this.datos[this.tail] = element;
		this.tail = next(this.tail);
	}
	
	public E dequeue() {
		if(this.head == this.tail) {
			throw new IllegalStateException("Cola vacia..");
		}
		E element = this.datos[this.head];
		this.head = next(this.head);
		return element;
	}

    private int next(int pos){
        if(++pos>=this.datos.length){
            pos=0;
        }
        return pos;
    }

    public boolean offer(E element){
        if(this.size()>=this.datos.length){
            return false;
        }
        this.datos[this.tail]=element;
        this.tail=this.next(this.tail);
        ++this.count;

        return true;
    }

    public E pool(){
        if(this.size()<=0){
            return null;
        }
        E result=this.datos[this.head];
        this.head=this.next(this.head);
        --this.count;

        return result;
    }  

    public E remove(){
        if(this.head == this.tail){
            throw new IllegalStateException("Cola vacia...");
        }

        E result=this.datos[this.head];
        this.head=this.next(this.head);
        --this.count;

        return result;
    }

    public E element(){
        if(this.head == this.tail){
            throw new IllegalStateException("Cola vacia...");
        }
        return this.datos[this.head];
    }

}
