import java.io.*;
import java.util.*;

/**
 * Problem Cf313C
 */
public class Cf313C {

    public void run() {
        int n = in.nextInt();
        List<Long> list = new ArrayList<>();
        for(int i = 0; i < n; ++i) {
            list.add(in.nextLong());
        }
        long sum = list.stream().reduce(0l, (a,b) -> a+b);
        Collections.sort(list, Comparator.reverseOrder());
        sum+=rem(list,n/4);
        out.println(sum);
    }

    public long rem(List<Long> list, int n){
        if(n==0) return 0;
        long sum = 0;
        for(int i = 0; i < n; ++i) sum+=list.get(i);
        return sum + rem(list,n/4);
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
        Cf313C task = new Cf313C(); task.run(); task.close();}
}
