import java.io.*;
import java.util.*;

/**
 * Problem Uva348
 */
public class Uva348 {

    public void run() {
        int c = 1;
        while(true){
            int n = in.nextInt();
            if(n==0) return;
            List<A> list = new ArrayList<>(n);
            for(int i = 0; i < n; ++i){
                list.add(new A(in.nextInt(), in.nextInt()));
            }
            out.println(String.format(
                    "Case %s: %s",
                    c++,
                    new Optimizer(list).run()));
        }
    }

    static class Optimizer {
        int n;
        List<A> list;
        Map<Integer, A> map;
        Map<Integer, String> output;
        Map<Integer, Integer> dp;

        public Optimizer(List<A> list){
            this.n=list.size();
            this.list = list;
            this.map = new HashMap<>();
            this.output = new HashMap<>();
            this.dp = new HashMap<>();
        }

        public String run(){
            run(0,n-1);
            return output.get(key(0,n-1));
        }

        private A run(int i, int j){
            int hash = key(i,j);
            if(map.containsKey(hash))
                return map.get(hash);
            if(i==j){
                output.put(hash, toS(i));
                map.put(hash, list.get(i));
                dp.put(hash, 0);
                return list.get(i);
            }
            A a = null;
            int m = Integer.MAX_VALUE;
            String s = "()";
            for(int k = i; k < j; ++k){
                A left = run(i,k);
                A right = run(k+1,j);
                int moves = dp.get(key(i,k))
                        + dp.get(key(k+1,j))
                        + multi(left,right);

                if(moves <= m){
                    m = moves;
                    a = left.combine(right);
                    s = String.format("(%s x %s)",
                            output.get(key(i,k)),
                            output.get(key(k+1,j)));
                }
            }
            output.put(hash,s);
            map.put(hash, a);
            dp.put(hash, m);
            return a;
        }

        private String toS(int i){
            return "A" + (i+1);
        }

        private int key(int i, int j){
            return Objects.hash(i,j);
        }

        private int multi(A a, A b){
            return a.x * b.y * a.y;
        }
    }

    static class A {
        int x,y;
        public A(int x, int y){
            this.x=x;
            this.y=y;
        }
        public A combine(A that){
            return new A(this.x, that.y);
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
        Uva348 task = new Uva348(); task.run(); task.close();}
}
