import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
// import java.nio.Buffer;
import java.util.HashSet;
import java.util.Iterator;

// import javax.swing.plaf.synth.SynthStyle;

//import jdk.internal.org.jline.utils.InputStreamReader;

/**
 * Main
 */
public class Main {

    // public static int sieve(int n) {

    // }

    public static void main(String[] args) throws IOException {
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int test = Integer.parseInt(read.readLine());
        while (test-- > 0) {
            int n = Integer.parseInt(read.readLine());
            
            boolean prime[] = new boolean[n + 1];
            for (int i = 2; i <= n; i++) {
                prime[i] = true;
            }
            for (int i = 2; i*i <= n; i++) {
                if (prime[i]) {
                    for (int j = i * i; j <= n; j+=i) {
                        prime[j] = false;
                    }
                }
            }
            
            boolean flag = false ;
            HashSet<Integer> hs = new HashSet<>() ;
            for (int i = 2; i <=n ; i++) {
                if(prime[i]) {
                    hs.add(i) ;
                }
            }
            for (int i=2; i<=n; i++) {
                int temp = n-i ;
                if (hs.contains(temp)) {
                    System.out.println(i + " " + (n-i)); 
                    flag = true ;
                    break ;
                }    
            }

            if(!flag) {
                System.out.println(-1); 
            }

            // Iterator value = hs.iterator() ;
            // while (value.hasNext()) {
            //     System.out.println(value.next());
            // }

        }
    }
}