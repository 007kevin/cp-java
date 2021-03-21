import java.io.*;
import java.util.*;

/**
 * Problem UVA11953
 */
@SuppressWarnings("unchecked")
public class UVA11953 {

    static class Task extends IOHandler {

        public void run() {
            int t = in.nextInt();
            int CASE =0;
            while(t-->0){
                CASE++;
                int n = in.nextInt();
                char g[][] = new char[n][n];
                for(int i = 0; i < n; ++i){
                    String row = in.next();
                    for(int j = 0; j < n; ++j){
                        g[i][j]=row.charAt(j);
                    }
                }
                Grid grid = new Grid(g);
                out.println(String.format("Case %s: %s", CASE, grid.countAlive()));
            }
        }

        public static class Grid {
            private static char EMPTY = '.';
            private static char SHIP = 'x';
            private static char HIT = '@';
            private static int[][] POS = new int[][]{{1,0},{0,1},{-1,0},{0,-1}};
            private int N;

            private List<String> ships = new ArrayList<>();

            public Grid(char[][] g){
                this.N = g.length;
                boolean[][] visited = new boolean[N][N];
                for(int i = 0; i < N; ++i){
                    for(int j = 0; j < N; ++j){
                        if(!visited[i][j]&&g[i][j]!=EMPTY){
                            ships.add(extract(g,visited,i,j));
                        }
                    }
                }
            }

            private String extract(char[][] g, boolean[][] v, int i, int j) {
                v[i][j]=true;
                String r = ""+g[i][j];
                for(int[] pos : POS){
                    int ni = i + pos[0];
                    int nj = j + pos[1];
                    if(ni<0||nj<0||ni>=N||nj>=N||v[ni][nj]||g[ni][nj]==EMPTY) continue;
                    r+=extract(g, v, ni, nj);
                }
                return r;
            }

            public int countAlive(){
                return (int) ships.stream().filter(this::isAlive).count();
            }

            public boolean isAlive(String ship){
                for(int i = 0; i < ship.length(); ++i){
                    if(ship.charAt(i)==SHIP)
                        return true;
                }
                return false;
            }
        }
    }

    /***********************************************************
     *                        COMMONS                          *
     ***********************************************************/
    static class Pair<A, B> implements Comparable<Pair<A, B>> {
        public A a;
        public B b;
        public Pair(Pair<A, B> p) {
            this(p.a, p.b);
        }

        public Pair(A a, B b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return a+" "+b;
        }

        public int hashCode() {
            return Objects.hash(a, b);
        }

        public boolean equals(Object o) {
            if(o instanceof Pair) {
                Pair<A,B> p = (Pair<A,B>) o;
                return a.equals(p.a)&&b.equals(p.b);
            }
            return false;
        }

        @Override
        public int compareTo(Pair<A, B> p) {
            int cmp = ((Comparable<A>) a).compareTo(p.a);
            if(cmp==0) {
                return ((Comparable<B>) b).compareTo(p.b);
            }
            return cmp;
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
     ***********************************************************/
    public static void main(String[] args) {
        Task task = new Task();
        task.run();
        task.cleanup();
    }

    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public OutputWriter out = new OutputWriter(System.out);

        public void cleanup() {
            out.close();
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        private boolean prime() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return true;
        }
        
        public boolean hasNext() {
            return prime();
        }

        public String next() {
            prime();
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {
            super(out);
        }

        public void println(String format, Object... args) {
            this.println(String.format(format, args));
        }

        public void print(String format, Object... args) {
            this.print(String.format(format, args));
        }
    }

}
