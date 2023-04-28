import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;
 
public class cf141c_1 {
 
    public static void main(String[] args) throws Throwable {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Pair[] a = new Pair[n];
        for (int i = 0; i < a.length; i++) 
            a[i] = new Pair(sc.next(), sc.nextInt());
        Arrays.sort(a);
        for (int i = 0; i < a.length; i++) 
            if(a[i].h>i)
            {
                System.out.println(-1);
                return;
            }
        ArrayList<Pair> ans = new ArrayList<>();
        int h = 10000;
        for (int i = 0; i < n; i++) 
            ans.add(a[i].h,new Pair(a[i].name, h--));
        for(Pair p : ans)
            System.out.println(p.name+" "+p.h);
    }
 
    static class Pair implements Comparable<Pair>
    {
        String name;
        int h;
        public Pair(String s,int n) {name = s;h = n;}
        public int compareTo(Pair o) {return h-o.h;}
    }
    
    static class Scanner {
        StringTokenizer st;
        BufferedReader br;
 
        public Scanner(InputStream s) {
            br = new BufferedReader(new InputStreamReader(s));
        }
 
        public Scanner(String file) throws FileNotFoundException {
            br = new BufferedReader(new FileReader(file));
        }
 
        public String next() throws IOException {
            while (st == null || !st.hasMoreTokens())
                st = new StringTokenizer(br.readLine());
            return st.nextToken();
        }
 
        public int nextInt() throws IOException {
            return Integer.parseInt(next());
        }
 
        public long nextLong() throws IOException {
            return Long.parseLong(next());
        }
 
        public String nextLine() throws IOException {
            return br.readLine();
        }
 
        public double nextDouble() throws IOException {
            String x = next();
            StringBuilder sb = new StringBuilder("0");
            double res = 0, f = 1;
            boolean dec = false, neg = false;
            int start = 0;
            if (x.charAt(0) == '-') {
                neg = true;
                start++;
            }
            for (int i = start; i < x.length(); i++)
                if (x.charAt(i) == '.') {
                    res = Long.parseLong(sb.toString());
                    sb = new StringBuilder("0");
                    dec = true;
                } else {
                    sb.append(x.charAt(i));
                    if (dec)
                        f *= 10;
                }
            res += Long.parseLong(sb.toString()) / f;
            return res * (neg ? -1 : 1);
        }
 
        public int[] nexIntArray() throws Throwable {
            st = new StringTokenizer(br.readLine());
            int[] a = new int[st.countTokens()];
            for (int i = 0; i < a.length; i++)
                a[i] = nextInt();
            return a;
        }
 
        public boolean ready() throws IOException {
            return br.ready();
        }
 
    }
 
}
