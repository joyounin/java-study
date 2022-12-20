package prob5;

public class Prob5 {

	public static void main(String[] args) {
		
		int count = 1000;
		 
        for(int i = 1; i < count; i++) {
            String number = String.valueOf(i);
            if(number.contains("3") || number.contains("6") || number.contains("9")) {
            System.out.print(number);
            }
            for(int j=0; j < number.length();j++) {
                char chk = number.charAt(j);
                if(chk == '3' || chk == '6' || chk == '9') {
                    System.out.print("짝");
                }
            }
            System.out.println();
        }
        
	}
	
}
