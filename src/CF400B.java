import java.io.*;
import java.util.*;

/**
 * Problem CF400B
 */
@SuppressWarnings("unchecked")
public class CF400B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            char[][] g = new char[n][m];
            for(int i = 0; i < n; ++i){
                String s = in.next();
                for(int j = 0; j < m; ++j){
                    g[i][j]=s.charAt(j);
                }
            }
            Game game = new Game(g,n,m);
            if(!game.isPossible()) out.println(-1);
            else out.println(game.calculate());
        }
    }

    static class Game {
        private char[][] g;
        private int n;
        private int m;
        public Game(final char[][] g, final int n, final int m){
            this.g = g;
            this.n = n;
            this.m = m;
        }
        public boolean isPossible() {
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < m; ++j){
                    if(g[i][j]=='G') break;
                    if(g[i][j]=='S') return false;
                }
            }
            return true;
        }

        public int calculate() {
            Set<Integer> set = new HashSet<>();
            for(int i = 0; i < n; ++i){
                int d=0;
                int c=0;
                for(int j = 0; j < m; ++j){
                    if(g[i][j]=='G') d=j;
                    if(g[i][j]=='S') c=j;
                }
                set.add(c-d);
            }
            return set.size();
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
