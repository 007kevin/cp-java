import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.StringTokenizer;
import java.util.stream.Collectors;

/**
 * Problem CF1303C
 */
public class CF1303C {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t--!=0)
                solve(in.next());
        }

        private void solve(String str) {
            Character[] password = str.chars().mapToObj(c -> (char) c).toArray(Character[]::new);
            Set<Character> set = "abcdefghijklmnopqrstuvwxyz".chars()
                    .mapToObj(c->Character.valueOf((char) c))
                    .collect(Collectors.toSet());
            List<Character> key = new ArrayList<>();
            for (int i = 0; i < 60; ++i)
                key.add(null);
            int pos = 31;
            for(Character c : password) {
                if (key.get(pos-1) == c || (key.get(pos-1) == null && set.contains(c)))
                    pos--;
                else if (key.get(pos+1) == c || (key.get(pos+1) == null && set.contains(c)))
                    pos++;
                else {
                    out.println("NO");
                    return;
                }
                set.remove(c);
                key.set(pos, c);
            }
            String ans = key.stream()
                    .filter(Objects::nonNull)
                    .map(String::valueOf)
                    .collect(Collectors.joining())
                    .trim();
            for (Character c : set.stream().toArray(Character[]::new))
                ans += c;
            out.println("YES");
            out.println(ans);

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
