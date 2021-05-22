import java.io.*;
import java.util.*;

/**
 * Problem Uva11053
 */
public class Uva11053 {

    static class Task extends IOHandler {
        public void run() {
            while(in.hasNext()){
                long N = in.nextLong();
                if(N==0L) break;
                long a = in.nextLong();
                long b = in.nextLong();
                long x = 0L;
                long dead =0L;
                Map<Long, Long> map = new HashMap<>();
                while(true){
                    long count = map.getOrDefault(x, 0L);
                    if(count == 2L) break;
                    if(count == 1L) dead++;
                    map.put(x,count+1);
                    x = (((a*x)%N * x)%N + b)%N;
                }
                out.println(N-dead);
            }
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
