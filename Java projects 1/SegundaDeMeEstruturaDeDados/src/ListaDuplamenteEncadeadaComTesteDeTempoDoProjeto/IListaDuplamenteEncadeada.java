package ListaDuplamenteEncadeadaComTesteDeTempoDoProjeto;

public interface IListaDuplamenteEncadeada<T> extends ILista<T>  {
	  public boolean adicionarNoInicio(T valor);
	    public T removerDoInicio();
	    public T removerDoFim();
}
