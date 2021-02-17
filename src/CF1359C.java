import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Problem CF1359C
 *
 * tag: Math
 *
 * Read editorial: https://codeforces.com/blog/entry/78116
 * TODO: Work on math
 *
 */
@SuppressWarnings("unchecked")
public class CF1359C {

    static class Task extends IOHandler {
        public void run() {
            int T = in.nextInt();
            while(T-->0) {
                long h = in.nextLong();
                long c = in.nextLong();
                long t = in.nextLong();
                double m = (h+c)/2.0;
                if(t<=m) {
                    out.println("2");
                } else if (t >= h) {
                    out.println("1");
                } else {
                    long a = h-t;
                    long b = 2*t - h - c;
                    long k = a/b;
                    long v1 = Math.abs(k*(h+c)+h-t*(2*k+1))*(2*k+3);
                    long v2 = Math.abs((k+1)*(h+c)+h-t*(2*k+3))*(2*k+1);
                    out.println(v1<=v2?2*k+1:2*k+3);
                    // out.println("=============");
                    // out.println(String.format("h=%s c=%s t=%s k=%s v1=%s v2=%s", h,c,t,k,v1,v2));
                    // out.println("=============");
                }

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
        public PrintWriter out = new PrintWriter(System.out);

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

        public long nextLong() {
            return Long.parseLong(next());
        }

        public double nextDouble() {
            return Double.parseDouble(next());
        }
    }

}
