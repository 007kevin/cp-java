import java.io.*;
import java.util.*;

/**
 * Problem Uva10976
 */
public class Uva10976 {

    public void run() {
        while(in.hasNext()){
            int k = in.nextInt();
            List<String> output = new LinkedList<>();
            for(int y = k+1; y < 1000000; ++y){
                int ky = k*y;
                int ymk = y-k;
                if((ky%ymk==0)){
                    int x = ky/ymk;
                    if(y>x) break;
                    output.add(fmt(k,x,y));
                }
            }
            out.println(output.size());
            for(String o : output)
                out.println(o);
        }
    }

    String fmt(int k, int x, int y){
        return String.format("1/%s = 1/%s + 1/%s", k,x,y);
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public InputReader in = new InputReader(System.in);
    public PrintWriter out = new PrintWriter(System.out);
    public void close() {out.close();}
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
    public static void main(String[] args) {
        Uva10976 task = new Uva10976(); task.run(); task.close();}
}
