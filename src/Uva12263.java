import java.io.*;
import java.util.*;

/** Problem Uva12263 */
public class Uva12263 {

  int n;
  List<Team> list = new ArrayList<>(500);
  Map<Integer, Team> map = new HashMap<>();

  public void run() {
    int t = in.nextInt();
    while (t-- > 0) {
      list.clear();
      map.clear();
      n = in.nextInt();
      for (int i = 0; i < n; ++i) {
        int num = in.nextInt();
        Team team = new Team(num);
        map.put(num, team);
        list.add(team);
      }
      for (int i = 0; i < n; ++i) {
        for (int j = i + 1; j < n; ++j) {
            list.get(i).beat.add(list.get(j).num);
        }
      }
      if (!populateRelative()) out.println("IMPOSSIBLE");
      else {
        StringJoiner joiner = new StringJoiner(" ");
        sort().stream().map(team -> team.num).map(String::valueOf).forEach(joiner::add);
        out.println(joiner);
      }
    }
  }

  boolean populateRelative() {
    int m = in.nextInt();
    while (m-- > 0) {
      int a = in.nextInt();
      int b = in.nextInt();
      Team A = map.get(a);
      Team B = map.get(b);
      if (A.beat.contains(b)) return false;
      B.beat.remove(a);
      A.beat.add(b);
    }
    for (Team t : list) {
      if (cycle(t, new HashSet<Integer>())) return false;
    }
    return true;
  }

  boolean cycle(Team t, Set<Integer> v) {
    if (v.contains(t.num)) return true;
    v.add(t.num);
    for (Integer b : t.beat) {
      if (cycle(map.get(b), v)) return true;
    }
    v.remove(t.num);
    return false;
  }

  static class Team {
    int num;
    NavigableSet<Integer> beat = new TreeSet<>();

    Team(int num) {
      this.num = num;
    }
  }

  List<Team> sort() {
    List<Team> ts = new ArrayList<>();
    Set<Integer> inc = new HashSet<>();
    for (Team t : list) {
      sort(ts, inc, t);
    }
    Collections.reverse(ts);
    return ts;
  }

  void sort(List<Team> ts, Set<Integer> inc, Team t) {
    if (inc.contains(t.num)) return;
    for (Integer b : t.beat) {
      Team B = map.get(b);
      sort(ts, inc, B);
    }
    ts.add(t);
    inc.add(t.num);
  }

  /***********************************************************
   *                      BOILERPLATE                        *
   * /***********************************************************/
  public InputReader in = new InputReader(System.in);

  public PrintWriter out = new PrintWriter(System.out);

  public void close() {
    out.close();
  }

  static class InputReader {
    public BufferedReader reader;
    public StringTokenizer tokens = null;

    public InputReader(InputStream stream) {
      reader = new BufferedReader(new InputStreamReader(stream), 32768);
    }

    private boolean prime() {
      while (tokens == null || !tokens.hasMoreTokens()) {
        try {
          String line = reader.readLine();
          if (line == null) return false; // EOF
          tokens = new StringTokenizer(line);
        } catch (IOException e) {
          throw new RuntimeException(e);
        }
      }
      return true;
    }

    public boolean hasNext() {
      return prime();
    }

    public String next() {
      prime();
      return tokens.nextToken();
    }

    public int nextInt() {
      return Integer.parseInt(next());
    }

    public long nextLong() {
      return Long.parseLong(next());
    }

    public double nextDouble() {
      return Double.parseDouble(next());
    }
  }

  public static void main(String[] args) {
    Uva12263 task = new Uva12263();
    task.run();
    task.close();
  }
}
