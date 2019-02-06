package genericTernaryTree;

public class Test {

	public static void main(String[] args) {
		TernaryTree<Integer, String> tree = new TernaryTree<>();
		tree.Insert(null, 1, "Aracaju", null);
		tree.Insert(1, 7, "São Paulo", Side.Left);
		tree.Insert(1, 12, "Salvador", Side.Right);
		tree.Insert(7, 17, "São Bernanrdo do Campo", Side.Left);
		tree.Insert(17, 2, "Santos", Side.Middle);
		tree.Insert(2, 5, "São Vicente", Side.Right);
		tree.Insert(5, 4, "Osasco", Side.Left);
		tree.Insert(1, 8, "São Cristovão", Side.Middle);
		System.out.println(tree.toString());
		System.out.println(tree.Get(2).getLeftSon());
	}

}
