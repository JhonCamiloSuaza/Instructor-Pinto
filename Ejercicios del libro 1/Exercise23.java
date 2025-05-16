public class Exercise23 {
 public static void main(String[] args) {


        int Q, R, K; 
        int N = 1;    

        
        K = 0;
        while (K < 10) {
            Q = N / 2;
            R = N - (Q * 2); 

            if (R != 0) {
                System.out.println(N);
                K++;
            }

            N++;
        }

    }
}
