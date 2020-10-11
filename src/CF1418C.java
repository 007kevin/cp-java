import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problem CF1418C
 */
public class CF1418C {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            for(int i = 0; i < t; ++i){
                int n = in.nextInt();
                int a[] = new int[n];
                for(int j = 0; j < n; ++j)
                    a[j]=in.nextInt();
                out.println(solve(a));
            }
        }

        private int solve(int[] a) {
            int myturn[] = new int[a.length];
            int histurn[] = new int[a.length];
            for(int i = 0; i < a.length; ++i){
                if(i==0){
                    histurn[i]=a[0];
                    myturn[i]=Integer.MAX_VALUE/2;
                }
                else if (i==1){
                    myturn[i]=histurn[i-1];
                    histurn[i]=a[i] + histurn[i-1];
                } else {
                    histurn[i]=a[i] + Math.min(a[i-1] + myturn[i-2], myturn[i-1]);
                    myturn[i]=Math.min(histurn[i-1], histurn[i-2]);
                }
            }

            // out.print("h[]=");
            // for(int i = 0; i < a.length; ++i)
            //     out.print(histurn[i] + " ");
            // out.println();
            // out.print("m[]=");
            // for(int i = 0; i < a.length; ++i){
            //     if(i==0) out.print("_ ");
            //     else
            //         out.print(myturn[i] + " ");
            // }
            // out.println();

            return Math.min(histurn[a.length-1],myturn[a.length-1]);
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
