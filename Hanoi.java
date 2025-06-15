import java.util.Date;
import java.text.SimpleDateFormat;

public class Hanoi {
    private static long movimentos = 0;
    private static SimpleDateFormat timeFormat = new SimpleDateFormat("HH:mm:ss:SSS");

    public static void main(String[] args) {
        int[] discos = {1, 10, 20, 30, 40, 41};
        
        for (int n : discos) {
            System.out.println("Resolvendo para " + n + " discos:");
            movimentos = 0;
            long startTime = System.currentTimeMillis();
            
            resolverHanoi(n, 'A', 'C', 'B');
            
            long endTime = System.currentTimeMillis();
            long duration = endTime - startTime;
            
            System.out.println("\nTotal de movimentos: " + movimentos);
            System.out.println("Tempo gasto: " + formatDuration(duration));
            System.out.println("----------------------------------\n");
        }
    }

    private static void resolverHanoi(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            movimentos++;
            return;
        }
        
        resolverHanoi(n-1, origem, auxiliar, destino);
        movimentos++;
        resolverHanoi(n-1, auxiliar, destino, origem);
    }

    private static String formatDuration(long millis) {
        Date date = new Date(millis);
        return timeFormat.format(date);
    }
}
