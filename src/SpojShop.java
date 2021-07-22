import java.io.*;
import java.util.*;

/**
 * Problem SpojShop
 */
public class SpojShop {

    static int[][] moves = new int[][]{
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };

    public void run() {
        while(true){
            int w = in.nextInt();
            int h = in.nextInt();
            if(h==0&&w==0) break;
            Cell s=null,d=null;
            Cell[][] shop = new Cell[h][w];
            for(int i = 0; i < h; ++i){
                char[] row = in.next().toCharArray();
                for(int j = 0; j < w; ++j){
                    shop[i][j]=new Cell(row[j],i,j,Integer.MAX_VALUE);
                    if(shop[i][j].v=='S') s = shop[i][j];
                    if(shop[i][j].v=='D') d = shop[i][j];
                }
            }
            Set<Cell> v = new HashSet<>();
            Queue<Cell> queue = new PriorityQueue<>((a,b) -> a.time - b.time);
            s.time = 0;
            queue.add(s);
            while(!queue.isEmpty()){
                Cell c = queue.remove();
                if(v.contains(c)) continue;
                v.add(c);
                if(c.equals(d)) break;
                for(int[] m : moves){
                    int i = c.x+m[0];
                    int j = c.y+m[1];
                    if(i<0||j<0||i>=h||j>=w) continue;
                    if(shop[i][j].v == 'D'
                            || ('0' <= shop[i][j].v && shop[i][j].v <= '9')){
                        if(v.contains(shop[i][j])) continue;
                        int time = c.time + (c.v=='S'?0 : c.v-'0');
                        if(time < shop[i][j].time){
                            queue.remove(shop[i][j]);
                            shop[i][j].time = time;
                            queue.add(shop[i][j]);
                        }
                    }
                }

            }
            out.println(d.time);
        }
    }

    static class Cell {
        char v;
        int x,y,time;
        Cell(char v, int x, int y, int time){
            this.v=v;
            this.x=x;
            this.y=y;
            this.time=time;
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
        SpojShop task = new SpojShop(); task.run(); task.close();}
}
