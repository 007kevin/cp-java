import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Problem CF1457C
 */
@SuppressWarnings("unchecked")
public class CF1457C {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n=in.nextInt();
                int p=in.nextInt();
                int k=in.nextInt();
                int a[] = extract(in.next());
                int x=in.nextInt();
                int y=in.nextInt();
                int shift[] = new int[k];
                for(int i = p-1; i < n; ++i){
                    shift[(i-p+1)%k]+=a[i]==0?1:0;
                }
                long ans=Long.MAX_VALUE;
                for(int i = n-1; i >= p-1; --i){
                    int sh = n-1-i;
                    // out.println(String.format(
                    //         "i:%s,sh:%s,shift=%s, ans:%s",
                    //         i,
                    //         sh,
                    //         shift[sh%k],
                    //         y*sh + x*(shift[sh%k])));
                    ans=Math.min(ans, y*sh + x*(shift[sh%k]));
                    shift[sh%k]-=a[sh+p-1]==0?1:0;
                }
                out.println(ans);
            }
        }

        private int[] extract(String next) {
            int a[] = new int[next.length()];
            for(int i = 0; i < next.length(); ++i)
                a[i]=next.charAt(i)-'0';
            return a;
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
