import java.io.*;
import java.util.*;

/**
 * Problem UVA352
 */
@SuppressWarnings("unchecked")
public class UVA352 {

    static class Task extends IOHandler {
        private static int[][] POS = new int[][]{{-1,-1},{-1,0},{-1,1},{0,1},{1,1},{1,0},{1,-1},{0,-1}};

        public void run() {
            int imageNumber = 0;
            while(in.hasNext()) {
                imageNumber++;
                int n = in.nextInt();
                int[][] image = new int[n][n];
                for(int i = 0; i < n; ++i) {
                    String row = in.next();
                    for(int j = 0; j < n; ++j){
                        image[i][j]=row.charAt(j) == '0' ? 0 : 1;
                    }
                }
                int count = 0;
                for(int i = 0; i < n; ++i){
                    for(int j = 0; j < n; ++j){
                        if(containsWarEagle(image,i,j)){
                            count++;
                        }
                    }
                }
                out.println(String.format("Image number %s contains %s war eagles.", imageNumber, count));
            }
        }

        private boolean containsWarEagle(int[][] image, int i, int j) {
            if(image[i][j] == 0){
                return false;
            }
            traverseWarEagle(image,i,j);
            return true;
        }

        private void traverseWarEagle(int[][] image, int i, int j) {
            int n = image.length;
            if(i<0||j<0||i>=n||j>=n) return;
            if(image[i][j] == 0) return;
            image[i][j]=0;
            for(int[] p : POS){
                traverseWarEagle(image, i+p[0], j+p[1]);
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
