import java.io.*;
import java.util.*;

/**
 * Problem CF141B
 */
public class CF141B {

    static class Task extends IOHandler {
        public void run() {
            long a = in.nextLong();
            long x = in.nextLong();
            long y = in.nextLong();
            if(!(-a<x&&x<a)){
                out.println(-1);
                return;
            }
            if(y%a==0) {
                out.println(-1);
                return;
            }
            if((-(a+1)/2<x&&x<(a+1)/2)&&y<a) {
                out.println(1);
                return;
            }
            if(((y-a)/a)%2==0){
                if(!(-(a+1)/2<x&&x<(a+1)/2)){
                    out.println(-1);
                    return;
                }
                out.println(block(a,x,y));
                return;
            } else {
                if(x==0){
                    out.println(-1);
                    return;
                }
                out.println(block(a,x,y));
                return;
            }
        }

        private long block(long a, long x, long y) {
            if (((y-a)/a)%2==0){
                return 1 + ((y-a)/a) + 1 + ((y-a)/a)/2;
            } else {
                boolean left = x<0;
                return 1 + ((y-a)/a) + 1 + ((y-a)/a)/2 + (left?0:1);
            }

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
        public PrintWriter out = new PrintWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
}
