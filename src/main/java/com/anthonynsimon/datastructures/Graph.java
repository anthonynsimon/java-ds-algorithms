package com.anthonynsimon.datastructures;

import com.anthonynsimon.datastructures.util.GraphNode;

import java.util.ArrayList;

// Undirected Graph
public class Graph {

    // Keep track of all vertices as some of them might not have edges
    protected ArrayList<GraphNode> vertices;

    public Graph() {
        this.vertices = new ArrayList<>();
    }

    public boolean isEmpty() {
        return this.vertices.isEmpty();
    }

    public boolean containsVertex(String id) {
        return getVertex(id) != null;
    }

    // Adds a new vertex without any edges as long as it doesn't exist already
    public void addVertex(String id) {
        if (containsVertex(id)) {
            return;
        }

        this.vertices.add(new GraphNode(id));
    }

    public void removeVertex(String id) {
        GraphNode vertex = getVertex(id);

        if (vertex == null) {
            return;
        }

        this.vertices.remove(this.vertices.indexOf(vertex));
    }

    // Creates an edge between a pair of vertices
    // No new object instantiated, simple created as a reference to each other
    public void addEdge(String idFrom, String idTo) {
        GraphNode vertexA = getVertex(idFrom);
        GraphNode vertexB = getVertex(idTo);

        if (vertexA == null || vertexB == null) {
            return;
        }

        vertexA.addNeighbor(vertexB);
        vertexB.addNeighbor(vertexA);
    }

    // Removes an edge if it exists
    public void removeEdge(String idFrom, String idTo) {
        GraphNode vertexA = getVertex(idFrom);
        GraphNode vertexB = getVertex(idTo);

        if (vertexA == null || vertexB == null) {
            return;
        }

        vertexA.removeNeighbor(vertexB);
        vertexB.removeNeighbor(vertexA);
    }

    // Returns the number of edges between the vertices with given id's
    // Result of 0 means there is no path between them.
    public int distanceBetween(String idFrom, String idTo) {
        GraphNode vertexA = getVertex(idFrom);
        GraphNode vertexB = getVertex(idTo);

        if (vertexA == null || vertexB == null) {
            return 0;
        }

        ArrayList<GraphNode> visited = new ArrayList<>();
        Queue<GraphNode> queue = new Queue<>();

        int distance = 0;
        queue.enqueue(vertexA);

        while (!queue.isEmpty()) {
            GraphNode current = queue.dequeue();
            visited.add(current);

            distance++;

            for (GraphNode currentNeighbor : current.neighbors()) {
                if (currentNeighbor == vertexB) {
                    return distance;
                }

                if (!visited.contains(currentNeighbor)) {
                    queue.enqueue(currentNeighbor);
                }
            }
        }

        return 0;
    }

    // Returns true if there is a path that connects the pair of vertices
    public boolean pathExists(String idFrom, String idTo) {
        return distanceBetween(idFrom, idTo) > 0;
    }

    public void clear() {
        this.vertices = new ArrayList<>();
    }

    protected GraphNode getVertex(String id) {
        for (GraphNode vertex : this.vertices) {
            if (vertex.getId() == id) {
                return vertex;
            }
        }
        return null;
    }
}