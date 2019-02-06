package genericBinaryTree;

public class Main {

	public static void main(String[] args) {
		BinaryTree<Integer, String> tree = new BinaryTree<>();
		tree.Insert(11, "São Paulo");
		tree.Insert(13, "Santos");
		tree.Insert(11, 79, "Aracaju", Side.Left);
		System.out.println(tree.toString());
		System.out.println(tree.getSize());
		System.out.println(tree.Get(11).getValue().toString());
	}

}
