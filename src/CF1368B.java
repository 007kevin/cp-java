import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problem CF1368B
 */
public class CF1368B {

    static class Task extends IOHandler {
        public void run() {
            long k = in.nextLong(), p =1;
            int[] n = {1,1,1,1,1,1,1,1,1,1};
            for(int i = 0; i < 10; ++i) n[i]=1;
            int i = 0;
            while(p<k){
                n[i]++;
                p=1;
                for(int j = 0; j < 10; ++j)
                    p*=n[j];
                i=(i+1)%10;
            }
            StringBuilder sb = new StringBuilder();
            String codeforces = "codeforces";
            for(i = 0; i < 10; ++i)
                sb.append(String.valueOf(codeforces.charAt(i)).repeat(n[i]));
            out.println(sb.toString());
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
