import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problem CF545C
 */
public class CF545C {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            long x[] = new long[n];
            long h[] = new long[n];
            for(int i = 0; i < n ; ++i){
                x[i]=in.nextInt();
                h[i]=in.nextInt();
            }
            long prev = 0;
            int c = 0;
            for(int i = 0; i < n; ++i){
                if(i==0){
                    prev=x[i];
                    c++;
                } else if(i==n-1){
                    c++;
                } else {
                    if (x[i]-prev > h[i]) {
                        c++;
                        prev=x[i];
                    } else if (x[i+1]-x[i] > h[i]) {
                        c++;
                        prev=x[i]+h[i];
                    } else {
                        prev=x[i];
                    }

                }
            }
            out.print(c);

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
