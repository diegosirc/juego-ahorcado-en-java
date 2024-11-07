import java.util.Scanner;

public class App {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String palabraSecreta = "inteligencia";  // Palabra que el jugador debe adivinar
        int intentosMaximos = 10;  // Número máximo de intentos
        int intentos = 0;  // Contador de intentos realizados
        boolean palabraAdivinada = false;

        char[] letrasAdivinadas = new char[palabraSecreta.length()];

        // Inicializar letras adivinadas con guiones bajos
        for (int i = 0; i < letrasAdivinadas.length; i++) {
            letrasAdivinadas[i] = '_';
        }

        System.out.println("¡Bienvenido al juego de Ahorcado!");
        System.out.println("Tienes " + intentosMaximos + " intentos para adivinar la palabra secreta.");

        while (intentos < intentosMaximos && !palabraAdivinada) {
            System.out.println("\nPalabra: ");
            for (char letra : letrasAdivinadas) {
                System.out.print(letra + " ");
            }

            System.out.println("\n\nIntroduce una letra:");
            char letraIngresada = scanner.nextLine().charAt(0);

            boolean letraEncontrada = false;

            for (int i = 0; i < palabraSecreta.length(); i++) {
                if (palabraSecreta.charAt(i) == letraIngresada) {
                    letrasAdivinadas[i] = letraIngresada;
                    letraEncontrada = true;
                }
            }

            if (!letraEncontrada) {
                intentos++;
                System.out.println("Letra incorrecta. Intentos restantes: " + (intentosMaximos - intentos));
            } else {
                System.out.println("¡Letra correcta!");
            }

            // Comprobar si la palabra ha sido completamente adivinada
            palabraAdivinada = true;
            for (char letra : letrasAdivinadas) {
                if (letra == '_') {
                    palabraAdivinada = false;
                    break;
                }
            }
        }

        if (palabraAdivinada) {
            System.out.println("\n¡Felicidades! Adivinaste la palabra: " + palabraSecreta);
        } else {
            System.out.println("\n¡Lo siento! Se te acabaron los intentos. La palabra era: " + palabraSecreta);
        }

        scanner.close();
    }
}
