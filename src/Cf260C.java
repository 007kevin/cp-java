import java.io.*;
import java.util.*;

/**
 * Problem Cf260C
 */
public class Cf260C {

    public void run() {
        int n = in.nextInt();
        int x = in.nextInt() - 1;
        long[] a = new long[n];
        for(int i = 0; i < n; ++i){
            a[i]=in.nextLong();
        }
        int i = x;
        for(int j = prv(x,n); j != x; j=prv(j,n)){
            if(a[j]<a[i]){
                i=j;
            }
        }
        long s = a[i]*n;
        for(int j = prv(i,n); j!=i; j=prv(j,n)){
            a[j]-=a[i];
        }
        for(int j = x; j!=i; j=prv(j,n)){
            s++;
            a[j]--;
        }
        a[i]=s;
        for(long num : a){
            out.print(num + " ");
        }
        out.println();
    }

    int prv(int i, int n){
        return i-1 < 0 ? n-1 : i-1;
    }

    int nxt(int i, int n){
        return i%n;
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
        Cf260C task = new Cf260C(); task.run(); task.close();}
}
