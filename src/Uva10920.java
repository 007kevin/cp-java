import java.io.*;
import java.util.*;

/**
 * Problem Uva10920
 */
public class Uva10920 {

    public void run() {
        while(true){
            long b = in.nextLong();
            long p = in.nextLong();
            if(b==0&&p==0) {
                return;
            }
            if(p==1) print(b/2+1,b/2+1);
            else {
                long ring = 1l;
                long i = 3l;
                for(; i*i < p; i+=2){
                    if(p<=i*i) break;
                    ring++;
                }
                long size = (i*i) - ((i-2)*(i-2));
                long len = (size+4l)/4l;

                if(i*i - len+1 <= p){
                    long col = (b/2+1)+ring;
                    long row = (b/2+1)-ring;
                    for(long j = i*i - len+1; j< p; ++j){
                        row++;
                    }
                    print(row, col);
                    continue;
                }

                if(i*i - 2*len + 2 <= p){
                    long col = (b/2+1)-ring;
                    long row = (b/2+1)-ring;
                    for(long j = i*i - 2*len + 2; j < p; ++j){
                        col++;
                    }
                    print(row, col);
                    continue;
                }

                if(i*i - 3*len + 3 <= p){
                    long col = (b/2+1)-ring;
                    long row = (b/2+1)+ring;
                    for(long j = i*i - 3*len + 3; j < p; ++j){
                        row--;
                    }
                    print(row, col);
                    continue;
                }

                if(i*i - 3*len + 3 - (len - 2) <= p){
                    long col = (b/2+1)+ring - 1;
                    long row = (b/2+1)+ring;
                    for(long j = i*i - 3*len + 3 - (len - 2); j < p; ++j){
                        col--;
                    }
                    print(row, col);
                    continue;
                }                
            }
        }
    }

    public void print(long l, long c){
        out.println(String.format("Line = %s, column = %s.", l, c));
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public InputReader in = new InputReader(System.in);
    public PrintWriter out = new PrintWriter(System.out);
    public void close() {out.close();}
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokens = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);}
        private boolean prime() {
            while (tokens == null || !tokens.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokens = new StringTokenizer(line);
                } catch (IOException e) {throw new RuntimeException(e);}
            } return true;}
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokens.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
    public static void main(String[] args) {
        Uva10920 task = new Uva10920(); task.run(); task.close();}
}
