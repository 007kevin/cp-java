
import java.io.*;
import java.util.*;

/**
 * Problem    = cf141c
 * Date       = Sun Oct 16 13:34:53 PDT 2022
 * ********************
 * Read  Time = 0:05:44
 * Think Time =
 * Code  Time =
 * Debug Time =
 * Total Time =
 *
 * Unfinished 
 */
public class cf141c {

    public void run() {
        int n = in.nextInt();
        List<Person> list = new ArrayList<>();
        for(int i = 0; i < n; ++i){
            list.add(new Person(in.next(), in.nextInt()));
        }
        list.sort((a,b)->a.a - b.a);
        for(int i = 0; i < n; ++i){
            if(list.get(i).a > i){
                out.println(-1);
                return;
            }
        }
        LinkedList<Person> res = new LinkedList<>();
        int cur = 3001;
        for(Person p : list){
            p.h=cur--;
            res.add(p.a, p);
        }
        for(Person p : res){
            out.println(p);
        }
    }

    public class Person {
        String name;
        int a, h;
        Person(String name, int a){
            this.name=name;
            this.a=a;
        }
        @Override
        public String toString() {
            return name + " " + h;
        }
        
    }

    /////////////////////////////////////////////////////////////////////////////
    IR in=new IR(System.in);PrintWriter out=new PrintWriter(System.out);void c(){
    out.close();}static class IR {BufferedReader r; StringTokenizer t= null; IR (
    InputStream s){r=new BufferedReader(new InputStreamReader(s), 32768);}boolean
    p(){while(t==null||!t.hasMoreTokens()){try{String l=r. readLine();if(l==null)
    return false; t = new StringTokenizer(l); } catch (IOException e) { throw new
    RuntimeException(e);}}return true;}boolean hasNext(){return p();}String next(
    ){ p();return t.nextToken();}int nextInt() {return Integer.parseInt(next());}
    long nextLong() { return Long.parseLong(next());} double nextDouble(){ return
    Double.parseDouble( next() ); } } public static void main ( String[ ]args ) {
    cf141c t=new cf141c();t.run();t.c();}
    /////////////////////////////////////////////////////////////////////////////
}
