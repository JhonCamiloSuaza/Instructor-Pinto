public class Exercise24 {
    public static void main(String[] args) {
      
        int S = 1;

        System.out.println("Términos de la serie menores a 1000:");

        while (S < 1000) {
            System.out.println(S);
            S = (S * S) + 1;
        }
    }
}

/*Por que me da ese resultado en la consola ejemplo para guiarme:
 1
(1² + 1) = 2
(2² + 1) = 5
(5² + 1) = 26
(26² + 1) = 677*/