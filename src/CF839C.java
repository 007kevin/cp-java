import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem CF839C
 */
@SuppressWarnings("unchecked")
public class CF839C {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            List<Set<Integer>> list = Stream
                    .generate(HashSet<Integer>::new).limit(n+1)
                    .collect(Collectors.toCollection(ArrayList::new));
            for(int i = 0; i < n-1; ++i){
                int a = in.nextInt();
                int b = in.nextInt();
                list.get(a).add(b);
                list.get(b).add(a);
            }
            Map<Integer,Double> E = new HashMap<>();
            dfs(new HashSet<>(), list,1,0,1,E);
            out.printf("%.8f", E.entrySet().stream()
                    .map(e->e.getKey()*e.getValue())
                    .reduce(0.0, (sum, value) -> sum+value));
        }

        private void dfs(
                Set<Integer> visited,
                List<Set<Integer>> list,
                int i,
                int l,
                double p,
                Map<Integer, Double> E) {
            boolean end = true;
            if(visited.contains(i)) return;
            int set = i==1?list.get(i).size() : list.get(i).size()-1;
            visited.add(i);
            for(int j : list.get(i)){
                if(!visited.contains(j)){
                    end=false;
                    dfs(visited,list,j,l+1,p*(1.0/set),E);
                }
            }
            if(end){
                // System.out.println("debug: " + l + " " + p);
                E.put(l, E.getOrDefault(l, 0.0) + p);
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
