//TODO
// - añadir validaciones (claves negativas, tamaño de mensaje, osea el tamaño de cola)
// - preparar menú (ingreso manual y aleatorio)
// - corregir el tema de que no cifra/descifra bien los caracteres con tilde (á,é,í, etc., los caracteres especiales como @ y los números los cifra y descifra bien)

import java.util.Scanner;

public class Punto5 {

    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){

        //Definición de colas
        QueueEspacio<Integer> clavecola1 = new QueueEspacio<>();
        QueueEspacio<Integer> clavecola2 = new QueueEspacio<>();
        QueueEspacio<Integer> clavecola3 = new QueueEspacio<>();
        QueueEspacio<Character> mensajecola = new QueueEspacio<>();

        System.out.println("Ingrese las claves de cifrado");
        clavecola1=definirClave(clavecola1);
        clavecola2=definirClave(clavecola2);
        clavecola3=definirClave(clavecola3);
        mensajecola=ingresarMensaje();

        mensajecola = cifrarMensaje(mensajecola, clavecola1, clavecola2, clavecola3);

        clavecola1.reset();
        clavecola2.reset();
        clavecola3.reset();

        System.out.println("Ingrese las claves de descifrado");
        clavecola1=definirClave(clavecola1);
        clavecola2=definirClave(clavecola2);
        clavecola3=definirClave(clavecola3);
        
        
        descifrarMensaje(mensajecola, clavecola1, clavecola2, clavecola3);
    }

    public static QueueEspacio<Integer> definirClave(QueueEspacio<Integer> cola){
        System.out.println("Ingrese clave");
        int resto,invertido=0;
        int clave=sc.nextInt();
        while( clave > 0 ) {
            resto = clave % 10;
            invertido = invertido * 10 + resto;
            clave /= 10;
        }
        while(invertido > 0){
            cola.enqueue(invertido % 10);
            invertido = invertido / 10;
        }
        return cola;
    }

    public static QueueEspacio<Character> ingresarMensaje(){
        QueueEspacio<Character> mensajecola = new QueueEspacio<>();
        System.out.println("Ingrese mensaje a cifrar");
        sc.nextLine();
        String mensaje=sc.nextLine();
        for (char c: mensaje.toCharArray ()){
            mensajecola.enqueue(c);
        }
        return mensajecola;
    }

    
    public static QueueEspacio<Character> cifrarMensaje(QueueEspacio<Character> mensaje, QueueEspacio<Integer> clave1, QueueEspacio<Integer> clave2, QueueEspacio<Integer> clave3){
        QueueEspacio<Character> mensajeCifrado = new QueueEspacio<>();

        mensajeCifrado = aplicarCifrado(clave1, mensaje);    
        mensajeCifrado = aplicarCifrado(clave2, mensajeCifrado);    
        mensajeCifrado = aplicarCifrado(clave3, mensajeCifrado);

        return mensajeCifrado;
    }

    public static QueueEspacio<Character> aplicarCifrado(QueueEspacio<Integer> clave, QueueEspacio<Character> mensaje){
        int digito=0;
        Character cifrado;
        QueueEspacio<Character> msjAux = new QueueEspacio<>();

        System.out.println("inicio del cifrado");
        while(!mensaje.isEmpty()){
            digito=clave.dequeue();
            System.out.println(digito);
            cifrado=(char)((int)mensaje.dequeue()+digito);
            msjAux.enqueue(cifrado);
            clave.enqueue(digito); 
        }
        System.out.println("fin del cifrado");
        return msjAux;

    }

    public static void descifrarMensaje(QueueEspacio<Character> mensaje, QueueEspacio<Integer> clave3, QueueEspacio<Integer> clave2, QueueEspacio<Integer> clave1){
        QueueEspacio<Character> mensajeDescifrado = new QueueEspacio<>();

        mensajeDescifrado = aplicarDescifrado(clave3, mensaje);    
        mensajeDescifrado = aplicarDescifrado(clave2, mensajeDescifrado);    
        mensajeDescifrado = aplicarDescifrado(clave1, mensajeDescifrado);

        while(mensajeDescifrado.isEmpty()!=true){
            System.out.println(mensajeDescifrado.dequeue());
        }
    }

    public static QueueEspacio<Character> aplicarDescifrado(QueueEspacio<Integer> clave, QueueEspacio<Character> mensaje){
        int digito=0;
        Character cifrado;
        QueueEspacio<Character> msjAux = new QueueEspacio<>();
        System.out.println("inicio del descifrado");
        while(!mensaje.isEmpty()){
            digito=clave.dequeue();
            System.out.println(digito);
            cifrado=(char)((int)mensaje.dequeue()-digito);
            msjAux.enqueue(cifrado);
            clave.enqueue(digito); 
        }
        System.out.println("fin del descifrado");
        return msjAux;

    }
          
}
