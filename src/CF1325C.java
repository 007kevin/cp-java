import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem CF1325C
 */
@SuppressWarnings("unchecked")
public class CF1325C {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            List<Edge> list = Stream
                    .generate(() -> new Edge(in.nextInt(), in.nextInt())).limit(n-1)
                    .collect(Collectors.toCollection(ArrayList::new));
            List<Set<Integer>> vertices = Stream
                    .generate(HashSet<Integer>::new).limit(n+1)
                    .collect(Collectors.toCollection(ArrayList::new));
            for(var e : list){
                vertices.get(e.v1).add(e.v2);
                vertices.get(e.v2).add(e.v1);
            }
            int l=0;
            for(int v1 = 1; v1 <= n; ++v1){
                if(vertices.get(v1).size()>2){
                    for(var e : list){
                        if(e.v1==v1||e.v2==v1){
                            e.label=l++;
                        }
                    }
                    break;
                }
            }
            for(var e : list){
                if(e.label==-1)
                    e.label=l++;
            }
            list.stream().forEach(e->out.println(e.label));
        }
    }

    static class Edge {
        private int v1;
        private int v2;
        private int label=-1;
        public Edge(int v1, int v2) {
            this.v1 = v1;
            this.v2 = v2;
        }
        public void setLabel(int label){
            this.label = label;
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

        public int[] nextInts(int n) {
            int a[] = new int[n];
            for(int i = 0; i < n; ++i)
                a[i] = nextInt();
            return a;
        }

        public long nextLong() {
            return Long.parseLong(next());
        }

        public long[] nextLongs(int n) {
            long a[] = new long[n];
            for(int i = 0; i < n; ++i)
                a[i] = nextLong();
            return a;
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
