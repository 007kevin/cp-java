import java.io.*;
import java.util.*;

/**
 * Problem SPOJTOE1
 */
@SuppressWarnings("unchecked")
class Main {
    public static char X = 'X';
    public static char O = 'O';

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            while(n-->0){
                String[] grid = new String[3];
                grid[0]=in.next();
                grid[1]=in.next();
                grid[2]=in.next();
                int o=0;
                int x=0;
                for(int i = 0; i < 3; ++i){
                    for(int j = 0; j < 3; ++j){
                        if(grid[i].charAt(j) == X) x++;
                        if(grid[i].charAt(j) == O) o++;
                    }
                }
                if(didWin(grid, X) && !didWin(grid, O) && x-o==1) out.println("yes");
                else if (didWin(grid, O) && !didWin(grid, X) && x==o) out.println("yes");
                else if (!didWin(grid, X) && !didWin(grid, O) && x-o <= 1) out.println("yes");
                else out.println("no");
            }
        }

        private boolean didWin(String[] grid, char V) {
            String line = ""+V+V+V;
            if(grid[0].equals(line)) return true;
            if(grid[1].equals(line)) return true;
            if(grid[2].equals(line)) return true;
            if(grid[0].charAt(0) == V &&
                    grid[1].charAt(1) == V &&
                    grid[2].charAt(2) == V) return true;
            if(grid[0].charAt(2) == V &&
                    grid[1].charAt(1) == V &&
                    grid[2].charAt(0) == V) return true;
            return false;
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
