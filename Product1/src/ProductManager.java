import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
	// 데이터를 담기 위한 list를 멤버변수에 추가
	List<ProductDTO> list = new ArrayList<ProductDTO>();
	Scanner scanner = new Scanner(System.in);
	
	public ProductManager() {
		super();	// 안 써도 자동으로 호출함. 그런데 만약에 쓰려면 꼭 생성자 최상단에 위치시키기
		list.add(new ProductDTO(1, "갤럭시", 10000000, "2023-02-01", "삼성전자"));
		list.add(new ProductDTO(2, "노트북", 12000000, "2023-01-03", "엘지전자"));
		list.add(new ProductDTO(3, "김치냉장고", 40000000, "2023-01-05", "삼성전자"));
	}
	
	public void insert() {
		ProductDTO dto = new ProductDTO();
		// 맨 마지막에 있는 제품번호 숫자보다 하나 크게 자동증가
		int num = list.get(list.size()-1).getPrdNum()+1;
		dto.setPrdNum(num);
		System.out.println("제품명 : ");
		dto.setPrdName(scanner.next());
		System.out.println("가격 : ");
		dto.setPrdPrice(scanner.nextInt());
		System.out.println("생산일자 : ");
		dto.setPrdDate(scanner.next());
		System.out.println("제조사 : ");
		dto.setPrdMaker(scanner.next());
		
		list.add(dto);
	}
	
	public void output() {
		for(ProductDTO dto : list) {
			System.out.println(dto);	// toString 안써줘도 자동 호출됨
		}
	}
	
	public void update() {
		System.out.print("수정할 제품 번호 : ");
		int num=scanner.nextInt();
		int pos=list.indexOf(new ProductDTO(num));
		// 임의의 객체 생성(제품번호가 같은지만 비교할 거니까 다른 값은 상관없음)
		// 그런데 매번 이렇게 만들기 귀찮으니 DTO 생성자에 추가하도록 한다

		// indexOf : equals 메소드를 자동 호출해서 원하는 데이터 위치를 찾아줌
		// Java는 C와 유사한 성격을 가졌으므로 오류가 생기면 -1을 반환해줌
		if(pos==-1) {
			System.out.println("제품을 찾을 수 없습니다.");
			return;
		}	// else는 안 쓴다
		ProductDTO dto = list.get(pos);
		System.out.println("제품명 : ");
		dto.setPrdName(scanner.next());
		System.out.println("가격 : ");
		dto.setPrdPrice(scanner.nextInt());
		System.out.println("생산일자 : ");
		dto.setPrdDate(scanner.next());
		System.out.println("제조사 : ");
		dto.setPrdMaker(scanner.next());
	}
	
	public void delete() {	// update랑 거의 같은 구조
		System.out.print("삭제할 제품 번호 : ");
		int num=scanner.nextInt();
		int pos=list.indexOf(new ProductDTO(num));
		// int pos=list.indexOf(new ProductDTO(num, "", 0, "", ""));	
		if(pos==-1) {
			System.out.println("제품을 찾을 수 없습니다.");
			return;
		}	// else는 안 쓴다
		list.remove(new ProductDTO(num));
		// list.remove(new ProductDTO(num, "", 0, "", ""));
		// remove메소드도 equals를 호출함
		// equals를 통해 새로 생성된 DTO 객체와 비교한 다음 같은 값을 가졌다면 remove를 발동
		
	}
	
	public void menuDisplay() {
		System.out.println("1. 출력\n2. 추가 \n3. 수정 \n4. 삭제 \n0. 종료");
	}
	
	public void start() {
		int menu=0;
		while(true) {
			menuDisplay();
			System.out.print("선택하세요 : ");
			menu = scanner.nextInt();
			switch(menu) {
			case 1 : output(); break;
			case 2 : insert(); break;
			case 3 : update(); break;
			case 4 : delete(); break;
			case 0 : return;	// 함수 종료
			}
		}
	}

}
