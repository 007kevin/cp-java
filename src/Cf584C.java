import java.io.*;
import java.util.*;

/**
 * Problem Cf584C

Scratch notes:
3 2
abc
xyc

s1 abc
s2 xyc

s1 and s2 have 1 character in common, c.
If we want s3, keep c, then make sure other characters are not the same.

kkc

When is it not possible?

Suppose s1 and s2 have c characters in common.
To find s3, we need to change

abcdef
zbcdeg

Is s3 with t=2 possible? yes
      with t=3 possible? yes

        abcdef
        kycdeg = 3

        zbcdeg
        kycdeg = 3

      with t=1 possible? no

        abcdef

        zbcdeg

So when s1,s2 have m characters in common, t must be >= n-m else it is impossible.

======================= debug
4 2
s1 acbb
s2 babc
   .. .

s1 acbb
s3 aaba = 2
    . .

s2 babc
s3 aaba = 2
   .  .

give chars s1[i], s2[i]
- if s1[i]==s2[i] then
     - s3[i] equals both making, d=d
     - s3[i] equals neither, d=d+1

- if s1[i]!=s2[i] then
     - s3[i] equals either making d=d+1
           - this means there must be j where s3[j] equals another
             to keep differences the same
     - s3[i] equals neither, making d=d+1

Let see..

Given s1,s2 we can find same m common characters, and n-m=d different characters.
Then t must be at least d - d/2. Else it is impossible to create s3 with more differences.

Example
s1 acbb

s2 babc

s3 ..b.

m = 1, d = 3. Therefore, t>= 3-1 = 2.

 
 */
public class Cf584C {

    public void run() {
        int n = in.nextInt();
        int t = in.nextInt();
        int m = 0;
        char[] s1 = in.next().toCharArray();
        char[] s2 = in.next().toCharArray();
        char[] s3 = new char[n]; Arrays.fill(s3, '0');
        for(int i = 0; i < n; ++i){
            if(s1[i]==s2[i]){
                m++;
                s3[i]=s1[i];
            }
        }
        int d = n-m;
        if(t < d-(d/2)) out.println(-1);
        else {
            if(d>t) {
                int j = 1;
                for(int i = 0; i < n && d!=t; ++i){
                    if(s3[i]=='0'){
                        j=Math.max(j, i+1);
                        while(j<n&&s3[j]!='0') j++;
                        if(j==n) continue;
                        s3[i]=s1[i];
                        s3[j]=s2[j];
                        d--;
                    }
                }
            } else if (d<t) {
                for(int i = 0; i < n && d!=t; ++i){
                    if(s3[i]!='0'){
                        s3[i]=not(s1[i],s2[i]);
                        d++;
                    }
                }
            }
            for(int i = 0; i < n; ++i){
                if(s3[i]=='0'){
                    s3[i]=not(s1[i],s2[i]);
                }
            }
            out.println(new String(s3));
        }
    }

    char not(char a, char b){
        char c = 'a';
        while(c==a||c==b) c++;
        return c;
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
        Cf584C task = new Cf584C(); task.run(); task.close();}
}
