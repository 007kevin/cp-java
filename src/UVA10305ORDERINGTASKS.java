import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem UVA10305ORDERINGTASKS
 */
@SuppressWarnings("unchecked")
public class UVA10305ORDERINGTASKS {

    static class Task extends IOHandler {
        public void run() {
            while(true){
                int n = in.nextInt();
                int m = in.nextInt();
                if(n==0&&m==0) break;

                List<List<Integer>> tasks = Stream.generate(ArrayList<Integer>::new)
                        .limit(n+1)
                        .collect(Collectors.toList());
                while(m-->0){
                    int i = in.nextInt();
                    int j = in.nextInt();
                    tasks.get(i).add(j);
                }
                StringJoiner joiner = new StringJoiner(" ");
                new TopologicalSorter(tasks).getResult()
                        .stream()
                        .map(String::valueOf)
                        .forEach(joiner::add);
                out.println(joiner.toString());
            }
        }
    }

    static class TopologicalSorter {
        private Set<Integer> visited = new HashSet<>();
        private List<Integer> result = new ArrayList<>();
        private List<List<Integer>> adj;

        public TopologicalSorter(List<List<Integer>> adj){
            this.adj = adj;
            for(int i = 1; i < adj.size(); ++i){
                dfs(i);
            }
            Collections.reverse(result);
        }

        public List<Integer> getResult() {
            return this.result;
        }


        private void dfs(Integer i){
            if(visited.contains(i)) return;
            visited.add(i);
            for(Integer a : adj.get(i)){
                dfs(a);
            }
            result.add(i);
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
