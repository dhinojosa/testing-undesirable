package com.evolutionnext.badstatic;


public class Foo {
    public void bar(int a, int b, String account) {
        Resource r = Server.getResource(account);
        r.add(400);
    }
}
