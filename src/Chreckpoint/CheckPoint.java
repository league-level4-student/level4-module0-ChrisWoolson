package Chreckpoint;

import java.util.Random;

public class CheckPoint {

	public static void main(String[] args) {
		
		
		int[][] ints = new int[5][5];
		
				for (int i = 0; i < ints.length; i++) {
					for (int j = 0; j < ints[i].length; j++) {
						int rand = new Random().nextInt(1000);
						ints[i][j] = rand;
						
					}
				}
				
				for (int i2 = 0; i2 < ints.length; i2++) {
					for (int j2 = 0; j2 < ints[1].length; j2++) {
						System.out.println(ints[i2][0] + "      " + ints[0][j2]);
					}
				}
				
		
		
		
	}
	
	
	
}
