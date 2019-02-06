package binarySearchTree;

import fila.FilaDupEnc;

public class BinarySearchTree<Key extends Comparable<Key>, Value> {

	private Node<Key, Value> root;
	private int size;
	private FilaDupEnc<Node<Key, Value>> queue = new FilaDupEnc<>();

	public BinarySearchTree() {
		setRoot(null);
		this.size = 0;
	}

	public boolean insert(Key nodeKey, Value value) {
		Node<Key, Value> newNode = new Node<>(nodeKey, value);
		Node<Key, Value> currentNode;
		boolean verification = false;
		if (size == 0) {
			setRoot(newNode);
			this.size++;
			verification = true;
		} else {
			currentNode = getRoot();
			while (verification != true) {
				if (nodeKey.compareTo(currentNode.getKey()) == 0) {
					currentNode.setValue(newNode.getValue());
				} else if (nodeKey.compareTo(currentNode.getKey()) > 0) {
					if (currentNode.getRightSon() != null) {
						currentNode = currentNode.getRightSon();
					} else {
						currentNode.setRightSon(newNode);
						newNode.setFather(currentNode);
						this.size++;
						verification = true;
					}
				} else if (nodeKey.compareTo(currentNode.getKey()) < 0) {
					if (currentNode.getLeftSon() != null) {
						currentNode = currentNode.getLeftSon();
					} else {
						currentNode.setLeftSon(newNode);
						newNode.setFather(currentNode);
						this.size++;
						verification = true;
					}
				}
			}
		}
		if (verification) {
			return true;
		} else {
			return false;
		}
	}

	public Node<Key, Value> getSon(Key key, Side side) {
		Node<Key, Value> wantedNode = null;
		Node<Key, Value> node;
		node = get(key);
		if (side.equals(Side.Left)) {
			wantedNode = node.getLeftSon();
		} else if (side.equals(Side.Right)) {
			wantedNode = node.getRightSon();
		}
		return wantedNode;
	}

	public Node<Key, Value> getSon(Node<Key, Value> fatherNode, Side side) {
		Node<Key, Value> wantedNode = null;
		if ((wantedNode = getSon(fatherNode.getKey(), side)) != null) {
			return wantedNode;
		} else {
			System.out.println("Nó não encontrado!");
			return null;
		}
	}

	public Node<Key, Value> get(Key key) {
		Node<Key, Value> currentNode = getRoot();
		Node<Key, Value> wantedNode = null;
		boolean verification = false;
		while (verification != true) {
			if (key.compareTo(currentNode.getKey()) == 0) {
				wantedNode = currentNode;
				verification = true;
			} else if (key.compareTo(currentNode.getKey()) > 0) {
				if (currentNode.getRightSon() != null) {
					currentNode = currentNode.getRightSon();
				} else {
					verification = true;
				}
			} else if (key.compareTo(currentNode.getKey()) < 0) {
				if (currentNode.getLeftSon() != null) {
					currentNode = currentNode.getLeftSon();
				} else {
					verification = true;
				}
			}
		}
		if (verification && wantedNode != null) {
			return wantedNode;
		} else {
			return wantedNode;
		}
	}

	public boolean remove(Node<Key, Value> node) {
		Node<Key, Value> wantedNode = node;
		Node<Key, Value> currentNode = null;
		boolean verification = false;
		if (wantedNode != null) {
			currentNode = wantedNode;
			if (currentNode.getRightSon() != null && currentNode.getLeftSon() != null) {
				currentNode = currentNode.getRightSon();
			}
			if (currentNode.equals(getRoot())) {
				if (currentNode.getLeftSon() != null) {
					this.root = currentNode.getLeftSon();
					this.root.setFather(null);
					currentNode.setLeftSon(null);
					verification = true;
				} else if (currentNode.getRightSon() != null) {
					this.root = currentNode.getRightSon();
					currentNode.getRightSon().setFather(null);
					this.root.setFather(null);
					currentNode.setRightSon(null);
					verification = true;
				}
			}
			while (verification != true) {
				if (currentNode.getRightSon() != null && currentNode.getLeftSon() != null) {
					currentNode = currentNode.getLeftSon();
				} else if (currentNode.getRightSon() != null) {
					wantedNode.setKey(currentNode.getKey());
					wantedNode.setValue(currentNode.getValue());
					currentNode.getRightSon().setFather(currentNode.getFather());
					if (currentNode.getFather().getRightSon() != null
							&& currentNode.getFather().getRightSon().equals(currentNode)) {
						currentNode.getFather().setRightSon(currentNode.getRightSon());
					} else if (currentNode.getFather().getLeftSon() != null
							&& currentNode.getFather().getLeftSon().equals(currentNode)) {
						currentNode.getFather().setLeftSon(currentNode.getRightSon());
					}
					currentNode.setFather(null);
					currentNode.setRightSon(null);
					this.size--;
					verification = true;
				} else if (currentNode.getLeftSon() != null) {
					wantedNode.setKey(currentNode.getKey());
					wantedNode.setValue(currentNode.getValue());
					currentNode.getLeftSon().setFather(currentNode.getFather());
					if (currentNode.getFather().getRightSon() != null
							&& currentNode.getFather().getRightSon().equals(currentNode)) {
						currentNode.getFather().setRightSon(currentNode.getLeftSon());
					} else if (currentNode.getFather().getLeftSon() != null
							&& currentNode.getFather().getLeftSon().equals(currentNode)) {
						currentNode.getFather().setLeftSon(currentNode.getLeftSon());
					}
					currentNode.setFather(null);
					currentNode.setLeftSon(null);
					this.size--;
					verification = true;
				} else {
					wantedNode.setKey(currentNode.getKey());
					wantedNode.setValue(currentNode.getValue());
					if (currentNode.getFather().getRightSon() != null
							&& currentNode.getFather().getRightSon().equals(currentNode)) {
						currentNode.getFather().setRightSon(null);
					} else if (currentNode.getFather().getLeftSon() != null
							&& currentNode.getFather().getLeftSon().equals(currentNode)) {
						currentNode.getFather().setLeftSon(null);
					}
					currentNode.setFather(null);
					this.size--;
					verification = true;
				}
			}
		}
		if (verification) {
			return true;
		} else {
			return false;
		}
	}

	public boolean remove(Node<Key, Value> fatherNode, Side side) {
		if (fatherNode != null) {
			if (side.equals(Side.Right) && fatherNode.getRightSon() != null) {
				return remove(fatherNode.getRightSon());
			} else if (side.equals(Side.Left) && fatherNode.getLeftSon() != null) {
				return remove(fatherNode.getLeftSon());
			} else {
				return false;
			}
		} else {
			return false;
		}
	}

	public boolean remove(Key key) {
		if (remove(get(key))) {
			return true;
		} else {
			return false;
		}
	}

	public int nodeHeight(Key key) {
		Node<Key, Value> currentNode = getRoot();
		Node<Key, Value> wantedNode = null;
		int height = 0;
		boolean verification = false;
		while (verification != true) {
			if (key.compareTo(currentNode.getKey()) == 0) {
				wantedNode = currentNode;
				verification = true;
			} else if (key.compareTo(currentNode.getKey()) > 0) {
				if (currentNode.getRightSon() != null) {
					currentNode = currentNode.getRightSon();
					height++;
				} else {
					verification = true;
				}
			} else if (key.compareTo(currentNode.getKey()) < 0) {
				if (currentNode.getLeftSon() != null) {
					currentNode = currentNode.getLeftSon();
					height++;
				} else {
					verification = true;
				}
			}
		}
		if (verification && wantedNode != null) {
			return height;
		} else {
			System.out.println("Nó não enocntrado!");
			return -1;
		}
	}

	public Node<Key, Value> minimum() {
		Node<Key, Value> currentNode = getRoot();
		while (currentNode.getLeftSon() != null) {
			currentNode = currentNode.getLeftSon();
		}
		return currentNode;
	}

	public Node<Key, Value> maximum() {
		Node<Key, Value> currentNode = getRoot();
		while (currentNode.getRightSon() != null) {
			currentNode = currentNode.getLeftSon();
		}
		return currentNode;
	}

	public boolean isEmpty() {
		if (size <= 0) {
			return true;
		} else {
			return false;
		}
	}

	public String inOrder() {
		queue.limpar();
		inOrder(getRoot());
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int auxSize = 0;
		for (Node<Key, Value> node : queue) {
			builder.append(node.getValue().toString());
			auxSize++;
			if (auxSize < getSize()) {
				builder.append(", ");
			}
		}
		builder.append("]");
		return builder.toString();
	}

	private void inOrder(Node<Key, Value> node) {
		if (node != null) {
			inOrder(node.getLeftSon());
			queue.enfileirar(node);
			inOrder(node.getRightSon());
		}
	}

	public String preOrder() {
		queue.limpar();
		preOrder(getRoot());
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int auxSize = 0;
		for (Node<Key, Value> node : queue) {
			builder.append(node.getValue().toString());
			auxSize++;
			if (auxSize < getSize()) {
				builder.append(", ");
			}
		}
		builder.append("]");
		return builder.toString();
	}

	private void preOrder(Node<Key, Value> node) {
		if (node != null) {
			queue.enfileirar(node);
			preOrder(node.getLeftSon());
			preOrder(node.getRightSon());
		}
	}

	public String postOrder() {
		queue.limpar();
		postOrder(getRoot());
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		int auxSize = 0;
		for (Node<Key, Value> node : queue) {
			builder.append(node.getValue().toString());
			auxSize++;
			if (auxSize < getSize()) {
				builder.append(", ");
			}
		}
		builder.append("]");
		return builder.toString();
	}

	private void postOrder(Node<Key, Value> node) {
		if (node != null) {
			postOrder(node.getLeftSon());
			postOrder(node.getRightSon());
			queue.enfileirar(node);
		}
	}

	/*
	 * public void Destroy (Node<Key, Value> node){ if (node != null){
	 * Destroy(node.getLeftSon()); if (node.getLeftSon() != null &&
	 * node.getRightSon() != null){ if
	 * (node.getFather().getLeftSon().equals(node)){
	 * node.getFather().setLeftSon(null); } else if
	 * (node.getFather().getRightSon().equals(node)){
	 * node.getFather().setRightSon(null); } } else {
	 * Destroy(node.getRightSon()); } } }
	 */

	@Override
	public String toString() {
		queue.limpar();
		if (this.getSize() == 0) {
			return "[]";
		}
		Node<Key, Value> currentNode = null;
		int auxSize = 0;
		this.queue.enfileirar(getRoot());
		auxSize++;
		StringBuilder builder = new StringBuilder();
		builder.append("[");
		builder.append(getRoot().getValue().toString());
		if (auxSize < getSize()) {
			builder.append(", ");
		}
		while (!this.queue.vazia()) {
			currentNode = this.queue.desenfileirar();
			if (currentNode.getLeftSon() != null) {
				this.queue.enfileirar(currentNode.getLeftSon());
				builder.append(currentNode.getLeftSon().getValue().toString());
				auxSize++;
				if (auxSize < getSize()) {
					builder.append(", ");
				}
			}
			if (currentNode.getRightSon() != null) {
				this.queue.enfileirar(currentNode.getRightSon());
				builder.append(currentNode.getRightSon().getValue().toString());
				auxSize++;
				if (auxSize < getSize()) {
					builder.append(", ");
				}
			}
		}
		builder.append("]");
		return builder.toString();
	}

	public FilaDupEnc<Node<Key, Value>> listInOrder() {
		queue.limpar();
		inOrder(getRoot());
		return queue;
	}

	public FilaDupEnc<Node<Key, Value>> listPreOrder() {
		queue.limpar();
		preOrder(getRoot());
		return queue;
	}

	public FilaDupEnc<Node<Key, Value>> listPostOrder() {
		queue.limpar();
		postOrder(getRoot());
		return queue;
	}

	public int getSize() {
		return size;
	}

	public Node<Key, Value> getRoot() {
		return root;
	}

	private void setRoot(Node<Key, Value> root) {
		this.root = root;
	}
}
