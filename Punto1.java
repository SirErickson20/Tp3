import java.util.Random;
import java.util.Scanner;

public class Punto1 {
	
	static Scanner sc = new Scanner(System.in);

	// Programa Principal
	public static void main(String[] args) {
		System.out.println("COLA DE CARACTERES");
		int tamanio = Helper.corrector("Tamaño de la cola: ");
		Cola cola = new Cola(tamanio);
		
		opciones(cola);

		System.out.println("Fin del Programa");
	}
	
	// Metodo para encolar Manualmente hasta que la cola este llena (se desperdicia un espacio)
	public static Cola encolarManualmente(Cola cola) {
		int i = 1;
		Character character;
		while(!cola.estaLlena()) {
			System.out.println("Character " + i + ": ");
			character = sc.nextLine().charAt(0);
			cola.encolar(character);
			i++;
		}
		return cola;
	}
	
	// Metodo para encolar Aleatoriamente hasta que la cola este llena (se desperdicia un espacio)
	public static Cola encolarAleatoriamente(Cola cola) {
		Random random = new Random();
		Character [] caracteres = {'a','b','c','d','e','f','g','h','i','j','k','l','m','n','ñ','o','p','q','r','s','t','u','v','w','x','y','z','1','2','3','4','5','6','7','8','9'};
		Character character;
		while(!cola.estaLlena()) {
			character = caracteres[random.nextInt(caracteres.length)];
			System.out.println("Se encolo el character: " + character);
			cola.encolar(character);
		}
		return cola;
	}

	// Opciones para que se ejecuten las distintas acciones
	public static void opciones(Cola cola) {
		Character continuar;
		int op = 0, eleccion;
		do {
			op = menu(op);
			switch(op) {
			case 1: 
				eleccion = Helper.seleccionarOpcion("1. Ingresar manualmente", "2. Generar aleatoriamente");
				if (eleccion == 1) {
					cola = encolarManualmente(cola);
				} else {
					cola = encolarAleatoriamente(cola);
				}
				break;
			case 2:
				System.out.println("Elemento desencolado: " + cola.desencolar());
				break;
			case 3:
				System.out.println("Proximo elemento a salir: " + cola.peek());
				break;
			case 4:
				System.out.println("Cantidad de elementos: " + cola.cantidad());
				break;
			case 5:
				break;
			}
			if (op == 5) {
				break;
			}
			continuar = Helper.correctorCaracter("Desea continuar?");
		} while(continuar == 'S');
	}
	
	// Menu
	public static int menu(int op) {
		System.out.println("-----MENU-----");
		System.out.println("1) Encolar \n2) Desencolar\n3) Proximo a salir\n4) Cantidad de elementos\n5) Salir");
		do {
			op = Helper.corrector("Opcion: ");
		} while (op > 5 || op < 1);
		return op;
	}

}
