package com.sist;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TwiterMain {
	
	public static void main(String[] args) {
		try {
			TwitterStream ts=new TwitterStreamFactory().getInstance();//src���־�� �ڵ��ν� �ȴ�. �ƴϸ� �����ڿ��� ��� ����
			String[] data={"������", "��ö��", "ȫ��ǥ", "�ɻ���", "���¹�", "�ּ���", "�ڱ���", "�����"};
			FilterQuery fq=new FilterQuery(); //���� �˻��� �����͸� �ѹ��� ��� ������.
			fq.track(data);
			
			TwitterListener list=new TwitterListener();
			ts.addListener(list);
			ts.filter(fq);//�ǽð��̱� ������ �ð��� ����� �����͸� �����ü� �ִ�.
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
