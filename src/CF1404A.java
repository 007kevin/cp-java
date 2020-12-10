import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Objects;
import java.util.StringTokenizer;
import java.util.stream.Stream;

/**
 * Problem CF1404A
 */
@SuppressWarnings("unchecked")
public class CF1404A {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t--!=0){
                int n = in.nextInt();
                int k = in.nextInt();
                Character[] s = new Character[n];
                String str = in.next();
                for(int i = 0; i < n; ++i)
                    s[i]=str.charAt(i);
                Character[] a = new Character[k];
                for(int i = 0; i < n; ++i){
                    a[i%k]=resolve(a[i%k],s[i]);
                }
                // for(int i = 0; i < k; ++i){
                //     out.print(a[i]);
                // }
                // out.println();
                if (Stream.of(a).anyMatch(c->c=='\0')){
                    out.println("NO");
                } else {
                    int ones=0;
                    int zeros=0;
                    int qs=0;
                    for(int i = 0; i < k; ++i){
                        if (a[i]=='0') zeros++;
                        if (a[i]=='1') ones++;
                        if (a[i]=='?') qs++;
                    }
                    if(Math.abs(ones-zeros) <= qs)
                        out.println("YES");
                    else
                        out.println("NO");
                }

            }
        }

        private Character resolve(Character a, Character b) {
            if (a==null || a == '?') return b;
            if (b=='?') return a;
            if (a!=b) return '\0';
            return b;
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
