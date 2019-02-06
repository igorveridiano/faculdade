package avltree;


public class Main {

	public static void main(String[] args) {
		AVLtree<Integer, Integer> tree = new AVLtree<>();
		tree.insert(26, 26);
		tree.insert(31, 31);
		tree.insert(98, 98);
		tree.insert(15, 15);
		tree.insert(30, 30);
		tree.insert(84, 84);
		tree.insert(51, 51);
		tree.insert(27, 27);
		tree.insert(65, 65);
		tree.insert(29, 29);
		tree.insert(71, 71);
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.get(65).getBalance());
		System.out.println(tree.toString());
	}

}
