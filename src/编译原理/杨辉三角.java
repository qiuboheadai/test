package ±àÒëÔ­Àí;

import java.util.Scanner;

public class Ñî»ÔÈı½Ç {
	public static void main(String[] args) {
		int[][] a=new int[6][6];
		for(int i=0;i<6;i++) {
			a[i][0]=1;
			a[i][i]=1;
		}
		for(int i=2;i<6;i++) {
			for(int j=1;j<i;j++)
				a[i][j]=a[i-1][j-1]+a[i-1][j];
		}
		for(int i=0;i<6;i++) {
			for(int j=0;j<=i;j++) {
			   System.out.print(a[i][j]+"\t");
			}
			System.out.println();
		}
		yanghui();
	}
	public static void yanghui() {
		System.out.println("................................");
		Scanner in = new Scanner(System.in);
		System.out.print("input n:");
		int n =in.nextInt();
		
		int[][] num = new int[n][];
		
		for(int i = 0;i<num.length;i++) {
			num[i] = new int[i+1];
			num[i][0] = 1;
			num[i][i] = 1;
			for(int j= 0;j<num[i].length;j++) {
				if(i>1&&j>0&&j<num[i].length-1)
					num[i][j] = num[i-1][j-1]+num[i-1][j];
				System.out.print(num[i][j]+"\t");
			}
			System.out.println();
		}
	}
}
