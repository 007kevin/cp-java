import java.io.*;
import java.util.*;

/**
 * Problem Cf313Cv2
 */
public class Cf313Cv2 {

    public void run() {
        int n = in.nextInt();
        List<Long> list = new ArrayList<>(n);
        for(int i = 0; i < n; ++i) list.add(in.nextLong());
        Collections.sort(list, Comparator.reverseOrder());
        for(int i = 0; i < n-1; ++i)
            list.set(i+1, list.get(i+1) + list.get(i));
        long sum = 0;
        for(int i = 1; i <= n; i*=4){
            sum+=list.get(i-1);
        }
        out.println(sum);

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
        Cf313Cv2 task = new Cf313Cv2(); task.run(); task.close();}
}
