package TZ;

import java.util.Arrays;

public class TruckTZ {
    public static void main(String[] args) {
        System.out.println(isPolindeome(323));
        System.out.println(isPolindeome(-45));

        int[][] arr1 = {{9, 8, 7},
                {6, 5, 4},
                {3, 2, 1}};
//        int[][] arr2 = {{3,2,6,3},
//                        {7,2,2,8},
//                        {9,0,6,1}};
        turnOverMatrix(arr1);
//        turnOverMatrix(arr1);
        for (int[] temp : arr1) {
            System.out.println(Arrays.toString(temp));
        }

        int[] k = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.println(findPrecipitationVolume(k));
    }

    // ------------------------------------------------(1)-------------------------------------------------------------------
    public static boolean isPolindeome(int k) {
        if (k < 0) {
            return false;
        }
        boolean result = false;
        int[] arrayDigit = intToArray(k);
        int rightPosition = arrayDigit.length - 1;
        for (int leftPosition = 0; leftPosition <= rightPosition; leftPosition++) {
            result = arrayDigit[leftPosition] == arrayDigit[rightPosition];
            rightPosition--;
            if (result == false) {
                break;
            }
        }
        return result;
    }

    static int[] intToArray(int k) {
        int j = 0;
        int length = Integer.toString(k).length();
        int[] result = new int[length];
        while (k != 0) {
            result[length - j - 1] = k % 10;
            k = k / 10;
            j++;
        }
        return result;
    }

    // ------------------------------------------------(2)-------------------------------------------------------------------
    public static void turnOverMatrix(int[][] m) {
        if (m.length != m[0].length) {
            System.out.println("Wrong Array");
            return;
        } else {

            for (int i = 0; i < m.length; i++) {
                for (int j = i + 1; j < m[i].length; j++) {
                    int temp = m[i][j];
                    m[i][j] = m[j][i];
                    m[j][i] = temp;
                }
            }
            for (int i = 0; i < m.length; i++) {
                for (int j = 0; j < m[i].length / 2; j++) {
                    int temp = m[i][j];
                    m[i][j] = m[i][m.length - j - 1];
                    m[i][m.length - j - 1] = temp;
                }
            }
        }
    }

    // ------------------------------------------------(3)-------------------------------------------------------------------
    public static int findPrecipitationVolume(int[] k) {
        int result = 0;
        int countIteration = findMaxElement(k);
        for (int i = 1; i <= countIteration; i++) {
            int startIndex = findStartIndex(k);
            int endIndex = findEndIndex(k);
            for (int start = startIndex; start < endIndex; start++) {
                if (k[start] == 0) {
                    result++;
                }
            }
            for (int j = 0; j < k.length; j++) {
                if (k[j] > 0) {
                    k[j] = k[j] - 1;
                }
            }
        }
        return result;
    }

    public static int findMaxElement(int[] k) {
        int result = 0;
        for (int temp : k) {
            if (temp > result) {
                result = temp;
            }
        }
        return result;
    }

    public static int findStartIndex(int[] arr) {
        int result = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 0) {
                result = i;
                return result;
            }
        }
        return result;
    }

    public static int findEndIndex(int[] arr) {
        int result = 0;
        for (int i = arr.length - 1; i != 0; i--) {
            if (arr[i] > 0) {
                result = i;
                return result;
            }
        }
        return result;
    }
}
    // ------------------------------------------------(4)-------------------------------------------------------------------
/*
SELECT * FROM (SELECT Users_id, Banned, Role FROM Users WHERE Banned = "No" and Role != "partner") AS a , (SELECT ID, Client_Id, Driver_Id, City_Id, Status, Request_at FROM Trips WHERE Request_at BETWEEN '2013-10-01' AND '2013-10-03') AS b WHERE a.Users_id = b.Client_id
SELECT a.Request_at, b.Request_at, a.TotalCount, b.CencelledCount, round((b.CencelledCount*1.0/a.TotalCount*1.0),2) as CencellationRatio FROM (SELECT Request_at, count(*) as TotalCount FROM Views1 GROUP BY Request_At) as a, (SELECT Request_at, count(*) as CencelledCount FROM Views1 WHERE Status Like "%cencelled%" GROUP BY Request_At) as b WHERE a.Request_at = b.Request_at;
 */

