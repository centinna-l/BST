class BinaryTreeNode {
    int data;
    BinaryTreeNode left;
    BinaryTreeNode right;

    public BinaryTreeNode(int data) {
        this.data = data;
        this.left = null;
        this.right = null;
    }
}

class BinaryTree {
    private BinaryTreeNode root;

    public BinaryTree() {
        this.root = null;
    }

    // Create operation
    public void insert(int data) {
        root = insertNode(root, data);
    }

    private BinaryTreeNode insertNode(BinaryTreeNode node, int data) {
        if (node == null) {
            node = new BinaryTreeNode(data);
            return node;
        }

        if (data < node.data) {
            node.left = insertNode(node.left, data);
        } else if (data > node.data) {
            node.right = insertNode(node.right, data);
        }

        return node;
    }

    // Read operation (inorder traversal)
    public void printInorder() {
        printInorderTraversal(root);
    }

    private void printInorderTraversal(BinaryTreeNode node) {
        if (node != null) {
            printInorderTraversal(node.left);
            System.out.print(node.data + " ");
            printInorderTraversal(node.right);
        }
    }

    // Update operation
    public void update(int oldData, int newData) {
        root = updateNode(root, oldData, newData);
    }

    private BinaryTreeNode updateNode(BinaryTreeNode node, int oldData, int newData) {
        if (node == null) {
            return null;
        }

        if (oldData == node.data) {
            node.data = newData;
        } else if (oldData < node.data) {
            node.left = updateNode(node.left, oldData, newData);
        } else {
            node.right = updateNode(node.right, oldData, newData);
        }

        return node;
    }

    // Delete operation
    public void delete(int data) {
        root = deleteNode(root, data);
    }

    private BinaryTreeNode deleteNode(BinaryTreeNode node, int data) {
        if (node == null) {
            return null;
        }

        if (data < node.data) {
            node.left = deleteNode(node.left, data);
        } else if (data > node.data) {
            node.right = deleteNode(node.right, data);
        } else {
            if (node.left == null) {
                return node.right;
            } else if (node.right == null) {
                return node.left;
            }

            node.data = findMinValue(node.right);
            node.right = deleteNode(node.right, node.data);
        }

        return node;
    }

    private int findMinValue(BinaryTreeNode node) {
        int minValue = node.data;
        while (node.left != null) {
            minValue = node.left.data;
            node = node.left;
        }
        return minValue;
    }
}

public class BinaryTreeEx2 {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        
        // Insert operation
        binaryTree.insert(50);
        binaryTree.insert(30);
        binaryTree.insert(20);
        binaryTree.insert(40);
        binaryTree.insert(70);
        binaryTree.insert(60);
        binaryTree.insert(80);

        // Read operation
        System.out.print("Inorder traversal: ");
        binaryTree.printInorder();
        System.out.println();

        // Update operation
        binaryTree.update(30, 35);
        System.out.print("Inorder traversal after update: ");
        binaryTree.printInorder();
        System.out.println();

        // Delete operation
        binaryTree.delete(40);
        System.out.print("Inorder traversal after delete: ");
        binaryTree.printInorder();
        System.out.println();
    }
}

