import java.io.*;
import java.util.*;

/**
 * Problem UVA713
 */
@SuppressWarnings("unchecked")
public class UVA713 {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                Number A = new Number(in.next());
                Number B = new Number(in.next());
                out.println(A.reverse().add(B.reverse()).reverse().toString());
            }
        }
    }

    static class Number {
        List<Integer> num;
        public Number(String str){
            num = new ArrayList<>();
            for(int i = 0; i < str.length(); ++i){
                num.add(str.charAt(i) - '0');
            }
        }
        public Number reverse(){
            while(!num.isEmpty() && num.get(num.size()-1) == 0){
                num.remove(num.size()-1);
            }
            Collections.reverse(num);
            return this;
        }

        public Number add(Number other){
            int size = this.num.size() > other.num.size() ?
                    this.num.size() : other.num.size();
            int[] a = new int[size];
            int[] b = new int[size];
            int[] c = new int[size+1];
            for(int i = this.num.size()-1; i >= 0; --i){
                a[this.num.size()-1 - i] = this.num.get(i);
            }
            for(int i = other.num.size()-1; i >= 0; --i){
                b[other.num.size()-1 - i] = other.num.get(i);
            }
            for(int i = 0; i < size; ++i){
                int value = a[i]+b[i]+c[i];
                c[i] = value%10;
                c[i+1] = value/10;
            }
            String ans = c[size]==0 ? "" : "1";
            for(int i = size-1; i >= 0; --i){
                ans+=String.valueOf(c[i]);
            }
            return new Number(ans);
        }

        public String toString() {
            String s = "";
            for(Integer n : num){
                s+=String.valueOf(n);
            }
            return s;
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
