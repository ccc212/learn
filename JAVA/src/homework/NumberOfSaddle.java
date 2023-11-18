package homework;

public class NumberOfSaddle {
    public static void main(String[] args) {
        int phalanx[][] = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };
        int saddlenum[] = findNumberOfSaddle(phalanx);
        if (saddlenum.length != 0) {
            System.out.println("马鞍数是：");
            for (int a : saddlenum) if (a != 0) System.out.print(a + " ");
        } else System.out.println("不存在马鞍数");
    }

    public static int[] findNumberOfSaddle(int phalanx[][]) {
        int num = phalanx.length, count = 0;
        int result[] = new int[num];
        for (int i = 0; i < num; i++) {
            int max = phalanx[0][0], min = phalanx[i][0];
            int temp1 = 0, temp2 = -1;
            for (int j = 0; j < num; j++) {
                if (min > phalanx[i][j]) {
                    min = phalanx[i][j];
                    temp1 = j;
                }
            }
            for (int k = 0; k < num; k++) {
                if (max < phalanx[k][temp1]) {
                    max = phalanx[k][temp1];
                    temp2 = k;
                }
            }
            if (i == temp2 && max == min) {
                result[count] = min;
                count++;
            }
        }
        return result;
    }
}
