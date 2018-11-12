package com.leetcode.dynamic;

/**
 * @author ly
 * @create 2018-11-10 17:35
 * һ��������λ��һ�� m x n ��������Ͻ� ����ʼ������ͼ�б��Ϊ��Start�� ����

������ÿ��ֻ�����»��������ƶ�һ������������ͼ�ﵽ��������½ǣ�����ͼ�б��Ϊ��Finish������

���ܹ��ж�������ͬ��·����



���磬��ͼ��һ��7 x 3 �������ж��ٿ��ܵ�·����

˵����m �� n ��ֵ�������� 100��

ʾ�� 1:

����: m = 3, n = 2
���: 3
����:
�����Ͻǿ�ʼ���ܹ��� 3 ��·�����Ե������½ǡ�
1. ���� -> ���� -> ����
2. ���� -> ���� -> ����
3. ���� -> ���� -> ����
ʾ�� 2:

����: m = 7, n = 3
���: 28
 **/
public class UniquePaths {

    public static void main(String[] args) {
        System.out.println(uniquePaths(7,3));
    }

    //�ݹ鷽ʽ  ����ʱ������
    public static int uniquePaths1(int m, int n) {
        if(m<=1 && n<=1)
            return 1;
        if(m<=1 && n>1)
            return uniquePaths(m,n-1);
        if(m>1 && n<=1)
            return uniquePaths(m-1,n);
        return uniquePaths(m-1,n) + uniquePaths(m,n-1);
    }

    //�ݹ�ת��Ϊѭ����ʽ
    //ʹ�ö���Ŀռ�����¼ÿһ�����ܵĴ���
    public static int uniquePaths2(int m, int n) {
        int[][] map = new int[m][n];

        for(int i=0;i<m;i++){
            map[i][0] = 1;
        }
        for(int i=0;i<n;i++){
            map[0][i] = 1;
        }

        for(int i=1;i<m;i++){
            for(int j=1;j<n;j++){
                map[i][j] = map[i-1][j] + map[i][j-1];
            }
        }
        return map[m-1][n-1];
    }

    //�鿴������ǿ����Ľ�𷽷� ������˼
    public static int uniquePaths(int m,int n){
        int total = m + n -2; //һ��Ҫ�ߵĲ���
        int down = m - 1;  //����Ҫ�ߵĲ���
        int res = 1;
        for(int i = 1 ; i <= down; i++){
            res =res * (total - down + i) / i;
        }
        return res;
    }

}
