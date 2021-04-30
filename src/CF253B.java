import java.io.*;
import java.util.*;

/**
 * Problem CF253B
 */
public class CF253B {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int[] c = new int[n];
            for(int i = 0; i < n; ++i){
                c[i]=in.nextInt();
            }
            Arrays.sort(c);
            int l = 0;
            int r = n-1;
            int m = 0;
            int ans = 0;
            while(l<=r){
                m=(l+r)/2;
                boolean p = false;
                for(int i = 0; i < n-m; ++i){
                    if(c[i]*2>=c[i+m]){
                        p=true;
                        ans = i + n - (i+m+1);
                        break;
                    }
                }
                if(p){
                    l=m+1;
                } else {
                    r=m-1;
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
        public OutputWriter out;

        
        
        public void cleanup() {out.close();}



        public IOHandler() {
            try {
                out = new OutputWriter("output.txt");
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            try {
                reader = new BufferedReader(new FileReader("input.txt"));
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            }
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
        public OutputWriter(String out) throws FileNotFoundException {
            super(out);
        }
        public void println(String format, Object... args) {
            this.println(String.format(format, args));}
        public void print(String format, Object... args) {
            this.print(String.format(format, args));}
    }
}
