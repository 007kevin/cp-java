import java.io.*;
import java.util.*;

/**
 * Problem Cf430B
 */
public class Cf430B {

    public void run() {
        int n = in.nextInt();
        int k = in.nextInt();
        int x = in.nextInt();
        int[] c = new int[n];
        for(int i = 0; i < n; ++i) c[i]=in.nextInt();
        int m = 0;
        for(int i = 0; i < n; ++i) m = Math.max(m,run(c,i,x));
        out.println(m);
    }

    int run(int[] c, int i, int k){
        if(c[i]!=k) return 0;
        int cnt = 0;
        int n = c.length;
        int j = i+1;
        while(0<=i && j<n){
            int subcnt = 0;
            int color = c[i];
            while(0 <= i && c[i]==color){
                subcnt++;
                i--;
            }
            while(j < n && c[j]==color){
                subcnt++;
                j++;
            }
            if(subcnt + (cnt==0?1:0) < 3) break;
            cnt+=subcnt;
        }
        return cnt;
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
        Cf430B task = new Cf430B(); task.run(); task.close();}
}
