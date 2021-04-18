import java.io.*;
import java.util.*;

/**
 * Problem CF152B
 */
@SuppressWarnings("unchecked")
public class CF152B {

    static class Task extends IOHandler {
        public void run() {
            Stepper stepper = new Stepper(
                    in.nextLong(),
                    in.nextLong(),
                    in.nextLong(),
                    in.nextLong());

            long k = in.nextLong();
            long ans = 0;
            while(k-->0){
                ans+=stepper.step(
                        in.nextLong(),
                        in.nextLong());
            }
            out.println(ans);
        }
    }

    static class Stepper {
        private long n;
        private long m;
        private long x;
        private long y;

        public Stepper(long n, long m, long x, long y){
            this.n = n;
            this.m = m;
            this.x = x;
            this.y = y;
        }

        public long step(long dx, long dy){
            long steps = Math.min(
                    xsteps(dx),
                    ysteps(dy));
            if(steps == Long.MAX_VALUE) return 0;
            x+=dx*steps;
            y+=dy*steps;
            return steps;
        }

        private long xsteps(long dx){
            if(dx==0) return Long.MAX_VALUE;
            if(dx>0) return Math.abs((n-x)/dx);
            return Math.abs((x-1)/dx);
        }

        private long ysteps(long dy){
            if(dy==0) return Long.MAX_VALUE;
            if(dy>0) return Math.abs((m-y)/dy);
            return Math.abs((y-1)/dy);
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
