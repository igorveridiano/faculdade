package genericTernaryTree;

import fila.FilaDupEnc;
import listaDuplamenteEncadeada.ListaDuplamenteEncadeada;

public class TernaryTree<Key extends Comparable<Key>, Value> {

	private Node<Key, Value> root;
	private int size;
	private ListaDuplamenteEncadeada<Node<Key, Value>> nodeList = new ListaDuplamenteEncadeada<Node<Key, Value>>();
	private FilaDupEnc<Node<Key, Value>> queue = new FilaDupEnc<>();

	public TernaryTree() {
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
				if (side.equals(Side.Left)) {
					if (currentNode.getLeftSon() != null) {
						node = currentNode.getLeftSon();
						currentNode.setLeftSon(newNode);
						newNode.setFather(currentNode);
						newNode.setLeftSon(node);
						node.setFather(newNode);
						this.nodeList.adicionar(newNode);
						this.size++;
						return true;
					} else {
						currentNode.setLeftSon(newNode);
						newNode.setFather(currentNode);
						this.nodeList.adicionar(newNode);
						this.size++;
						return true;
					}
				} else if (side.equals(Side.Right)) {
					if (currentNode.getRightSon() != null) {
						node = currentNode.getRightSon();
						currentNode.setRightSon(newNode);
						newNode.setFather(currentNode);
						newNode.setRightSon(node);
						node.setFather(newNode);
						this.nodeList.adicionar(newNode);
						this.size++;
						return true;
					} else {
						currentNode.setRightSon(newNode);
						newNode.setFather(currentNode);
						this.nodeList.adicionar(newNode);
						this.size++;
						return true;
					}
				} else if (side.equals(Side.Middle)) {
					if (currentNode.getMiddleSon() != null) {
						node = currentNode.getMiddleSon();
						currentNode.setMiddleSon(newNode);
						newNode.setFather(currentNode);
						newNode.setMiddleSon(node);
						node.setFather(newNode);
						this.nodeList.adicionar(newNode);
						this.size++;
						return true;
					} else {
						currentNode.setMiddleSon(newNode);
						newNode.setFather(currentNode);
						this.nodeList.adicionar(newNode);
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
		Node<Key, Value> newNode = new Node<>(nodeKey, value);
		Node<Key, Value> currentNode = new Node<>(nodeKey, value);
		boolean verification = false;
		if (size == 0) {
			this.root = newNode;
			this.nodeList.adicionar(newNode);
			this.size++;
			return true;
		} else {
			this.root.setVisited(true);
			this.queue.enfileirar(this.root);
			while (!this.queue.vazia()) {
				currentNode = this.queue.desenfileirar();
				if (currentNode.getLeftSon() != null) {
					if (currentNode.getLeftSon().isVisited() == false) {
						currentNode.getLeftSon().setVisited(true);
						this.queue.enfileirar(currentNode.getLeftSon());
					}
				} else {
					currentNode.setLeftSon(newNode);
					newNode.setFather(currentNode);
					this.nodeList.adicionar(newNode);
					this.size++;
					verification = true;
					break;
				}
				if (currentNode.getRightSon() != null) {
					if (currentNode.getRightSon().isVisited() == false) {
						currentNode.getRightSon().setVisited(true);
						this.queue.enfileirar(currentNode.getRightSon());
					}
				} else {
					currentNode.setRightSon(newNode);
					newNode.setFather(currentNode);
					this.nodeList.adicionar(newNode);
					this.size++;
					verification = true;
					break;
				}
				if (currentNode.getMiddleSon() != null) {
					if (currentNode.getMiddleSon().isVisited() == false) {
						currentNode.getMiddleSon().setVisited(true);
						this.queue.enfileirar(currentNode.getMiddleSon());
					}
				} else {
					currentNode.setMiddleSon(newNode);
					newNode.setFather(currentNode);
					this.nodeList.adicionar(newNode);
					this.size++;
					verification = true;
					break;
				}
			}
		}
		for (Node<Key, Value> node : nodeList) {
			node.setVisited(false);
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
		} else if (side.equals(Side.Middle)) {
			wantedNode = node.getMiddleSon();
		}
		return wantedNode;
	}

	public Node<Key, Value> GetSon(Node<Key, Value> fatherNode, Side side) {
		Node<Key, Value> wantedNode = null;
		Node<Key, Value> currentNode = null;
		this.root.setVisited(true);
		this.queue.enfileirar(this.root);
		if (this.root != null && this.root.equals(fatherNode)) {
			if (side.equals(Side.Left)) {
				wantedNode = this.root.getLeftSon();
			} else if (side.equals(Side.Right)) {
				wantedNode = this.root.getRightSon();
			} else if (side.equals(Side.Middle)) {
				wantedNode = this.root.getMiddleSon();
			}
		} else {
			while (!this.queue.vazia()) {
				currentNode = this.queue.desenfileirar();
				if (currentNode.getLeftSon() != null && currentNode.getLeftSon().isVisited() == false) {
					currentNode.getLeftSon().setVisited(true);
					this.queue.enfileirar(currentNode.getLeftSon());
					if (currentNode.getLeftSon().equals(fatherNode)) {
						if (side.equals(Side.Left)) {
							wantedNode = currentNode.getLeftSon().getLeftSon();
						} else if (side.equals(Side.Right)) {
							wantedNode = currentNode.getLeftSon().getRightSon();
						} else if (side.equals(Side.Middle)) {
							wantedNode = currentNode.getLeftSon().getMiddleSon();
						}
					}
				}

				if (currentNode.getRightSon() != null && currentNode.getRightSon().isVisited() == false) {
					currentNode.getRightSon().setVisited(true);
					this.queue.enfileirar(currentNode.getRightSon());
					if (currentNode.getRightSon().equals(fatherNode)) {
						if (side.equals(Side.Left)) {
							wantedNode = currentNode.getRightSon().getLeftSon();
						} else if (side.equals(Side.Right)) {
							wantedNode = currentNode.getRightSon().getRightSon();
						} else if (side.equals(Side.Middle)) {
							wantedNode = currentNode.getRightSon().getMiddleSon();
						}
					}
				}

				if (currentNode.getMiddleSon() != null && currentNode.getMiddleSon().isVisited() == false) {
					currentNode.getMiddleSon().setVisited(true);
					this.queue.enfileirar(currentNode.getMiddleSon());
					if (currentNode.getMiddleSon().equals(fatherNode)) {
						if (side.equals(Side.Left)) {
							wantedNode = currentNode.getMiddleSon().getLeftSon();
						} else if (side.equals(Side.Right)) {
							wantedNode = currentNode.getMiddleSon().getRightSon();
						} else if (side.equals(Side.Middle)) {
							wantedNode = currentNode.getMiddleSon().getMiddleSon();
						}
					}
				}
			}
		}
		for (Node<Key, Value> node : nodeList) {
			node.setVisited(false);
		}
		if (wantedNode != null) {
			return wantedNode;
		} else {
			System.out.println("O nó buscado não existe");
		}
		return wantedNode;
	}

	public Node<Key, Value> Get(Key key) {
		Node<Key, Value> currentNode = null;
		Node<Key, Value> wantedNode = null;
		this.root.setVisited(true);
		this.queue.enfileirar(this.root);
		if (this.root != null && this.root.getKey().equals(key)) {
			wantedNode = this.root;
		} else {
			while (!this.queue.vazia()) {
				currentNode = this.queue.desenfileirar();
				if (currentNode.getLeftSon() != null && currentNode.getLeftSon().isVisited() == false) {
					currentNode.getLeftSon().setVisited(true);
					this.queue.enfileirar(currentNode.getLeftSon());
					if (currentNode.getLeftSon().getKey().equals(key)) {
						wantedNode = currentNode.getLeftSon();
					}
				}

				if (currentNode.getRightSon() != null && currentNode.getRightSon().isVisited() == false) {
					currentNode.getRightSon().setVisited(true);
					this.queue.enfileirar(currentNode.getRightSon());
					if (currentNode.getRightSon().getKey().equals(key)) {
						wantedNode = currentNode.getRightSon();
					}
				}

				if (currentNode.getMiddleSon() != null && currentNode.getMiddleSon().isVisited() == false) {
					currentNode.getMiddleSon().setVisited(true);
					this.queue.enfileirar(currentNode.getMiddleSon());
					if (currentNode.getMiddleSon().getKey().equals(key)) {
						wantedNode = currentNode.getMiddleSon();
					}
				}
			}
		}
		for (Node<Key, Value> node : nodeList) {
			node.setVisited(false);
		}
		if (wantedNode != null) {
			return wantedNode;
		} else {
			System.out.println("O nó buscado não existe");
		}
		return wantedNode;
	}

	public boolean Remove(Node<Key, Value> node) {
		Node<Key, Value> currentNode;
		Node<Key, Value> nextdNode;
		node.setVisited(true);
		this.queue.enfileirar(node);
		while (!this.queue.vazia()) {
			currentNode = this.queue.desenfileirar();
			if (currentNode.getLeftSon() != null && currentNode.getLeftSon().isVisited() == false) {
				nextdNode = currentNode.getLeftSon();
				nextdNode.setVisited(true);
				if (nextdNode.getLeftSon() != null && nextdNode.getRightSon() != null
						&& nextdNode.getMiddleSon() != null) {
					this.queue.enfileirar(nextdNode);
				} else if (nextdNode.getLeftSon() != null && nextdNode.getRightSon() != null) {
					this.queue.enfileirar(nextdNode);
				} else if (nextdNode.getLeftSon() != null && nextdNode.getMiddleSon() != null) {
					this.queue.enfileirar(nextdNode);
				} else if (nextdNode.getMiddleSon() != null && nextdNode.getRightSon() != null) {
					this.queue.enfileirar(nextdNode);
				} else {
					if (nextdNode.getRightSon() != null) {
						node.setKey(nextdNode.getKey());
						node.setValue(nextdNode.getValue());
						nextdNode.getRightSon().setFather(nextdNode.getFather());
						nextdNode.getFather().setLeftSon(nextdNode.getRightSon());
						this.nodeList.remover(nextdNode);
						for (Node<Key, Value> nodes : nodeList) {
							nodes.setVisited(false);
						}
						return true;
					} else if (nextdNode.getLeftSon() != null) {
						node.setKey(nextdNode.getKey());
						node.setValue(nextdNode.getValue());
						nextdNode.getLeftSon().setFather(nextdNode.getFather());
						nextdNode.getFather().setLeftSon(nextdNode.getLeftSon());
						this.nodeList.remover(nextdNode);
						for (Node<Key, Value> nodes : nodeList) {
							nodes.setVisited(false);
						}
						return true;
					} else if (nextdNode.getMiddleSon() != null) {
						node.setKey(nextdNode.getKey());
						node.setValue(nextdNode.getValue());
						nextdNode.getLeftSon().setFather(nextdNode.getFather());
						nextdNode.getFather().setLeftSon(nextdNode.getMiddleSon());
						this.nodeList.remover(nextdNode);
						for (Node<Key, Value> nodes : nodeList) {
							nodes.setVisited(false);
						}
						return true;
					} else {
						node.setKey(nextdNode.getKey());
						node.setValue(nextdNode.getValue());
						nextdNode.setFather(null);
						node.setLeftSon(null);
						this.nodeList.remover(nextdNode);
						for (Node<Key, Value> nodes : nodeList) {
							nodes.setVisited(false);
						}
						return true;
					}
				}

				if (nextdNode.getLeftSon() != null && nextdNode.getRightSon() != null
						&& nextdNode.getMiddleSon() != null) {
					this.queue.enfileirar(nextdNode);
				} else if (nextdNode.getLeftSon() != null && nextdNode.getRightSon() != null) {
					this.queue.enfileirar(nextdNode);
				} else if (nextdNode.getLeftSon() != null && nextdNode.getMiddleSon() != null) {
					this.queue.enfileirar(nextdNode);
				} else if (nextdNode.getMiddleSon() != null && nextdNode.getRightSon() != null) {
					this.queue.enfileirar(nextdNode);
				} else {
					if (nextdNode.getRightSon() != null) {
						node.setKey(nextdNode.getKey());
						node.setValue(nextdNode.getValue());
						nextdNode.getRightSon().setFather(nextdNode.getFather());
						nextdNode.getFather().setRightSon(nextdNode.getRightSon());
						this.nodeList.remover(nextdNode);
						for (Node<Key, Value> nodes : nodeList) {
							nodes.setVisited(false);
						}
						return true;
					} else if (nextdNode.getLeftSon() != null) {
						node.setKey(nextdNode.getKey());
						node.setValue(nextdNode.getValue());
						nextdNode.getLeftSon().setFather(nextdNode.getFather());
						nextdNode.getFather().setRightSon(nextdNode.getLeftSon());
						this.nodeList.remover(nextdNode);
						for (Node<Key, Value> nodes : nodeList) {
							nodes.setVisited(false);
						}
						return true;
					} else if (nextdNode.getMiddleSon() != null) {
						node.setKey(nextdNode.getKey());
						node.setValue(nextdNode.getValue());
						nextdNode.getRightSon().setFather(nextdNode.getFather());
						nextdNode.getFather().setRightSon(nextdNode.getMiddleSon());
						this.nodeList.remover(nextdNode);
						for (Node<Key, Value> nodes : nodeList) {
							nodes.setVisited(false);
						}
						return true;
					} else {
						node.setKey(nextdNode.getKey());
						node.setValue(nextdNode.getValue());
						nextdNode.setFather(null);
						node.setRightSon(null);
						this.nodeList.remover(nextdNode);
						for (Node<Key, Value> nodes : nodeList) {
							nodes.setVisited(false);
						}
						return true;
					}
				}

				if (currentNode.getMiddleSon() != null && currentNode.getMiddleSon().isVisited() == false) {
					nextdNode = currentNode.getMiddleSon();
					nextdNode.setVisited(true);
					if (nextdNode.getLeftSon() != null && nextdNode.getRightSon() != null
							&& nextdNode.getMiddleSon() != null) {
						this.queue.enfileirar(nextdNode);
					} else if (nextdNode.getLeftSon() != null && nextdNode.getRightSon() != null) {
						this.queue.enfileirar(nextdNode);
					} else if (nextdNode.getLeftSon() != null && nextdNode.getMiddleSon() != null) {
						this.queue.enfileirar(nextdNode);
					} else if (nextdNode.getMiddleSon() != null && nextdNode.getRightSon() != null) {
						this.queue.enfileirar(nextdNode);
					} else {
						if (nextdNode.getRightSon() != null) {
							node.setKey(nextdNode.getKey());
							node.setValue(nextdNode.getValue());
							nextdNode.getRightSon().setFather(nextdNode.getFather());
							nextdNode.getFather().setMiddleSon(nextdNode.getRightSon());
							this.nodeList.remover(nextdNode);
							for (Node<Key, Value> nodes : nodeList) {
								nodes.setVisited(false);
							}
							return true;
						} else if (nextdNode.getLeftSon() != null) {
							node.setKey(nextdNode.getKey());
							node.setValue(nextdNode.getValue());
							nextdNode.getLeftSon().setFather(nextdNode.getFather());
							nextdNode.getFather().setMiddleSon(nextdNode.getLeftSon());
							this.nodeList.remover(nextdNode);
							for (Node<Key, Value> nodes : nodeList) {
								nodes.setVisited(false);
							}
							return true;
						} else if (nextdNode.getMiddleSon() != null) {
							node.setKey(nextdNode.getKey());
							node.setValue(nextdNode.getValue());
							nextdNode.getMiddleSon().setFather(nextdNode.getFather());
							nextdNode.getFather().setMiddleSon(nextdNode.getMiddleSon());
							this.nodeList.remover(nextdNode);
							for (Node<Key, Value> nodes : nodeList) {
								nodes.setVisited(false);
							}
							return true;
						} else {
							node.setKey(nextdNode.getKey());
							node.setValue(nextdNode.getValue());
							nextdNode.setFather(null);
							node.setMiddleSon(null);
							this.nodeList.remover(nextdNode);
							for (Node<Key, Value> nodes : nodeList) {
								nodes.setVisited(false);
							}
							return true;
						}
					}
				}
			}
		}
		for (Node<Key, Value> nodes : nodeList) {
			nodes.setVisited(false);
		}
		return false;
	}

	public boolean Remove(Node<Key, Value> fatherNode, Side side) {
		Node<Key, Value> node = null;
		if (side.equals(Side.Left)) {
			node = fatherNode.getLeftSon();
		} else if (side.equals(Side.Right)) {
			node = fatherNode.getRightSon();
		} else if(side.equals(Side.Middle)) {
			node = fatherNode.getMiddleSon();
		}
		Remove(node);
		return false;
	}

	public boolean Remove(Key key) {
		Node<Key, Value> node = null;
		node = Get(key);
		Remove(node);
		return false;
	}

	@Override
	public String toString() {
		if (this.getSize() == 0) {
			return "[]";
		}
		Node<Key, Value> currentNode = null;
		int auxSize = 0;
		this.root.setVisited(true);
		this.queue.enfileirar(this.root);
		auxSize++;

		StringBuilder builder = new StringBuilder();
		builder.append("[");

		builder.append(this.root.getValue().toString());
		if (auxSize < this.size) {
			builder.append(", ");
		}

		while (!this.queue.vazia()) {
			currentNode = this.queue.desenfileirar();
			if (currentNode.getLeftSon() != null && currentNode.getLeftSon().isVisited() == false) {
				currentNode.getLeftSon().setVisited(true);
				this.queue.enfileirar(currentNode.getLeftSon());
				builder.append(currentNode.getLeftSon().getValue().toString());
				auxSize++;
				if (auxSize < this.size) {
					builder.append(", ");
				}
			}

			if (currentNode.getRightSon() != null && currentNode.getRightSon().isVisited() == false) {
				currentNode.getRightSon().setVisited(true);
				this.queue.enfileirar(currentNode.getRightSon());
				builder.append(currentNode.getRightSon().getValue().toString());
				auxSize++;
				if (auxSize < this.size) {
					builder.append(", ");
				}
			}
			
			if (currentNode.getMiddleSon() != null && currentNode.getMiddleSon().isVisited() == false) {
				currentNode.getMiddleSon().setVisited(true);
				this.queue.enfileirar(currentNode.getMiddleSon());
				builder.append(currentNode.getMiddleSon().getValue().toString());
				auxSize++;
				if (auxSize < this.size) {
					builder.append(", ");
				}
			}
		}
		builder.append("]");

		for (Node<Key, Value> node : nodeList) {
			if (node != null) {
				node.setVisited(false);
			}
		}

		return builder.toString();
	}

	public int getSize() {
		return size;
	}

}
