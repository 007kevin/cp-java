import java.io.*;
import java.util.*;

/**
 * Problem Cf705C
 */
public class Cf705C {

    public void run() {
        int n = in.nextInt();
        int q = in.nextInt();
        Map<Integer, Queue<Integer>> app = new HashMap<>();
        for(int i = 1; i <= n; ++i){
            app.put(i, new ArrayDeque<>());
        }
        List<Integer> list = new ArrayList<>(q);
        int total_notif = 0;
        int total_read = 0;
        int maxt = 0;
        while(q-->0){
            int t = in.nextInt();
            int x = in.nextInt();
            if(t==1){
                list.add(x);
                app.get(x).add(total_notif);
                total_notif++;
            } else if (t==2){
                total_read+=app.get(x).size();
                app.get(x).clear();
            } else if (t==3){
                for(int i = maxt; i < x; ++i){
                    Queue<Integer> queue = app.get(list.get(i));
                    if(queue.isEmpty()) continue;
                    if(queue.peek() > i) continue;
                    total_read++;
                    queue.remove();
                }
                maxt=Math.max(maxt,x);
            }
            out.println(total_notif-total_read);
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
        Cf705C task = new Cf705C(); task.run(); task.close();}
}
