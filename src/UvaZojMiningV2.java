import java.io.*;
import java.util.*;

/**
 * Problem ZojMining
 */
public class UvaZojMiningV2 {

    Queue<Integer> queue = new PriorityQueue<>();

    public void run() {
        while(in.hasNext()){
            queue.clear();
            int S = in.nextInt();
            int W = in.nextInt();
            int C = in.nextInt();
            int K = in.nextInt();
            int M = in.nextInt();
            int time = 0;
            int res = 0;
            int dig = 0;
            for(int i = 1; i <= K; ++i){
                queue.add(M*i + S);
            }
            while(res < 10000){
                Integer val = queue.remove();
                Integer next = Math.max(dig, val) + W;
                dig=next;
                time = next + S;
                res+=C;
                queue.add(next + 2*S);
            }
            System.out.println(time);
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
        UvaZojMiningV2 task = new UvaZojMiningV2(); task.run(); task.close();}
}
