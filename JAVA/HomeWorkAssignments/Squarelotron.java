
public class Squarelotron {
    int squarelotron[][];
    int size;
    public Squarelotron(int n){
	int count = 1;
	this.size = n;
	squarelotron = new int [n][n];
	for (int i = 0; i <= n-1 ; i++) {
	    for (int j = 0; j <= n-1; j++) {
		squarelotron[i][j] = count;
	 
		count+= 1;

	    }
	}
    }

    public Squarelotron upsideDownFlip(int ring){
	Squarelotron squarelotrontemp = new Squarelotron(this.size);
	for (int i = 0; i <= this.size-1; i++) {
	    for (int j = 0; j <= this.size-1; j++) {
		if (i == ring - 1 || i == this.size - ring){
		    squarelotrontemp.squarelotron[i][j] = squarelotron[this.size - i - 1][j];
		}		else{
		    squarelotrontemp.squarelotron[i][j] = squarelotron[i][j];
		}
	    }
	}
	return squarelotrontemp;
    } 

    public Squarelotron mainDiagonalFlip(int ring){
	Squarelotron squarelotrontemp = new Squarelotron(this.size);
	int[][] temp = new int[this.size][this.size];
	
for (int i = 0; i < this.squarelotron.length; i++) {
	    for (int j = 0; j < this.squarelotron.length; j++) {
	squarelotrontemp.squarelotron[i][j] = this.squarelotron[i][j];
	    }
	
	}
	 
     
	for (int i = ring - 1 ; i <= this.size - ring; i++) {
	    for (int j = ring - 1 ; j <= this.size - ring; j++) {
		if (i==j) {
		    continue;
		}
		temp[i][j] = squarelotrontemp.squarelotron[i][j];
		squarelotrontemp.squarelotron[i][j] = squarelotrontemp.squarelotron[j][i];
		squarelotrontemp.squarelotron[j][i] = temp[i][j];
		if (j == this.size - ring) {
		    i = this.size - ring;
		    j = ring - 1;
		    
		}
	        }
	}
	return squarelotrontemp;
    }


 void rotateRight(int numberOfTurns){

	while (numberOfTurns != 0){
	    Squarelotron sqtemp = new Squarelotron(this.size);
      
	    if (numberOfTurns > 0){
		for (int i = 0; i <= this.size - 1 ; i++) {
		    for (int j = 0; j <= this.size-1; j++) {
			sqtemp.squarelotron[j][this.size-1-i] = this.squarelotron[i][j];
			
             
		    }
		}
         numberOfTurns--;
	    }
	    else if(numberOfTurns < 0){ 
		for (int i = 0; i <= this.size - 1 ; i++) {
		    for (int j = 0; j <= this.size-1; j++) {
			sqtemp.squarelotron[this.size-1-j][i] = this.squarelotron[i][j];
		    }
		}


		numberOfTurns++;

	    }


	    this.squarelotron = sqtemp.squarelotron;

	}

    }


    public static void main(String[] args) {
	Squarelotron sq = new Squarelotron(4);

	for (int i = 0; i < sq.squarelotron.length; i++) {
	    for (int j = 0; j < sq.squarelotron[i].length; j++) {
		System.out.print(sq.squarelotron[i][j] + " ");
	    }
	    System.out.println();
	}
	System.out.println();
	System.out.println("Returned from upsidedown");
	System.out.println();
	Squarelotron Sq1 = sq.upsideDownFlip(2);
	for (int i = 0; i < Sq1.squarelotron.length; i++) {
	    for (int j = 0; j < Sq1.squarelotron.length; j++) {
		System.out.print(Sq1.squarelotron[i][j] + " ");
	    }
	    System.out.println();
	}
	 
	Squarelotron Sq2 = sq.mainDiagonalFlip(1);
	System.out.println("DiagonalFlip");
	for (int i = 0; i < Sq2.squarelotron.length; i++) {
	    for (int j = 0; j < Sq2.squarelotron.length; j++) {
		System.out.print(Sq2.squarelotron[i][j] + " ");
	    }
	    System.out.println();
	}

    }

}

