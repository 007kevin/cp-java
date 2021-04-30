import java.io.*;
import java.util.*;

/**
 * Problem CF448B
 */
public class CF448B {

    static class Task extends IOHandler {
        public void run() {
            String s = in.next();
            String t = in.next();
            if(t.length() > s.length()){
                out.println("need tree");
            } else if(automaton(s,t)){
                out.println("automaton");
            } else {
                String sortedS = sort(s);
                String sortedT = sort(t);
                if(sortedS.equals(sortedT)){
                    out.println("array");
                }
                else if(automaton(sortedS, sortedT)){
                    out.println("both");
                } else {
                    out.println("need tree");
                }
            }
        }

        private boolean automaton(String s, String t) {
            char[] cs = s.toCharArray();
            char[] ct = t.toCharArray();
            for(int i = 0; i < cs.length; ++i){
                int c =0;
                for(int j = i; j < cs.length; ++j){
                    if(cs[j]==ct[c]) c++;
                    if(c==ct.length) break;
                }
                if(c==ct.length) return true;
            }
            return false;
        }
    }

    static String sort(String s){
        char[] c = s.toCharArray();
        Arrays.sort(c);
        return new String(c);
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
