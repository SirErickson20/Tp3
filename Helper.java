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
		public static int corrector(String mensajeEntrada) {
			int valorControlar = 0;
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
		
		
}
		

