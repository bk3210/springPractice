
public class ProductDTO {
	private int prdNum=0;
	private String prdName="";
	private int prdPrice=0;
	private String prdDate="";
	private String prdMaker="";

	// �ٸ� �����ڰ� ���� ���� �ݵ�� �⺻�����ڸ� �߰������ ��
	// �⺻������ ������ �̷������� �Ź� ���鶧���� �� �߰������ ��
	// ProductDTO dto = new ProductDTO(1, "��Ʈ��", 1200000, "2020-01-01", "�Ｚ����");
	// �⺻������ ������ �̷��� ���� ��ü���� ����
	// ProductDTO dto = new ProductDTO();
	public ProductDTO() {
	}

	public ProductDTO(int num) {
		this.prdNum = num;
		// update, delete �޼ҵ��� num�� �񱳸� ���� ��ü ������ �����
	}

	public ProductDTO(int prdNum, String prdName, int prdPrice, String prdDate, String prdMaker) {
		super();
		this.prdNum = prdNum;
		this.prdName = prdName;
		this.prdPrice = prdPrice;
		this.prdDate = prdDate;
		this.prdMaker = prdMaker;
	}


	public int getPrdNum() {
		return prdNum;
	}

	public void setPrdNum(int prdNum) {
		this.prdNum = prdNum;
	}

	public String getPrdName() {
		return prdName;
	}

	public void setPrdName(String prdName) {
		this.prdName = prdName;
	}

	public int getPrdPrice() {
		return prdPrice;
	}

	public void setPrdPrice(int prdPrice) {
		this.prdPrice = prdPrice;
	}

	public String getPrdDate() {
		return prdDate;
	}

	public void setPrdDate(String prdDate) {
		this.prdDate = prdDate;
	}

	public String getPrdMaker() {
		return prdMaker;
	}

	public void setPrdMaker(String prdMaker) {
		this.prdMaker = prdMaker;
	}

	@Override
	public String toString() {
		return prdNum + "	" + prdName + "	" + prdPrice + "	"
				+ prdDate + "	" + prdMaker;
	}
	
	// ��ü�� �� �񱳽� ����
	// ProductDTO d1=new ProductDTO();
	// ProductDTO d2=new ProductDTO();
	// d1 == d2 : ���� ���� �޸𸮸� �����ϰ� �ִ���
	// d1.equals(d2) : ���� ���� ������ ���� �ִ���
	// ��� Java ��ü�� Object Class�� ��ӹ��� - equals �Լ�
	// �ڹ��ʿ��� equals �޼ҵ�� hashcode �޼ҵ�� ���� �������̵� ���ֶ�� ��Ŵ
	@Override
	public boolean equals(Object obj) {
		// �� �޼ҵ带 ȣ���ϸ� ���񱳸� ���� ProductDTO Ÿ���� Object Ÿ������ ��ȯ : ��ĳ����
		// �ٽ� �ٿ�ĳ���� ����� ���� ������
		ProductDTO tempDTO = (ProductDTO)obj;
		return this.prdNum==tempDTO.prdNum;	// �� ��ȣ�� ������ �� ��ü�� ���� ���̶�� �Ǵ���
	}
	
	@Override
	public int hashCode() {
		return this.prdNum;
	}
	
	
	
}
