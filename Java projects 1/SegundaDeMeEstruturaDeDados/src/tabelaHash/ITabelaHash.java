package tabelaHash;

public interface ITabelaHash<K, V> extends Iterable<V>{
    public void inserir(K chave, V valor);
    public boolean remover(K chave);
    public V buscar(K chave);
    public boolean contem(V valor);
    public int tamanho();
    public boolean vazio();
    public void limpar();
}
