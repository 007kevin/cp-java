import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problem CF1332C
 */
public class CF1332C {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            for(int i = 0; i < t; ++i)
                out.println(solve(in.nextInt(),in.nextInt(),in.next()));

        }

        private int solve(final int n, final int k, final String s) {
            int arr[][] = new int[k][256], r=0;
            for(int i = 0; i < n; ++i)
                arr[i%k][s.codePointAt(i)]++;
            for(int i = 0; i <= k/2; ++i){
                if(i>k-i-1) break;
                int c = Integer.MAX_VALUE;
                for(int j = 'a'; j <= 'z'; ++j){
                    if(i==k-i-1)
                        c=Math.min(c, n/k - arr[i][j]);
                    else
                        c=Math.min(c, 2*n/k -arr[i][j] - arr[k-i-1][j]);
                }
                r+=c;
            }
            return r;
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

    static class IOHandler {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);

        public void cleanup() {
            out.close();
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
