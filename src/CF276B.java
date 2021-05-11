import java.io.*;
import java.util.*;

/**
 * Problem CF276B
 */
public class CF276B {

    static class Task extends IOHandler {
        public void run() {
            String s = in.next();
            int[] ctrs = new int[26];
            s.chars().forEach(c -> ctrs[c-'a']++);
            int l=0, maxOdd=0, minI=0;
            for(int i = 0; i < ctrs.length; ++i){
                if(ctrs[i]%2==1&&ctrs[i]>maxOdd){
                    maxOdd = ctrs[i];
                    minI=i;
                }
            }
            l+=maxOdd;
            ctrs[minI]=0;
            for(int i = 0; i < ctrs.length; ++i){
                l+=(ctrs[i]/2)*2;
            }
            out.println((s.length() - l)%2==0?"First":"Second");
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
