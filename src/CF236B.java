import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.HashSet;
import java.util.StringTokenizer;

/**
 * Problem CF236B
 */
public class CF236B {

    static class Task extends IOHandler {
        public void run() {
            int mod = 1073741824;
            int a = in.nextInt();
            int b = in.nextInt();
            int c = in.nextInt();
            int ans = 0;
            HashMap<Integer,Integer> map = new HashMap<>();
            for(int i = 1; i <= a; ++i){
                for(int j = 1; j <= b; ++j){
                    for(int k = 1; k <= c; ++k){
                        int p = i*j*k;
                        if(p==1){
                            ans++;
                            continue;
                        }
                        if(p==2||p==3){
                            ans+=2;
                            continue;
                        }
                        if(map.containsKey(p)){
                            ans+=map.get(p);
                            continue;
                        }
                        int d = 2;
                        for(int x = 2; x*x <= p; ++x)
                            if(p%x==0)
                                if(x*x==p) d++;
                                else d+=2;
                        map.put(p, d);
                        ans+=d;

                    }
                }
            }
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
        public OutputWriter out = new OutputWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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
    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {super(out);}
        public void println(String format, Object... args) {
            this.println(String.format(format, args));}
        public void print(String format, Object... args) {
            this.print(String.format(format, args));}
    }
}
