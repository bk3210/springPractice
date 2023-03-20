
public class ProductDTO {
	private int prdNum=0;
	private String prdName="";
	private int prdPrice=0;
	private String prdDate="";
	private String prdMaker="";

	// 다른 생성자가 있을 때는 반드시 기본생성자를 추가해줘야 함
	// 기본생성자 없으면 이런식으로 매번 만들때마다 값 추가해줘야 함
	// ProductDTO dto = new ProductDTO(1, "노트북", 1200000, "2020-01-01", "삼성전자");
	// 기본생성자 있으면 이렇게 만들어도 객체생성 가능
	// ProductDTO dto = new ProductDTO();
	public ProductDTO() {
	}

	public ProductDTO(int num) {
		this.prdNum = num;
		// update, delete 메소드의 num값 비교를 위한 객체 생성을 담당함
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
	
	// 객체의 값 비교시 사용됨
	// ProductDTO d1=new ProductDTO();
	// ProductDTO d2=new ProductDTO();
	// d1 == d2 : 서로 같은 메모리를 공유하고 있느냐
	// d1.equals(d2) : 서로 같은 내용을 갖고 있느냐
	// 모든 Java 객체는 Object Class를 상속받음 - equals 함수
	// 자바쪽에서 equals 메소드와 hashcode 메소드는 같이 오버라이딩 해주라고 시킴
	@Override
	public boolean equals(Object obj) {
		// 이 메소드를 호출하면 값비교를 위해 ProductDTO 타입이 Object 타입으로 전환 : 업캐스팅
		// 다시 다운캐스팅 해줘야 접근 가능함
		ProductDTO tempDTO = (ProductDTO)obj;
		return this.prdNum==tempDTO.prdNum;	// 이 번호가 같으면 두 객체가 같은 것이라고 판단함
	}
	
	@Override
	public int hashCode() {
		return this.prdNum;
	}
	
	
	
}
