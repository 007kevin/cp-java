import java.io.*;
import java.util.*;

/**
 * Problem Cf1530C
 */
public class Cf1530C {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int n = in.nextInt();
            List<Integer> a = new ArrayList<>();
            List<Integer> b = new ArrayList<>();
            for(int i = 0; i < n; ++i) a.add(in.nextInt());
            for(int i = 0; i < n; ++i) b.add(in.nextInt());
            Collections.sort(a);
            Collections.sort(b);
            for(int i = 0; i < n-1; ++i){
                a.set(i+1, a.get(i+1) + a.get(i));
                b.set(i+1, b.get(i+1) + b.get(i));
            }
            Collections.reverse(b);
            // for(int num : b) out.print(num + " ");
            // out.println();
            // out.println(ptsA(a) + " " + ptsB(b));

            int r=0;
            while(ptsA(a) < ptsB(b)){
                r++;
                a.add(100 + a.get(a.size()-1));
                b.add(0);
            }
            out.println(r);
        }
    }

    int ptsA(List<Integer> a){
        int n = a.size();
        if(n/4==0) return a.get(a.size()-1);
        return a.get(a.size()-1) - a.get(n/4-1);
    }

    int ptsB(List<Integer> b){
        int n = b.size();
        if(n/4==0) return b.get(0);
        return b.get(0) - b.get(n-(n/4));
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
        Cf1530C task = new Cf1530C(); task.run(); task.close();}
}
