import Facade.Facade;
import Singleton.SingletonEager;
import Singleton.SingletonLazy;
import Singleton.SingletonLazyHolder;
import Strategy.*;

public class Teste {
    public static void main(String[] args) {


        //? Testes Relacionados ao Singleton

        SingletonLazy lazy = SingletonLazy.getInstancia();
        System.out.println("lazy" + lazy);
        lazy = SingletonLazy.getInstancia();
        System.out.println("lazy" + lazy);

        SingletonEager eager = SingletonEager.getInstancia();
        System.out.println("eager" + eager);
        eager = SingletonEager.getInstancia();
        System.out.println("eager" + eager);

        SingletonLazyHolder lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println("lazyHolder" + lazyHolder);
        lazyHolder = SingletonLazyHolder.getInstancia();
        System.out.println("lazyHolder" + lazyHolder);

        //? Testes Relacionados ao Strategy

        Comportamento normal = new ComportamentoNormal();
        Comportamento agressivo = new ComportamentoAgressivo();
        Comportamento defensivo = new ComportamentoDefensivo();

        Robo robo = new Robo();

        robo.setComportamento(normal);
        robo.mover();
        robo.mover();

        robo.setComportamento(defensivo);
        robo.mover();

        robo.setComportamento(agressivo);
        robo.mover();
        robo.mover();
        robo.mover();

        //? Testes Relacionados ao Facade

        Facade facade = new Facade();
        facade.migrarCliente("Vantuir","13567640");



    }
}
