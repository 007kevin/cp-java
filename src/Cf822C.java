import java.io.*;
import java.util.*;

/**
 * Problem Cf822C
 */
public class Cf822C {

    public void run() {
        int n = in.nextInt();
        int x = in.nextInt();
        List<Voucher> list = new ArrayList<>(n);
        Map<Integer, TreeSet<Voucher>> map = new HashMap<>();
        for(int i = 0; i < n; ++i){
            int l = in.nextInt();
            int r = in.nextInt();
            int c = in.nextInt();
            Voucher v = new Voucher(l, r, c);
            list.add(v);
            map.computeIfAbsent(r-l+1, (key) -> new TreeSet<>()).add(v);
        }
        for(TreeSet<Voucher> set : map.values()){
            Iterator<Voucher> iter = set.descendingIterator();
            int min = Integer.MAX_VALUE;
            while(iter.hasNext()){
                Voucher v = iter.next();
                min=Math.min(min,v.c);
                v.c=min;
            }
        }
        int ans = Integer.MAX_VALUE;
        for(Voucher v : list){
            int d = v.r-v.l+1;
            if(map.containsKey(x-d)){
                TreeSet<Voucher> set = map.get(x-d);
                Voucher ceil = new Voucher(v.r, v.r+2,0);
                Voucher w = set.ceiling(ceil);
                if(w!=null){
                    ans=Math.min(ans, v.o + w.c);
                }
            }
        }
        out.println(ans==Integer.MAX_VALUE ? -1 : ans);
    }

    static class Voucher implements Comparable<Voucher> {
        int l,r,c,o;
        Voucher(int l,int r,int c){
            this.l=l;
            this.r=r;
            this.c=c;
            this.o=c;
        }

        @Override
        public int compareTo(Voucher that) {
            if(this.l==that.l){
                return that.c-this.c;
            }
            return this.l - that.l;
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
        Cf822C task = new Cf822C(); task.run(); task.close();}
}
