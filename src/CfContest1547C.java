import java.io.*;
import java.util.*;

/**
 * Problem CfContest1547C
 */
public class CfContest1547C {

    public void run() {
        int t = in.nextInt();
        while(t-->0){
            int k = in.nextInt();
            int n = in.nextInt();
            int m = in.nextInt();
            int[] a = new int[n];
            int[] b = new int[m];
            for(int i = 0; i < n; ++i) a[i]=in.nextInt();
            for(int i = 0; i < m; ++i) b[i]=in.nextInt();
            List<Integer> seq = find(a,b,k);
            if(seq==null) out.println(-1);
            else {
                seq.stream().forEach(num -> out.print(num + " "));
                out.println();
            }
        }
    }

    List<Integer> find(int[] a, int[] b, int k){
        int n = a.length, m = b.length, i = 0, j = 0;
        List<Integer> list = new ArrayList<>();
        while(i<n||j<m){
            if(i<n&&a[i]==0) {
                list.add(0);
                k++;
                i++;
                continue;
            }
            if(j<m&&b[j]==0){
                list.add(0);
                k++;
                j++;
                continue;
            }
            if(i<n&&a[i]<=k){
                list.add(a[i]);
                i++;
                continue;
            }
            if(j<m&&b[j]<=k){
                list.add(b[j]);
                j++;
                continue;
            }
            return null;
        }
        return list;
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
        CfContest1547C task = new CfContest1547C(); task.run(); task.close();}
}
