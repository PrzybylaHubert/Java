
public class Process {
	
	int[] seekForFirstLetter(int i_position, int j_position, char[] seeked, char letters[][]){
		int[] position = new int[2];
		for(int i=i_position; i<5; i++) {
			for(int j=j_position; j<5; j++) {
				if(letters[i][j]==seeked[0]) {
					position[0] = i;
					position[1] = j;
					return position;
				}
			}
		}
		position[0] = -1;
		position[1] = -1;
		return position;
	}
	
	int [] seekForSecondLetter(int position_i, int position_j, char letters[][], char seeked[]){
		int[] vector = new int[2];
		for(int i=position_i-1; i<=position_i+1; i++) {
			if(i<0 || i>=letters.length) 
				continue;
			for(int j=position_j-1; j<=position_j+1; j++) {
				if(j<0 || j>=letters[i].length || (position_i==i && position_j==j)) 
					continue;
				if(letters[i][j]==seeked[1]) {
					vector[0] = i-position_i;
					vector[1] = j-position_j;
					return vector;
				}
			}
		}
		vector[0] = 0;
		vector[1] = 0;
		return vector;
	}
	
	public void seekForAnotherLetter(int position_i, int position_j, int[] vector) {
		position_i = position_i + vector[0];
		position_j = position_j + vector[1];
	}
		
	
	
}
