import java.io.*;
import java.util.*;

/**
 * Problem CF520B
 */
public class CF520B_BFS_SOLUTION {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            Set<Integer> visited = new HashSet<>();
            Queue<Node> q = new LinkedList<>();
            q.add(new Node(n,0));
            while(!q.isEmpty()){
                Node node = q.remove();
                if(node.a==m){
                    out.println(node.b);
                    return;
                }
                int times2 = node.a*2;
                if(!visited.contains(times2) && times2 <= 2*m){
                    visited.add(times2);
                    q.add(new Node(times2, node.b+1));
                }
                int subtract1 = node.a-1;
                if(!visited.contains(subtract1) && subtract1 > 0){
                    visited.add(subtract1);
                    q.add(new Node(subtract1, node.b+1));
                }
            }
        }
    }

    static class Node {
        int a,b;
        public Node(int a, int b){this.a=a;this.b=b;}
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
        public OutputWriter out = new OutputWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
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
    static class OutputWriter extends PrintWriter {
        public OutputWriter(OutputStream out) {super(out);}
        public void println(String format, Object... args) {
            this.println(String.format(format, args));}
        public void print(String format, Object... args) {
            this.print(String.format(format, args));}
    }
}
