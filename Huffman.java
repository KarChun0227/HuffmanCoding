import java.util.ArrayList;
import java.util.PriorityQueue;

public class Huffman 
{
	
	ArrayList<String> code = new ArrayList<>();
	
	public ArrayList<String> compress(String input)
	{
		String s = input;
		char [] ch = s.toCharArray();
		PriorityQueue<Node> PQ = new PriorityQueue<Node>();
		ArrayList<Node> freq = new ArrayList<>();
		String str = "";
		
		for(int i = 0; i < ch.length; i++)
		{
			boolean check;
			check = true; 
			for(int k = 0; k < freq.size(); k++)
			{
				if(freq.get(k).getCh().equals("" + ch[i]))
				{
					freq.get(k).setFreq(freq.get(k).getFreq() +1);
					check = false;
				}
			}
			if(check == true)
			{
				Node node = new Node("" + ch[i], 1, null, null);
				freq.add(node);
				str = str + ch[i];
			}
			
		}
		
		PQ = toPQ(freq);
		Node tree = buildTree(PQ);
		char [] ch2 = str.toCharArray();
		for(int j = 0; j < ch2.length; j++)
		{
			String cd = codePrint(tree,ch2[j]);
			code.add(cd);
		}

		return code;
	}
	
	private PriorityQueue<Node> toPQ(ArrayList<Node> freq)
	{
		PriorityQueue<Node> PQ = new PriorityQueue<>();
		for(int i = 0; i < freq.size(); i++)
		{
			PQ.add(freq.get(i));
			
		}
		return PQ;
	}
	
	
	private Node buildTree(PriorityQueue<Node> PQ)
	{
		PriorityQueue<Node> treeNode = new PriorityQueue<Node>();
		treeNode = PQ;
		while(treeNode.size() > 1)
		{
			Node right = treeNode.poll();
			Node left = treeNode.poll();
			treeNode.add(new Node(left.getCh()+right.getCh(), left.getFreq() + right.getFreq(), left, right));
		}
		return treeNode.poll();
	}
	
	private String codePrint(Node tree, Character ch)
	{
		String code = "";
		
		while(tree.left != null && tree.right != null)
		{
			if(tree.left.getCh().contains(String.format("%c", ch)))
			{
				code = code + "0";
				tree = tree.left;
			}
			else
			{
				code = code + "1";
				tree = tree.right;
			}
		}
		
		code = code + "\t" + tree.getCh();
		
		return code;
	}
}
