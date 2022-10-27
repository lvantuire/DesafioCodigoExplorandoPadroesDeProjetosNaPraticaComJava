package one.digitalinnovation.gof;

/**
 * Sigleton preguiçoso
 *
 * @author lvantuire
 *
 */
public class SingletonLazy {
    private static SingletonLazy instancia;

    private SingletonLazy() {
        super();
    }

    public static SingletonLazy getInstancia() {
        if (instancia == null) {
            instancia = new SingletonLazy();
        }
        return instancia;
    }
}
