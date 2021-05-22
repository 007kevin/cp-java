import java.io.*;
import java.util.*;

/**
 * Problem Uva10509Feynman
 */
public class Uva10509Feynman {

    static class Task extends IOHandler {
        public void run() {
            while(in.hasNext()){
                double n = in.nextDouble();
                if(n==0) break;
                double a = Math.floor(Math.pow(n,1/3.0) + 0.000001);
                double dx = (n-(a*a*a))/3.0/a/a;
                out.println(String.format("%.4f", a + dx));
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
