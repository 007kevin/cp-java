import java.io.*;
import java.util.*;

/**
 * Problem UVA10461Difference
 */
@SuppressWarnings("unchecked")
public class UVA10461Difference {

    static class Task extends IOHandler {
        public void run() {
            int CASE = 1;
            while(true){
                int v = in.nextInt();
                int e = in.nextInt();
                if(v==0&&e==0) break;
                out.println("Case #" + CASE++ + ":");
                Node[] jobs = new Node[v+1];
                Node[] reverseJobs = new Node[v+1];
                for(int i = 1; i <= v; ++i){
                    long time = in.nextLong();
                    jobs[i]=new Node(time);
                    reverseJobs[i]=new Node(time);
                }
                for(int i = 0; i < e; ++i){
                    int x = in.nextInt();
                    int y = in.nextInt();
                    jobs[y].dep.add(x);
                    reverseJobs[x].dep.add(y);
                }
                long total = 0;
                for(int i = 1; i <= v; ++i){
                    total+=jobs[i].time;
                }
                long[] minStart = new long[v+1];
                long[] maxStart = new long[v+1];
                for(int i = 1; i <= v; ++i){
                    minStart[i] = calculateMinStart(new HashSet<Integer>(),jobs, i) - jobs[i].time;
                    maxStart[i] = total - (calculateMinStart(new HashSet<Integer>(),reverseJobs, i));
                }
                int q = in.nextInt();
                while(q-->0){
                    int x = in.nextInt();
                    // out.println("total: " + total);
                    // out.println("min: " + minStart[x]);
                    // out.println("max: " + maxStart[x]);
                    out.println(Math.abs(maxStart[x]-minStart[x]));
                }
                out.println();
            }
        }

        private long calculateMinStart(Set<Integer> visited, Node[] jobs, int i) {
            if(visited.contains(i)) return 0;
            visited.add(i);
            long time = 0;
            for(Integer dep : jobs[i].dep){
                time+=calculateMinStart(visited, jobs, dep);
            }
            return time + jobs[i].time;
        }
    }

    static class Node {
        Set<Integer> dep;
        long time;
        public Node(final long time){
            this.time=time;
            dep=new HashSet<>();
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
