﻿# BinaryTreeOperations
## Project Description
This repository contains a Java program that processes the elements of a given binary tree according to specified operations and then traverses the tree in post-order to print the updated values.

## Files
- `TNode.java`: Defines the node structure used in the binary tree.
- `BinaryTree.java`: Implements the binary tree structure and its operations such as building the tree from input, applying operations, and performing post-order traversal.
- `Main.java`: Main class to handle the input parsing, tree construction, operation application, and output of the traversal result.

## Algorithm Explanation

### TNode Class
The `TNode` class defines the basic unit of the binary tree. Each node contains:
- An integer (`int value`): The data stored in the node.
- References to the left and right children (`TNode left`, `TNode right`): Points to the left and right children of the node.

### BinaryTree Class
The `BinaryTree` class manages the nodes and provides methods to manipulate the tree:
- `buildTree(String input)`: Constructs the binary tree from the given input string in the specified format.
- `applyOperation(String operation)`: Applies the specified operation to each node's value in the tree.
- `postOrderTraversal()`: Performs a post-order traversal of the tree and collects the node values.

### Main Class
The `Main` class contains the main method to run the binary tree operations application:
- Parses the input to extract the binary tree structure and the operation.
- Uses the `BinaryTree` class to construct the tree and apply the operation.
- Performs a post-order traversal and prints the updated node values.

### Example Workflow
1. The user inputs a binary tree and an operation: `4[2[3][1]][6[5]], +8`.
2. The program constructs the binary tree from the input string.
3. The program applies the operation to each node's value.
4. The program performs a post-order traversal of the tree and prints the updated values:
5. 11 9 10 13 14 12
   
