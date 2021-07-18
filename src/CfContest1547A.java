import java.io.*;
import java.util.*;

/**
 * Problem CfContest1547A
 */
public class CfContest1547A {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int xa = in.nextInt();
            int ya = in.nextInt();
            int xb = in.nextInt();
            int yb = in.nextInt();
            int fx = in.nextInt();
            int fy = in.nextInt();
            int d = Math.abs(xa-xb) + Math.abs(ya-yb);
            if((ya<fy&&fy<yb)||(ya>fy&&fy>yb)){
                if (xa==xb&&xb==fx) d+=2;
            }
            if((xa<fx&&fx<xb)||(xa>fx&&fx>xb)){
                if (ya==yb&&yb==fy) d+=2;
            }            
            out.println(d);
        }
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
        CfContest1547A task = new CfContest1547A(); task.run(); task.close();}
}
