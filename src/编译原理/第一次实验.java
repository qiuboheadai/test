package ����ԭ��;

import java.util.Scanner;

public class ��һ��ʵ�� {
	public static void main(String[] args) {
		String[][] a = new String[30][2];
		String[] b = new String[30];
		String[] c = new String[30];
		Scanner input = new Scanner(System.in);
		int i = 0,n=0;
		System.out.println("�����ķ�����0����");
		while (i <= 30) {
			b[i] = input.nextLine();
			n++;
			if (b[i].equals("0"))
				break;
			i++;
		}
		n=n-1;
		for (i = 0; i < n; i++) {
			c = b[i].split(":");
			a[i][0] = c[0];
			a[i][1] = c[1];
		}
		FZJF(a,n);
		fw(a,n);
	}

	public static void FZJF(String[][] a,int n) {
		String b = "";
		String c = "";
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < 2; j++) {
				for (int k = 0; k < a[i][j].length(); k++) {
					if (Character.isUpperCase(a[i][j].charAt(k))) {
						if (!b.contains("" + a[i][j].charAt(k)))
							b += a[i][j].charAt(k) + "   ";
					} else {
						if (!c.contains("" + a[i][j].charAt(k))) {
							c += a[i][j].charAt(k) + "   ";
						}
					}
				}
			}
		}
		System.out.println("�ǽK�Y����" + b);
		System.out.println("�K�Y����" + c);
	}

	public static void fw(String[][] a,int n) {
		int b = 0, i, flag = 0, flag1 = 0, flag2 = 0;
		for (i = 0; i < n; i++) {
			int p = 0, k;
			for (k = 0; k < a[i][0].length(); k++) {
				if (Character.isUpperCase(a[i][0].charAt(k))) {
					p++;
				}
			}
			if (p == 0) {
				System.out.println("�������ķ�");
				i++;
				break;
			} else
				b++;
			p=0;
		}
		if (b == i) {
			flag = 1;
		}
		if (flag == 1) {
			b = 0;
			for (i = 0; i < n; i++) {
				if (a[i][0].length() <= a[i][1].length()) {
					b++;
				}
			}
			if (b == i) {
				flag1 = 1;
			} else
				System.out.println("0���ķ�");
		}
		if (flag1 == 1) {
			b = 0;
			int c = 0, d = 0;
			for (i = 0; i < n; i++) {
				for (int k = 0; k < a[i][0].length(); k++) {
					if (Character.isUpperCase(a[i][0].charAt(k))) {
						c++;
					}
				}
				if (c == 1) {
					d++;
				}
				c=0;
			}
			if (d == i) {
				flag2 = 1;
			} else
				System.out.println("1���ķ�");
		}
		if (flag2 == 1) {
			b = 0;
			for (i = 0; i < n; i++) {
				if (Character.isUpperCase(a[i][0].charAt(0)) && a[i][0].length() == 1
						&& Character.isLowerCase(a[i][1].charAt(0))&&(a[i][1].length()==1||
								(Character.isUpperCase(a[i][1].charAt(1))&&a[i][1].length()==2)))
					b++;
			}
			if(b==i)
				System.out.println("3���ķ�");
			else
				System.out.println("2���ķ�");
		}

	}
	// 0���ķ��������뺬�з��ս��
	// 1���ķ����Ҳ���ַ����ȴ��ڵ������
	// 2���ķ���������һ�����ս��
	// 3���ķ�������ʽ��������:A->aB|a
}
