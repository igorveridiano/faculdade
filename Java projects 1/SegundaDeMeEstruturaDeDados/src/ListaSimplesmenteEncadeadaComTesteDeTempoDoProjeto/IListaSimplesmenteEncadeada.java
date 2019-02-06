package ListaSimplesmenteEncadeadaComTesteDeTempoDoProjeto;

public interface IListaSimplesmenteEncadeada<T> extends ILista<T>{
    public boolean adicionarNoInicio(T valor);
    public T removerDoInicio();
    public T removerDoFim();
}
