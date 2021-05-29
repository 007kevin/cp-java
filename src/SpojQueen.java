import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

/**
 * Problem SpojQueen
 */
public class SpojQueen {

    static final char START = 'S';
    static final char END = 'F';
    static final char FREE = '.';
    static final char OCC = 'X';

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                int m = in.nextInt();
                char[][] board = new char[n][1];
                for(int i = 0; i < n; ++i){
                    board[i]=in.next().toCharArray();
                }
                out.println(bfs(board,n,m));
            }
        }

        public int bfs(char[][] board, int n, int m){
            Coord start = findStart(board,n,m);
            Coord end = findEnd(board,n,m);
            int[][] dist = new int[n][m];
            Arrays.stream(dist).forEach(arr -> Arrays.fill(arr, n*m));
            Queue<Coord> queue = new LinkedList<>();
            queue.add(start);
            while(!queue.isEmpty()){
                Coord coord = queue.remove();
                if(coord.equals(end)){
                    return coord.d;
                }
                if(coord.d >= getDist(dist, coord)) continue;
                setDist(dist,coord);
                queue.addAll(filter(genMoves(board,coord), dist));
            }
            return -1;
        }

        public List<Coord> genMoves(char[][] board, Coord coord){
            List<Coord> list = new LinkedList<>();
            list.addAll(left(board,coord));
            list.addAll(up(board,coord));
            list.addAll(down(board,coord));
            list.addAll(right(board,coord));
            list.addAll(leftUp(board,coord));
            list.addAll(rightUp(board,coord));
            list.addAll(rightDown(board,coord));
            list.addAll(leftDown(board,coord));
            return list;
        }

        public List<Coord> left(char[][] board, Coord coord){
            int n = board.length;
            int m = board[0].length;
            int r = coord.r;
            int c = coord.c-1;
            int d = coord.d+1;
            List<Coord> list = new LinkedList<>();
            while(0<=c&&valid(board[r][c])){
                list.add(new Coord(r,c,d));
                c--;
            }
            return list;
        }

        public List<Coord> right(char[][] board, Coord coord){
            int n = board.length;
            int m = board[0].length;
            int r = coord.r;
            int c = coord.c+1;
            int d = coord.d+1;
            List<Coord> list = new LinkedList<>();
            while(c<m&&valid(board[r][c])){
                list.add(new Coord(r,c,d));
                c++;
            }
            return list;
        }

        public List<Coord> up(char[][] board, Coord coord){
            int n = board.length;
            int m = board[0].length;
            int r = coord.r-1;
            int c = coord.c;
            int d = coord.d+1;
            List<Coord> list = new LinkedList<>();
            while(0<r&&valid(board[r][c])){
                list.add(new Coord(r,c,d));
                d++;
                r--;
            }
            return list;
        }

        public List<Coord> down(char[][] board, Coord coord){
            int n = board.length;
            int m = board[0].length;
            int r = coord.r+1;
            int c = coord.c;
            int d = coord.d+1;
            List<Coord> list = new LinkedList<>();
            while(r<n&&valid(board[r][c])){
                list.add(new Coord(r,c,d));
                r++;
            }
            return list;
        }

        public List<Coord> leftUp(char[][] board, Coord coord){
            int n = board.length;
            int m = board[0].length;
            int r = coord.r-1;
            int c = coord.c-1;
            int d = coord.d+1;
            List<Coord> list = new LinkedList<>();
            while(0<=r&&0<=c&&valid(board[r][c])){
                list.add(new Coord(r,c,d));
                c--;
                r--;
            }
            return list;
        }

        public List<Coord> rightUp(char[][] board, Coord coord){
            int n = board.length;
            int m = board[0].length;
            int r = coord.r-1;
            int c = coord.c+1;
            int d = coord.d+1;
            List<Coord> list = new LinkedList<>();
            while(0<=r&&c<m&&valid(board[r][c])){
                list.add(new Coord(r,c,d));
                c++;
                r--;
            }
            return list;
        }

        public List<Coord> rightDown(char[][] board, Coord coord){
            int n = board.length;
            int m = board[0].length;
            int r = coord.r+1;
            int c = coord.c+1;
            int d = coord.d+1;
            List<Coord> list = new LinkedList<>();
            while(r<n&&c<m&&valid(board[r][c])){
                list.add(new Coord(r,c,d));
                c++;
                r++;
            }
            return list;
        }

        public List<Coord> leftDown(char[][] board, Coord coord){
            int n = board.length;
            int m = board[0].length;
            int r = coord.r+1;
            int c = coord.c-1;
            int d = coord.d+1;
            List<Coord> list = new LinkedList<>();
            while(r<n&&0<=c&&valid(board[r][c])){
                list.add(new Coord(r,c,d));
                c--;
                r++;
            }
            return list;
        }

        public boolean valid(char c){
            return c == FREE || c == END;
        }

        public Collection<Coord> filter(List<Coord> moves, int[][] dist){
            return moves.stream().filter(coord -> coord.d < getDist(dist, coord))
                    .collect(Collectors.toCollection(LinkedList<Coord>::new));
        }

        public int getDist(int[][] dist, Coord coord){
            return dist[coord.r][coord.c];
        }

        public void setDist(int[][] dist, Coord coord){
            dist[coord.r][coord.c] = coord.d;
        }

        public Coord findStart(char[][] board, int n, int m){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    if(board[i][j]==START){
                        return new Coord(i,j);
                    }
                }
            }
            return null;
        }

        public Coord findEnd(char[][] board, int n, int m){
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    if(board[i][j]==END){
                        return new Coord(i,j);
                    }
                }
            }
            return null;
        }
    }

    static class Coord {
        int r,c,d;
        Coord(int r, int c){this.r=r;this.c=c;this.d=0;}
        Coord(int r, int c, int d){this.r=r;this.c=c;this.d=d;}
        public boolean equals(Coord that){
            return this.r==that.r&&this.c==that.c;
        }

        public String toString() {
            return new StringJoiner(",", "{", "}")
                    .add(String.valueOf(r))
                    .add(String.valueOf(c))
                    .add(String.valueOf(d))
                    .toString();
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
