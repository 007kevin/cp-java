import java.io.*;
import java.util.*;

/**
 * Problem Cf979B
 */
public class Cf979B {

    public void run() {
        long n = in.nextLong();
        String Kuro = in.next();
        String Shiro = in.next();
        String Katie = in.next();
        long p1 = pts(Kuro,n);
        long p2 = pts(Shiro,n);
        long p3 = pts(Katie,n);
        if(draw(p1,p2,p3)) out.println("Draw");
        else out.println(winner(p1,p2,p3));
    }

    boolean draw(long p1, long p2, long p3){
        long[] a = new long[]{p1,p2,p3};
        Arrays.sort(a);
        return a[1]==a[2];
    }

    String winner(long p1, long p2, long p3) {
        Map<Long, String> map = new HashMap<>() {{
                put(p1, "Kuro");
                put(p2, "Shiro");
                put(p3, "Katie");
            }};
        long[] a = new long[]{p1,p2,p3};
        Arrays.sort(a);
        return map.get(a[2]);
    }

    long pts(String str, long n){
        long s = str.length();
        long[] c = new long[256];
        for(int i = 0; i < s; ++i) c[str.charAt(i)]++;
        long p = 0;
        for(long f : c){
            if(f==0) continue;
            if(f+n < s) p = Math.max(p, f+n);
            else if (f+n==s+1 && n==1){
                p = Math.max(p,s-1);
            } else {
                p = Math.max(p,s);
            }
        }
        return p;
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
        Cf979B task = new Cf979B(); task.run(); task.close();}
}
