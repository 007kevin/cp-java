import java.io.*;
import java.util.*;

/**
 * Problem CF716B
 */
public class CF716B {

    static class Task extends IOHandler {
        public void run() {
            StringBuilder s = new StringBuilder(in.next());
            
            boolean yes=false;
            for(int i = 0; i <= s.length()-26; ++i){
                if(possible(s,i,i+26)){
                    fill(s,i,i+26);
                    yes=true;
                    break;        
                }
            }
            if(!yes) out.println(-1);
            else {
                fillRemaining(s);
                out.println(s.toString());
            }
            
            
        }

        public boolean possible(CharSequence s, int i, int j){
            Set<Character> set = new HashSet<>();
            int q = 0;
            for(int a = i; a < j; ++a){
                if(s.charAt(a) != '?'){
                    set.add(s.charAt(a));
                } else q++;
            }
            return set.size()==26-q;
        }

        public void fill(StringBuilder s, int i, int j){
            Set<Character> set = new HashSet<>();
            for(int a = 0; a < 26; ++a){
                set.add((char)('A'+a));
            }
            
            for(int a = i; a < j; ++a)
                set.remove(s.charAt(a));
            Iterator<Character> iter = set.iterator();
            for(int a = i; a < j; ++a){
                if(s.charAt(a)=='?'){
                    s.setCharAt(a, iter.next());
                    iter.remove();
                }
            }
        }

        public void fillRemaining(StringBuilder s){
            for(int i = 0; i < s.length(); ++i){
                if(s.charAt(i)=='?'){
                    s.setCharAt(i, 'A');
                }
            }
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
