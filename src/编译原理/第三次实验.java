package ����ԭ��;

import java.util.Scanner;

public class ������ʵ�� {
	public static void main(String[] args) {
		//E'ΪA T'ΪB
		String[] Vn = new String[100];
		Vn[0] = "E";
		Vn[1] = "A";
		Vn[2] = "T";
		Vn[3] = "B";
		Vn[4] = "F";
		char[] Vt = new char[100];
		Vt[0] = '+';
		// ��Ǯ�������
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
		// ��0=i;1=+;2=*;3=(;4=);5=#;
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
		System.out.println("�������ַ�����");
		Scanner input = new Scanner(System.in);
		String a = input.nextLine();
		System.out.println("����                   ����ջ                           ʣ�����봮                     �Ƶ����ò���ʽ��ƥ��");
		for (int i = 0; i < a.length();) {
			for (int k = 0; k < 5; k++) {
				if (Vn[k].equals("" + stack[bz - 1].charAt(1))) {
					for (int j = 0; j < 7; j++)
						if (a.charAt(i) == Vt[j]) {
							for (int z = 0; z < 8; z++)
								if (S2[k][j][z] != null) {
									System.out.println("����"+bz+"     "+stack[bz-1]+"      "+a.substring(i)+"         "+S2[k][j][z]);
									stack[bz] = stack[bz-1].replace(Vn[k], S1[z][1]);
									if(stack[bz].charAt(1) == '$') {
										stack[bz+1] = stack[bz].substring(0,1)+stack[bz].substring(2);
										bz++;}
									if(stack[bz].equals("#")) {
										System.out.println("����"+bz+"     "+"#"+"      "+"#"+"         ����");
										break;
									}
									bz++;
									if (stack[bz-1].charAt(1) == a.charAt(i)) {
										i++;
										System.out.println("����"+bz+"     "+stack[bz-1]+"      "+a.substring(i)+"         "+"'"+a.charAt(i-1)+"'ƥ��");
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
