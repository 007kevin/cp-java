import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.StringTokenizer;

/**
 * Problem CF1425A
 */
public class CF1425A {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t--!=0) {
                long n = in.nextLong(),a=0;
                boolean turn=true;
                while(n!=0){
                    if(n%2==1){
                        if(turn)a++;
                        n--;
                    } else {
                        if(n!=4&&(n/2)%2==0) {
                            if(turn)a++;
                            n--;
                        } else {
                            if(turn)a+=n/2;
                            n/=2;
                        }
                    }
                    turn=!turn;
                }
                out.println(a);
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
