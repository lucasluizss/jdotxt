package com.todotxt.todotxttouch.util;

import org.junit.Test;

import java.util.List;

import static org.junit.Assert.*;

public class TreeTest {

    @Test
    public void testAddTreeChildrenNull() {
        Tree<String> tree1 = new Tree<>("test1");
        Tree<String> tree2 = new Tree<>("test2");
        Tree<String> tree3 = tree1.addChild(tree2);

        assertEquals(tree1.getData(), tree3.getParent().getData());
    }

    @Test
    public void testAddTreeChildrenSetLoaded() {
        Tree<String> tree1 = new Tree<>("test1");
        Tree<String> tree2 = new Tree<>("test2");
        tree1.setLoaded();
        Tree<String> tree3 = tree1.addChild(tree2);

        assertEquals(tree1.getData(), tree3.getParent().getData());
    }

    @Test
    public void testAddTreeChildrenSetLoadedNotNull() {
        Tree<String> tree1 = new Tree<>("test1");
        Tree<String> tree2 = new Tree<>("test2");
        Tree<String> tree3 = tree1.addChild(tree2);
        tree1.setLoaded();

        assertEquals(tree1.getData(), tree3.getParent().getData());
    }

    @Test
    public void testTreeContainsDataNull() {
        Tree<String> tree1 = new Tree<>("test1");
        boolean contains = tree1.contains("test1");

        assertFalse(contains);
    }

    @Test
    public void testTreeContainsDataFalse() {
        Tree<String> tree1 = new Tree<>("test");
        tree1.addChild("test1");
        boolean contains = tree1.contains("test2");

        assertFalse(contains);
    }

    @Test
    public void testTreeContainsDataTrue() {
        Tree<String> tree1 = new Tree<>("test");
        tree1.addChild("test1");
        boolean contains = tree1.contains("test1");

        assertTrue(contains);
    }

    @Test
    public void testTreeContainsChildNull() {
        Tree<String> tree1 = new Tree<>("test1");
        Tree<String> tree2 = new Tree<>("test2");
        boolean contains = tree1.contains(tree2);

        assertFalse(contains);
    }

    @Test
    public void testTreeContainsChild() {
        Tree<String> tree1 = new Tree<>("test1");
        Tree<String> tree2 = new Tree<>("test2");
        tree1.addChild(tree2);
        boolean contains = tree1.contains(tree2);

        assertTrue(contains);
    }

    @Test
    public void testGetChild() {
        Tree<String> tree1 = new Tree<>("test1");
        Tree<String> tree2 = new Tree<>("test2");
        tree1.addChild(tree2);
        Tree<String> child = tree1.getChild(0);

        assertEquals("test2", child.getData());
    }

    @Test
    public void testIsNotLoaded() {
        Tree<String> tree1 = new Tree<>("test1");
        boolean isLoaded = tree1.isLoaded();

        assertFalse(isLoaded);
    }

    @Test
    public void testIsLoaded() {
        Tree<String> tree1 = new Tree<>("test1");
        tree1.setLoaded();
        boolean isLoaded = tree1.isLoaded();

        assertTrue(isLoaded);
    }

    @Test
    public void testChildrenAndParent() {
        Tree<String> tree1 = new Tree<>("test1");
        Tree<String> tree2 = new Tree<>(tree1,"test2");
        tree1.addChild(tree2);
        List<Tree<String>> children = tree1.getChildren();
        Tree<String> parent = tree2.getParent();

        assertEquals("test2", children.get(0).getData());
        assertEquals("test1", parent.getData());
    }
}
