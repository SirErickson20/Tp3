import java.util.Scanner;
import java.util.Random;

public class Punto2 {
    public static void main(String[] args) {
        //pruebas

        QueueVelocidad<Integer> cola = new QueueVelocidad<Integer>(6);
        cola.enqueue(10);
        cola.enqueue(27);
        cola.enqueue(3);
        cola.enqueue(9);
        cola.enqueue(15);
        suprimirNumero(cola, 9);

        //fin pruebas

    }   

    public static void menuCola(){
        System.out.println("***MENU***");
        System.out.println("Elija una opción");
        System.out.println("1. Cargar cola manualmente (tamaño y elementos)");
        System.out.println("2. Cargar cola aleatoriamente (tamaño y elementos)");
        
        int opcion = Helper.corrector("Ingrese una opción: ");

        if(opcion == 1){
            //cargarColaManual()
        }else{
            //cargarColaAleatoria()
        }
    }


    // ** MÉTODOS QUE REALIZAN EL PUNTO **
    //Métodos auxiliares
    public static boolean isNum(int valor, int num){
        return num == valor;
    }

    public static boolean isMult(int valor, int num){        
        return valor % num == 0;
    }

    public static boolean isDiv(int valor, int num){

        return num % valor == 0;
    }

    //Método principal
    public static QueueVelocidad<Integer> suprimirNumero(QueueVelocidad<Integer> queue, int num){
        QueueVelocidad<Integer> qAux = new QueueVelocidad<Integer>(6);

        while(!queue.isEmpty()){
            if (
                isNum(queue.element(), num)
                || isMult(queue.element(), num)
                || isDiv(queue.element(), num)
            ){
                System.out.println("Sale el elemento " + queue.element() + " y se borra");
                queue.dequeue(); //Saca el elemento de la cola y lo pierde, pues es el elemento a eliminar
            }else{
                System.out.println("Sale el elemento " + queue.element() + " y se guarda en una cola auxiliar");
                qAux.enqueue(queue.dequeue()); //Saca el elemento de la cola y lo encola en una cola auxiliar, esta cola servirá como valor de retorno de la función
            }
        }
    
        return qAux;
    } 
    // ** MÉTODOS QUE REALIZAN EL PUNTO (fin)**



}
