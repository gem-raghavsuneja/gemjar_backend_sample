import java.time.Instant;

public class papu {
    public static void main(String[] args) {
        // Get current timestamp using Instant
       String s= String.valueOf(Instant.now().toEpochMilli());
        System.out.println(s);

    }
}