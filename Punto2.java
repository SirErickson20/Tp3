package EdD.Tp4;
import java.util.*;
public class Punto2 {
    static boolean parentesis = false;
    static Scanner sc = new Scanner(System.in);
    static Pila<Character> pilaLista = new Pila<>();
    public static void main(String[] args) {
        String expresion = menu();
        System.out.println(expresion);
        pilaLista = ingresarMensaje(expresion);
        if(pilaLista.isEmpty()){
            if(parentesis){
                System.out.println("La expresion esta bien parantelizada");
            }
            else{
                System.out.println("La expresion no tiene parentesis");
            }
        }
        else{
            System.out.println("La expresion esta mal parantelizada");
        }
    }
    //Menu y salida de expresion
    public static String menu() {
        String expresion;
        int op=Helper.seleccionarOpcion("1) Ingresar manualmente: ", "2) Ingresar Aleatoriamente");
        if(op==1){
        	System.out.println("Ingrese expresion a verificar: ");
            expresion = sc.nextLine();
            while(expresion.isBlank()){
                System.out.println("Ingrese expresion a verificar: ");
                expresion = sc.nextLine();
            }
        }
        else{
            expresion = Helper.expresionRandom();
        }
        return expresion;
    }
    //Cargar pila
    public static Pila<Character> ingresarMensaje(String mensaje){
        char ver;
        Pila<Character> mensajecola = new Pila<>();
        for (char c: mensaje.toCharArray ()){
            if (c=='{'||c=='('||c=='['||c==']'||c==')'||c=='}'){
                parentesis = true;
                if (c=='{'||c=='('||c=='['){
                    mensajecola.Push(c);
                }
                else{
                    if(mensajecola.isEmpty()){
                        mensajecola.Push(c);
                        break;
                    }
                    else{
                        ver = mensajecola.Peek();
                        if(ver=='{'){
                            if(c=='}'){
                                mensajecola.Pop();
                            }
                            else{
                                break;
                            }
                        }
                        else if(ver=='('){
                            if(c==')'){
                                mensajecola.Pop();
                            }
                            else{
                                break;
                            }
                        }
                        else{
                            if(c==']'){
                                mensajecola.Pop();
                            }
                            else{
                                break;
                            }
                        }
                    }
                }
            }
        }
        return mensajecola;
    }
}
