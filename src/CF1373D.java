import java.io.*;
import java.util.*;

/**
 * Problem CF1373D
 */
@SuppressWarnings("unchecked")
public class CF1373D {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                long a[] = new long[n];
                long sum = 0;
                long fsum = 0;
                for(int i = 0; i < n; ++i){
                    a[i]=in.nextLong();
                    if(i%2==0)
                        sum+=a[i];
                    else
                        fsum+=a[i];
                }
                if(n==1){
                    out.println(sum);
                } else {
                    long ans=fsum;
                    long oans=fsum;
                    long d[] = new long[n/2];
                    for(int i = 0; i < n-1; i+=2){
                        d[i/2]+=a[i+1]-a[i];
                    }
                    long cur=d[0];
                    long max=d[0];
                    for(int i = 1; i < n/2; ++i){
                        if(cur<0) cur=0;
                        cur=cur+d[i];
                        if(cur<=0) cur=d[i]<0?0:d[i];
                        max=Math.max(max,cur);
                    }
                    ans=Math.max(ans, max>0?sum+max:sum);

                    long od[] = new long[n/2];
                    for(int i = 1; i < n-1; i+=2){
                        od[i/2]+=a[i]-a[i+1];
                    }
                    long ocur=od[0];
                    long omax=od[0];
                    for(int i = 1; i < n/2; ++i){
                        if(ocur<0) ocur=0;
                        ocur=ocur+od[i];
                        if(ocur<=0) ocur=od[i]<0?0:od[i];
                        omax=Math.max(omax,ocur);
                    }
                    oans=Math.max(oans, omax>0?omax+sum:sum);
                    out.println(ans>oans?ans:oans);
                }

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
