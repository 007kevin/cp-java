import java.io.*;
import java.util.*;

/**
 * Problem CF699C
 */
@SuppressWarnings("unchecked")
public class CF699C {

    static class Task extends IOHandler {

        public static int TODAY_NONE = 0;
        public static int TODAY_CONTEST = 1;
        public static int TODAY_GYM = 2;
        public static int TODAY_BOTH = 3;

        public static int REST = 0;
        public static int CONTEST = 1;
        public static int GYM = 2;


        public void run() {
            int n = in.nextInt();
            int[] a = new int[n+1];
            for(int i = 1; i <= n; ++i){
                a[i]=in.nextInt();
            }

            int[][] dp = new int[n+1][3];

            for(int i =1; i <= n; ++i){
                if(a[i]==TODAY_CONTEST){
                    dp[i][CONTEST]=max(
                            dp[i-1][GYM],
                            dp[i-1][REST]) + 1;
                    dp[i][GYM]=max(
                            dp[i-1][CONTEST],
                            dp[i-1][REST]);
                    dp[i][REST]=max(
                            dp[i-1][GYM],
                            dp[i-1][CONTEST],
                            dp[i-1][REST]);
                } else if (a[i]==TODAY_GYM){
                    dp[i][CONTEST]=max(
                            dp[i-1][GYM],
                            dp[i-1][REST]);
                    dp[i][GYM]=max(
                            dp[i-1][CONTEST],
                            dp[i-1][REST]) + 1;
                    dp[i][REST]=max(
                            dp[i-1][GYM],
                            dp[i-1][CONTEST],
                            dp[i-1][REST]);
                } else if (a[i]==TODAY_NONE){
                    dp[i][CONTEST]=max(
                            dp[i-1][GYM],
                            dp[i-1][REST]);
                    dp[i][GYM]=max(
                            dp[i-1][CONTEST],
                            dp[i-1][REST]);
                    dp[i][REST]=max(
                            dp[i-1][GYM],
                            dp[i-1][CONTEST],
                            dp[i-1][REST]);
                } else if (a[i]==TODAY_BOTH){
                    dp[i][CONTEST]=max(
                            dp[i-1][GYM],
                            dp[i-1][REST]) + 1;
                    dp[i][GYM]=max(
                            dp[i-1][CONTEST],
                            dp[i-1][REST]) + 1;
                    dp[i][REST]=max(
                            dp[i-1][GYM],
                            dp[i-1][CONTEST],
                            dp[i-1][REST]);                    
                }
            }
            out.println(n - max(dp[n][GYM],dp[n][CONTEST],dp[n][REST]));
        }

        public int min(int... args){
            int min=Integer.MAX_VALUE;
            for(int i = 0; i < args.length; ++i){
                min=Math.min(args[i],min);
            }
            return min;
        }

        public int max(int... args){
            int max=0;
            for(int i = 0; i < args.length; ++i){
                max=Math.max(args[i],max);
            }
            return max;
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
