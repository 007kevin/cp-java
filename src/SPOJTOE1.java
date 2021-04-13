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
            Set<CharSequence> possible = generate();
            // out.println(hasWinner(new CharSequence[] {
            //                     "1X3",
            //                     "4X6",
            //                     "7X9"
            //                 }));
            // for(var p : possible) {
            //     out.println(p.subSequence(0, 3));
            //     out.println(p.subSequence(3, 6));
            //     out.println(p.subSequence(6, 9));
            //     out.println();
            // }
            // out.println(possible.size());
            while(n-->0){
                CharSequence[] grid = new CharSequence[3];
                grid[0]=in.next();
                grid[1]=in.next();
                grid[2]=in.next();
                if(possible.contains(serialize(grid))) out.println("yes");
                else out.println("no");
            }
        }

        private Set<CharSequence> generate() {
            Set<CharSequence> set = new HashSet<>();
            CharSequence[] grid = {
                new StringBuilder("..."),
                new StringBuilder("..."),
                new StringBuilder("...")};
            set.add(serialize(grid));
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j < 3; ++j){
                    set(grid[i],j,X);
                    generate(set, grid, O);
                    set(grid[i],j,DOT);
                }
            }
            return set;
        }

        private void generate(Set<CharSequence> set, CharSequence[] grid, char o) {
            if(hasWinner(grid)){
                set.add(serialize(grid));
                return;
            }
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j < 3; ++j){
                    if(notSet(grid[i],j)){
                        set(grid[i],j,o);
                        generate(set, grid, o==X?O:X);
                        set(grid[i],j,DOT);
                    }
                }
            }
            set.add(serialize(grid));
        }

        private String serialize(CharSequence[] grid){
            return grid[0].toString()+grid[1].toString()+grid[2].toString();
        }

        private void set(CharSequence line, int pos, char c){
            StringBuilder sb = (StringBuilder) line;
            sb.setCharAt(pos, c);
        }

        private boolean notSet(CharSequence line, int pos){
            return line.charAt(pos) == DOT;
        }
        
        private boolean hasWinner(CharSequence[] grid){
            CharSequence[] cand = {
                grid[0].toString(),
                grid[1].toString(),
                grid[2].toString(),
                ""+grid[0].charAt(0)+grid[1].charAt(1)+grid[2].charAt(2),
                ""+grid[0].charAt(2)+grid[1].charAt(1)+grid[2].charAt(0),
                ""+grid[0].charAt(0)+grid[1].charAt(0)+grid[2].charAt(0),
                ""+grid[0].charAt(1)+grid[1].charAt(1)+grid[2].charAt(1),
                ""+grid[0].charAt(2)+grid[1].charAt(2)+grid[2].charAt(2)
            };
            for(CharSequence c : cand){
                if(c.equals("XXX") || c.equals("OOO"))
                    return true;
            }
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
