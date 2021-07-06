import java.io.*;
import java.util.*;

/**
 * Problem Uva11573
 */
public class Uva11573 {

    int[][] moves = new int[][]{
        {-1,0},
        {-1,1},
        {0,1},
        {1,1},
        {1,0},
        {1,-1},
        {0,-1},
        {-1,-1}
    };

    int r,c,n,xs,ys,xe,ye,d;
    int[][] oc, en;
    public void run() {
        r = in.nextInt();
        c = in.nextInt();
        oc = new int[r+1][c+1];
        en = new int[r+1][c+1];
        for(int i = 1; i <= r; ++i){
            char[] row = in.next().toCharArray();
            for(int j = 1; j <= c; ++j){
                oc[i][j]=row[j-1]-'0';
            }
        }
        n = in.nextInt();
        while(n-->0){
            reset();
            xs=in.nextInt();
            ys=in.nextInt();
            xe=in.nextInt();
            ye=in.nextInt();
            out.println(find());
        }
    }

    public void reset(){
        for(int i = 1; i <= r; ++i)
            for(int j = 1; j <= c; ++j)
                en[i][j]=1000*1000+1;
    }

    int find(){
        Deque<Coord> q = new ArrayDeque<>();
        q.add(new Coord(xs,ys,0));
        while(!q.isEmpty()){
            Coord coord = q.removeFirst();
            if(!valid(coord)) continue;
            en[coord.x][coord.y]=coord.e;
            for(int i = 0; i < 8; ++i){
                Coord next = new Coord(
                        coord.x+moves[i][0],
                        coord.y+moves[i][1],
                        coord.e + (i==oc[coord.x][coord.y]?0:1));
                if(valid(next)){
                    if(i==oc[coord.x][coord.y]) q.addFirst(next);
                    else q.addLast(next);
                }
            }
        }
        return en[xe][ye];
    }

    boolean valid(Coord coord){
        int x = coord.x;
        int y = coord.y;
        if(x<1||y<1||x>r||y>c) return false;
        return coord.e < en[x][y];
    }

    static class Coord {
        int x,y,e;
        Coord(int x, int y, int e){
            this.x=x;this.y=y;this.e=e;
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
        Uva11573 task = new Uva11573(); task.run(); task.close();}
}
