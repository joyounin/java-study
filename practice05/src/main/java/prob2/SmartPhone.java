package prob2;

public class SmartPhone extends MusicPhone {
	
	@Override
	public void execute (String function) {
		if (function.equals("앱") ) {
			appPhone();
	          return;
	      } else if (function.equals("음악") ) {
	          playMusic();
	          return;
	      }
	      
	      super.execute( function );
	}
	
	private void appPhone() {
	    System.out.println("앱실행");

	}
	private void playMusic() {
		System.out.println("MP3 플레이어에서 음악재생");
	}
}

