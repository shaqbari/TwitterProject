package com.sist;

import java.io.FileWriter;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * @author user
 *	Twitter => 데이터검색 : 파일에 저장
 *	언급횟수 => 저장
 *	저장된데이터 => R => 그래프
 */
public class TwitterListener implements StatusListener{

	/* (non-Javadoc)
	 * @see twitter4j.StreamListener#onException(java.lang.Exception)
	 * 예외가 발생했을때 호출되는 메소드 
	 * 
	 */
	@Override
	public void onException(Exception ex) {
		// TODO Auto-generated method stub
		System.out.println(ex.getMessage());
	}

	@Override
	public void onDeletionNotice(StatusDeletionNotice arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see twitter4j.StatusListener#onScrubGeo(long, long)
	 * 지역별로 받을때 사용
	 */
	@Override
	public void onScrubGeo(long arg0, long arg1) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onStallWarning(StallWarning arg0) {
		// TODO Auto-generated method stub
		
	}

	/* (non-Javadoc)
	 * @see twitter4j.StatusListener#onStatus(twitter4j.Status)
	 * 읽을때마다 onStatus자동호출
	 * SAX 작동방식과 비슷하다
	 */
	@Override
	public void onStatus(Status status) {
		// TODO Auto-generated method stub
		String id=status.getUser().getScreenName(); //쓴사람 id를 읽는다.
		String data=status.getText(); //쓴내용
		System.out.println("@"+id+":"+data);
		
		try {
			FileWriter fw=new FileWriter("c:\\webDev\\twitter.txt", true); //true옵션을 줘야 append가 된다, 안쓰면, 지우고 다시만든다.
			fw.write(data);
			fw.close();
					
					
					
		} catch (Exception e) {

		}
	}

	@Override
	public void onTrackLimitationNotice(int arg0) {
		// TODO Auto-generated method stub
		
	}
	
}
