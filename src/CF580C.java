import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

/**
 * Problem CF580C
 */
public class CF580C {
    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            int m = in.nextInt();
            Node t[] = new Node[n+1];
            for (int i = 1; i < n + 1; ++i){
                t[i] = new Node();
                t[i].cat = in.nextInt() == 1;
            }
            for (int i = 1; i < n; ++i){
                int x = in.nextInt();
                int y = in.nextInt();
                t[x].a.add(y);
                t[y].a.add(x);
            }
            normalize(1, t);
            out.println(f(1,0,m,t));
        }

        private void normalize(int i, Node[] t) {
            if (t[i].visit) return;
            for(int a : t[i].a){
                t[i].visit = true;
                normalize(a,t);
                t[i].visit = false;
            }
            t[i].a.removeIf(a -> {
                return t[a].visit;
            });
        }

        private int f(int i, int c, int m, Node[] t) {
            c = t[i].cat ? c + 1 : 0;
            if (c > m) return 0;
            if (t[i].a.isEmpty()) return 1;
            int cnt = 0;
            for(int a : t[i].a) {
                cnt+=f(a, c, m, t);
            }
            return cnt;
        }
    }

    static class Node {
        public Set<Integer> a = new HashSet<>();
        public boolean cat;
        public boolean visit;
    }

    /***********************************************************
     *                      BOILERPLATE                        *
     ***********************************************************/
    public static void main(String[] args) {
        Task task = new Task();
        task.run();
        task.cleanup();
    }

    static class IOHandler {
        public InputReader in = new InputReader(System.in);
        public PrintWriter out = new PrintWriter(System.out);

        public void cleanup() {
            out.close();
        }
    }

    static class InputReader {
        public BufferedReader reader;
        public StringTokenizer tokenizer;

        public InputReader(InputStream stream) {
            reader = new BufferedReader(new InputStreamReader(stream), 32768);
            tokenizer = null;
        }

        public String next() {
            while (tokenizer == null || !tokenizer.hasMoreTokens()) {
                try {
                    tokenizer = new StringTokenizer(reader.readLine());
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
            return tokenizer.nextToken();
        }

        public int nextInt() {
            return Integer.parseInt(next());
        }

        public long nextLong() {
            return Long.parseLong(next());
        }
    }

}
