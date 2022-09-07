package model;

public class MusicModel {
	private String musicName;
	private String musicPath;

	public MusicModel(String musicPath) {
		this.musicPath = musicPath;
	}
	
	
	public MusicModel(String musicName,  String musicPath) {
		super();
		this.musicName = musicName;
		this.musicPath = musicPath;
	}
	
	public String getMusicName() {
		return musicName;
	}


	public String getMusicPath() {
		return musicPath;
	}

}
