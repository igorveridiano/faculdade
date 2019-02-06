package questao3;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class Node<Key extends Comparable<Key>, Value> {

	private Node<Key, Value> father;
	private Node<Key, Value> rightSon;
	private Node<Key, Value> leftSon;
	ArrayList<String> listTime = new ArrayList<>();

	private Key key;
	private Value value;

	Node(Key key, Value value) {
		Date currentTime = new Date();
		SimpleDateFormat formate = new SimpleDateFormat("hh:mm");
		listTime.add(formate.format(currentTime));
		this.value = value;
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

}
