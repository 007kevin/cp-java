import java.io.*;
import java.util.*;

/**
 * Problem CF337B
 */
public class CF337B {

    static class Task extends IOHandler {
        public void run() {
            Ratio monitor = new Ratio(in.nextInt(), in.nextInt());
            Ratio screen = new Ratio(in.nextInt(), in.nextInt());
            Ratio h = monitor.fitH(screen);
            Ratio v = monitor.fitV(screen);
            if(h==null){
                out.println(v.toString());
            } else if (v==null){
                out.println(h.toString());
            } else {
                if(h.compareTo(v) <= 0){
                    out.println(h.toString());
                } else {
                    out.println(v.toString());
                }
            }
        }
    }

    static class Ratio implements Comparable<Ratio> {
        int h,v;
        public Ratio(int h, int v){
            if(h==0||v==0){
                this.h=0;
                this.v=1;
                return;
            }
            int gcd=this.gcd(h,v);
            this.h=h/gcd;
            this.v=v/gcd;
        }

        public Ratio fitH(Ratio that){
            int a=this.h*that.h;
            int b=this.v*that.h;
            int c=that.h*this.h;
            int d=that.v*this.h;
            if(d>b) return null;
            return new Ratio(b,b-d);
        }

        public Ratio fitV(Ratio that){
            int a=this.h*that.v;
            int b=this.v*that.v;
            int c=that.h*this.v;
            int d=that.v*this.v;
            if(c>a) return null;
            return new Ratio(a-c,a);
        }

        @Override
        public int compareTo(Ratio that) {
            return Integer.compare(
                    Math.min(this.h,this.v) * Math.max(that.h, that.v),
                    Math.min(that.h,that.v) * Math.max(this.h, this.v));
        }

        public String toString(){
            return Math.min(h,v) + "/" + Math.max(h,v);
        }

        private int gcd(int a, int b){
            if(b==0) return a;
            return gcd(b,a%b);
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
