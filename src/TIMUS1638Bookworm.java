import java.io.*;
import java.util.*;

/**
 * Problem TIMUS1638Bookworm
 */
@SuppressWarnings("unchecked")
public class TIMUS1638Bookworm {

    static class Task extends IOHandler {
        public void run() {
            int volumeThickness = in.nextInt();
            int coverThickness = in.nextInt();
            List<Book> shelf = new ArrayList<>();
            for(int i = 0; i <= 100; ++i){
                shelf.add(new Book(volumeThickness, coverThickness));
            }
            int start = in.nextInt();
            int end = in.nextInt();
            if(start == end){
                out.println(volumeThickness);
            } else if (start < end){
                int len = shelf.get(start).startThenGoRightLength();
                for(int i = start + 1; i < end; ++i){
                    len+=shelf.get(i).getLength();
                }
                len+=shelf.get(end).endFromLeftLength();
                out.println(len);
            } else {
                int len = shelf.get(start).startThenGoLeftLength();
                for(int i = start -1; i > end; --i){
                    len+=shelf.get(i).getLength();
                }
                len+=shelf.get(end).endFromRightLength();
                out.println(len);
            }

        }
    }

    static class Book {
        private int volumeThickness;
        private int coverThickness;

        public Book(int volumeThickness, int coverThickness){
            this.volumeThickness = volumeThickness;
            this.coverThickness = coverThickness;
            
        }

        int getLength(){
            return coverThickness + volumeThickness + coverThickness;
        }

        int startThenGoLeftLength() {
            return coverThickness + volumeThickness;
        }

        int startThenGoRightLength() {
            return coverThickness;
        }

        int endFromLeftLength() {
            return coverThickness;
        }

        int endFromRightLength() {
            return coverThickness + volumeThickness;
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
