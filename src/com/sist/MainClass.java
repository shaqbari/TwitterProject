package com.sist;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author user
 *	������ü[A-Za-z]
 *	������ü�� �ƴѰ�[^A-Za-z]
 *
 *	������ ����ó�� �߿� �ϵӿ����� ���� ���δ�.
 */
public class MainClass {
	
	public static void main(String[] args) {
		String[] data={"������", "��ö��", "ȫ��ǥ", "�ɻ���", "���¹�", "�ּ���", "�ڱ���", "�����"};
		Pattern[] p=new Pattern[data.length];//������ ���� ���Ե� �����͸� ã�� �� �ִ�.
		for (int i = 0; i < p.length; i++) {
			p[i]=Pattern.compile(data[i]);
		}
		
		try {
			String temp="";
			FileReader fr=new FileReader("c://webDev//twitter.txt");
			//������ �α����Ͽ� �����Ƿ� �̶� byte��� input outputStream����.
			//
			int i=0;
			while ((i=fr.read())!=-1) {
				temp+=String.valueOf((char)i);//��ȣ�� ������ ���ڷ� �ٲ� ����
			}
			fr.close();
			String[] strData=temp.split("\n");//�����͸� ���پ� �б����� ó��
			Matcher[] m=new Matcher[data.length];
			int[] count=new int[data.length];
			
			for(int a=0; a<strData.length; a++){
				for (int j = 0; j < m.length; j++) {
					m[j]=p[j].matcher(strData[a]);
					if (m[j].find()) {
						count[j]++;
					}
				}
			}
			
			String csv="";
			
			for(int k=0; k<data.length; k++){
				System.out.println(data[k]+":"+count[k]);
				csv+=data[k]+" "+count[k]+"\n";
			}
			
			FileWriter fw=new FileWriter("c:\\webDev\\data.txt");
			fw.write(csv);
			fw.close();
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
