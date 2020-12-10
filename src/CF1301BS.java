import java.util.*;

public class CF1301BS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while(t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) {
                arr[i] = sc.nextInt();
            }

            int mx = Integer.MIN_VALUE, mn = Integer.MAX_VALUE;
            for (int i = 0; i < n; i++) {
              if(arr[i] == -1)
                  continue;

              if(i - 1 >= 0 && arr[i-1] == -1 || i + 1 < n && arr[i+1] == -1) {
                  mx = Math.max(mx, arr[i]);
                  mn = Math.min(mn, arr[i]);
              }
            }

            int res = (mx + mn) / 2;
            int ans = 0;
            for (int i = 0; i < n; i++) {
                if (arr[i] == -1)
                    arr[i] = res;
            }

            for (int i = 0; i < n - 1; i++) {
                ans = Math.max(ans , Math.abs(arr[i+1] - arr[i]));
            }
            System.out.println(ans + " " + res);
        }
    }
}
