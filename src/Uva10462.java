import java.io.*;
import java.util.*;

/**
 * Problem Uva10462
 */
public class Uva10462 {

    public void run() {
        int t = in.nextInt();
        int cse = 0;
        while(t-->0){
            cse++;
            int v = in.nextInt();
            int e = in.nextInt();
            int[] n = new int[v+1];
            reset(n);
            List<Edge> list = new ArrayList<>();
            for(int i = 0; i < e; ++i){
                list.add(new Edge(in.nextInt(), in.nextInt(), in.nextInt()));
            }
            Collections.sort(list);
            List<Edge> mst = new ArrayList<>();
            for(Edge edge : list){
                if(n[edge.a]!=n[edge.b]){
                    mst.add(edge);
                    int b = n[edge.b];
                    for(int i = 1; i <= v; ++i){
                        if(n[i]==b)
                            n[i]=n[edge.a];
                    }
                }
            }
            if(!valid(n)) {
                print(cse, "No way");
                continue;
            }
            int cost = Integer.MAX_VALUE;
            for(Edge chsn : mst){
                List<Edge> scd = new ArrayList<>();
                reset(n);
                for(Edge edge : list){
                    if(edge == chsn) continue;
                    if(n[edge.a]!=n[edge.b]){
                        scd.add(edge);
                        int b = n[edge.b];
                        for(int i = 1; i <= v; ++i){
                            if(n[i]==b)
                                n[i]=n[edge.a];
                        }
                    }                    
                }
                if(valid(n)){
                    cost = Math.min(cost, scd.stream()
                            .map(edge -> edge.c)
                            .reduce(0, (a,b) -> a+b));
                }
            }
            if(cost == Integer.MAX_VALUE){
                print(cse, "No second way");
                continue;
            }
            print(cse, String.valueOf(cost));
        }
    }

    public void print(int cse, String s){
        out.println(String.format("Case #%s : %s", cse, s));
    }

    public void reset(int[] n){
        for(int i = 0; i < n.length; ++i)
            n[i]=i;
    }

    public boolean valid(int[] n){
        for(int i = 1; i < n.length; ++i){
            if(n[i]!=n[1]) return false;
        }
        return true;
    }

    static class Edge implements Comparable<Edge> {
        int a,b,c;
        Edge(int a, int b, int c){
            this.a=a;
            this.b=b;
            this.c=c;
        }

        @Override
        public int compareTo(Edge that) {
            return this.c - that.c;
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
        Uva10462 task = new Uva10462(); task.run(); task.close();}
}
