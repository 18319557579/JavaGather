package com.hsf.javagather.thread.six.default_function;

public class Mule implements IHorse, IAnimal, IDonkey{
    @Override
    public void eat() {
        System.out.println("Mule eat");
    }

    @Override
    public void run() {
        IHorse.super.run();
    }

    public static void main(String[] args) {
        Mule m = new Mule();
        m.run();
        m.breath();

        m.eat();
    }
}
