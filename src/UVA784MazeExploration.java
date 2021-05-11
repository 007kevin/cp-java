import java.io.*;
import java.util.*;

/**
 * Problem UVA784MazeExploration
 */
public class UVA784MazeExploration {

    static int[][] MOVES = new int[][]{
        {0,1},
        {0,-1},
        {1,0},
        {-1,0}
    };
    
    static class Task extends IOHandler {
        public void run() throws Exception {
            int n = in.nextInt();
            while(n-->0){
                Maze maze = new Maze();
                String s;
                while(true){
                    s = in.reader.readLine();
                    if(s==null || s.charAt(0) == '_') break;
                    maze.add(s);
                }
                paint(maze);
                maze.maze.stream().forEach(out::println);
                out.println(s);
            }
        }

        public void paint(Maze maze){
            Queue<Coord> queue = new LinkedList<>();
            queue.add(findStar(maze));
            while(!queue.isEmpty()){
                Coord cur = queue.remove();
                if(maze.get(cur) == '#') continue;
                maze.set(cur, '#');
                for(int i = 0; i < MOVES.length; ++i){
                    Coord next = new Coord(cur.x+MOVES[i][0], cur.y+MOVES[i][1]);
                    if(maze.valid(next) && maze.get(next) == ' '){
                        queue.add(next);
                    }
                }
            }
        }

        private Coord findStar(Maze maze) {
            int n = maze.maze.size();
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < maze.maze.get(i).length(); ++j){
                    if(maze.maze.get(i).charAt(j) == '*'){
                        return new Coord(i,j);
                    }
                }
            }
            return null;
        }
    }

    public static class Coord {
        int x,y;
        public Coord(int x, int y){
            this.x=x;
            this.y=y;
        }
    }

    public static class Maze {
        private List<StringBuilder> maze = new ArrayList<>();
        public void add(String s){
            maze.add(new StringBuilder(s));
        }
        public char get(Coord coord){
            return maze.get(coord.x).charAt(coord.y);
        }
        public void set(Coord coord, char c){
            maze.get(coord.x).setCharAt(coord.y, c);
        }
        public boolean valid(Coord coord){
            int x = coord.x, y = coord.y;
            if(x<0||y<0) return false;
            if(x >= maze.size()) return false;
            if(y >= maze.get(x).length()) return false;
            return true;
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public static void main(String[] args) throws Exception {
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
