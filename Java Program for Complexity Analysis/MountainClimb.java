import java.util.*;


class BackPack{
	// for Storing food 
	private String[] food;
	private int foodLength;
	
	// for storing equipments
	private String[] equipment;
	private int equipLength;
	
	//for storing cloths
	private String[] clothing;
	private int clothLength;
	
	//for Storing Elevation
	private int elevation;
	
	//for Input Stream
	private Scanner sc;
	
	
	public BackPack(String[] food,String[] equipment,String[] clothing) {
		sc=new Scanner(System.in);
		
		this.food=new String[100];
		this.foodLength=0;
		for(int i=0;i<food.length;i++) {
			this.food[i]=food[i];
			this.foodLength++;
		}
		
		this.equipment=new String[100];
		this.equipLength=0;
		for(int i=0;i<equipment.length;i++) {
			this.equipment[i]=equipment[i];
			this.equipLength++;
		}
		
		this.clothing=new String[100];
		this.clothLength=0;
		for(int i=0;i<clothing.length;i++) {
			this.clothing[i]=clothing[i];
			this.clothLength++;
		}
		
		this.elevation=100;					// Intitial Elevation.
	}
	
	public BackPack() {
		sc=new Scanner(System.in);
		
		this.food=new String[100];
		this.foodLength=0;

		this.equipment=new String[100];
		this.equipLength=0;

		this.clothing=new String[100];
		this.clothLength=0;
		
		this.elevation=100;				//Initial Elevation.
	}
	
	
	
	public void getFood() {
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Food item:");
		for(int i=0;i<this.foodLength;i++){
			System.out.print(this.food[i]+", ");
		}
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	
	
	public void getEquip() {
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Equipments:");
		for(int i=0;i<this.equipLength;i++){
			System.out.print(this.equipment[i]+", ");
		}
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	
	
	public void getCloths() {
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------");
		System.out.println("Clothings:");
		for(int i=0;i<this.clothLength;i++){
			System.out.print(this.clothing[i]+", ");
		}
		System.out.println("\n-----------------------------------------------------------------------------------------------------------------------------------------------------\n");
	}
	
	
	public void addMoreFood() {

		System.out.println("Enter the number of food item you want to add");
		int n=sc.nextInt();
		
		for(int i=this.foodLength;i<n+this.foodLength;i++) {
			System.out.println("Enter the food item you want to add");
			this.food[i]=sc.next();
		}
		this.foodLength+=n;
		System.out.println();
	}
	
	
	public void addMoreEquipment() {
		
		System.out.println("Enter the number of Equipments you want to add");
		int n=sc.nextInt();
		
		for(int i=this.equipLength;i<n+this.equipLength;i++) {
			System.out.println("Enter the equipment item you want to add");
			this.equipment[i]=sc.next();
		}
		this.equipLength+=n;
		System.out.println();
	}
	
	
	public void addMoreCloths() {
		
		System.out.println("Enter the number of Cloths you want to add");
		int n=sc.nextInt();
		
		for(int i=this.clothLength;i<n+this.clothLength;i++) {
			System.out.println("Enter the clothing item you want to add");
			this.clothing[i]=sc.next();
		}
		this.clothLength+=n;
		System.out.println();
	}
	
	
	
	public void getElevation() {
		System.out.printf("\nCurrently You are at %d Elevation\n",this.elevation);
	}

	
	public void addElevation() {
		// To Increase the elevation value.
		System.out.println("Press 1, if you Have climbed 455.");
		System.out.println("Press 2, if you want to add other value than 455.");
		int choice=sc.nextInt();
		if(choice==2) {
			System.out.println("Enter the Elevation You climbed from last time");
			int s=sc.nextInt();
			this.elevation+=s;
		}
		else {
			this.elevation+=455;
		}
	}
	
}


public class MountainClimb {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		//intial content is given according to questions.
		BackPack mybackpack=new BackPack(new String[]{"banana"}, new String[] {"map"}, new String[] {"Hat"});
		//BackPack mybackpack=new BackPack();        // IF Your BackPack Contains Nothing Initally, It will also Work Fine.
		
		System.out.println("Intially Your BackPack Contains:");
		mybackpack.getFood();
		mybackpack.getEquip();
		mybackpack.getCloths();
		
		int choice=0;
		
		while(choice!=5) {
			System.out.println("\n---------------------------------------ENTER YOUR CHOICE:----------------------------------------------\n");
			System.out.println("Press 1 to Know items in your BackPack.");
			System.out.println("Press 2 to Add item to your BackPack.");
			System.out.println("Press 3 to Know the current Elevation Where you are.");
			System.out.println("Press 4 to Add more Elevation, and climb Higher.");
			System.out.println("Press 5 to Exit");
			choice=sc.nextInt();
			
			switch(choice) {
				case 1:{
					System.out.println("Press 1 to Know Food item in your bag");
					System.out.println("Press 2 to Know Equipments in your bag");
					System.out.println("Press 3 to Know Cloths in your bag");
					int choice2=sc.nextInt();
					
					if(choice2==1) {
						//to store more food
						mybackpack.getFood();
						
					}else if(choice2==2) {
						//to store more equipment
						mybackpack.getEquip();
						
					}else if(choice2==3) {
						//to store more cloths
						mybackpack.getCloths();
						
					}
					break;
				}
				case 2:{
					//To store more item in mybackpack
					System.out.println("Press 1 to Add Food item in your bag");
					System.out.println("Press 2 to Add Equipments in your bag");
					System.out.println("Press 3 to Add Cloths in your bag");
					int choice2=sc.nextInt();
					
					if(choice2==1) {
						//to store more food
						mybackpack.addMoreFood();
						
					}else if(choice2==2) {
						//to store more equipment
						mybackpack.addMoreEquipment();
						
					}else if(choice2==3) {
						//to store more cloths
						mybackpack.addMoreCloths();
						
					}
					break;
				}
				case 3:{
					mybackpack.getElevation();
					break;
				}
				case 4:{
					mybackpack.addElevation();
					break;
				}
				case 5:{
					choice=5;
				}	
			}
		}
		System.out.println("CLOSING");
		sc.close();
	}

}