import java.util.ArrayList;

public class Main {

	public static void main(String[] args) {
		char[][] letters = { 
				{'a','w','o','r','d'},
				{'w','d','o','g','e'},
				{'o','r','r','r','d'},
				{'r','d','l','o','d'},
				{'d','w','o','r','w'},
				};
		String seeked_word = "word";
		char[] seeked = seeked_word.toCharArray();
		int[] actualPosition = new int[2];
		int vector[] = {1,1};
		int[] lastFirstLetterPosition = new int[2];
		ArrayList<ArrayList<Integer>> FoundLetters = new ArrayList<>();	
		
		Process Process = new Process();
		
		actualPosition = Process.seekForFirstLetter(0, 0, seeked, letters);
		lastFirstLetterPosition[0] = actualPosition[0];
		lastFirstLetterPosition[1] = actualPosition[1];
		
		while(vector[0]!=0 && vector[1]!=0) {

			vector = Process.seekForSecondLetter(actualPosition[0], actualPosition[1], letters, seeked);
			//problem z wektorem - co jeœli znajda sie wiecej niz 2 drugie litery?
		}
		
	}
	
}
