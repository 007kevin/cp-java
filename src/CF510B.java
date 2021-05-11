import java.io.*;
import java.util.*;

/**
 * Problem CF510B
 */
public class CF510B {

    static class Task extends IOHandler {
        public static int[][] MOVES = new int[][] {
            {0,1},
            {0,-1},
            {1,0},
            {-1,0}
        };
        
        public void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] game = new char[n][m];
            for(int i = 0; i < n; ++i){
                game[i] = in.next().toCharArray();
            }
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    if(isCycle(game,i,j)){
                        out.println("Yes");
                        return;
                    }
                }
            }
            out.println("No");
        }

        public boolean isCycle(char[][] game, int i, int j){
            boolean[][] visited = new boolean[game.length][game[0].length];
            return dfs(visited, game, i, j, i, j);
        }

        public boolean dfs(boolean [][] visited, char[][] game, int i, int j, int li, int lj){
            if(visited[i][j]){
                return true;
            }
            visited[j][j]=true;
            for(int a = 0; a < MOVES.length; ++a){
                int ni = i + MOVES[a][0];
                int nj = i + MOVES[a][1];
                if(0<=ni&&ni<game.length&&0<=nj&&nj<game[0].length){
                    if(ni!=li&&nj!=lj){
                        if(game[ni][nj]==game[li][lj]){
                            dfs(visited, game, ni, nj, i, j);
                        }
                    }
                }
                
            }
            return false;
        }

    }

    static class Cell {
        int i,j;
        public Cell(int i, int j){
            this.i=i;
            this.j=j;
        }

        public boolean valid(char[][] game, char color){
            int n = game.length;
            int m = game[0].length;
            if(!(0<=i&&i<n)) return false;
            if(!(0<=j&&j<m)) return false;
            return game[i][j]==color;
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
        public PrintWriter out = new PrintWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
}
