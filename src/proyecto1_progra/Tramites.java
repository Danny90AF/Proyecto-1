package proyecto1_progra;

import java.util.Scanner;

public class Tramites {

    static int opcion;
    static String[] nombre = new String[10];
    static String[] cedula = new String[10];
    static int[] promedio = new int[10];
    static String[] condicion = new String[10];
    static int indice = 0;
    static int ingresados = 0;
    private static Scanner leer = new Scanner(System.in);

    public Tramites() {
    }

    public static void Inicializar() {
        for (int i = 0; i < ingresados; i++) {
            nombre[i] = "";
            cedula[i] = "";
            promedio[i] = 0;
            condicion[i] = "";
        }
        System.out.println("*****Los Vectores han sido Inicializados*****");
    }

    public static void Incluirestudiantes() {
        char continuar = 's';

        do {
            if (indice > 9) {
                System.out.println("Alcanzo numero de registros ");
                continuar = 'n';
            } else {
                System.out.println("Digite el Nombre del Estudiante ");
                nombre[indice] = leer.next();
                System.out.println("Ingrese el numero de cedula del Estudiante ");
                cedula[indice] = leer.next();
                System.out.println("Ingrese la nota obtenida del Estudiante ");
                promedio[indice] = leer.nextInt();
                System.out.println("Desea ingresar otro Estudiante S / N ");
                indice++;

            }
            continuar = leer.next().charAt(0);
            ingresados++;
        } while (continuar != 'n');

    }

    public static void Consultarestudiantes() {
        System.out.println("Ingrese el numero de cedula");
        boolean existe = false;
        String nomb = leer.next();
        for (int i = 0; i < ingresados; i++) {

            if (promedio[i] >= 70) {
                condicion[i] = "Aprobado";
            } else if (promedio[i] < 70 && promedio[i] >= 60) {
                condicion[i] = "Aplazado";
            } else if (promedio[i] > 0 && promedio[i] < 60) {

            }
            if (nomb.equals(cedula[i])) {
                System.out.println(" Cedula: " + cedula[i] + " Nombre: " + nombre[i] + " Nota " + promedio[i] + " Condicion del estudiante es " + condicion[i]);
                existe = true;
                break;
            }

        }
        if (existe == false) {
            System.out.println("Cliente no existe en la base de datos");
        }
    }

    public static void Modificarestudiante() {
        System.out.println("Ingrese el numero de cedula del estudiante que desea modificar.");
        boolean existe = false;
        String nomb = leer.next();
        for (int i = 0; i < ingresados; i++) {
            if (nomb.equals(cedula[i])) {
                System.out.println(" Ingrese el numero de cedula nuevo. ");
                cedula[i] = leer.next();
                System.out.println(" Ingrese el nombre nuevo.");
                nombre[i] = leer.next();
                System.out.println(" Ingrese la nota nueva a modificar.");
                promedio[i] = leer.nextInt();

                System.out.println(" Dato modificado");
                existe = true;
                break;
            }
        }
        if (existe == false) {
            System.out.println("Cliente no existe en la base de datos");
        }
    }

    public static void eliminarestudiante() {
        boolean existe = false;
        System.out.println("Ingrese el numero de cedula del Estudiante");
        String nomb = leer.next();

        for (int i = 0; i < cedula.length; i++) {
            if (nomb.equals(cedula[i])) {
                System.out.println("Estudiante eliminado de la base de datos");
                cedula[i] ="";
                existe = true;
                break;
            }
        }
        if (existe == false) {
            System.out.println("Estudainte no existe en la base de datos");
        }
    }

    public static void Salir() {
        char sali = 's';
        do {
            System.out.println("Desea salir del programa s /n ");

            sali = leer.next().charAt(0);

            if ('s' == sali) {
                System.out.println("Muchas gracias ");
                System.exit(0);
            }
        } while (sali != 's');

    }

    public static void submenu() {

        do {
            System.out.println(" Opcion 1- Reporte Estudiantes por Condicion");
            System.out.println(" Opcion 2- Reporte de todos los datos");
            System.out.println(" Opcion 3- Regresar menu Principal ");
            opcion = leer.nextByte();
            switch (opcion) {
                case 1:
                    Reporteestudiantes();
                    break;
                case 2:
                    Reportedatos();
                    break;
                case 3:
                    Menuprincipal();
                    break;
                default:
                    throw new AssertionError();

            }
        } while (opcion != 3);

    }

    public static void Reporteestudiantes() {
        int aprobados = 0;
        int aplazados = 0;
        int reprobados = 0;

        for (int i = 0; i < ingresados; i++) {
            if (promedio[i] >= 70) {
                aprobados++;
            } else if (promedio[i] < 70 && promedio[i] >= 60) {
                aplazados++;
            } else if (promedio[i] > 0 && promedio[i] < 60) {
                reprobados++;
            }

        }
        System.out.println("Los cantidad de estudiantes Aprobados es de " + aprobados);
        System.out.println("Los cantidad de estudiantes Aplazados es de " + aplazados);
        System.out.println("Los cantidad de estudiantes Reprobados es de " + reprobados);
    }

    public static void Reportedatos() {

        for (int i = 0; i < ingresados; i++) {

            if (promedio[i] >= 70) {
                condicion[i] = "Aprobado";
                System.out.println((nombre[i] + " Cedula " + cedula[i] + " Nota obtenida " + promedio[i] + " EL estudiante esta " + condicion[i]));
            } else if (promedio[i] < 70 && promedio[i] >= 60) {
                condicion[i] = "Aplazado";
                System.out.println((nombre[i] + " Cedula " + cedula[i] + " Nota obtenida " + promedio[i] + " EL estudiante esta " + condicion[i]));
            } else if (promedio[i] >= 0 && promedio[i] < 60) {
                condicion[i] = "Reprobado";
                System.out.println((nombre[i] + " Cedula " + cedula[i] + " Nota obtenida " + promedio[i] + " EL estudiante esta " + condicion[i]));
            }

        }
    }

    public static void Menuprincipal() {

    }

}
