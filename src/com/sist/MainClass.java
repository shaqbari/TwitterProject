package com.sist;

import java.io.FileReader;
import java.io.FileWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author user
 *	영문전체[A-Za-z]
 *	영문전체가 아닌것[^A-Za-z]
 *
 *	빅데이터 파일처리 중요 하둡에서도 많이 쓰인다.
 */
public class MainClass {
	
	public static void main(String[] args) {
		String[] data={"문재인", "안철수", "홍준표", "심상정", "유승민", "최순실", "박근혜", "백원우"};
		Pattern[] p=new Pattern[data.length];//패턴을 쓰면 포함된 데이터를 찾을 수 있다.
		for (int i = 0; i < p.length; i++) {
			p[i]=Pattern.compile(data[i]);
		}
		
		try {
			String temp="";
			FileReader fr=new FileReader("c://webDev//twitter.txt");
			//영문은 로그파일에 많으므로 이때 byte기반 input outputStream쓴다.
			//
			int i=0;
			while ((i=fr.read())!=-1) {
				temp+=String.valueOf((char)i);//번호를 읽은뒤 문자로 바꿔 저장
			}
			fr.close();
			String[] strData=temp.split("\n");//데이터를 한줄씩 읽기위해 처리
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
