import java.io.*;
import java.util.*;

/**
 * Problem CF1009B
 */
public class CF1009B {

    static class Task extends IOHandler {
        public void run() {
            char[] c = in.next().toCharArray();
            StringBuilder s = new StringBuilder();
            for(int i = 0; i < c.length; ++i){
                if(c[i]=='2'){
                    s.append('2');
                    c[i]='3';
                    int j = i+1;
                    for(;j<c.length && c[j]!='2'; ++j){
                        if(c[j]=='0'){
                            s.append('0');
                            c[j]='3';
                        }
                    }
                    i=j-1;
                }
            }
            Arrays.sort(c);
            String o = new String(c, 0, c.length-s.length());
            out.println(o + s.toString());
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
