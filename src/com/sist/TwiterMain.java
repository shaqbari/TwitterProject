package com.sist;

import twitter4j.FilterQuery;
import twitter4j.TwitterStream;
import twitter4j.TwitterStreamFactory;

public class TwiterMain {
	
	public static void main(String[] args) {
		try {
			TwitterStream ts=new TwitterStreamFactory().getInstance();//src에넣어야 자동인식 된다. 아니면 생성자에서 경로 지정
			String[] data={"문재인", "안철수", "홍준표", "심상정", "유승민", "최순실", "박근혜", "백원우"};
			FilterQuery fq=new FilterQuery(); //위의 검색어 데이터를 한번에 묶어서 보낸다.
			fq.track(data);
			
			TwitterListener list=new TwitterListener();
			ts.addListener(list);
			ts.filter(fq);//실시간이기 때문에 시간을 맞춰야 데이터를 가져올수 있다.
			
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
	}
}
