package Programmers.LV0;

public class 연속된수의합 {
    public int[] solution(int num, int total) {
        int part_sum = 0;
        int total_part_sum = 0;
        int start = 0;
        int[] result = new int [num];

        for(int i = 1; i <= num-1; i++){
            part_sum = part_sum + i;
        }
        //n,n+1,n+2,n+3...이런식으로 생각

        total_part_sum = total - part_sum;
        start = total_part_sum / num;
        //n,n,n,n,...다 합해진게 total_part_sum이므로 나누면 시작점
        for(int i = 0; i < num; i++){
            result[i] = start + i;
        }
        return result;
    }
}
