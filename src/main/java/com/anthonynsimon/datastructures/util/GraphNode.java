package com.anthonynsimon.datastructures.util;

import java.util.ArrayList;

public class GraphNode {

    protected String id;
    protected ArrayList<GraphNode> neighbors;

    public GraphNode(String id) {
        this.id = id;
        this.neighbors = new ArrayList<>();
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean hasNeighbor(GraphNode node) {
        return this.neighbors.contains(node);
    }

    public void addNeighbor(GraphNode node) {
        if (this.neighbors.contains(node)) {
            return;
        }

        this.neighbors.add(node);
    }

    public void removeNeighbor(GraphNode node) {
        this.neighbors.remove(node);
    }

    public ArrayList<GraphNode> neighbors() {
        return this.neighbors;
    }
}