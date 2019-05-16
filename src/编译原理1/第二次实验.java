package 编译原理1;

import java.util.Scanner;

public class 第二次实验 {
	public static void main(String[] args) {
		String[][] DFA =new String[8][8];
		for(int i=0;i<8;i++)
			for(int j=0;j<8;j++)
				DFA[i][j]="";
		DFA[1][3]="a";
		DFA[1][2]="b";
		DFA[2][4]="a";
		DFA[2][2]="b";
		DFA[3][3]="c";
		DFA[3][5]="d";
		DFA[3][6]="b";
		DFA[4][5]="d";
		DFA[5][4]="a";
		DFA[4][3]="c";
		DFA[4][7]="b";
		DFA[7][6]="b";
		DFA[6][6]="b";
		System.out.println("请输入一段字符串：");
		Scanner input =new Scanner(System.in);
		String a =input.nextLine();
		int k=1,j=0,i;
		for( i=0;i<a.length();i++) {
			for( j=1;j<8;j++) {
				if(DFA[k][j].equals(""+a.charAt(i))) {
					k=j;
					break;
				}
			}
			if(j==8) {
				break;
			}
		}
		if(i==a.length()&&(j==6||j==7)) {
			System.out.println("是");
		}
		else
			System.out.println("不能识别");
		
		
		
	}

}
