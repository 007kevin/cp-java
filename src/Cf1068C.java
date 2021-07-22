import java.io.*;
import java.util.*;

/**
 * Problem Cf1068C
 */
public class Cf1068C {

    public void run() {
        int n = in.nextInt();
        int m = in.nextInt();
        Map<Integer, Set<Pair>> map = new HashMap<>();
        for(int i = 1; i <= n; ++i){
            map.computeIfAbsent(i, key -> new HashSet<>()).add(new Pair(i,i));
        }
        for(int i = 1; i <= m; ++i){
            int a = in.nextInt();
            int b = in.nextInt();
            map.get(a).add(new Pair(n+i,a));
            map.get(b).add(new Pair(n+i,b));
            
        }
        for(int i = 1; i <= n; ++i){
            out.println(map.get(i).size());
            for(Pair p : map.get(i)){
                out.println(p.x + " " + p.y);
            }
        }
    }

    static class Pair {
        int x,y;

        Pair(int x, int y){this.x=x;this.y=y;}

        @Override
        public int hashCode() {
            return Objects.hash(x,y);
        }
        @Override
        public boolean equals(Object obj) {
            Pair that = (Pair) obj;
            return this.x==that.x&&this.y==that.y;
        }
        

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
        Cf1068C task = new Cf1068C(); task.run(); task.close();}
}
