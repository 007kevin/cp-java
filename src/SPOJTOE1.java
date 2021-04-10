import UVA11953.Task.Grid;

import java.io.*;
import java.util.*;

/**
 * Problem SPOJTOE1
 */
@SuppressWarnings("unchecked")
public class SPOJTOE1 {
    public static char X = 'X';
    public static char O = 'O';
    public static char DOT = '.';

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            Set<String> possible = generate();
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
            }
        }

        private Set<String> generate() {
            Set<String> set = new HashSet<>();
            CharSequence[] grid = {
                new StringBuilder("..."),
                new StringBuilder("..."),
                new StringBuilder("...")};
            set.add(serialize(grid));
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j < 3; ++j){
                    set(grid[i],j,X);
                    generate(set, grid, O);
                    set(grid[i],j,dot);
                }
            }
        }

        private void generate(Set<String> set, CharSequence[] grid, char o) {

        }

        private String serialize(CharSequence[] grid){
            return grid[0].toString()+grid[1].toString()+grid[2].toString();
        }

        private void set(CharSequence line, int pos, char c){
            StringBuilder sb = (StringBuilder) line;
            sb.setCharAt(pos, c);
        }

        private boolean hasWinner(CharSequence[] grid){
            
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
