import java.io.*;
import java.util.*;

/**
 * Problem CF369B
 */
public class CF369B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int k = in.nextInt();
            int l = in.nextInt();
            int r = in.nextInt();
            int sall = in.nextInt();
            int sk = in.nextInt();
            if(n==k){
                int sum = l*n;
                int[] scores = new int[n];
                Arrays.fill(scores, l);
                while(sum<sall){
                    for(int i = 0; i < n; ++i){
                        if(scores[i]<r){
                            scores[i]++;
                            sum++;
                            break;
                        }
                    }
                }
                for(int i = 0; i < n; ++i)
                    out.println(scores[i] + " ");
                out.println();
            } else {
                
                int sum = 0;
                int[] scores = new int[n];
                int rem = sk%k;
                for(int i = 0; i < k; ++i){
                    scores[i]=sk/k+(rem>0?1:0);
                    sum+=scores[i];
                    rem--;
                }
                sum+=(n-k)*l;
                Arrays.fill(scores, k, n, l);
                while(sum<sall){
                    for(int i = k; i < n; ++i){
                        if(scores[i]<scores[k-1]){
                            scores[i]++;
                            sum++;
                            break;
                        }
                    }
                }
                for(int i = 0; i < n; ++i)
                    out.print(scores[i] + " ");
                out.println();
            }
            
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
     ***********************************************************/
    public static void main(String[] args) {
        Task task = new Task();
        task.run();
        task.cleanup();
    }
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }
        private boolean prime() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {throw new RuntimeException(e);}
            }
            return true;
        }
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokenizer.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
}
