package prob02;

import java.util.Scanner;

public class GoodsApp {
	private static final int COUNT_GOODS = 3;
	
	public final void m() {
		
	}
	
	public static void main(String[] args) {
		
		Scanner scanner = new Scanner(System.in);
		Goods[] goods = new Goods[COUNT_GOODS];
		
		
		// 상품 입력
		for(int i = 0; i < COUNT_GOODS; i++) {
			String info = scanner.nextLine();
			String[] infos = info.split(" ");
			//System.out.println(infos[0] + ":" + infos[1] + ":" + infos[2]);
			
			String name = infos[0];
			int price = Integer.parseInt(infos[1]);
			int countStock = Integer.parseInt(infos[2]);
			
			Goods goods2 = new Goods();
			goods2.setName(name);
			goods2.setPrice(price);
			goods2.setCountStock(countStock);
			
			goods[i] = goods2;
			
		}

		// 상품 출
		 for(int i = 0; i < goods.length; i++) {
			 System.out.println(goods[i].getName() + "(가격:" + 
					 goods[i].getPrice() + "원)이 " + 
					 goods[i].getCountStock() + "개 입고 되었습니다.");
		 }
		// 자원정리
		scanner.close();
	}
}
