import java.io.*;
import java.util.*;

/**
 * Problem Cf490B_v2
 */
public class Cf490B_v2 {

    public void run() {
        int n = in.nextInt();
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> a = new HashSet<>();
        Set<Integer> b = new HashSet<>();
        for(int i = 0; i < n; ++i){
            int ai = in.nextInt();
            int bi = in.nextInt();
            map.put(ai,bi);
            a.add(ai);
            b.add(bi);
        }
        List<Integer> list = new ArrayList<>();
        int first = find(a,b);
        int second = map.get(0);
        list.add(first);
        list.add(second);
        while(second!=0){
            list.add(map.get(first));
            first=second;
            second=list.get(list.size()-1);
        }
        list.stream()
                .filter(i -> i!=0)
                .forEach(i -> out.print(i + " "));
        out.println();
    }

    int find(Set<Integer> a, Set<Integer> b){
        for(int ai : a){
            if(!b.contains(ai)) return ai;
        }
        return 0;
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
        Cf490B_v2 task = new Cf490B_v2(); task.run(); task.close();}
}
