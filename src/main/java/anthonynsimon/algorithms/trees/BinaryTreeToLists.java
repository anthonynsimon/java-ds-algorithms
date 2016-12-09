package anthonynsimon.algorithms.trees;

import anthonynsimon.datastructures.BinarySearchTree;
import anthonynsimon.datastructures.Queue;
import anthonynsimon.datastructures.util.BinaryNode;

import java.util.ArrayList;

public class BinaryTreeToLists<T> {

    // Collects the Tree nodes per level into a list and returns them list of lists
    public ArrayList<ArrayList<BinaryNode<T>>> treeToListsByLevel(BinarySearchTree tree) {
        ArrayList<ArrayList<BinaryNode<T>>> results = new ArrayList<>();

        if (tree.size() == 0) {
            return results;
        }

        // Setup for Breadth first search
        Queue<BinaryNode<T>> queue = new Queue<>();

        queue.enqueue(tree.getRootNode());

        // Traverse the tree per level using BFS,
        while (!queue.isEmpty()) {
            ArrayList<BinaryNode<T>> level = new ArrayList<>();

            // Get the level's nodes from the queue
            while (!queue.isEmpty()) {
                level.add(queue.dequeue());
            }

            results.add(level);

            // Enqueue the children of the current level's nodes if any
            for (BinaryNode<T> node : level) {
                if (node.hasLeftChild()) {
                    queue.enqueue(node.getLeft());
                }
                if (node.hasRightChild()) {
                    queue.enqueue(node.getRight());
                }
            }
        }

        return results;
    }
}