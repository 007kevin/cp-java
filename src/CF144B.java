import java.io.*;
import java.util.*;
import java.util.function.BiConsumer;

/**
 * Problem CF144B
 */
public class CF144B {

    static class Task extends IOHandler {
        public void run() {
            Table table = new Table(
                    in.nextInt() + 1000,
                    in.nextInt() + 1000,
                    in.nextInt() + 1000,
                    in.nextInt() + 1000);
            int n = in.nextInt();
            List<Radiator> list = new ArrayList<>();
            for(int i = 0; i < n; ++i){
                list.add(new Radiator(
                        in.nextInt() + 1000,
                        in.nextInt() + 1000,
                        in.nextInt()));
            }
            MutableInt ans = new MutableInt(0);
            table.iterateEdge((x,y) -> {
                boolean reaches = false;
                for(Radiator r : list){
                    if(r.reaches(x, y)){
                        reaches = true;
                    };
                }
                if(!reaches) ans.increment();
            });
            out.println(ans.get());
        }
    }

    static class Table {
        private int xa;
        private int ya;
        private int xb;
        private int yb;

        public Table(int xa, int ya, int xb, int yb){
            this.xa = Math.min(xa, xb);
            this.ya = Math.min(ya, yb);
            this.xb = Math.max(xa, xb);
            this.yb = Math.max(ya, yb);
        }

        public void iterateEdge(BiConsumer<Integer,Integer> biConsumer){
            for(int i = xa; i < xb; ++i){
                biConsumer.accept(i,ya);
            }
            for(int i = ya; i < yb; ++i){
                biConsumer.accept(xb, i);
            }
            for(int i = xb; i > xa; --i){
                biConsumer.accept(i, yb);
            }
            for(int i = yb; i > ya; --i){
                biConsumer.accept(xa,i);
            }
        }
    }


    static class Radiator {
        private int x;
        private int y;
        private int r;

        public Radiator(int x, int y, int r){
            this.x = x;
            this.y = y;
            this.r = r;
        }

        public boolean reaches (int x, int y){
            return distance(x, y) <= (double) r;
        }

        private double distance(int x, int y){
            double v1 = Math.abs(this.x-x);
            double v2 = Math.abs(this.y-y);
            return Math.sqrt(v1*v1 + v2*v2);
        }
    }

    static class MutableInt {
            int internal;
            public MutableInt(int value){
                internal=value;
            }

            public void increment(){
                internal++;
            }

            public int get(){
                return internal;
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
        public void cleanup() {out.close();}
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
                } catch (IOException e) {throw new RuntimeException(e);}
            }
            return true;
        }
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokenizer.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {super(out);}
        public void println(String format, Object... args) {
            this.println(String.format(format, args));}
        public void print(String format, Object... args) {
            this.print(String.format(format, args));}
    }
}
