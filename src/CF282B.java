import java.io.*;
import java.util.*;

/**
 * Problem CF282B
 */
public class CF282B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int sa=0, sg=0;
            StringBuilder d = new StringBuilder();
            for(int i = 0; i < n; ++i){
                int a = in.nextInt(), g = in.nextInt();
                if(sa + a <= sg + 500){
                    sa+=a;
                    d.append('A');
                } else {
                    sg+=g;
                    d.append('G');
                }
            }
            if(500 >= sa-sg) out.println(d);
            else out.println(-1);
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
