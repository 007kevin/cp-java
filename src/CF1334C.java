import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.LongStream;

/**
 * Problem CF1334C
 */
@SuppressWarnings("unchecked")
public class CF1334C {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t--!=0){
                int n = in.nextInt();
                long[] a = new long[n];
                long[] b = new long[n];
                long[] c = new long[n];
                for(int i = 0; i < n; ++i){
                    a[i]=in.nextLong();
                    c[i]=a[i];
                    b[i]=in.nextLong();
                }

                for(int i = 0; i < n; ++i)
                    c[(i+1)%n]=Math.max(0,c[(i+1)%n]-b[i%n]);
                long sum = LongStream.of(c).sum();

                // for(int i = 0; i < n; ++i)
                //     out.print(c[i] + " ");
                // out.println();

                long ans = Long.MAX_VALUE;
                for(int i = 0; i < n; ++i){
                    ans=Math.min(ans,sum-c[i]+a[i]);
                }
                out.println(ans);
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
    }

}
