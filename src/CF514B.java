import java.io.*;
import java.util.*;

/**
 * Problem CF514B
 */
public class CF514B {

    static class Task extends IOHandler {
        public void run() {
            Map<Integer, Set<Integer>> map = new HashMap<>();
            int n = in.nextInt();
            int x0 = in.nextInt();
            int y0 = in.nextInt();
            for(int i = 0; i < n; ++i){
                int xi = in.nextInt() - x0;
                int yi = in.nextInt() - y0;
                int gcd = gcd(xi,yi);
                xi/=gcd;
                yi/=gcd;
                map.computeIfAbsent(
                        xi, (key) -> new HashSet<>())
                        .add(yi);
            }
            int ans = map.values()
                    .stream()
                    .map(set -> set.size())
                    .reduce(0, (a,v) -> a+v);
            out.println(ans);

        }

        public int gcd(int a, int b){
            if(a==0) return b;
            if(b==0) return a;
            if(b%a==0) return a;
            return gcd(b,a%b);
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
