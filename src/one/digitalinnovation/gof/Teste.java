package one.digitalinnovation.gof;

import javax.swing.*;
import java.sql.SQLOutput;

public class Teste {
    public static void main(String[] args) {
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
    }
}
