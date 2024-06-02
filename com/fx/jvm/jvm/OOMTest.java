package com.fx.jvm.jvm;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class OOMTest {

    public static void main(String[] args) {

        List<Object> list = new ArrayList<>();

        int m = 0;

        int n = 1000;

        while (true) {

            list.add(new User(m++,UUID.randomUUID().toString()));

            new User(list,n++,UUID.randomUUID().toString());

        }
    }
}