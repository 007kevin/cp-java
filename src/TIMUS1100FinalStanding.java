import java.io.*;
import java.util.*;

/**
 * Problem TIMUS1100FinalStanding
 */
public class TIMUS1100FinalStanding {

    static class Task extends IOHandler {
        public void run() {
            int n = in.nextInt();
            Team[] teams = new Team[n];
            for(int i = 0; i < n; ++i){
                teams[i]=new Team(in.nextInt(),in.nextInt());
            }
            Team[] sorted = msort(teams,0,n-1);
            for(Team t : sorted){
                out.println(t.id + " " + t.m);
            }
        }

        public Team[] msort(Team[] teams, int i, int j){
            if(i==j){
                return new Team[]{teams[i]};
            }
            int mid = (i+j)/2;
            Team[] left = msort(teams,i,mid);
            Team[] right = msort(teams,mid+1,j);
            Team[] ret = new Team[left.length + right.length];
            int l=0,r=0;
            for(int c = 0; c < ret.length; ++c){
                if(l==left.length) {
                    ret[c]=right[r++];
                    continue;
                }
                if (r==right.length) {
                    ret[c]=left[l++];
                    continue;
                }
                if(left[l].m>=right[r].m){
                    ret[c]=left[l++];
                } else {
                    ret[c]=right[r++];
                }
            }
            return ret;
        }
    }

    static class Team {
        int id, m;
        public Team(int id, int m){
            this.id=id;
            this.m=m;
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
