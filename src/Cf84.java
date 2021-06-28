import java.io.*;
import java.util.*;

/**
 * Problem Cf84
 */
public class Cf84 {

    public void run() {
        int n = in.nextInt();
        List<Target> targets = new ArrayList<>();
        TreeMap<Integer, Target> map = new TreeMap<>();
        for(int i = 0; i < n; ++i){
            int x = in.nextInt();
            int r = in.nextInt();
            Target target = new Target(x,r);
            targets.add(target);
            map.put(x,target);
        }
        int m = in.nextInt();
        for(int i = 1; i <= m; ++i){
            int h = i;
            int x = in.nextInt();
            int y = in.nextInt();

            Optional.ofNullable(map.floorEntry(x))
                    .map(e -> e.getValue())
                    .filter(t -> hit(t,x,y))
                    .ifPresent(t -> t.setHit(h));

            Optional.ofNullable(map.ceilingEntry(x))
                    .map(e -> e.getValue())
                    .filter(t -> hit(t,x,y))
                    .ifPresent(t -> t.setHit(h));

        }
        out.println(targets.stream().filter(t -> t.hit != -1).count());
        for(Target t : targets){
            out.print(t.hit + " ");
        }
        out.println();

    }

    public boolean hit(Target target, int x1, int y1){
        if(target.hit != -1) return false;
        int x = x1-target.x;
        int y = y1;
        int r = target.r;
        return (x*x+y*y) <= r*r;
    }

    public class Target {
        int x,r,hit;
        Target(int x, int r){
            this.x=x;
            this.r=r;
            this.hit = -1;
        }
        void setHit(int m){
            hit=m;
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public InputReader in = new InputReader(System.in);
    public PrintWriter out = new PrintWriter(System.out);
    public void close() {out.close();}
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokens = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);}
        private boolean prime() {
            while (tokens == null || !tokens.hasMoreTokens()) {
                try {
                    String line = reader.readLine();
                    if(line==null) return false; // EOF
                    tokens = new StringTokenizer(line);
                } catch (IOException e) {throw new RuntimeException(e);}
            } return true;}
        public boolean hasNext() {return prime();}
        public String next() {prime(); return tokens.nextToken();}
        public int nextInt() {return Integer.parseInt(next());}
        public long nextLong() {return Long.parseLong(next());}
        public double nextDouble() {return Double.parseDouble(next());}
    }
    public static void main(String[] args) {
        Cf84 task = new Cf84(); task.run(); task.close();}
}
