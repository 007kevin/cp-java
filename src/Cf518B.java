import java.io.*;
import java.util.*;

/**
 * Problem Cf518B
 */
public class Cf518B {

    static class Task extends IOHandler {
        public void run() {
            char[] s = in.next().toCharArray();
            String t = in.next();
            int[] ctrs = new int[256];
            int y=0,w=0;
            for(int i = 0; i < t.length(); ++i){
                ctrs[t.charAt(i)]++;
            }
            for(int i = 0; i < s.length; ++i){
                if(ctrs[s[i]]>0){
                    y++;
                    ctrs[s[i]]--;
                    s[i]=0;
                }
            }
            for(int i = 0; i < s.length; ++i){
                if(s[i]==0) continue;
                char other = other(s[i]);
                if(ctrs[other]>0){
                    w++;
                    ctrs[other]--;
                }
            }
            out.println(y + " " + w);
        }

        public char other(char c){
            if (Character.isUpperCase(c)) return Character.toLowerCase(c);
            return Character.toUpperCase(c);
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
