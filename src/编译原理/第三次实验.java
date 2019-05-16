package 编译原理;

import java.util.Scanner;

public class 第三次实验 {
	public static void main(String[] args) {
		//E'为A T'为B
		String[] Vn = new String[100];
		Vn[0] = "E";
		Vn[1] = "A";
		Vn[2] = "T";
		Vn[3] = "B";
		Vn[4] = "F";
		char[] Vt = new char[100];
		Vt[0] = '+';
		// 金钱符代表空
		Vt[1] = '$';
		Vt[2] = '*';
		Vt[3] = 'i';
		Vt[4] = '(';
		Vt[5] = ')';
		Vt[6] = '#';
		String[] S = new String[8];
		S[0] = "E:TA";
		S[1] = "A:+TA";
		S[2] = "A:$";
		S[3] = "T:FB";
		S[4] = "B:*FB";
		S[5] = "B:$";
		S[6] = "F:i";
		S[7] = "F:(E)";
		String[][] S1 = new String[8][2];
		for (int i = 0; i < S.length; i++) {
			S1[i] = S[i].split(":");
		}
		// 令0=i;1=+;2=*;3=(;4=);5=#;
		String[][][] S2 = new String[5][7][8];
		S2[0][3][0] = S[0];
		S2[0][4][0] = S[0];
		S2[1][0][1] = S[1];
		S2[1][5][2] = S[2];
		S2[1][6][2] = S[2];
		S2[2][3][3] = S[3];
		S2[2][4][3] = S[3];
		S2[3][0][5] = S[5];
		S2[3][2][4] = S[4];
		S2[3][5][5] = S[5];
		S2[3][6][5] = S[5];
		S2[4][3][6] = S[6];
		S2[4][4][7] = S[7];
		String[] stack = new String[100];
		for(int i=0;i<stack.length;i++)
			stack[i]="";
		stack[0] = "#E";
		int bz = 1;
		int c = 0;
		System.out.println("请输入字符串：");
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		System.out.println("步骤                   分析栈                           剩余输入串                     推导所用产生式或匹配");
		for (int i = 0; i < a.length();) {
			for (int k = 0; k < 5; k++) {
				if (Vn[k].equals("" + stack[bz - 1].charAt(1))) {
					for (int j = 0; j < 7; j++)
						if (a.charAt(i) == Vt[j]) {
							for (int z = 0; z < 8; z++)
								if (S2[k][j][z] != null) {
									System.out.println("步骤"+bz+"     "+stack[bz-1]+"      "+a.substring(i)+"         "+S2[k][j][z]);
									stack[bz] = stack[bz-1].replace(Vn[k], S1[z][1]);
									if(stack[bz].charAt(1) == '$') {
										stack[bz+1] = stack[bz].substring(0,1)+stack[bz].substring(2);
										bz++;}
									if(stack[bz].equals("#")) {
										System.out.println("步骤"+bz+"     "+"#"+"      "+"#"+"         接受");
										break;
									}
									bz++;
									if (stack[bz-1].charAt(1) == a.charAt(i)) {
										i++;
										System.out.println("步骤"+bz+"     "+stack[bz-1]+"      "+a.substring(i)+"         "+"'"+a.charAt(i-1)+"'匹配");
										stack[bz] = stack[bz-1].substring(0,1)+stack[bz-1].substring(2);
										
										bz++;
										
									}
								}
						}
				}

			}
		}

	}
}
