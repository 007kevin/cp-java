import java.io.*;
import java.util.*;

/**
 * Problem UVA11094Continents
 * https://onlinejudge.org/index.php?option=com_onlinejudge&Itemid=8&category=22&page=show_problem&problem=2035
 */
public class UVA11094Continents {

    private static int CONQUERED = -1;

    private static int[][] MOVES = {
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };

    private static int M = 0;
    private static int N = 0;
    
    static class Task extends IOHandler {
        public void run() {
            while(in.hasNext()){
                M = in.nextInt();
                N = in.nextInt();
                int[][] map = new int[M][N];
                for(int i = 0; i < M; ++i){
                    String row = in.next();
                    for(int j = 0; j < N; ++j){
                        map[i][j]=(int) row.charAt(j);
                    }
                }
                int mR = in.nextInt();
                int mC = in.nextInt();
                int land = map[mR][mC];
                countRegions(map, land, mR,mC);
                int ans=0;
                for(int i = 0; i < M; ++i){
                    for(int j = 0; j < N; ++j){
                        ans=Math.max(ans,countRegions(map, land, i, j));
                    }
                }
                out.println(ans);
            }
        }

    private int countRegions(int[][] map, int land, int startR, int startC) {
            int count = 0;
            Queue<Pos> q = new LinkedList<>();
            q.add(new Pos(startR,startC));
            while(!q.isEmpty()){
                Pos c = q.remove();
                if(map[c.r][c.c]!=land||map[c.r][c.c]==CONQUERED)
                    continue;
                count++;
                map[c.r][c.c]=CONQUERED;
                for(int i = 0; i < MOVES.length; ++i){
                    int newR = c.r+MOVES[i][0];
                    int newC = c.c+MOVES[i][1];
                    if (0<=newR&&newR<=M-1){
                        q.add(new Pos(newR, c.c+MOVES[i][1]));
                    }
                }
            }
            return count;
        }

    }

    static class Pos{
        int r,c;
        public Pos(int r, int c){
            this.r=r;
            this.c=wrap(c,N);
        }

        private static int wrap(int x, int limit){
            if(x<0) return limit-1;
            if(x>=limit) return 0;
            return x;
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
        public void cleanup() {out.close();}
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
                } catch (IOException e) {throw new RuntimeException(e);}
            }
            return true;
        }
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokenizer.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {super(out);}
        public void println(String format, Object... args) {
            this.println(String.format(format, args));}
        public void print(String format, Object... args) {
            this.print(String.format(format, args));}
    }
}
