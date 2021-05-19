import java.io.*;
import java.util.*;

/**
 * Problem SPOJBitMap
 */
public class SPOJBitMap {

    static class Task extends IOHandler {
        private final static int[][] MOVES = {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                int m = in.nextInt();
                int[][] map = new int[n][m];
                for(int i = 0; i < n; ++i){
                    map[i]=in.next().chars().map(c -> c-'0').toArray();
                }
                int[][] dmap = new int[n][m];
                Arrays.stream(dmap).forEach(arr -> Arrays.fill(arr, Integer.MAX_VALUE));
                List<Pair> wp = whitePixels(map);
                for(Pair p : wp){
                    Queue<Pair> queue = new LinkedList<>();
                    queue.add(p);
                    while(!queue.isEmpty()){
                        Pair cur = queue.remove();
                        if(dmap[cur.a][cur.b] <= cur.d) continue;
                        dmap[cur.a][cur.b]=cur.d;
                        for(int i = 0; i < MOVES.length; ++i){
                            Pair next = new Pair(
                                    cur.a+MOVES[i][0],
                                    cur.b+MOVES[i][1],
                                    cur.d+1);
                            if(0<=next.a&&next.a<n&&0<=next.b&&next.b<m){
                                if(dmap[next.a][next.b] > next.d){
                                    queue.add(next);
                                }
                            }
                        }
                    }
                }
                for(int i = 0; i < n; ++i){
                    for(int j = 0; j < m; ++j){
                        out.print(dmap[i][j] + " ");
                    }
                    out.println();
                }
            }
        }

        private List<Pair> whitePixels(int[][] map) {
            List<Pair> list = new LinkedList<>();
            int n = map.length;
            int m = map[0].length;
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    if(map[i][j]==1)
                        list.add(new Pair(i,j,0));
                }
            }
            return list;
        }
    }

    static class Pair {
        int a,b,d;
        public Pair(int a, int b, int d)
        {this.a=a;this.b=b;this.d=d;}
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
