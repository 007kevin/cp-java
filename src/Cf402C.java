import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem Cf402C
 */
public class Cf402C {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                int p = in.nextInt();
                Set<Edge> set = new HashSet<>();
                for(int i = 1; i <= n; ++i){
                    for(int j = i+1; j <= n; ++j){
                        int rank = Math.min(Math.abs(i-j), Math.abs(i+n-j));
                        set.add(new Edge(rank,i,j));
                    }
                }
                List<Edge> list = set.stream()
                        .collect(Collectors.toCollection(ArrayList<Edge>::new));
                Collections.sort(list, (a,b) -> a.rank - b.rank);
                for(int i = 0; i < 2*n +p; ++i){
                    out.println(list.get(i));
                }
            }
        }
    }

    static class Edge {
        int rank,a,b;
        public Edge(int rank, int a, int b){
            this.rank=rank;
            if(a>b){
                int n = a;
                a=b;
                b=n;
            }
            this.a=a;
            this.b=b;
        }
        @Override
        public int hashCode() {
            return Objects.hash(a,b);
        }
        @Override
        public boolean equals(Object obj){
            Edge that = (Edge) obj;
            return this.hashCode() == that.hashCode();
        }
        public String toString(){
            return a + " " + b;
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
