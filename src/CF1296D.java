import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Problem CF1296D.java
 */
@SuppressWarnings("unchecked")
public class CF1296D {

    static class Task extends IOHandler {
        public void run() {
            int n=in.nextInt();
            long a=in.nextLong(), b=in.nextLong(), k=in.nextLong();
            long h[] = new long[n];
            for(int i = 0; i < n; ++i)
                h[i]=in.nextLong();
            List<Pair<Long,Long>> list = Arrays.stream(h)
                    .boxed()
                    .map(p->f(p,a,b))
                    .collect(Collectors.toList());
            long ans=0;
            // for(int i = 0; i < n; ++i){
            //     out.println(h[i] + ":\t" + list.get(i).toString());
            // }
            Collections.sort(list);
            for(var pair:list){
                if (pair.b==1){
                    ans++;
                } else {
                    if(k-pair.a>=0){
                        ans++;
                        k-=pair.a;
                    }
                }
            }
            out.println(ans);
        }

        private Pair<Long,Long> f(Long p, long a, long b) {
            Long sum = a+b;
            Long rem = p-(p/sum)*sum;
            if (rem==0) return new Pair<>(ceil(b,a),0L);
            if (rem<=a) return new Pair<>(0L,1L);
            return new Pair<>(ceil(rem-a,a),0L);
        }

        private Long ceil(long x,long y) {
            return (x+y-1)/y;
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
