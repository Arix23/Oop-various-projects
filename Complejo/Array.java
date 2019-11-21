public class Array{
    public static int[] Array() {
    	int[] integerArray;
    	integerArray = new int[20];
	for(int i =0; i<20;i++){
	    integerArray[i] = 20-i;
	}
	return integerArray;
    }
    public static void main(String[] args) {
	for(int i:Array()) {
		//arreglo.length
	    System.out.println(i);
	}
	int [] [] n = {{1,2},{3,4}};
	//Arreglos pueden NO ser rectangulares
	int [] [] b;
	b = new int [2][3];

	//Arreglo irregular
	int [] [] c;
	c = new int [2] [];
	c[0] = new int [3];
	c[1] = new int [5];
	
	//Recorrer un arreglo multidimensional
	for(int i = 0; i<arreglo.length; i++) {
		for(int j = 0; j<arreglo[i].length; j++) {
			arreglo[i][j];
		}
	}
    }
}