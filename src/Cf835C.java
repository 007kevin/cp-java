import java.io.*;
import java.util.*;

/**
 * Problem Cf835C
 */
public class Cf835C {

    public void run() {
        int N = in.nextInt();
        int Q = in.nextInt();
        int C = in.nextInt();
        Map<Integer, Map<Integer, List<Integer>>> XY = new HashMap<>();
        for(int i = 0; i < N; ++i){
            int x = in.nextInt();
            int y = in.nextInt();
            int s = in.nextInt();
            XY.computeIfAbsent(x, key -> new HashMap<>())
              .computeIfAbsent(y, key -> new ArrayList<>())
              .add(s);
        }
        int[][][] B = new int[101][101][11];
        for(int c = 0; c <= C; ++c){
            for(int x = 1; x <= 100; ++x){
                for(int y = 1; y <= 100; ++y){
                    int b = 0;
                    for(int s : get(XY,x,y)){
                        b+=(s+c)%(C+1);
                    }
                    B[x][y][c] = B[x-1][y][c] + B[x][y-1][c] - B[x-1][y-1][c] + b;
                }
            }
        }
        while(Q-->0){
            int t = in.nextInt()%(C+1);
            int x1 = in.nextInt();
            int y1 = in.nextInt();
            int x2 = in.nextInt();
            int y2 = in.nextInt();
            int b = B[x2][y2][t] - B[x2][y1-1][t] - B[x1-1][y2][t] + B[x1-1][y1-1][t];
            out.println(b);
        }

    }

    List<Integer> get(Map<Integer, Map<Integer, List<Integer>>> XY, int x, int y){
        return Optional.of(XY)
                .map(map -> map.get(x))
                .map(map -> map.get(y))
                .orElse(Collections.emptyList());
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
        Cf835C task = new Cf835C(); task.run(); task.close();}
}
