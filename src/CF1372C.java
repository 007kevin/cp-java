import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

/**
 * Problem CF1372C
 */
public class CF1372C {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while (t--!=0) {
                int n = in.nextInt();
                int a[] = new int[n];
                for(int i = 0; i < n; ++i)
                    a[i]=in.nextInt();
                if(isSorted(a))
                    out.println(0);
                else if(isNoPositionsSorted(a))
                    out.println(1);
                else
                    out.println(2);
            }
        }

        private boolean isSorted(int[] a) {
            int n = a.length;
            for(int i = 0; i < n; ++i)
                if(a[i] != i+1)
                    return false;
            return true;
        }

        private boolean isNoPositionsSorted(int[] a) {
            int n = a.length;
            int i = 0, j = n-1;
            while(a[i]==i+1) i++;
            while(a[j]==j+1) j--;
            // out.println("[" + i + "," + j + "]");
            for(;i<=j;++i){
                if(a[i]==i+1){
                    return false;
                }
            }
            return true;
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
