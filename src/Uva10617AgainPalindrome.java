import java.io.*;
import java.util.*;

/**
 * Problem Uva10617AgainPalindrome
 */
public class Uva10617AgainPalindrome {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                String s = in.next();
                int n = s.length();
                out.println(find(new long[n][n], s.toCharArray(), 0, n-1));
            }
        }

        public long find(long[][] dp, char[] s, int i, int j){
            if(i==j) return 1;
            if(i>j) return 0;
            long cnt=0;
            if(s[i]==s[j]) cnt++;
            cnt+=find(dp,s,i+1,j-1);
            cnt+=find(dp,s,i+1,j);
            cnt+=Math.max(0,find(dp,s,i,j-1)-1);
            return cnt;
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
