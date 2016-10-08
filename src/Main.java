import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		RiceBug hold = new RiceBug();
		Scanner scanner = new Scanner(System.in); 
		int rows = scanner.nextInt();
		int columns = scanner.nextInt();
		int time = scanner.nextInt();
		hold.numBugs =scanner.nextInt();
		hold.field = new boolean[rows][columns];
		for(int i=0; i<hold.numBugs;i++){
			int y=scanner.nextInt();
			int x=scanner.nextInt();
			int time1=scanner.nextInt();
			String temp = scanner.next();
			char temp1 = temp.charAt(0);
			RiceBugInsect temp23 = new RiceBugInsect(x,y,time1,temp1);
			hold.bugs[i]=temp23;
		}	
		scanner.close();
		int currentTime =0;
		while(time >currentTime){
			hold.makeAlive(currentTime);
			
			hold.killPlant();
			hold.moveBug();
			currentTime++;
		}

		int unifectedCount= 0;
		for(int n =0; n< 6;n++){
			for(int m =0;m<6 ;m++){
				if(hold.field[n][m]==false){
					unifectedCount++;
				}
			}
		}
		int counter=0;
		for(int q=0; q< hold.numBugs; q++){
			if(hold.bugs[q].isAlive()==true){
				counter++;
			}
		}
		System.out.println(unifectedCount + " " + counter);
	}

}
