import java.io.*;
import java.util.*;

/**
 * Problem Cf577C
 */
public class Cf577C {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int[] nums = new int[n+1];
            for(int i = 1; i <= n; ++i) nums[i]=i;
            List<Integer> q = new LinkedList<>();
            for(int i = 2; i <= n; ++i){
                if(nums[i]!=1){
                    q.add(i);
                    for(int j = i+i; j <= n; j+=i){
                        nums[j]/=nums[i];
                    }
                }
            }
            out.println(q.size());
            for(Integer num : q){
                out.print(num + " ");
            }
            out.println();
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
