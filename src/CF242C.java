import java.io.*;
import java.util.*;

/**
 * Problem CF242C
 */
@SuppressWarnings("unchecked")
public class CF242C {

    private static int[][] MOVES = {
        {1,0},
        {1,1},
        {0,1},
        {-1,1},
        {-1,0},
        {-1,-1},
        {0,-1},
        {1,-1}
    };

    static class Task extends IOHandler {
        public void run() {
            King start = new King(in.nextLong(),in.nextLong(),0);
            King end = new King(in.nextLong(),in.nextLong(),0);
            Queue<King> Q = new LinkedList<>();
            Map<Long, Set<Long>> visited = new HashMap<>();
            Map<Long, List<Segment>> allowed = new HashMap<>();
            int n = in.nextInt();
            while(n-->0){
                long r = in.nextLong();
                long a = in.nextLong();
                long b = in.nextLong();
                allowed.computeIfAbsent(r, key -> new LinkedList<>())
                        .add(new Segment(r, a, b));
            }
            Q.add(start);
            visited.computeIfAbsent(start.x, key -> new HashSet<>()).add(start.y);
            long ans = -1;
            while(!Q.isEmpty()){
                King current = Q.remove();
                if(current.equals(end)){
                    ans=current.m;
                }
                for(int i = 0; i < MOVES.length; ++i){
                    long x = current.x + MOVES[i][0];
                    long y = current.y + MOVES[i][1];
                    if(!visited.computeIfAbsent(x, key->new HashSet<>()).contains(y) &&
                            allowed(allowed, x, y)) {
                        visited.get(x).add(y);
                        Q.add(new King(x, y, current.m + 1));
                    }
                }
            }
            out.println(ans);
        }

        private boolean allowed(Map<Long, List<Segment>> allowed, long x, long y){
            if(!allowed.containsKey(x)) return false;
            List<Segment> list = allowed.get(x);
            for(Segment seg : list){
                if(seg.contains(x, y)) return true;
            }
            return false;
        }
    }

    static class King {
        private long x;
        private long y;
        private long m;

        public King(long x, long y, long m){
            this.x = x;
            this.y = y;
            this.m = m;
        }

        public boolean equals(King other){
            return this.x==other.x&&this.y==other.y;
        }
    }

    static class Segment {
        private long r;
        private long a;
        private long b;

        public Segment(long r, long a, long b){
            this.r = r;
            this.a = a;
            this.b = b;
        }

        public boolean contains(long x, long y){
            return x==r&&a<=y&&y<=b;
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
