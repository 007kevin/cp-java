import java.io.*;
import java.util.*;

/**
 * Problem UVA10276HanoiTowerTrouble
 */
public class UVA10276HanoiTowerTrouble {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int n = in.nextInt();
                int[] p = new int[n];
                int c = 1;
                while(true){
                    boolean cont = false;
                    for(int i = 0; i < n; ++i){
                        if(p[i]==0){
                            cont = true;
                            p[i]=c;
                            break;
                        } else {
                            int sqrt = (int) Math.sqrt(p[i] + c);
                            if(sqrt * sqrt == p[i]+c){
                                cont=true;
                                p[i]=c;
                                break;
                            }
                        }
                    }
                    if(!cont) break;
                    c++;
                }
                out.println(c-1);
            }
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
