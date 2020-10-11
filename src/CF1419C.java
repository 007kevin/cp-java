import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problem CF1419C
 */
public class CF1419C {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            for(int i = 0; i < t; ++i){
                int n = in.nextInt();
                int x = in.nextInt();
                int a[] = new int[n];
                for(int j = 0; j < n; ++j)
                    a[j] = in.nextInt();
                if (allEqual(x, a)) out.println(0);
                else if (oneStep(x, a)) out.println(1);
                else if (otherOneStep(x,a)) out.println(1);
                else out.println(2);
            }

        }

        private boolean otherOneStep(int x, int[] a) {
            long e = 0;
            for(int i = 0; i < a.length; ++i)
                e+=x-a[i];
            return e==0;
        }

        private boolean allEqual(int x, int a[]){
            for(int i = 0; i < a.length; ++i)
                if(a[i]!=x) return false;
            return true;
        }

        private boolean oneStep(int x, int a[]){
            for(int i = 0; i < a.length; ++i)
                if(x==a[i]) return true;
            return false;
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
