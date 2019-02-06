package PessoasBens;



public class NoABB<K extends Comparable<K>, T> {

    private K chave;
    private T elemento;
    private NoABB<K, T> noPai;
    private NoABB<K, T> noEsquerdo;
    private NoABB<K, T> noDireito;

    public NoABB(K chave, T elemento) {
        this.chave = chave;
        this.elemento = elemento;
    }

    public K getChave() {
        return chave;
    }

    public void setChave(K chave) {
        this.chave = chave;
    }

    public T getElemento() {
        return elemento;
    }

    public void setElemento(T elemento) {
        this.elemento = elemento;
    }

    public NoABB<K, T> getNoPai() {
        return noPai;
    }

    public void setNoPai(NoABB<K, T> noPai) {
        this.noPai = noPai;
    }

    public NoABB<K, T> getNoEsquerdo() {
        return noEsquerdo;
    }

    public void setNoEsquerdo(NoABB<K, T> noEsquerdo) {
        this.noEsquerdo = noEsquerdo;
    }

    public NoABB<K, T> getNoDireito() {
        return noDireito;
    }

    public void setNoDireito(NoABB<K, T> noDireito) {
        this.noDireito = noDireito;
    }

}
