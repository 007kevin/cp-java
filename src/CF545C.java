import java.io.*;
import java.util.*;

/**
 * Problem CF545C
 */
@SuppressWarnings("unchecked")
public class CF545C {

    static class Task extends IOHandler {
        final static int LEFT=0;
        final static int RIGHT=1;

        public void run() {
            int n = in.nextInt();
            int[][] dp = new int[n+2][2];
            long[] x = new long[n+2];
            long[] h = new long[n+2];
            x[0]=Long.MIN_VALUE;
            x[n+1]=Long.MAX_VALUE;
            for(int i = 1; i <= n; ++i){
                x[i]=in.nextLong();
                h[i]=in.nextLong();
            }

            for(int i = 1; i <= n; ++i){
                dp[i][LEFT]=Math.max(
                        dp[i-1][LEFT] + (x[i-1] < x[i]-h[i]?1:0),
                        dp[i-1][RIGHT] + (x[i-1]+h[i-1] < x[i]-h[i]?1:0));
                dp[i][RIGHT]=Math.max(
                        dp[i-1][LEFT] + (x[i] + h[i] < x[i+1]?1:0),
                        dp[i-1][RIGHT] + (x[i] + h[i] < x[i+1]?1:0));
            }
            out.println(Math.max(dp[n][LEFT],dp[n][RIGHT]));
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
