import java.io.*;
import java.util.*;

/**
 * Problem CF215B
 */
@SuppressWarnings("unchecked")
public class CF215B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            double[] x = new double[n];
            for(int i = 0; i < n; ++i) x[i]=in.nextDouble();
            int m = in.nextInt();
            double[] y = new double[m];
            for(int i = 0; i < m; ++i) y[i]=in.nextDouble();
            int k = in.nextInt();
            double[] z = new double[k];
            for(int i = 0; i < k; ++i) z[i]=in.nextDouble();
            Arrays.sort(z);
            double A = in.nextDouble();
            double B = in.nextDouble();

            double ans = 0;
            for(int a = 0; a < n; ++a){
                for(int b = 0; b < m; ++b){
                    ans=Math.max(ans, calc(A, B, x[a],y[b],z[0]));
                }
            }

            out.println("%.9f", ans);
        }

        private double calc(double a, double b, double r1, double p1, double p2) {
            double numerator = b*p1*r1*r1;
            double deno = a*p2 + b*p1;
            return Math.sqrt(numerator/deno);
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
