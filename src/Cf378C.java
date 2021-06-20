import java.io.*;
import java.util.*;

/**
 * Problem Cf378C
 */
public class Cf378C {
    int[][] moves = new int[][] {
        {0,-1},
        {1,0},
        {0,1},
        {-1,0}
    };
    int n,m,k;
    char[][] maze;
    boolean[][] v;
    List<Pair> list = new ArrayList(500*500);
    public void run() {
        n=in.nextInt();
        m=in.nextInt();
        k=in.nextInt();
        maze = new char[n][];
        v = new boolean[n][m];
        for(int i = 0; i < n; ++i){
            maze[i]=in.next().toCharArray();
        }
        bfs();
        Collections.sort(list, (a,b) -> b.step - a.step);
        list.stream().limit(k).forEach(p -> maze[p.i][p.j]='X');
        for(char[] row : maze)
            out.println(new String(row));
    }

    public void bfs(){
        Queue<Pair> queue = new ArrayDeque<>();
        int[] start = find();
        queue.add(new Pair(start[0],start[1],0));
        while(!queue.isEmpty()){
            Pair p = queue.remove();
            if(v[p.i][p.j]) continue;
            v[p.i][p.j]=true;
            list.add(p);
            for(int[] move : moves){
                int ni = p.i+move[0];
                int nj = p.j+move[1];
                if(valid(ni,nj)){
                    queue.add(new Pair(ni,nj,p.step+1));
                }
            }
        }

    }

    static class Pair {
        int i,j,step;
        Pair(int i, int j, int step){
            this.i=i;
            this.j=j;
            this.step=step;
        }
    }

    public boolean valid(int i, int j){
        if(i<0||j<0||i>=n||j>=m) return false;
        if(v[i][j]) return false;
        return maze[i][j]=='.';
    }

    public int[] find(){
        for(int i = 0; i < n; ++i){
            for(int j = 0; j < m; ++j){
                if(maze[i][j]=='.')
                    return new int[]{i,j};
            }
        }
        return new int[2];
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
        Cf378C task = new Cf378C(); task.run(); task.close();}
}
