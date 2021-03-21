import java.io.*;
import java.util.*;

/**
 * Problem UVA10452
 */
@SuppressWarnings("unchecked")
public class UVA10452 {

    static class Task extends IOHandler {
        private static int[][] POS = new int[][]{{-1,0},{0,1},{0,-1}};
        private static String[] POS_NAME = new String[]{"forth", "right", "left"};
        private static char[] PATH = {'@','I','E','H','O','V','A','#'};

        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                int m = in.nextInt();
                char[][] cobbles = new char[n][m];
                for(int i = 0; i < n; ++i){
                    String row = in.next();
                    for(int j = 0; j < m; ++j){
                        cobbles[i][j]=row.charAt(j);
                    }

                }
                Pair<Integer,Integer> start = findStart(cobbles, n, m);
                List<String> path = findPath(cobbles, 0, start.a, start.b);
                StringJoiner joiner = new StringJoiner(" ");
                path.stream().forEach(joiner::add);
                out.println(joiner.toString());
            }
        }

        private List<String> findPath(char[][] cobbles, int p, int i, int j) {
            int n = cobbles.length;
            int m = cobbles[0].length;
            if(i<0||j<0||i>=n||j>=m) return null;
            if(cobbles[i][j]!=PATH[p]) return null;
            if(cobbles[i][j]=='#') return new LinkedList<String>();
            for(int a = 0; a < 3; ++a){
                List<String> result = findPath(cobbles, p+1, i+POS[a][0], j+POS[a][1]);
                if(result!=null){
                    result.add(0,POS_NAME[a]);
                    return result;
                }
            }
            return null;
        }

        private Pair<Integer,Integer> findStart(char[][] cobbles, int n, int m) {
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    if(cobbles[i][j]=='@')
                        return new Pair<>(i,j);
                }
            }
            return null;
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
