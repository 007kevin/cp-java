import java.io.*;
import java.util.*;

/**
 * Problem CF1372D
 */
@SuppressWarnings("unchecked")
public class CF1371D {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                Grid g = new Grid(in.nextInt(),in.nextInt());
                int s = g.solve();
                out.println(s);
                g.print(out);
            }
            // for(int i = 0; i <= 9; ++i){
            //     Grid g = new Grid(3,i);
            //     int s = g.solve();
            //     g.print(out);
            //     out.println("k="+i+" ,s="+s);
            //     out.println("==========================");
            // }
        }
    }

    static class Grid {
        private int n;
        private int k;
        private int[][] g;
        public Grid(int n, int k) {
            this.n = n;
            this.k = k;
            this.g = new int[n][n];
        }
        public int solve() {
            int i = 0;
            int j = 0;
            for (int a = 0; a < k; ++a){
                g[i][j]=1;
                i++;
                j=(j+1)%n;
                if(i==n){
                    i=0;
                    j=(j+1)%n;
                }

            }
            return k%n==0?0:2;
        }
        public void print(OutputWriter out) {
            for(int i = 0; i < n; ++i){
                for(int j = 0; j < n; ++j){
                    out.print(g[i][j]);
                }
                out.println();
            }
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

    static class IOHandler {
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

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public int[] nextInts(int n) {
            int a[] = new int[n];
            for(int i = 0; i < n; ++i)
                a[i] = nextInt();
            return a;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongs(int n) {
            long a[] = new long[n];
            for(int i = 0; i < n; ++i)
                a[i] = nextLong();
            return a;
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
