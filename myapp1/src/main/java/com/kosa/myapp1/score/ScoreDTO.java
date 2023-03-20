package com.kosa.myapp1.score;

public class ScoreDTO {
	private String seq="";
	private String name="";
	private String kor="";
	private String mat="";
	private String eng="";

	public ScoreDTO() {
	// TODO Auto-generated constructor stub
	}

	public ScoreDTO(String seq, String name, String kor, String mat, String eng) {
		super();
		this.seq = seq;
		this.name = name;
		this.kor = kor;
		this.mat = mat;
		this.eng = eng;
	}

	public String getName() {
		return name;
	}

	public String getSeq() {
		return seq;
	}

	public void setSeq(String seq) {
		this.seq = seq;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getKor() {
		return kor;
	}

	public void setKor(String kor) {
		this.kor = kor;
	}

	public String getMat() {
		return mat;
	}

	public void setMat(String mat) {
		this.mat = mat;
	}

	public String getEng() {
		return eng;
	}

	public void setEng(String eng) {
		this.eng = eng;
	}

	

}
