
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Objects;
import java.util.Scanner;


public class metodos {

    public static void interfaz(String usuario) {

        while (!Objects.equals(usuario, "salir")) {

                Lanzador(usuario);

                 Scanner scanner = new Scanner(System.in);
                 usuario = scanner.nextLine();


        }

        System.out.println("Programa finalizado");

    }

    //Usamos el comando de la terminal factor llamandolo mediante un ProcessBuilder llamado pb,
    //una vez inicializado leemos la respuesta del proceso mediante el BufferedReader reader,
    //con el buchle el programa revisa todas las lineas de tezto que haya y las guarda en el outputBuffer
    // con el siguiente errorReader hace lo mismo que el reader pero solo ante posibles mensajes de error
    //con el codigoSalida waitFor lo que hace es parar ese proceso hasta que termine y dice si da error o no

    public static void Lanzador(String usuario) {
        int codigoSalida = 1;
        StringBuilder outputBuffer = new StringBuilder();
        boolean esPrimo = false;

        try {
            ProcessBuilder pb = new ProcessBuilder("factor", usuario);

            Process proceso = pb.start();


            try (BufferedReader reader = new BufferedReader(new InputStreamReader(proceso.getInputStream()))) {
                String linea;
                while ((linea = reader.readLine()) != null) {
                    outputBuffer.append(linea);

                    if (linea.contains(": " + usuario)){
                        esPrimo = true;
                    }
                        
                }
            }


            try (BufferedReader errorReader = new BufferedReader(new InputStreamReader(proceso.getErrorStream()))) {
                String linea;
                while ((linea = errorReader.readLine()) != null) {
                    outputBuffer.append(linea);
                }
            }

            codigoSalida = proceso.waitFor();

        } catch (Exception e) {
            outputBuffer.append("Error al intentar ejecutar el comando 'factor'.");
        }


        if (codigoSalida == 0) {
            System.out.println("[OK] " + outputBuffer);
            if (esPrimo){
                System.out.println("Es primo");
            }
            
        } else {
            System.out.println("[ERROR] " + outputBuffer);
        }

        System.out.println("Operación completada. Código de salida: " + codigoSalida);
    }
}




