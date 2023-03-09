package proyecto1_progra;

import java.util.Scanner;
import static proyecto1_progra.Tramites.Consultarestudiantes;
import static proyecto1_progra.Tramites.Incluirestudiantes;
import static proyecto1_progra.Tramites.Inicializar;
import static proyecto1_progra.Tramites.Modificarestudiante;
import static proyecto1_progra.Tramites.Salir;
import static proyecto1_progra.Tramites.eliminarestudiante;
import static proyecto1_progra.Tramites.submenu;

public class Menuprincipal {

    byte opcion;
    public Scanner leer = new Scanner(System.in);

    public Menuprincipal() {
        opcion = 0;
    }

    public void mostar() {

        do {
            System.out.println(" Opcion 1- Inicializar Vectores");
            System.out.println(" Opcion 2- Incluir Estudiantes");
            System.out.println(" Opcion 3- Consultar Estudiantes ");
            System.out.println(" Opcion 4- Modificar Estudiantes");
            System.out.println(" Opcion 5- Eliminar Estudiantes");
            System.out.println(" Opcion 6- Submenu Reportes");
            System.out.println(" Opcion 7- Salir");
            System.out.println("Digite una opcion para continuar");
            opcion = leer.nextByte();
            switch (opcion) {
                case 1:
                    Inicializar();
                    break;
                case 2:
                    Incluirestudiantes();
                    break;
                case 3:
                    Consultarestudiantes();
                    break;
                case 4:
                    Modificarestudiante();
                    break;
                case 5:eliminarestudiante();
                    break;
                case 6:submenu();
                    break;
                case 7: Salir();
                    break;

                default:
                   System.out.println("Digite una opcion valida");
            
            
            }
        } while (opcion != 7);
    }

    
    
}
