import java.io.*;
import java.util.*;

/**
 * Problem SPOJ_EASYMATH
 * https://www.spoj.com/problems/EASYMATH/
 */
@SuppressWarnings("unchecked")
public class SPOJ_EASYMATH {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                long n = in.nextLong();
                long m = in.nextLong();
                long a = in.nextLong();
                long d = in.nextLong();
                long[] arr = new long[]{a,a+d,a+(2*d),a+(3*d),a+(4*d)};
                long c1=0;
                long c2=0;
                out.println("========");
                for(int i = 0; i < 5; ++i){
                    c1+=(n-1)-((n-1)/arr[i]);
                    c2+=m-(m/arr[i]);
                    out.println(String.format("%s %s",(n-1)-((n-1)/arr[i]), m-(m/arr[i])));
                }
                out.println("> " + c1 + " " + c2);
                long lcm = arr[0];
                for(int i = 1; i < 5; ++i){
                    lcm=lcm(lcm,arr[i]);
                    c1-=(n-1)-((n-1)/lcm);
                    c2-=m-(m/lcm);
                    out.println(String.format("lcm=%s, %s %s",lcm, (n-1)-((n-1)/lcm), m-(m/lcm)));
                }
                out.println(c2-c1);
            }
        }

        private long lcm(long a, long b) {
            return a / gcd(a,b) * b;
        }

        private long gcd(long a, long b) {
            if (b==0){
                return a;
            } else {
                return gcd(b,a%b);
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
