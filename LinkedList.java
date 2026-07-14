import java.util.Iterator;

public class LinkedList<E> implements Lista<E> {


    private class Nodo<E> {

        private Nodo<E> siguiente= null;
        
        private E info=null;
    
        Nodo(Nodo<E> siguiente, E info) {
            this.siguiente = siguiente;
            this.info = info;
        }
    
        Nodo<E> getSiguiente() {
            return siguiente;
        }
    
        void setSiguiente(Nodo<E> siguiente) {
            this.siguiente = siguiente;
        }
    
        E getInfo() {
            return info;
        }
    
        void setInfo(E info) {
            this.info = info;
        }
    }

	private Nodo<E> primero=null; 
	private Nodo<E> ultimo=null; 		
	private int tamanio=0;


	@Override
	public void agregarElemento(E e) {
		agregarFinal(e);
	}

	@Override
	public void agregarInicio(E e) {
		Nodo <E> aux=new Nodo<E> (null, e);
		if(esVacia()){
			this.primero=aux;
			this.ultimo=aux;
		}else{
			aux.setSiguiente(this.primero);
			this.primero=aux;
		}
		aux=null;
		this.tamanio++;
	}

	@Override
	public void agregarFinal(E e) {
		Nodo <E> aux=new Nodo <E> (null, e);
		if(esVacia()){
		this.primero=aux;
		this.ultimo=aux;
		}else{
			this.ultimo.setSiguiente(aux);
			this.ultimo=aux;
		}
		aux=null;
		this.tamanio++;
	}

	@Override
	public void agregarPosicion(E e, int posicion) {
		if(posicion>=0 && posicion<=tamanio){
			if(posicion==0){
				agregarInicio(e);
				}else{
					if(posicion==tamanio){
					agregarFinal(e);
					}else{
						Nodo <E> aux=new Nodo <E> (null, e);
						Nodo <E> iterador=primero;
						for(int i=0; i<posicion-1; i++){
							iterador=iterador.getSiguiente();
						}
						aux.setSiguiente(iterador.getSiguiente());
						iterador.setSiguiente(aux);
						aux=null;
						iterador=null;
						tamanio++;	
				}
			}
		}else{
			throw new IndexOutOfBoundsException("La posicion no es valida");
		}

	}

	@Override
	public E eliminarElemento() {
		return eliminarElementoFinal();
	}

	@Override
	public E eliminarElementoInicio() {
        if(esVacia()){
            throw new NullPointerException("La lista esta vacia");
        }
        E datoEliminado = primero.getInfo();
        primero = primero.getSiguiente();
        tamanio--;
        if(primero == null){
            ultimo = null;
        }
        return datoEliminado;
	}

	@Override
	public E eliminarElementoFinal() {
		if(esVacia()){
			throw new NullPointerException("La lista esta vacia");
		}
		E datoEliminado= ultimo.getInfo();
		if(primero==ultimo){
			return eliminarElementoInicio();
		}else{
			Nodo<E> aux=primero;
			while(aux.getSiguiente() !=ultimo){
				aux=aux.getSiguiente();
			}
			aux.setSiguiente(null);
			ultimo=aux;
			aux=null;
		}
		tamanio--;
		return datoEliminado;
	}

	@Override
	public E eliminarElementoPosicion(int posicion) {
		Nodo <E> eliminado=null;
		Nodo <E> aux=null;
		E datoEliminado=null;
		if(esVacia()){
			throw new NullPointerException("La lista esta vacia");		
		}else{
			if(posicion>=0 && posicion<=tamanio){
				if(posicion==0){
					return eliminarElementoInicio();
				}else{
					if(posicion==tamanio-1){
						return eliminarElementoFinal();
					}else{
						aux=primero;
						for(int i=0; i<posicion-1; i++){
							aux=aux.getSiguiente();
						}
						eliminado=aux.getSiguiente();
						aux.setSiguiente(eliminado.getSiguiente());
						eliminado.setSiguiente(null);
						aux=null;
						datoEliminado=eliminado.getInfo();
						eliminado=null;
						tamanio--;
						return datoEliminado;
					}
				}
			}else{
				throw new IndexOutOfBoundsException("La posicion no es valida");
			}
		}
	}

	@Override
	public boolean esVacia() {
		return tamanio==0;
	}

	@Override
	public int numElementos() {
		// TODO Auto-generated method stub
		return tamanio;
	}

	@Override
	public void limpiarLista() {
		this.primero=null;
		this.ultimo=null;
		tamanio=0;
	}

	@SuppressWarnings("unchecked")
	@Override
	public E[] convertirArreglo() {

		Object[] arreglo = new Object[tamanio];
		Nodo<E> aux = primero;
		for(int i=0;aux!=null;i++){
			arreglo[i]=aux.getInfo();
			aux = aux.getSiguiente();
		}

		return (E[])arreglo;
	}

	@Override
	public E consultar(int posicion) {
		if(posicion>=0 && posicion<tamanio) {
            Nodo<E> aux = primero;
            for(int i=0; i<posicion; i++) {
                aux = aux.getSiguiente();
            }
            return aux.getInfo();
        } else {
            throw new IndexOutOfBoundsException("La posicion no es valida");
        }
	}
	
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>(){

            Nodo<E> nodo= primero;
            @Override
            public boolean hasNext() {
                return nodo!=null;
            }

            @Override
            public E next() {
                E tmp=nodo.getInfo();
                nodo=nodo.getSiguiente();
                return tmp;
            }

        };
    }

}