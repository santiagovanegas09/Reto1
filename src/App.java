
import java.util.Random;
import java.util.Scanner;

public class App {

    static Scanner scanner = new Scanner(System.in);

    static String[] planets = { "MARTE", "JUPITER", "SATURNO", "URANO", "NEPTUNO" };
    static double[] distance = { 225, 778, 1.429, 2.870, 4.500 };
    static String[] details = {
            "Es un mundo frío y seco, con montañas, valles y el volcán más grande del sistema solar, Olympus Mons.",
            "es el quinto planeta del sistema solar y el más grande de todos",
            "Es famoso por sus espectaculares anillos hechos de hielo, polvo y rocas.",
            "Es un gigante helado compuesto principalmente de hidrógeno, helio y metano, lo que le da su característico color azul verdoso.",
            "Es un gigante helado de color azul intenso debido a la presencia de metano en su atmósfera." };

    static String[] spaceships = { "Stellar Voyager", "Eclipse Horizon", "Nova Sentinel", "Celestial Drift" };
    static double[] shipSpeeds = { 40000.0, 42000.0, 56000.0, 70000 };
    static double[] fuelConsuption = { 100, 120, 130, 140 };
    static int[] passengers = { 15, 25, 35, 50 };

    static int selectedShip;
    static int selectedPlanet;

    int result;

    public static void main(String[] args) throws Exception {
        int option;

        do {

            showMenu();
            option = scanner.nextInt();

            switch (option) {
                case 1:
                    choosePlanet();
                    break;
                case 2:
                    chooseShip();
                    break;

                case 3:

                    shipResources();
                    break;

                case 4:
                    startJourney();
                    break;

                default:
                    break;
            }

        } while (option != 5);
        System.out.println("SIMULACION FINALIZADA");

    }

    public static void showMenu() {

        System.out.println("////////////////////////");
        System.out.println("MENU PRINCIPAL DEL VIAJE INTER ESPACIAL");
        System.out.println("////////////////////////");
        System.out.println();

        System.out.println("OPCION 1: SELECCIONE POR FAVOR EL PLANETA DESEADO");
        System.out.println("OPCION 2: SELECCIONA UNA NAVE DESEADA");
        System.out.println("OPCION 3: RECURSOS DEL VIAJE");
        System.out.println("OPCION 4: EMPEZAR SIMULACION");
        System.out.println("OPCION 5: SALIR DEL SIMULADOR");
        System.out.println();

        System.out.println("POR FAVOR SELECCIONA UNA OPCION: ");

    }

    public static void choosePlanet() {

        System.out.println("//////////////");
        System.out.println("MENU DE PLANETAS DISPONIBLES");
        System.out.println("//////////////");

        for (int i = 0; i < planets.length; i++) {

            System.out.println(" PLANETA: " + (i + 1) + " - " + planets[i] + " - " + " DISTANCIA DE LA TIERRA: "
                    + distance[i] + "KM" + " DESCRIPCION:  " + details[i]);
        }

        System.out.println("SELECCIONA EL PLANETA DESEADO: ");
        int selectpla = scanner.nextInt();

        if (selectpla > 0 && selectpla <= planets.length) {
            System.out.println("HAS SELECCIONADO EL PLANETA: " + planets[selectpla - 1]);
            selectedPlanet = selectpla - 1;

        } else {
            System.out.println("HAS SELECCIONADO UNA OPCION INVALIDA, POR FAVOR VERIFICA DE NUEVO");
        }

    }

    public static void chooseShip() {

        System.out.println("/////////////////////////");
        System.out.println("MENU DE NAVES DISPONIBLES");
        System.out.println("/////////////////////////");

        for (int i = 0; i < spaceships.length; i++) {

            System.out.println("NAVE: " + (i + 1) + ". " + spaceships[i] + "- VELOCIDAD: " + shipSpeeds[i] + "km"
                    + "-CAPACIDAD DE PASAJEROS: " + passengers[i]);

        }

        System.out.println("SELECCIONA UNA NAVE: ");
        int select = scanner.nextInt();

        if (select > 0 && select <= spaceships.length) {
            System.out.println("HAS SELECCIONADO LA NAVE " + spaceships[select - 1]);
            selectedShip = select - 1;

        } else {
            System.out.println("HAS SELECCIONADO UNA OPCION INVALIDA, VERIFICA POR FAVOR");
        }

    }

    public static void startJourney() {

        System.out.println("///////////////");
        System.out.println("INICIANDO VIAJE");
        System.out.println("///////////////");

        Random random = new Random();

        for (int progress = 0; progress <= 100; progress += 10) {

            System.out.println("PROGRESO DEL VIAJE " + progress + "%");

            if (progress == 50) {
                System.out.println("MITAD DEL CAMINO ALCANZADO");
            }

            if (progress == 80 ) {

                System.out.println("SU NAVE ESTA PROXIMA EN LLEGAR A "+ planets[selectedPlanet]+ " POR FAVOR PREPARESE PARA EL ATERRIZAJE");
                
            }

            if (random.nextInt(10) < 1) {
                System.out.println("/////////////////");
                System.out.println("----ATENCION----");
                System.out.println("/////////////////");

                int event = random.nextInt(3);
                switch (event) {
                    case 0:
                        System.out.println("¡COLISIÓN DE ASTEROIDES INMINENTE!");
                        System.out.println("ACTIVANDO ESCUDOS Y REALIZANDO MANIOBRAS EVASIVAS...");
                        break;
                    case 1:
                        System.out.println("FALLO EN EL MOTOR DETECTADO.");
                        System.out.println("REALIZANDO REPARACIONES DE EMERGENCIA...");
                        break;
                    case 2:
                        System.out.println("SEÑAL DE SOS RECIBIDA DESDE UNA NAVE CERCANA.");
                        System.out.println("DESVIÁNDONOS PARA OFRECER ASISTENCIA...");
                        break;
                    default:
                        System.out.println("EVENTO DESCONOCIDO...");
                        break;

                }

                System.out.println("REALIZANDO AJUSTES NECESARIOS.....");
                System.out.println("................................");

            }

            try {
                Thread.sleep(3000);
            } catch (InterruptedException e) {
                System.out.println("ERROR AL SIMULAR" + e);
            }

            
        }

        System.out.println("LLEGADA EXITOSA A " + planets[selectedPlanet]);

        

    }

    public static void shipResources() {

        double fuel = fuelConsuption[selectedShip];
        double oxygen = distance[selectedPlanet] * 100;
        System.out.println("EL COMBUSTIBLE NECESARIO ES: " + fuel);
        System.out.println("LA CANTIDAD DE UNIDADES DE OXIGENO NECESARIO PARA EL VIAJE ES: " + oxygen);
    }
}
