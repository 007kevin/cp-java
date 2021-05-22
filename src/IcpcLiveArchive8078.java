import java.io.*;
import java.util.*;

/**
 * Problem IcpcLiveArchive8078
 */
public class IcpcLiveArchive8078 {

    static class Task extends IOHandler {
        public void run() {
            int T = in.nextInt();
            int CASE = 1;
            StringJoiner joiner = new StringJoiner("\n");
            while(T-->0){
                String B = in.next();
                int[] l = new int[B.length()];
                Stack<Pair> stack = new Stack<>();
                for(int i = 0; i < B.length(); ++i){
                    char c = B.charAt(i);
                    if(open(c)){
                        stack.push(new Pair(i, c));
                    }
                    if(close(c) && !stack.isEmpty()){
                        Pair p = stack.pop();
                        if(match(p.c,c)){
                            l[p.i]=i-p.i+1;
                        } else stack.clear();
                    }
                }
                for(int i = 0; i < l.length; ++i) pq(l,i);
                joiner.add("Case " + CASE + ":");
                for(int i = 0; i < l.length; ++i){
                    joiner.add(String.valueOf(l[i]));
                }
                CASE++;
            }
            out.println(joiner.toString());
        }
        

        public int pq(int[] l, int i){
            if(i >= l.length || l[i]==0) return 0;
            int jump = l[i] + pq(l,i+l[i]);
            l[i]+=jump-l[i];
            return jump;
        }

        public boolean open(char c){
            return c=='('||c=='{'||c=='['||c=='<';
        }

        public boolean close(char c){
            return c==')'||c=='}'||c==']'||c=='>';
        }
        public boolean match(char c, char o){
            if(c=='(') return o == ')';
            if(c=='{') return o == '}';
            if(c=='[') return o == ']';
            if(c=='<') return o == '>';
            return false;
        }
    }

    static class Pair {
        int i;
        char c;
        Pair(int i, char c){
            this.i=i;
            this.c=c;
        }
    }

    /***********************************************************
     *                      BOILERPLATE                        *
    /***********************************************************/
    public static void main(String[] args) {
        Task task = new Task(); task.run(); task.close();}
    static class IOHandler  {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);
        public void close() {out.close();}}
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
}
