import java.io.*;
import java.util.*;

/**
 * Problem codeforces16B
 */
public class codeforces16B {

    public void run() {
        Long n = in.nextLong();
        Long m = in.nextLong();
        List<Pair<Long, Long>> list = new ArrayList<>();
        for(int i = 0; i < m; ++i){
            list.add(new Pair<Long,Long>(in.nextLong(), in.nextLong()));
        }
        Collections.sort(list, (p1,p2) -> {
            if(p1.b==p2.b) return 0;
            if(p1.b>p2.b) return -1;
            return 1;
        });
        Long matches = 0L;
        for(Pair<Long, Long> p : list){
            if(n==0) break;
            matches+=p.b * Math.min(n,p.a);
            n-=Math.min(n,p.a);
        }
        out.println(matches);
    }

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
        codeforces16B task = new codeforces16B(); task.run(); task.close();}
}
