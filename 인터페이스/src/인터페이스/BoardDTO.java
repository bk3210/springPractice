package �������̽�;

public class BoardDTO {
	private String title="";
	private String writer="";
	private String contents="";
	
	// �⺻������ : ����ڰ� ������ ������ �ý����� ���� ȣ����(�ϴ� ���� ��� ������)
	// ����ڰ� ����Ʈ ������(�Ű������� ���� ������)�� ������ �ʰ� �ٸ� �����ڸ� �����
	// �ý����� ����Ʈ �����ڸ� ����� ���� �ʱ� ������ ��ü�� ������ �� �⺻ �����ڰ� �������� ����
	// ��, ���� �ٸ� �����ڰ� �ʿ��� ��Ȳ�̶�� �ݵ�� �⺻�����ڸ� ����� ����
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
