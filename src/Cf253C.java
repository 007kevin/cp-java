import java.io.*;
import java.util.*;

/**
 * Problem Cf253C
 */
public class Cf253C {

    int RIGHT = 0;
    int LEFT = 1;
    int UP = 2;
    int DOWN = 3;

    int[][] moves = new int[][]{
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };

    public void run() {
        int n = in.nextInt();
        int[] lines = new int[n+1];
        for(int i = 1; i <= n; ++i) lines[i]=in.nextInt();
        Queue<Pos> queue = new ArrayDeque<>();
        int[][] v = new int[n+1][100002];
        Pos start = new Pos(in.nextInt(), in.nextInt(),0);
        Pos end = new Pos(in.nextInt(), in.nextInt(),0);
        Pos cur = null;
        queue.add(start);
        while(!queue.isEmpty()){
            cur = queue.remove();
            if(contains(v,cur)) continue;
            set(v,cur);
            if(end.equals(cur)) break;
            for(int i = 0; i < moves.length; ++i){
                int r = cur.r + moves[i][0];
                int c = cur.c + moves[i][1];
                if(r<=0||c<0) continue;
                if(r>n) continue;
                Pos pos = null;
                if(i==LEFT) {
                    pos = new Pos(r,c,cur.s+1);
                }
                if(i==RIGHT && c <= lines[r] + 1){
                    pos = new Pos(r,c,cur.s+1);
                }
                if(i==UP||i==DOWN) {
                    pos = new Pos(r,Math.min(lines[r]+1,c), cur.s+1);
                }
                if(pos!=null && !contains(v,pos)){
                    queue.add(pos);
                }
            }
        }
        out.println(cur.s);
    }

    boolean contains(int[][] v, Pos pos){
        return v[pos.r][pos.c]==1;
    }

    void set(int[][] v, Pos pos){
        v[pos.r][pos.c]=1;
    }    

    static class Pos {
        int r,c,s;
        Pos(int r, int c, int s){
            this.r=r;
            this.c=c;
            this.s=s;
        }

        @Override
        public boolean equals(Object obj) {
            Pos that = Pos.class.cast(obj);
            return this.r==that.r
                && this.c==that.c;
        }
        
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public InputReader in = new InputReader(System.in);
    public PrintWriter out = new PrintWriter(System.out);

    public Cf253C() {
        try {
            in = new InputReader(new FileInputStream(new File("input.txt")));
            out = new PrintWriter(new FileOutputStream(new File("output.txt")));
        } catch (Exception e){
            throw new RuntimeException(e);
        }
    }

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
        Cf253C task = new Cf253C(); task.run(); task.close();}
}
