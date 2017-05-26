package com.sist;

import java.io.FileWriter;

import twitter4j.StallWarning;
import twitter4j.Status;
import twitter4j.StatusDeletionNotice;
import twitter4j.StatusListener;

/**
 * @author user
 *	Twitter => �����Ͱ˻� : ���Ͽ� ����
 *	���Ƚ�� => ����
 *	����ȵ����� => R => �׷���
 */
public class TwitterListener implements StatusListener{

	/* (non-Javadoc)
	 * @see twitter4j.StreamListener#onException(java.lang.Exception)
	 * ���ܰ� �߻������� ȣ��Ǵ� �޼ҵ� 
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
	 * �������� ������ ���
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
	 * ���������� onStatus�ڵ�ȣ��
	 * SAX �۵���İ� ����ϴ�
	 */
	@Override
	public void onStatus(Status status) {
		// TODO Auto-generated method stub
		String id=status.getUser().getScreenName(); //����� id�� �д´�.
		String data=status.getText(); //������
		System.out.println("@"+id+":"+data);
		
		try {
			FileWriter fw=new FileWriter("c:\\webDev\\twitter.txt", true); //true�ɼ��� ��� append�� �ȴ�, �Ⱦ���, ����� �ٽø����.
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
