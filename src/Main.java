import java.io.*;
import java.util.*;

/**
 * Problem SPOJPOSTERIN
 */
@SuppressWarnings("unchecked")
class Main {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            List<Building> list = new ArrayList<>();
            for(int i = 0; i < n; ++i){
                list.add(new Building(in.nextInt(), in.nextInt()));
            }
            int ans = 1;
            Stack<Integer> stack = new Stack<>();
            stack.add(list.get(0).w);
            for(int i = 0; i < n-1; ++i){
                int a = list.get(i).w;
                int b = list.get(i+1).w;
                if(a<b){
                    stack.push(b);
                } else if (a>b){
                    while(!stack.isEmpty() && stack.peek() > b){
                        ans++;
                        stack.pop();
                    }
                    if(stack.isEmpty() || stack.peek() != b)
                        stack.push(b);
                }
            }
            if(!stack.isEmpty()) ans += stack.size()-1;

            out.println(ans);
        }
    }

    static class Building {
        private int d;
        private int w;

        public Building(int d, int w){
            this.d = d;
            this.w = w;
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
