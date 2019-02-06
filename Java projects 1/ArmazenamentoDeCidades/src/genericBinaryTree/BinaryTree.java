package genericBinaryTree;

import fila.FilaDupEnc;

public class BinaryTree<Key extends Comparable<Key>, Value> {

	private Node<Key, Value> root;
	private int size;
	private FilaDupEnc<Node<Key, Value>> queue = new FilaDupEnc<>();

	public BinaryTree() {
		this.root = null;
		this.size = 0;
	}

	public boolean Insert(Key fatherKey, Key nodeKey, Value value, Side side) {
		Node<Key, Value> newNode = new Node<>(nodeKey, value);
		Node<Key, Value> currentNode;
		Node<Key, Value> node;
		if (this.size == 0) {
			Insert(nodeKey, value);
		} else {
			if ((currentNode = Get(fatherKey)) != null) {
				if (side == Side.Left) {
					if (currentNode.getLeftSon() != null) {
						node = currentNode.getLeftSon();
						currentNode.setLeftSon(newNode);
						newNode.setFather(currentNode);
						newNode.setLeftSon(node);
						node.setFather(newNode);
						this.size++;
						return true;
					} else {
						currentNode.setLeftSon(newNode);
						newNode.setFather(currentNode);
						this.size++;
						return true;
					}
				} else if (side == Side.Right) {
					if (currentNode.getRightSon() != null) {
						node = currentNode.getRightSon();
						currentNode.setRightSon(newNode);
						newNode.setFather(currentNode);
						newNode.setRightSon(node);
						node.setFather(newNode);
						this.size++;
						return true;
					} else {
						currentNode.setRightSon(newNode);
						newNode.setFather(currentNode);
						this.size++;
						return true;
					}
				}
			} else {
				System.out.println("O nó buscado para quem deseja insirir um novo nó seguinte não existe");
			}
		}
		return false;
	}

	public boolean Insert(Key nodeKey, Value value) {
		queue.limpar();
		Node<Key, Value> newNode = new Node<>(nodeKey, value);
		Node<Key, Value> currentNode = new Node<>(nodeKey, value);
		boolean verification = false;
		if (size == 0) {
			this.root = newNode;
			this.size++;
			return true;
		} else {
			this.queue.enfileirar(getRoot());
			while (!this.queue.vazia()) {
				currentNode = this.queue.desenfileirar();
				if (currentNode.getLeftSon() != null) {
					this.queue.enfileirar(currentNode.getLeftSon());
				} else {
					currentNode.setLeftSon(newNode);
					newNode.setFather(currentNode);
					this.size++;
					verification = true;
					break;
				}
				if (currentNode.getRightSon() != null) {
					this.queue.enfileirar(currentNode.getRightSon());
				} else {
					currentNode.setRightSon(newNode);
					newNode.setFather(currentNode);
					this.size++;
					verification = true;
					break;
				}
			}
		}
		if (verification) {
			return true;
		} else {
			return false;
		}
	}

	public Node<Key, Value> GetSon(Key key, Side side) {
		Node<Key, Value> wantedNode = null;
		Node<Key, Value> node;
		node = Get(key);
		if (side.equals(Side.Left)) {
			wantedNode = node.getLeftSon();
		} else if (side.equals(Side.Right)) {
			wantedNode = node.getRightSon();
		}
		return wantedNode;
	}

	public Node<Key, Value> GetSon(Node<Key, Value> fatherNode, Side side) {
		Node<Key, Value> wantedNode = null;
		if ((wantedNode = GetSon(fatherNode.getKey(), side)) != null) {
			return wantedNode;
		} else {
			System.out.println("Nó não encontrado!");
			return null;
		}
	}

	public Node<Key, Value> Get(Key key) {
		queue.limpar();
		Node<Key, Value> currentNode = null;
		Node<Key, Value> wantedNode = null;
		this.queue.enfileirar(getRoot());
		if (this.root != null && this.root.getKey().equals(key)) {
			wantedNode = getRoot();
		} else {
			while (!this.queue.vazia()) {
				currentNode = this.queue.desenfileirar();
				if (currentNode.getLeftSon() != null) {
					this.queue.enfileirar(currentNode.getLeftSon());
					if (currentNode.getLeftSon().getKey().equals(key)) {
						wantedNode = currentNode.getLeftSon();
					}
				}

				if (currentNode.getRightSon() != null) {
					this.queue.enfileirar(currentNode.getRightSon());
					if (currentNode.getRightSon().getKey().equals(key)) {
						wantedNode = currentNode.getRightSon();
					}
				}
			}
		}
		if (wantedNode != null) {
			return wantedNode;
		} else {
			System.out.println("O nó buscado não existe");
		}
		return wantedNode;
	}

	public boolean Remove(Node<Key, Value> node) {
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

	public boolean Remove(Node<Key, Value> fatherNode, Side side) {
		Node<Key, Value> node = null;
		if (side.equals(Side.Left)) {
			node = fatherNode.getLeftSon();
		} else if (side.equals(Side.Right)) {
			node = fatherNode.getRightSon();
		}
		if (Remove(node)) {
			return true;
		} else {
			return false;
		}
	}

	public boolean Remove(Key key) {
		Node<Key, Value> node = null;
		node = Get(key);
		if (Remove(node)) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * public int Index(Node<Key, Value> fatherNode, Side side) { int index = 0;
	 * Node<Key, Value> currentNode; for (int i = 0; i < this.nodeList.size();
	 * i++) { currentNode = this.nodeList.get(i); if
	 * (currentNode.equals(fatherNode)) { if (side.equals(Side.Right)) { index =
	 * 2 * (i + 1); } else if (side.equals(Side.Left)) { index = (2 * (i + 1)) -
	 * 1; } } } if (this.nodeList.size() < index) { for (int i = 0; i < index;
	 * i++) { this.nodeList.add(null); } } return index; }
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
		if (auxSize < this.size) {
			builder.append(", ");
		}

		while (!this.queue.vazia()) {
			currentNode = this.queue.desenfileirar();
			if (currentNode.getLeftSon() != null) {
				this.queue.enfileirar(currentNode.getLeftSon());
				builder.append(currentNode.getLeftSon().getValue().toString());
				auxSize++;
				if (auxSize < this.size) {
					builder.append(", ");
				}
			}

			if (currentNode.getRightSon() != null) {
				this.queue.enfileirar(currentNode.getRightSon());
				builder.append(currentNode.getRightSon().getValue().toString());
				auxSize++;
				if (auxSize < this.size) {
					builder.append(", ");
				}
			}
		}
		builder.append("]");

		return builder.toString();
	}

	private void PreOrder(Node<Key, Value> node) {
		if (node != null) {
			queue.enfileirar(node);
			PreOrder(node.getLeftSon());
			PreOrder(node.getRightSon());
		}
	}

	public FilaDupEnc<Node<Key, Value>> ListPreOrder() {
		queue.limpar();
		PreOrder(getRoot());
		return queue;
	}

	public Node<Key, Value> getRoot() {
		return root;
	}

	public int getSize() {
		return size;
	}

}
