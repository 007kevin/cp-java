import java.io.*;
import java.util.*;

/**
 * Problem Cf479B
 */
public class Cf479B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int k = in.nextInt();
            List<Tower> a = new ArrayList<>();
            for(int i = 0; i < n; ++i)
                a.add(new Tower(in.nextInt(), i));
            List<Move> moves = new ArrayList<>();
            while(moves.size() < k){
                Tower max = Collections.max(a);
                Tower min = Collections.min(a);
                if(max.a-min.a<=1) break;
                max.a--; min.a++;
                moves.add(new Move(max.i,min.i));
            }
            out.println((Collections.max(a).a - Collections.min(a).a) + " " + moves.size());
            for(Move move : moves){
                out.println((move.i + 1) + " " + (move.j + 1));
            }
        }
    }

    static class Tower implements Comparable<Tower> {
        int a,i;
        Tower(int a, int i){this.a=a;this.i=i;}

        @Override
        public int compareTo(Tower that){
            return this.a - that.a;
        }
    }

    static class Move {
        int i,j; Move(int i, int j){this.i=i;this.j=j;}
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
