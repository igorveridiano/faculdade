package genericBinaryTree;

import genericBinaryTree.BinaryTree;

public class MainQuestao2 {

	public static void main(String[] args) {
		BinaryTree<Integer, Integer> tree = new BinaryTree<>();
		tree.Insert(5, 5);
		tree.Insert(5, 3, 3, Side.Left);
		tree.Insert(5, 8, 8, Side.Right);
		tree.Insert(3, 0, 0, Side.Left);
		tree.Insert(3, 1, 1, Side.Right);
		tree.Insert(8, 7, 7, Side.Left);
		tree.Insert(8, 2, 2, Side.Right);
		System.out.println(tree.InOrder());
	}

}
