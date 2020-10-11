import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Problem CF1338A
 */
public class CF1338A {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t--!=0){
                int n = in.nextInt();
                long a[] = new long[n];
                for(int i = 0; i < n; ++i) a[i]=in.nextLong();
                long d = Long.MIN_VALUE;
                PriorityQueue<Long> pq = new PriorityQueue<>(n, Comparator.reverseOrder());
                pq.add(a[0]);
                for(int i = 0; i < n; ++i){
                    d=Math.max(d, pq.peek() - a[i]);
                    pq.add(a[i]);
                }
                int time = 0;
                while(d>0) d-=Math.pow(2,time++);
                out.println(time);
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
