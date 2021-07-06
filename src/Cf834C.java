import java.io.*;
import java.util.*;

/**
 * Problem Cf834C
 */
public class Cf834C {

    Map<Integer, Set<Integer>> v = new HashMap<>();

    public void run() {
        int n = in.nextInt();
        set(0,0);
        while(n-->0){
            int a=in.nextInt();
            int b=in.nextInt();
            if(yes(pf(a), pf(b))) out.println("Yes");
            else out.println("No");
        }
    }

    void set(int a, int b){
        if(a>3000||b>3000) return;
        if(contains(a, b))return;
        v.computeIfAbsent(a, (key) -> new HashSet<>()).add(b);
        set(a+1,b+2);
        set(a+2,b+1);
    }

    boolean contains(int a, int b){
        if(v.containsKey(a)){
            return v.get(a).contains(b);
        }
        return false;
    }

    boolean yes(Map<Integer, Integer> A, Map<Integer, Integer> B){
        for(int p : A.keySet()){
            if(!B.containsKey(p)) return false;
        }
        for(int p : B.keySet()){
            if(!A.containsKey(p)) return false;
        }
        for(int p : A.keySet()){
            int a = A.get(p);
            int b = B.get(p);
            if(!contains(a,b) && !contains(b,a))
                return false;
        }
        return true;
    }

    Map<Integer, Integer> pf(int n){
        Map<Integer, Integer> map = new HashMap<>();
        for(int i = 2; i*i <= n; ++i){
            while(n%i==0){
                map.put(i,map.getOrDefault(i, 0) + 1);
                n/=i;
            }
        }
        if(n!=1) map.put(n,1);
        return map;
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
        Cf834C task = new Cf834C(); task.run(); task.close();}
}
