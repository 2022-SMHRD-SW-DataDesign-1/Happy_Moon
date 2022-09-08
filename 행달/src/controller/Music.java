package controller;

	import java.util.ArrayList;

import javazoom.jl.player.MP3Player;
import model.MusicModel;

	public class Music { // Controller 플레이랑 스탑밖에 없어요
		ArrayList<MusicModel> musicList = new ArrayList<MusicModel>();
		MP3Player mp3 = new MP3Player();
		int currentIndex = 0;
		
		public Music() {
			
			musicList.add(new MusicModel("bgm//computer+keyboard.mp3"));//1번재생
			musicList.add(new MusicModel("bgm//scary_comming.mp3"));//1번재생
			musicList.add(new MusicModel("bgm//walking_nearly.mp3"));//1번재생

		}
		
		public MusicModel play(int num) {
			MusicModel m = musicList.get(num-1);
			
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			
			mp3.play(m.getMusicPath());
			
			return m;
			
		}
		
		
		public MusicModel play() {
			MusicModel m = musicList.get(currentIndex);
			
			if(mp3.isPlaying()) {
				mp3.stop();
			}
			
			mp3.play(m.getMusicPath());
			
			return m;
			
		}
		
		public void stop() {
			mp3.stop();
		}
		
	}
