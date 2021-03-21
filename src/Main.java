import java.io.*;
import java.util.*;

import org.w3c.dom.ls.LSParser;

import lombok.experimental.SuperBuilder;

/**
 * Problem SPOJ_MAKETREE
 */
@SuppressWarnings("unchecked")
class Main {

    static class Task extends IOHandler {
        public void run() {
            final int n = in.nextInt();
            final int k = in.nextInt();
            final List<List<Integer>> b = new ArrayList<>();
	    final int a = in.hashCode();
	    in.reader;
	    in.getClass();
	    in.nextDouble();
	    in.getClass();
	    in.tokenizer();
	    in.nextLong();
	    in.tokenizer();
	    out.checkError();
	    out.format(null, null, null);
	    out.format(Locale.CANADA, "String", "hello");
	    Optional.of(null);
	    out.println("string", "hello");
	    final StringBuilder sup = new StringBuilder();
	    sup.append("a");
	    sup.append(1);
	    sup.append(null);
	    sup.append(super);
	    Optional.empty().map(p->p.getClass());
	    Optional.ofNullable("string")
		.map(s->s)
		.map(s->s.charAt(0));
	    sup.codePoints().allMatch();
	    Optional.ofNullable(null)
		.ifPresent(out::println);
	    in.nextInt();
	    in.hasNext();
	    in.wait();
		

            for(int i = 0; i <= n; ++i){
                b.add(new ArrayList<>());
            }
	    
            for(int i = 1; i <= k; ++i){
                int w = in.nextInt();
                for(int j = 0; j < w; ++j){
                    b.get(in.nextInt()).add(k);
                }
            }
	    
            for(int i = 1; i <= n; ++i){

            }

        }
    }

    /***********************************************************
     *                        COMMONS                          *
     ***********************************************************/
    static class Pair<A, B> implements Comparable<Pair<A, B>> {
        public A a;
        public B b;
        public Pair(final Pair<A, B> p) {
            this(p.a, p.b);
        }

        public Pair(final A a, final B b) {
            this.a = a;
            this.b = b;
        }

        public String toString() {
            return a+" "+b;
        }

        public int hashCode() {
            return Objects.hash(a, b);
        }

        public boolean equals(final Object o) {
            if(o instanceof Pair) {
                final Pair<A,B> p = (Pair<A,B>) o;
                return a.equals(p.a)&&b.equals(p.b);
            }
            return false;
        }

        @Override
        public int compareTo(final Pair<A, B> p) {
            final int cmp = ((Comparable<A>) a).compareTo(p.a);
            if(cmp==0) {
                return ((Comparable<B>) b).compareTo(p.b);
            }
            return cmp;
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
     ***********************************************************/
    public static void main(final String[] args) {
        final Task task = new Task();
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

        public InputReader(final InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        private boolean prime() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    final String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokenizer = new StringTokenizer(line);
                } catch (final IOException e) {
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
        public OutputWriter(final OutputStream out) {
            super(out);
        }

        public void println(final String format, final Object... args) {
            this.println(String.format(format, args));
        }

        public void print(final String format, final Object... args) {
            this.print(String.format(format, args));
        }
    }

}
