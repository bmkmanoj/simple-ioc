package com.ectworks.simpleioc;

public class BindingMap
{
    private class Node
    {
        Definition defn;
        Node prev;
    }

    Node head = null;

    public void enrich(Definition defn)
    {
        Node n = new Node();

        n.defn = defn;
        n.prev = head;

        head = n;
    }

    public Definition lookup(Class klass)
    {
        for(Node pos = head; pos != null; pos = pos.prev) {

            Definition defn = pos.defn;

            if (defn.isBindableTo(klass))
                return defn;
        }

        return null;
    }

    public boolean isBound(Class klass)
    {
        return (lookup(klass) != null);
    }
}