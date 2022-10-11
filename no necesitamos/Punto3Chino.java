import java.text.Collator;
import java.util.Arrays;
import java.util.Random;
import java.util.*;
public class Punto3Chino {
    static Collator comparador = Collator.getInstance();
    public static void main(String[] args) {
        System.out.println("UNION DE COLAS");
        int op = Helper.seleccionarOpcion("1. Ingresar manualmente", "2. Generar aleatoriamente");
        QueueVelocidad<String> cola1 = new QueueVelocidad<>();
        cargarCola(cola1, op);
        QueueVelocidad<String> cola2 = new QueueVelocidad<>();
        cargarCola(cola2, op);
        QueueVelocidad<String> cola3 = new QueueVelocidad<>();
        unionDeCola(cola1, cola2,cola3);
        System.out.println(cola1);
        System.out.println(cola2);
        System.out.println(cola3);
    }
    
    //Genera una palabra ya sea por consola o random
	public static String generarPalabra(int op) {
		String palabra;
		Scanner sc = new Scanner(System.in);
		if (op == 1) {
			System.out.println("Ingrese palabra: ");
			palabra = sc.nextLine();
		} else {
			palabra = palabraRandom();
			System.out.println(palabra);
		}
		sc.close();
		return palabra;
    }
    // Genera una palabra random
	public static String palabraRandom() {
		Random random = new Random();
		String palabrasRandom[] = {"Juan Fernando Pérez del Corral","Valentina Laverde de la Rosa","Óscar Garcia","Sara Teresa Sánchez del Pinar","Efraín Zapatero","Julieta Ponce","Martín Elías de los Ríos Acosta"};
		return palabrasRandom[random.nextInt(palabrasRandom.length)];
    }
    // Cargar cola
    public static void cargarCola(QueueVelocidad<String> cola,int op) {
        Random random = new Random();
        if(op == 1){
            String palabra = generarPalabra(op);
            cola.offer(palabra);
            int continuar = Helper.seleccionarOpcion("1. Continuar ingresando datos ", "2. Dejar de ingresar datos");
            while(continuar == 1){
                palabra = generarPalabra(op);
                cola.offer(palabra);
                continuar = Helper.seleccionarOpcion("1. Continuar ingresando datos ", "2. Dejar de ingresar datos");
            }
        }
        else{
            for(int i = 0;i<random.nextInt(7);i++){
                cola.offer(generarPalabra(op));
            }
        }
    }
    // Union de cola
    public static void unionDeCola(QueueVelocidad<String> cola1,QueueVelocidad<String> cola2,QueueVelocidad<String> cola3) {
        if(cola1.isEmpty()&&cola2.isEmpty()){
            System.out.println("Ambas colas estan vacias...");
        }
        else{
            String[] lista = new String[100];
            int tamañoCola1 = cola1.diferencia();
            int tamañoCola2 = cola2.diferencia();
            int tamaño;
            int index = 0;
            String x;
            if (tamañoCola1>=tamañoCola2){
                tamaño = tamañoCola1;
                lista[index]=cola1.dequeue();
            }
            else{
                tamaño = tamañoCola2;
                lista[index]=cola2.dequeue();
            }
            for(int i = 0;i<=tamaño;i++){
                Arrays.sort(lista);
                if(i<=tamañoCola1){
                    x = cola1.dequeue();
                    if(Arrays.binarySearch(lista,x)<0){
                        index+=1;
                        lista[index] = x;
                        cola3.offer(x);
                    }
                }
                Arrays.sort(lista);
                if(i<=tamañoCola2){
                    x = cola2.dequeue();
                    if(Arrays.binarySearch(lista,x)<0){
                        index+=1;
                        lista[index] = x;
                        cola3.offer(x);
                    }
                }
            }
        }
    }
}
