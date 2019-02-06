package binarySearchTree;


public class Main {

	public static void main(String[] args) {
		BinarySearchTree<Integer, Integer> tree = new BinarySearchTree<>();
		tree.insert(10, 10);
		tree.insert(20, 20);
		tree.insert(26, 26);
		tree.insert(29, 29);
		tree.insert(30, 30);
		tree.insert(50, 50);
		System.out.println(tree.toString());
		tree.balanceTree();
		System.out.println(tree.toString());
	}

}
