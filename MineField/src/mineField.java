import java.util.Random;
import java.util.Scanner;

public class mineField {
    private int row;
    private int col;
    private int counter;
    
	public mineField(int row,int col) {
		this.row=row;
		this.col=col;
	}
	public void run() {
		Scanner scan=new Scanner(System.in);
	     String[][] board=new String[this.row][this.col];
	     String[][] mBoard= new String[this.row][this.col];
	     
	     int mNumber=(this.row*this.col)/4;
	     
	     int[] index1=new int[mNumber];
	     int[] index2=new int[mNumber];
	     
	     Random random=new Random();
	     
	     boolean onGame=true;
	     int win=0;
	     for(int i=0;i<board.length;i++) {
	    	  for(int j=0;j<board[i].length;j++) {
	    		  board[i][j]="-";
	    	  }
	     }
	     for(int k=0;k<index1.length;k++) {
	    	 int n=random.nextInt(this.row);
	    	 index1[k]=n;
	     }
	     for(int k=0;k<index2.length;k++) {
	    	 int n=random.nextInt(this.row);
	    	 index2[k]=n;
	     }
	     
	     for(int i=0;i<mBoard.length;i++) {
	    	 for(int j=0;j<mBoard[i].length;j++) {
	    		 mBoard[i][j]="-";
	    	 }
	     }
	     for(int k=0;k<index1.length;k++) {
	    	 mBoard[index1[k]][index2[k]]=" * ";
	     }
	     System.out.println("User name:");
	     String name=scan.nextLine();
	     System.out.print("===================");
	     System.out.println(name+", Welcome to Game");
	     
	     while(onGame) {
	    	 counter=0;
	    	for(String[] row: board) {
	    		for(String col: row) {
	    			System.out.println(col);
	    		}
	    		System.out.println();
	    	}
	    	System.out.print("Enter row number");
	    	int row=scan.nextInt();
	    	--row;
	    	System.out.print("Enter coloumn number");
	    	int col=scan.nextInt();
	    	--col;
	    	
	    	if((row+1>mBoard.length)) {
	    		System.out.println("Invalid row value");
	    		continue;
	    	}
	    	if((col+1>mBoard.length)) {
	    		System.out.println("Invalid coloumn value");
	    		continue;
	    	}
	    	if(mBoard[row][col]==" * ") {
	    		System.out.println("You've stepped on a mine and lost the game.");
	    		onGame=false;
	    	
	    	}
	    	controller(mBoard,row,col);
	    	
	         board[row][col]=" "+(counter)+" ";
	    	win++;
	    	if(win==(this.row*this.col-mNumber)) {
	    		System.out.println("Congratulations, you have won the game!");
	    		onGame=false;
	    	}
	     }
	     System.out.print("=====================");
	     System.out.println("Location of the mines ");
	     for(String[] row: mBoard) {
	    	 for(String col: row) {
	    		 System.out.print(col);
	    	 }
	    	 System.out.println();
	     }
	}
	public void controller(String[][] mBoard,int row,int col) {
		int x=row-1;
		int y=row+1;
		int z=col-1;
		int t=col+1;
		
		if(x<0) {
			x++;
		}
		if(z<0) {
			z++;
		}
		if(y>mBoard.length-1) {
			y--;
		}
		if(t>mBoard.length-1) {
			t--;
		}
		if(mBoard[x][z]==" * ") {
			counter++;
		}
		if(mBoard[x][t]==" * ") {
			counter++;
		}
		if(x!=row&&y!=row) {
			if(mBoard[row][z]==" * ") {
				counter++;
			}
			if(mBoard[row][t]==" * ") {
				counter++;
			}
		}
		if(z!=col&&t!=col) {
			if(mBoard[x][col]==" * ") {
				counter++;
			}
			}
		if(y!=row&& z!=col&&t!= col) {
			if(mBoard[y][col]==" * ") {
				counter++;
			}
		}
		if(mBoard[y][z] == " * "){
            counter++;
        }

        if(mBoard[y][t] == " * "){
            counter++;
        }
		
		
	}
	
}
