import java.io.*;
import java.util.*;

/**
 * Problem UVA460_OVERLAPPING_RECTANGLES
 */
@SuppressWarnings("unchecked")
public class UVA460_OVERLAPPING_RECTANGLES {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            StringJoiner results = new StringJoiner("\n\n");
            while(t-->0){
                Rectangle r1 = new Rectangle(
                        in.nextInt(),
                        in.nextInt(),
                        in.nextInt(),
                        in.nextInt());
                Rectangle r2 = new Rectangle(
                        in.nextInt(),
                        in.nextInt(),
                        in.nextInt(),
                        in.nextInt());
                Rectangle overlap = r1.overlap(r2);
                if(overlap == null){
                    results.add("No Overlap");
                } else {
                    results.add(String.format("%s %s %s %s",
                                    overlap.llx,
                                    overlap.lly,
                                    overlap.urx,
                                    overlap.ury));
                }

            }
            out.println(results.toString());
        }
    }

    static class Rectangle {
        private Integer llx;
        private Integer lly;
        private Integer urx;
        private Integer ury;

        public Rectangle(
                Integer llx,
                Integer lly,
                Integer urx,
                Integer ury) {
            this.llx = llx;
            this.lly = lly;
            this.urx = urx;
            this.ury = ury;
        }

        private Rectangle overlap(final Rectangle other){
            if(nooverlap(other)){
                return null;
            }
            List<Integer> xs = Arrays.asList(urx,llx,other.urx,other.llx);
            List<Integer> ys = Arrays.asList(ury,lly,other.ury,other.lly);
            Collections.sort(xs);
            Collections.sort(ys);
            return new Rectangle(xs.get(1), ys.get(1), xs.get(2), ys.get(2));
        }

        private boolean nooverlap(Rectangle other) {
            if(urx <= other.llx || other.urx <= llx) return true;
            if(ury <= other.lly || other.ury <= lly) return true;
            return false;
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
