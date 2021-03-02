import java.io.*;
import java.util.*;
import java.util.stream.Stream;
/**
 * Problem CF1374E1
 */
@SuppressWarnings("unchecked")
public class CF1374E1 {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int k = in.nextInt();
            List<Long> b11 = new ArrayList<>(); b11.add(0L);
            List<Long> b10 = new ArrayList<>(); b10.add(0L);
            List<Long> b01 = new ArrayList<>(); b01.add(0L);
            for(int i = 0; i < n; ++i){
                Long t = in.nextLong();
                Long a = in.nextLong();
                Long b = in.nextLong();
                if(a==1&b==1)
                    b11.add(t);
                else if(a==1)
                    b10.add(t);
                else if(b==1)
                    b01.add(t);
            }
            if(b11.size()+b10.size()-2<k||b11.size()+b01.size()-2<k){
                out.println(-1);
                return;
            }
            Collections.sort(b11);
            Collections.sort(b10);
            Collections.sort(b01);
            for(int i = 1; i < b11.size(); ++i) b11.set(i, b11.get(i)+b11.get(i-1));
            for(int i = 1; i < b10.size(); ++i) b10.set(i, b10.get(i)+b10.get(i-1));
            for(int i = 1; i < b01.size(); ++i) b01.set(i, b01.get(i)+b01.get(i-1));

            Long ans = Long.MAX_VALUE;
            for(int i = 0; i < b11.size(); ++i) {
                int j = k-i;
                if(j>=0&&j<b01.size() && j < b10.size()){
                    ans=Math.min(ans, b11.get(i) + b10.get(j) + b01.get(j));
                }
            }
            out.println(ans);
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
