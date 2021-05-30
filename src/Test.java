import java.io.*;
import java.util.*;

/**
 * Problem Test
 */
public class Test {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                out.println(solve(in.nextInt(), in.nextInt(), in.next()));
            }
        }
        public String solve(int n, int k, String s){
            // Write your code here
            long[] l = new long[n];
            long[] r= new long[n];
            long deno = (long)n* (long) n;
            l[0]=get(s,0);
            for(int i = 1; i < n; ++i){
                l[i]=get(s,i)+l[i-1];
            }
            r[n-1]=get(s,n-1);
            for(int i = n-2; i >= 0; --i){
                r[i]=get(s,i)+r[i+1];
            }
            long cnt = 0;
            for(int i = 0; i < n; ++i){
                if(get(s,i)==1){
                    cnt++;
                    if(i>0) cnt+=l[i-1];
                    if(i<n-1) cnt+=r[i+1];
                    if(i-k>0) cnt-=l[i-k-1];
                    if(i+k<n-1) cnt-=r[i+k+1];
                }
            }
            if(cnt==0l){
                return "0/1";
            }
            long gcd = gcd(cnt, deno);
            return String.format("%s/%s", cnt/gcd, deno/gcd);
        }

    
        public static int get(String s, int i){
            return s.charAt(i)=='1'?1:0;
        }
    
        public static long gcd(long a, long b){
            if(a%b==0) return b;
            return gcd(b,a%b);
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public static void main(String[] args) {
        Task task = new Task(); task.run(); task.close();}
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void close() {out.close();}}
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
}
