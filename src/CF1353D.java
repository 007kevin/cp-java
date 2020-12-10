import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

/**
 * Problem CF1353D
 */
@SuppressWarnings("unchecked")
public class CF1353D {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t--!=0){
                int n = in.nextInt();
                int[] a = new int[n];
                var pq = new PriorityQueue<Pair<Integer,Integer>>(10, (x,y) -> {
                    int lenx = x.b-x.a;
                    int leny = y.b-y.a;
                    if(lenx==leny){
                        if (x.a < y.a) return -1;
                        else return 1;
                    }
                    if(lenx>leny) return -1;
                    return 1;
                });
                pq.add(new Pair<>(0,n));
                int i = 1;
                while(!pq.isEmpty()){
                    var v = pq.poll();
                    var s = v.a+v.b;
                    var m = s%2==0?(s-1)/2:s/2;
                    a[m]=i++;
                    if(v.a!=m) pq.add(new Pair<>(v.a,m));
                    if(m+1!=v.b) pq.add(new Pair<>(m+1, v.b));
                }
                for(int j = 0; j < n; ++j)
                    out.print(a[j] + " ");
                out.println();
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
        public PrintWriter out = new PrintWriter(System.out);

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

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
