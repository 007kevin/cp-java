import java.io.*;
import java.util.*;

/**
 * Problem Cf151C
 */
public class Cf151C {

    public void run() {
        long q = in.nextLong();
        List<Long> list = div(q);
        if(list.size() <= 1){
            out.println(1);
            out.println(0);
        } else if(list.size() == 2){
            out.println(2);
        } else {
            long m = list.get(0) * list.get(1);
            out.println(1);
            out.println(m);
        }
    }

    public List<Long> div(long q){
        List<Long> list = new ArrayList<>();
        for(long i = 2; i*i <= q; ++i){
            while(q%i==0){
                list.add(i);
                q/=i;
            }
        }
        if(q!=1) list.add(q);
        return list;
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
        Cf151C task = new Cf151C(); task.run(); task.close();}
}
