import java.io.*;
import java.util.*;

/**
 * Problem UVA439KnightMoves
 */
@SuppressWarnings("unchecked")

public class UVA439KnightMoves {

    private static int[][] MOVES = {
        {2,1},
        {2,-1},
        {1,2},
        {-1,2},
        {-2,1},
        {-2,-1},
        {1,-2},
        {-1,-2}
    };

    static class Task extends IOHandler {

        public void run() {
            while(in.hasNext()){
                final String start = in.next();
                final String end = in.next();
                Knight kEnd = Knight.of(end, 0);
                Queue<Knight> Q = new LinkedList<>();
                int ans = -1;
                Q.add(Knight.of(start, 0));
                while(!Q.isEmpty()){
                    Knight k = Q.remove();
                    if(k.equals(kEnd)){
                        ans=k.m;
                        break;
                    }
                    for(int i = 0; i < MOVES.length; ++i){
                        Knight next = new Knight(k.x+MOVES[i][0], k.y+MOVES[i][1], k.m+1);
                        if(next.valid()){
                            Q.add(next);
                        }
                    }
                }
                out.println("To get from %s to %s takes %d knight moves.",
                        start,
                        end,
                        ans);
            }
        }

    }

    static class Knight {
        int x;
        int y;
        int m;
        public Knight(int x, int y, int m){
            this.x = x;
            this.y = y;
            this.m = m;
        }

        public static Knight of(final String e, int m){
            return new Knight(
                    (int) e.charAt(0) - 'a' + 1,
                    (int) e.charAt(1)-'0',
                    m);
        }

        public boolean equals(final Knight other){
            return this.x == other.x && this.y == other.y;
        }

        public boolean valid(){
            return 1<=x&&x<=8&&1<=y&&y<=8;
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
