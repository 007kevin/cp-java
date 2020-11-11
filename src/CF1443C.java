import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.StringTokenizer;

/**
 * Problem CF1443C
 */
@SuppressWarnings("unchecked")
public class CF1443C {

    static class Task extends IOHandler {
        public void run() {
            int t = in.nextInt();
            while(t--!=0){
                Long n = in.nextLong();
                List<Pair<Long, Long>> p = new ArrayList<>();
                for(int i = 0; i < n; ++i)
                    p.add(new Pair<Long,Long>(in.nextLong(),0L));
                for(int i = 0; i < n; ++i)
                    p.get(i).b=in.nextLong();
                Collections.sort(p, Collections.reverseOrder());
                Long sum=0L;
                Long ans=Long.MAX_VALUE;
                for(Pair<Long, Long> i : p){
                    ans=Math.min(ans, Math.max(i.a, sum));
                    sum+=i.b;
                }
                ans=Math.min(ans, sum);
                out.println(ans);
            }
        }
    }

    /***********************************************************
     *                        COMMONS                          *
     ***********************************************************/
	static class Pair<A, B> implements Comparable<Pair<A, B>> {
		public A a;
		public B b;
		public Pair(Pair<A, B> p) {
			this(p.a, p.b);
		}

		public Pair(A a, B b) {
			this.a = a;
			this.b = b;
		}
 
		public String toString() {
			return a+" "+b;
		}
 
		public int hashCode() {
			return Objects.hash(a, b);
		}
 
		public boolean equals(Object o) {
			if(o instanceof Pair) {
				Pair<A,B> p = (Pair<A,B>) o;
				return a.equals(p.a)&&b.equals(p.b);
			}
			return false;
		}
 
        @Override
		public int compareTo(Pair<A, B> p) {
			int cmp = ((Comparable<A>) a).compareTo(p.a);
			if(cmp==0) {
				return ((Comparable<B>) b).compareTo(p.b);
			}
			return cmp;
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
