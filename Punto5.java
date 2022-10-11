import java.util.Random;
import java.util.Scanner;

public class Punto5 {

    static Scanner sc = new Scanner(System.in);
  //Definición de colas Estaticas
    static QueueEspacio<Integer> clavecola1 = new QueueEspacio<>();
    static QueueEspacio<Character> mensajecola = new QueueEspacio<>(); 
    public static void main(String[] args){
    	tripleDES(); //Aplica el cifrado
    	String cifrado=mostrarCola(mensajecola);
    	System.out.println("Mensaje cifrado: "+cifrado);
    	mensajecola=ingresarMensaje(cifrado);
    	System.out.print("Presione una tecla para continuar...");
    	sc.nextLine();
    	descifrar();
    }
    //Modulos relacionados al cifrado
    
    public static void tripleDES() {
    	Random random = new Random();
        int clave=0;
        int op=Helper.seleccionarOpcion("1) Ingresar manualmente: ", "2) Ingresar Aleatoriamente");
        if(op==1) {
        	System.out.println("Ingrese mensaje a cifrar");
            String mensaje=sc.nextLine();
        	mensajecola=ingresarMensaje(mensaje);
        	for(int i=0;i<3;i++) {
        		clave=Helper.corrector("Ingrese clave: ");
              	clavecola1=definirClave(clave);
                mensajecola = aplicarCifrado(clavecola1, mensajecola);
                clavecola1.reset();
            }
     
        }else {
        	String mensaje=Helper.palabraRandom();
        	System.out.println("El mensaje es: "+mensaje);
        	mensajecola=ingresarMensaje(mensaje);
        	for(int i=0;i<3;i++) {
        		clave=random.nextInt(0,mensaje.length()*(10^mensaje.length()));
              	System.out.println("Clave: "+clave);
        		clavecola1=definirClave(clave);
              	mensajecola = aplicarCifrado(clavecola1, mensajecola);
                clavecola1.reset();
            }
        	
        }
        
    }
    
    public static QueueEspacio<Character> ingresarMensaje(String mensaje){
        QueueEspacio<Character> mensajecola = new QueueEspacio<>();
        for (char c: mensaje.toCharArray ()){
            mensajecola.enqueue(c);
        }
        return mensajecola;
    }

    public static QueueEspacio<Character> aplicarCifrado(QueueEspacio<Integer> clave, QueueEspacio<Character> mensaje){
        int digito=0;
        Character cifrado;
        QueueEspacio<Character> msjAux = new QueueEspacio<>();
        while(!mensaje.isEmpty()){
            digito=clave.dequeue();
            cifrado=(char)((int)mensaje.dequeue()+digito);
            msjAux.enqueue(cifrado);
            clave.enqueue(digito); 
        }
        return msjAux;
    }

    //Modulos relacionados al descifrado
    public static QueueEspacio<Character> aplicarDescifrado(QueueEspacio<Integer> clave, QueueEspacio<Character> mensaje){
        int digito=0;
        Character cifrado;
        QueueEspacio<Character> msjAux = new QueueEspacio<>(); 
        while(!mensaje.isEmpty()){
            digito=clave.dequeue();
            cifrado=(char)((int)mensaje.dequeue()-digito);
            msjAux.enqueue(cifrado);
            clave.enqueue(digito); 
        }
        return msjAux;

    }
    public static void descifrar() {
    	int clave=0;
    	System.out.println("Inicio del descifrado");
        for(int i=0;i<3;i++) {
        	clave=Helper.corrector("Ingrese clave: ");
        	clavecola1=definirClave(clave);
            mensajecola = aplicarDescifrado(clavecola1, mensajecola);
            clavecola1.reset();
        }
        String descifrado=mostrarCola(mensajecola);
    	System.out.println(descifrado);
    }
    
    //Metodos que se aplican tanto como el cifrado como el descifrado
    public static QueueEspacio<Integer> definirClave(int clave){
    	QueueEspacio<Integer> cola = new QueueEspacio<>();
    	String claveCadena=String.valueOf(clave);
        for(int i=0;i<claveCadena.length();i++) {
        	int numero = Character.getNumericValue(claveCadena.charAt(i));
        	cola.enqueue(numero);
            
        }
        return cola;
    }
    public static String mostrarCola(QueueEspacio<Character> cola) {
    	String cifrado="";
    	while(!cola.isEmpty()) {
     	   cifrado=cifrado+cola.dequeue();
        }
    	return cifrado;
    }
          
}
