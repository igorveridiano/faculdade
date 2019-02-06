package avltree;

public class Node<Key extends Comparable<Key>, Value> {

	private Node<Key, Value> father;
	private Node<Key, Value> rightSon;
	private Node<Key, Value> leftSon;

	private Key key;
	private Value value;
	private int balance;

	Node(Key key, Value value) {
		this.value = value;
		this.balance = 0;
		this.key = key;
	}

	public Node<Key, Value> getFather() {
		return father;
	}

	public void setFather(Node<Key, Value> father) {
		this.father = father;
	}

	public Node<Key, Value> getRightSon() {
		return rightSon;
	}

	public void setRightSon(Node<Key, Value> rightSon) {
		this.rightSon = rightSon;
	}

	public Node<Key, Value> getLeftSon() {
		return leftSon;
	}

	public void setLeftSon(Node<Key, Value> leftSon) {
		this.leftSon = leftSon;
	}

	public Key getKey() {
		return key;
	}

	public void setKey(Key key) {
		this.key = key;
	}

	public Value getValue() {
		return value;
	}

	public void setValue(Value value) {
		this.value = value;
	}

	public int getBalance() {
		return balance;
	}

	public void setBalance(int balance) {
		this.balance = balance;
	}

}
