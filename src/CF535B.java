import java.io.*;
import java.util.*;

/**
 * Problem CF535B
 */
public class CF535B {

    static class Task extends IOHandler {
        public void run() {
            long n = in.nextLong();
            List<Long> list = new ArrayList<>();
            generate(list, 0L, 0);
            Collections.sort(list);
            for(int i = 0; i < list.size(); ++i){
                if(list.get(i) == n){
                    out.println(i+1);
                    return;
                }
            }
        }

        private void generate(List<Long> list, long val, int i) {
            if(i==10) return;
            long four = val*10+4;
            long seven = val*10+7;
            list.add(four);
            list.add(seven);
            generate(list, four, i+1);
            generate(list, seven, i+1);
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
