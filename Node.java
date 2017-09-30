
public class Node implements Comparable<Node>
{
	private String ch;
	private int freq;
	Node left,right;
	
	
	public String getCh() 
	{
		return ch;
	}

	public void setCh(String ch) 
	{
		this.ch = ch;
	}

	public int getFreq() 
	{
		return freq;
	}

	public void setFreq(int freq) 
	{
		this.freq = freq;
	}

	public Node(String ch, int freq, Node left, Node right)
	{
		this.ch = ch;
		this.freq = freq;
		this.left = left;
		this.right = right;
	}
	
	public boolean isLeaf()
	{
		assert((left == null) && (right == null) );
		return false ;
	}
	
	@Override
	public int compareTo(Node o) 
	{
		return this.freq - o.freq;
	}

}
