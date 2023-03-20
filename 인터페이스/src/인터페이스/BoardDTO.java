package 인터페이스;

public class BoardDTO {
	private String title="";
	private String writer="";
	private String contents="";
	
	// 기본생성자 : 사용자가 만들지 않으면 시스템이 만들어서 호출함(하는 일이 없어도 무조건)
	// 사용자가 디폴트 생성자(매개변수가 없는 생성자)를 만들지 않고 다른 생성자를 만들면
	// 시스템이 디폴트 생성자를 만들어 주지 않기 때문에 객체를 생성할 때 기본 생성자가 생성되지 않음
	// 즉, 만약 다른 생성자가 필요한 상황이라면 반드시 기본생성자를 만들어 주자
	public BoardDTO() {
		super();
	}
	
	public BoardDTO(String title, String writer, String contents) {
		super();
		this.title = title;
		this.writer = writer;
		this.contents = contents;
	}

	@Override
	public String toString() {
		return String.format("%s %s %s", title, writer, contents);
	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWriter() {
		return writer;
	}
	public void setWriter(String writer) {
		this.writer = writer;
	}
	public String getContents() {
		return contents;
	}
	public void setContents(String contents) {
		this.contents = contents;
	}

}
