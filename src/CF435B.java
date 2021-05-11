import java.io.*;
import java.util.*;

/**
 * Problem CF435B
 */
public class CF435B {

    static class Task extends IOHandler {
        public void run() {
            int[] s = in.next().chars().map(c -> c-'0').toArray();
            int k = in.nextInt();
            for(int i = 0; i < s.length; ++i){
                int b = i;
                for(int j = i+1; j <= i+k && j < s.length; ++j){
                    if(s[b] < s[j]) b = j;
                }
                k-=b-i;
                for(int j = b; j > i; --j){
                    int swap = s[j-1];
                    s[j-1]=s[j];
                    s[j]=swap;
                }
            }
            StringBuilder ans = new StringBuilder();
            Arrays.stream(s).forEach(c -> ans.append(String.valueOf(c)));
            out.println(ans);
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
     ***********************************************************/
    public static void main(String[] args) {
        Task task = new Task();
        task.run();
        task.cleanup();
    }
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
        }
        private boolean prime() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokenizer = new StringTokenizer(line);
                } catch (IOException e) {throw new RuntimeException(e);}
            }
            return true;
        }
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokenizer.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
}
