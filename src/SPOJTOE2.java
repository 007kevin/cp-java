import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Problem SPOJTOE2
 */
@SuppressWarnings("unchecked")
public class SPOJTOE2 {
    public static char X = 'X';
    public static char O = 'O';
    public static char DOT = '.';

    static class Task extends IOHandler {
        public void run() {
            long time = System.currentTimeMillis();
            Set<Integer> possible = generate();
            out.println(System.currentTimeMillis() - time);
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
            while(true){
                String input = in.next();
                if(input.equals("end")) break;
                if(possible.contains(serialize(input))) out.println("valid");
                else out.println("invalid");
            }
        }

        private Set<Integer> generate() {
            Set<Integer> set = new HashSet<>();
            CharSequence[] grid = {
                new StringBuilder("..."),
                new StringBuilder("..."),
                new StringBuilder("...")};
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j < 3; ++j){
                    set(grid[i],j,X);
                    generate(set, grid, O, 1);
                    set(grid[i],j,DOT);
                }
            }
            return set;
        }

        private void generate(Set<Integer> set, CharSequence[] grid, char o, int c) {
            if(c > 5 && (full(grid) || hasWinner(grid))){
                set.add(serialize(grid));
                return;
            }
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j < 3; ++j){
                    if(notSet(grid[i],j)){
                        set(grid[i],j,o);
                        generate(set, grid, o==X?O:X, c+1);
                        set(grid[i],j,DOT);
                    }
                }
            }
        }

        private Integer serialize(CharSequence[] grid){
            return Objects.hash(
                    grid[0].charAt(0),
                    grid[0].charAt(1),
                    grid[0].charAt(2),
                    grid[1].charAt(0),
                    grid[1].charAt(1),
                    grid[1].charAt(2),
                    grid[2].charAt(0),
                    grid[2].charAt(1),
                    grid[2].charAt(2));
        }

        private Integer serialize(String grid){
            return Objects.hash(
                    grid.charAt(0),
                    grid.charAt(1),
                    grid.charAt(2),
                    grid.charAt(3),
                    grid.charAt(4),
                    grid.charAt(5),
                    grid.charAt(6),
                    grid.charAt(7),
                    grid.charAt(8));
        }        

        private void set(CharSequence line, int pos, char c){
            StringBuilder sb = (StringBuilder) line;
            sb.setCharAt(pos, c);
        }

        private boolean notSet(CharSequence line, int pos){
            return line.charAt(pos) == DOT;
        }
        
        private boolean hasWinner(CharSequence[] grid){
            char[][] cand = {
                {grid[0].charAt(0),grid[0].charAt(1),grid[0].charAt(2)},
                {grid[1].charAt(0),grid[1].charAt(1),grid[1].charAt(2)},
                {grid[2].charAt(0),grid[2].charAt(1),grid[2].charAt(2)},
                {grid[0].charAt(0),grid[1].charAt(1),grid[2].charAt(2)},
                {grid[0].charAt(2),grid[1].charAt(1),grid[2].charAt(0)},
                {grid[0].charAt(0),grid[1].charAt(0),grid[2].charAt(0)},
                {grid[0].charAt(1),grid[1].charAt(1),grid[2].charAt(1)},
                {grid[0].charAt(2),grid[1].charAt(2),grid[2].charAt(2)}
            };
            for(int i = 0; i < cand.length; ++i){
                if(cand[i][0]==X&&cand[i][1]==X&&cand[i][2]==X) return true;
                if(cand[i][0]==O&&cand[i][1]==O&&cand[i][2]==O) return true;
            }
            return false;
        }

        private boolean full(CharSequence[] grid){
            for(int i = 0; i < 3; ++i){
                for(int j = 0; j < 3; ++j)
                    if(grid[i].charAt(j) == DOT)
                        return false;
            }
            return true;
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
