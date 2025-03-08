# Splay Tree Implementation

This repository contains a Java implementation of a Splay Tree data structure. Splay trees are self-adjusting binary search trees with the property that recently accessed elements are quick to access again.

## Features

- **Dynamic Self-Adjustment**: Automatically moves frequently accessed nodes closer to the root
- **Efficient Operations**: O(log n) amortized time complexity for basic operations
- **Key Operations Implemented**:
  - Insertion
  - Deletion
  - Search
  - Level Order Traversal
  - Visual Tree Printing

## How It Works

A splay tree performs a "splaying" operation after every access, which restructures the tree to bring the accessed element to the root. This helps optimize for locality of reference patterns.

### Core Operations

- **Rotations**:
  - `rotateZig()` (right rotation)
  - `rotateZag()` (left rotation)

- **Main Functions**:
  - `insert(int key)`: Adds a new key to the tree
  - `search(int key, int[] steps)`: Finds a key and tracks the number of steps taken
  - `delete(int key)`: Removes a key from the tree
  - `levelOrderTraversal()`: Prints all nodes in level order
  - `printTree()`: Displays a visual representation of the tree structure

## Output

```
Inserting initial elements: 10, 20, 30, 40, 50
Initial Tree Structure:
         /----- 80
 /----- 70
 |       \----- 60
 |               \----- 40
 |                       \----- 20

Menu:
1. Insert
2. Search
3. Delete
4. Level Order Traversal
5. Exit
Enter your choice: 1
Enter key to insert: 55
Tree after insertion of 55:
                         /----- 80
                 /----- 70
         /----- 60
 /----- 55
 |       \----- 40
 |               \----- 20

Menu:
1. Insert
2. Search
3. Delete
4. Level Order Traversal
5. Exit
Enter your choice: 
```

## Time Complexity

- **Search**: O(log n) amortized
- **Insert**: O(log n) amortized
- **Delete**: O(log n) amortized

## Additional Notes

- The code includes a step counter in the search function to track performance
- The implementation handles cases where the exact key isn't found, returning the closest key
- The visual tree printing function helps with debugging and understanding the tree structure

## Requirements

- Java 8 or higher