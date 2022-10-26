package EdD.Tp4;
import java.util.Random;
import java.util.Scanner;

public class Helper {
	static Scanner sc = new Scanner(System.in);
		// SELECCIONES DE OPCIONES
		public static int seleccionarOpcion(String mensaje1,String mensaje2) {
			int opcion = 0;
			while (opcion != 1 && opcion != 2) {
				System.out.println("Ingrese una de las siguientes opciones: \n" + mensaje1+"\n"+mensaje2);
				opcion = corrector("Elija una opcion: ");
				if (opcion != 1 && opcion != 2) { 
					System.out.println("Ingrese una opción válida");
				}
			}
			return opcion;
		}

		// VALIDADORES
		public static Integer corrector(String mensajeEntrada) {
			Integer valorControlar = 0;
			while (true) {
				try {
					do {
						System.out.print(mensajeEntrada);
						valorControlar = Integer.parseInt(sc.nextLine());
						if(valorControlar<0)System.out.println("Debe ingresar un numero positivo");
					}while(valorControlar<0);
					return valorControlar;
					
				} catch (Exception exception) {
					System.out.println("¡Solo debe ingresar numeros!");
				}
			}
			
		}
		// Genera una palabra random
		public static String palabraRandom() {
			Random random = new Random();
			String palabrasRandom[] = {"Erick","Tu no mete cabra","Neuquen","Ana","Pana","Estructura","Gaspi","Ringcraft","FNE", "A cavar a Caravaca", "Amad a la dama", "Atar a la rata", "Arte para Petra",
					"Ella te da detalle", "Saca tus butacas", "Se van sus naves", "Yo hago yoga hoy", "Se es o no se es" };
			return palabrasRandom[random.nextInt(palabrasRandom.length)];
			
		}
		public static String expresionRandom() {
			Random random = new Random();
			String palabrasRandom[] = {"[6+{1+5}-(8-3)]","[8-9]+(8+{9-1})","[1-2*(5-4)+{9+0}]","(2+2)+[9/9]-{0+5}","[{(2*2)-(2/2)}]","4+(9-6)*[7-3]","([2+9]*4)/{3-7}","[{(2*2)/2}*2]","(7-7)*[7*7]/{7+7}", "[(2-1)-(1-2)*{2+9}]", "[6*{1/5}*(8/3)]", "[1*2+(5*4)/{9+0}]", "(2*2)/[9/9]-{0*5}",
					"(7*7)-[7/7]+{7*7}", "[{(2+2)*(2-2)}]", "[(2*2)-2]/{8+8}", "[(2+2)/2]-{8*8}", "(1-1)*{2+2}/[3*3]-(4/4)"};
			return palabrasRandom[random.nextInt(palabrasRandom.length)];
			
		}
		public static int corrector(String mensajeEntrada,String mensajeError) {
			int valorControlar = 0;
			while (true) {
				try {
					do {
						System.out.print(mensajeEntrada);
						valorControlar = Integer.parseInt(sc.nextLine());
						if(valorControlar<0)System.out.println(mensajeError);
					}while(valorControlar<0);
					return valorControlar;
					
				} catch (Exception exception) {
					System.out.println(mensajeError);
				}
			}
		}
		public static float correctorFloat(String mensajeEntrada) {
			float valorControlar = 0;
			while (true) {
				try {
					do {
						System.out.print(mensajeEntrada);
						valorControlar = Float.parseFloat(sc.nextLine());
						if(valorControlar<0)System.out.println("Debe ingresar un numero positivo");
					}while(valorControlar<0);
					return valorControlar;
					
				} catch (Exception exception) {
					System.out.println("¡Solo debe ingresar numeros!");
				}
			}
		}
		public static Character correctorCaracter(String mensaje) {
			Character valorControlar;
			do {
				System.out.println(mensaje+" S/N");
				valorControlar =sc.nextLine().charAt(0);
				valorControlar=Character.toUpperCase(valorControlar);	
				if(Character.isDigit(valorControlar)) {
					System.out.println("No se permite numeros");
				}
				if(!(valorControlar=='S')&&!(valorControlar=='N')){
					System.out.println("Solo debe ingresar S o N");
				}		
			}while(!(valorControlar=='S')&&!(valorControlar=='N'));
				
			return valorControlar;
			
		}
		
		public static Character correctorCaracteres(String mensaje) {
			Character valorControlar;
			while(true) {
				System.out.println(mensaje);
				valorControlar =sc.nextLine().charAt(0);
				valorControlar=Character.toUpperCase(valorControlar);	
				if(Character.isDigit(valorControlar)) {
					System.out.println("No se permite numeros");
				}
				else {
					break;
				}
			}				
			return valorControlar;
			
		}
		public static Integer correctorInt(){
			Integer valorControlar = 0;
			while (true) {
				try {
					valorControlar = Integer.parseInt(sc.nextLine());
					return valorControlar;
				}catch (Exception exception) {
					System.out.println("¡Solo debe ingresar numeros!");
				}
			}
			
		}
		
		
}
		

