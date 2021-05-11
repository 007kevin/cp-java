import java.io.*;
import java.util.*;

/**
 * Problem CF614B
 */

public class CF614B {

    static class Task extends IOHandler {
        public void run() {
            long n=in.nextLong();
            String b="1";
            long z=0;
            while(n-->0){
                String val = in.next();
                long beautiful = beautiful(val);
                if(beautiful==-2){
                    out.println(0);
                    return;
                }
                if(beautiful==-1){
                    b=val;
                } else {
                    z+=beautiful;
                }
            }
            out.print(b);
            while(z-->0){
                out.print("0");
            }
            out.println();
        }

        public long beautiful(String num){
            long z = 0;
            long one = 0;
            for(int i = 0; i < num.length(); ++i){
                if(num.charAt(i) != '0' && num.charAt(i) != '1') return -1;
                if(num.charAt(i) == '0') z++;
                if(num.charAt(i) == '1') one++;
                
            }
            return one == 1 ? z : one == 0 ? -2 : -1;
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
