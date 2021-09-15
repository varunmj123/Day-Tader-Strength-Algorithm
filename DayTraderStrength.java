import java.util.Random;
public class DayTraderStrength {
	public static void main(String[] args) {

		Random randomnum = new Random();
		int[] trading_Records = new int[ 1000 ];
				
		for(int i = 0; i < trading_Records.length; i++){
			trading_Records[i] = randomnum.nextInt(1000)-500;
		};
		
		
		DayTraderStrength test = new DayTraderStrength();
		
		//values to time the functions
		long start_Time;
		long end_Time;
		long total_Time;
		
		//Algorithm A
		start_Time = System.currentTimeMillis();
		System.out.println("Strength: " + test.algorithmAforStrength(trading_Records));
		end_Time = System.currentTimeMillis();
		total_Time = end_Time - start_Time;
		System.out.println("Algorithm A time = " + total_Time + " milliseconds");
		
		//Algorithm B
		start_Time = System.currentTimeMillis();
		System.out.println("Strength: " + test.algorithmBforStrength(trading_Records));
		end_Time = System.currentTimeMillis();
		total_Time = end_Time - start_Time;
		System.out.println("Algorithm B time = " + total_Time + " milliseconds");

}
	//algorithm a
		public int algorithmAforStrength(int[] profits){
			int max = Integer.MIN_VALUE;
			for(int i = 1; i <= profits.length; i++ ){
				for(int j = 0; j < (profits.length - (i - 1)); j++ ){
					int sum = 0;
					for(int k = 0; k < i; k++){
						sum = sum + profits[j + k];
					}
					if(sum > max){
						max = sum;
					}
				}
			}
			return(max);
			}
		
		//algorithm b
		public int algorithmBforStrength(int[] profits){
			int max = profits[0];
			int temporarymax = profits[0];
			for(int i = 1; i < profits.length; i++){
				if(temporarymax + profits[i] > profits[i]){
					temporarymax = temporarymax + profits[i];
				}else{
					temporarymax = profits[i];
				}
				if(temporarymax > max){
					max = temporarymax;
				}
			}
			return(max);
		}//end of function
		
}
