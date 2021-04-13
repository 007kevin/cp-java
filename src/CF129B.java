import java.io.*;
import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Problem CF129B
 */
@SuppressWarnings("unchecked")
public class CF129B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            List<Set<Integer>> club = Stream
                    .generate(HashSet<Integer>::new)
                    .limit(n+1)
                    .collect(Collectors.toList());
            for(int i = 0; i < m; ++i){
                int a = in.nextInt();
                int b = in.nextInt();
                club.get(a).add(b);
                club.get(b).add(a);
            }
            // for(int i = 1; i < n; ++i){
            //     out.print(i + " Adj: ");
            //     for(Integer adj : club.get(i)){
            //         out.print(adj + " " );
            //     }
            //     out.println();
            // }

            int kickOutGroups = 0;
            while(kickOut(club)){
                kickOutGroups++;
            }
            out.println(kickOutGroups);
        }

        private boolean kickOut(List<Set<Integer>> club) {
            // out.println("TURN");
            boolean kickedOut = false;
            Set<Integer> visited = new HashSet<>();
            Set<Integer> toRemove = new HashSet<>();
            for(Integer i = 1; i < club.size(); ++i){
                if(!visited.contains(i))
                    kickedOut = bfs(visited, toRemove, club, i) || kickedOut;
            }
            // out.print("toRemove: ");
            for(Integer r : toRemove){
                // out.print(r + " ");
                club.get(r).clear();
                for(Integer i = 1; i < club.size(); ++i){
                    club.get(i).remove(r);
                }
            }
            // out.println();
            return kickedOut;
        }

        private boolean bfs(Set<Integer> visited, Set<Integer> toRemove, List<Set<Integer>> club, Integer start) {
            Queue<Integer> Q = new LinkedList<>();
            boolean removed = false;
            Q.add(start);
            visited.add(start);
            while(!Q.isEmpty()){
                Integer i = Q.remove();
                if(club.get(i).size() == 1){
                    toRemove.add(i);
                    removed = true;
                }
                for(Integer adj : club.get(i)){
                    if(!visited.contains(adj)){
                        visited.add(adj);
                        Q.add(adj);
                    }
                }
            }
            return removed;
        }

    }

    static class Student {
        Set<Integer> adj;
        boolean kickedOut = false;
        public void add(Integer i){
            adj.add(i);
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
