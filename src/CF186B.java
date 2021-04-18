import java.io.*;
import java.util.*;

/**
 * Problem CF186B
 */
@SuppressWarnings("unchecked")
public class CF186B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            double t1 = in.nextDouble();
            double t2 = in.nextDouble();
            double k = in.nextDouble();
            List<Dwarf> list = new ArrayList<>();
            for(int i = 1; i <= n; ++i){
                list.add(new Dwarf(i, t1, t2,
                                in.nextDouble(),
                                in.nextDouble(),
                                k));
            }
            Collections.sort(list);
            for(Dwarf d : list){
                out.println("%s %.2f", d.number, d.mHeight);
            }
        }
    }

    static class Dwarf implements Comparable<Dwarf> {
        int number;
        double mHeight;

        public Dwarf(int number, double t1, double t2, double v, double u, double k){
            this.number = number;
            this.mHeight = Math.max(
                    (t1*v)*((100-k)/100) + t2*u,
                    (t1*u)*((100-k)/100) + t2*v);
        }

        @Override
        public int compareTo(Dwarf that) {
            if(this.mHeight == that.mHeight)
                return Integer.compare(this.number, that.number);
            if(this.mHeight > that.mHeight)
                return -1;
            return 1;
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
