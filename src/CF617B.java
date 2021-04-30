import java.io.*;
import java.util.*;

/**
 * Problem CF617B
 */
public class CF617B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int[] a = new int[n];
            for(int i = 0; i < n; ++i)
                a[i]=in.nextInt();
            if(Arrays.stream(a).reduce(0, (acc,v) -> acc+v) == 0){
                out.println(0);
            } else {
                long ans = 1;
                for(int i = 0; i < n; ++i){
                    if(a[i]==1){
                        int j = i+1;
                        for(;j < n; ++j){
                            if(a[j]==1) break;
                        }
                        if(j!=n) ans*=j-i;
                    }
                }
                out.println(ans);
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
        public OutputWriter out = new OutputWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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
    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {super(out);}
        public void println(String format, Object... args) {
            this.println(String.format(format, args));}
        public void print(String format, Object... args) {
            this.print(String.format(format, args));}
    }
}
