import java.io.*;
import java.util.*;

/**
 * Problem UVA11503VirtualFriends
 */
public class UVA11503VirtualFriends {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t-->0){
                int f = in.nextInt();
                Dsu dsu = new Dsu();
                while(f-->0){
                    String a = in.next();
                    String b = in.next();
                    out.println(dsu.unionSet(a, b));
                }
            }
        }
    }

    static class Dsu {
        Map<String, String> parent = new HashMap<>();
        Map<String, Integer> size = new HashMap<>();

        public String findSet(String name){
            makeSet(name);
            if(parent.get(name).equals(name)){
                return name;
            }
            parent.put(name, findSet(parent.get(name)));
            return parent.get(name);
        }

        public Integer unionSet(String a, String b){
            a = findSet(a);
            b = findSet(b);
            
            if(a.equals(b)) return size.get(a);
            if(size.get(a) < size.get(b)){
                String c = a;
                a = b;
                b = c;
            }
            parent.put(b, a);
            Integer sizeA = size.get(a);
            Integer sizeB = size.get(b);
            size.put(a, sizeA + sizeB);
            return sizeA + sizeB;
        }

        public void makeSet(String name){
            if(!parent.containsKey(name)){
                size.put(name,1);
                parent.put(name, name);
            }
        }
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
        public PrintWriter out = new PrintWriter(System.out);
        public void cleanup() {out.close();}
    }
    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer = null;
        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
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
}
