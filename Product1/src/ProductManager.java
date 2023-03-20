import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ProductManager {
	// �����͸� ��� ���� list�� ��������� �߰�
	List<ProductDTO> list = new ArrayList<ProductDTO>();
	Scanner scanner = new Scanner(System.in);
	
	public ProductManager() {
		super();	// �� �ᵵ �ڵ����� ȣ����. �׷��� ���࿡ ������ �� ������ �ֻ�ܿ� ��ġ��Ű��
		list.add(new ProductDTO(1, "������", 10000000, "2023-02-01", "�Ｚ����"));
		list.add(new ProductDTO(2, "��Ʈ��", 12000000, "2023-01-03", "��������"));
		list.add(new ProductDTO(3, "��ġ�����", 40000000, "2023-01-05", "�Ｚ����"));
	}
	
	public void insert() {
		ProductDTO dto = new ProductDTO();
		// �� �������� �ִ� ��ǰ��ȣ ���ں��� �ϳ� ũ�� �ڵ�����
		int num = list.get(list.size()-1).getPrdNum()+1;
		dto.setPrdNum(num);
		System.out.println("��ǰ�� : ");
		dto.setPrdName(scanner.next());
		System.out.println("���� : ");
		dto.setPrdPrice(scanner.nextInt());
		System.out.println("�������� : ");
		dto.setPrdDate(scanner.next());
		System.out.println("������ : ");
		dto.setPrdMaker(scanner.next());
		
		list.add(dto);
	}
	
	public void output() {
		for(ProductDTO dto : list) {
			System.out.println(dto);	// toString �Ƚ��൵ �ڵ� ȣ���
		}
	}
	
	public void update() {
		System.out.print("������ ��ǰ ��ȣ : ");
		int num=scanner.nextInt();
		int pos=list.indexOf(new ProductDTO(num));
		// ������ ��ü ����(��ǰ��ȣ�� �������� ���� �Ŵϱ� �ٸ� ���� �������)
		// �׷��� �Ź� �̷��� ����� �������� DTO �����ڿ� �߰��ϵ��� �Ѵ�

		// indexOf : equals �޼ҵ带 �ڵ� ȣ���ؼ� ���ϴ� ������ ��ġ�� ã����
		// Java�� C�� ������ ������ �������Ƿ� ������ ����� -1�� ��ȯ����
		if(pos==-1) {
			System.out.println("��ǰ�� ã�� �� �����ϴ�.");
			return;
		}	// else�� �� ����
		ProductDTO dto = list.get(pos);
		System.out.println("��ǰ�� : ");
		dto.setPrdName(scanner.next());
		System.out.println("���� : ");
		dto.setPrdPrice(scanner.nextInt());
		System.out.println("�������� : ");
		dto.setPrdDate(scanner.next());
		System.out.println("������ : ");
		dto.setPrdMaker(scanner.next());
	}
	
	public void delete() {	// update�� ���� ���� ����
		System.out.print("������ ��ǰ ��ȣ : ");
		int num=scanner.nextInt();
		int pos=list.indexOf(new ProductDTO(num));
		// int pos=list.indexOf(new ProductDTO(num, "", 0, "", ""));	
		if(pos==-1) {
			System.out.println("��ǰ�� ã�� �� �����ϴ�.");
			return;
		}	// else�� �� ����
		list.remove(new ProductDTO(num));
		// list.remove(new ProductDTO(num, "", 0, "", ""));
		// remove�޼ҵ嵵 equals�� ȣ����
		// equals�� ���� ���� ������ DTO ��ü�� ���� ���� ���� ���� �����ٸ� remove�� �ߵ�
		
	}
	
	public void menuDisplay() {
		System.out.println("1. ���\n2. �߰� \n3. ���� \n4. ���� \n0. ����");
	}
	
	public void start() {
		int menu=0;
		while(true) {
			menuDisplay();
			System.out.print("�����ϼ��� : ");
			menu = scanner.nextInt();
			switch(menu) {
			case 1 : output(); break;
			case 2 : insert(); break;
			case 3 : update(); break;
			case 4 : delete(); break;
			case 0 : return;	// �Լ� ����
			}
		}
	}

}
