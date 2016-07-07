package ru.hokan.strange.numbers;

import java.util.ArrayList;
import java.util.List;

public class TreeProcessor implements StrangeNumberProcessor {

    private Node tree = new Node();
    private int highNumberNumbersBorder;

    /**
     * {@inheritDoc}
     */
    @Override
    public void run(int highNumberNumbersBorder) {
        this.highNumberNumbersBorder = highNumberNumbersBorder;
        processDigitLevel(tree, 0);
    }

    private void processDigitLevel(Node parentNode, int level) {
        if (level == highNumberNumbersBorder) {
            Integer result = parentNode.constructDigitFromLeaf();
            System.out.println(result);
            return;
        }

        for (int i = 0; i <= 9; ++i) {
            Integer integer = parentNode.constructDigitFromLeaf();
            integer = integer * 10 + i;
            if (integer == 0) {
                continue;
            }

            if (integer % (level + 1) != 0) {
                continue;
            }

            Node childNode = new Node(i);
            parentNode.addChild(childNode);
            processDigitLevel(childNode, level + 1);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean filter(long value) {
        return false;
    }

    private static class Node {
        private Integer data;
        private Node parent;
        private List<Node> children;

        public Node() {
            children = new ArrayList<>();
        }

        public Node(Integer data) {
            this();
            this.data = data;
        }

        public void addChild(Node node) {
            children.add(node);
            node.setParent(this);
        }

        public Integer constructDigitFromLeaf() {
            return constructDigitRecursively(this, 0, 0);
        }

        private Integer constructDigitRecursively(Node node, int value, int levelOfDepth) {
            Integer data = node.getData();
            if (data == null) {
                return value;
            }

            value += data * (Math.pow(10, levelOfDepth));
            Node parent = node.getParent();
            if (parent == null) {
                return value;
            }

            return constructDigitRecursively(parent, value, levelOfDepth + 1);
        }

        // TODO add clear() method

        public Node getParent() {
            return parent;
        }

        public void setParent(Node parent) {
            this.parent = parent;
        }

        public Integer getData() {
            return data;
        }
    }
}
