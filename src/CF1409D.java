import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.math.BigInteger;
import java.util.StringTokenizer;

/**
 * Problem CF1409D
 */
public class CF1409D {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            for (int i = 0; i < t; ++i) {
                System.out.println(new N(in.next()).solve(in.nextInt()));
            }
        }
    }

    static class N {
        long sumOfDigits = 0;
        int n[] = new int[20];

        public N(final String n) {
            StringBuilder sb = new StringBuilder(n).reverse();
            for(int i = 0; i < sb.length(); ++i) {
                int v = Character.getNumericValue(sb.charAt(i));
                sumOfDigits+=v;
                this.n[i] = v;
            }
        }

        public BigInteger solve(int s) {
            BigInteger moves = BigInteger.ZERO;
            int i = 0;
            while(sumOfDigits > s) {
                if (n[i] == 0){
                    i++;
                    continue;
                }

                moves = moves.add(BigInteger.valueOf((long)((10-(n[i])) * Math.pow(10, i))));
                for(int j = i+1; j < 20; ++j) {
                    if ((n[j] + 1) % 10 == 0){
                        n[j]=0;
                        sumOfDigits-=9;
                    } else {
                        n[j]++;
                        sumOfDigits+=1;
                        break;
                    }
                }
                sumOfDigits-=n[i];
                i++;
            }
            return moves;
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
