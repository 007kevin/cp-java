import java.io.*;
import java.util.*;

/**
 * Problem CF977E
 */
@SuppressWarnings("unchecked")
public class CF977E {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            var v = new ArrayList<Set<Integer>>();
            for(int i = 0; i < n+1; ++i) v.add(new HashSet<>());
            for(int i = 0; i < m; ++i) {
                int a = in.nextInt();
                int b = in.nextInt();
                v.get(a).add(b);
                v.get(b).add(a);
            }
            int cnt=0;
            Set<Integer> visited = new HashSet<>();
            for(int i = 1; i <= n; ++i){
                if(!visited.contains(i) && isCyclic(new HashSet<>(), v, i))
                    cnt++;
                markVisited(visited, v, i);
            }
            out.println(cnt);
        }

        public boolean isCyclic(Set<Integer> visited, ArrayList<Set<Integer>> v, int i) {
            if(visited.contains(i)) return true;
            visited.add(i);
            if(v.get(i).size()!=2) return false;
            for(int j : v.get(i))
                if(i!=j && !isCyclic(visited, v, j))
                    return false;
            return true;
        }

        public void markVisited(Set<Integer> visited, ArrayList<Set<Integer>> v, int i){
            if(visited.contains(i)) return;
            visited.add(i);
            for(int j : v.get(i))
                markVisited(visited, v, j);
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
