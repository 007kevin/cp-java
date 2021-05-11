import java.io.*;
import java.util.*;

/**
 * Problem CF651c
 */
public class CF651c {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            Map<Integer, Integer> X = new HashMap<>();
            Map<Integer, Integer> Y = new HashMap<>();
            Map<Integer, Map<Integer, Integer>> XY = new HashMap<>();
            long ans = 0;
            for(int i = 0; i < n; ++i){
                int x = in.nextInt();
                int y = in.nextInt();
                ans+=X.getOrDefault(x, 0)
                        + Y.getOrDefault(y, 0)
                        - XY.getOrDefault(x, new HashMap<>()).getOrDefault(y, 0);
                X.compute(x, (k,v) -> v == null ? 1 : v + 1);
                Y.compute(y, (k,v) -> v == null ? 1 : v + 1);
                XY.computeIfAbsent(x, (k) -> new HashMap<>()).compute(y, (k,v) -> v == null ? 1 : v + 1);
            }
            out.println(ans);
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public static void main(String[] args) {
        Task task = new Task(); task.run(); task.close();}
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void close() {out.close();}}
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokens = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);}
        private boolean prime() {
            while (tokens == null || !tokens.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokens = new StringTokenizer(line);
                } catch (IOException e) {throw new RuntimeException(e);}
            } return true;}
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokens.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
}
