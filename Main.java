import java.util.Scanner;

public class Main 
{
	static Huffman HM = new Huffman();
	static Scanner sc = new Scanner(System.in);
	
	public static void main(String args[])
	{
		String input;
		System.out.println("Give some thing");
		input = sc.nextLine();
		HM.compress(input);
		for(String x: HM.code)
		{
			System.out.println(x);
		}
	}
}
