import java.io.*;
import java.util.*;

/**
 * Problem Uva10812BeatTheSpread
 */
public class Uva10812BeatTheSpread {

    static class Task extends IOHandler {
        static String impossible = "impossible";
        public void run() {
            int n = in.nextInt();
            while(n-->0){
                int s = in.nextInt();
                int d = in.nextInt();
                int a = (s+d)/2;
                int b = (s-d)/2;
                if(a<0||b<0) out.println(impossible);
                else if (a+b!=s||a-b!=d) out.println(impossible);
                else out.println(a + " " + b);
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
