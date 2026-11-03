import java.util.*;

public class Huffman {

    static class Node {
        char ch;
        int freq;
        Node left, right;

        Node(char ch, int freq) {
            this.ch = ch;
            this.freq = freq;
        }

        Node(int freq, Node left, Node right) {
            this.freq = freq;
            this.left = left;
            this.right = right;
        }
    }

    static void generateCodes(Node root, String code) {
        if (root == null) {
            return;
        }

        if (root.left == null && root.right == null) {
            System.out.println(root.ch + " : " + (code.isEmpty() ? "0" : code));
            return;
        }

        generateCodes(root.left, code + "0");
        generateCodes(root.right, code + "1");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter a string: ");
        String str = sc.nextLine();

        if (str.isEmpty()) {
            System.out.println("Please enter a valid string.");
            sc.close();
            return;
        }

        Map<Character, Integer> freq = new HashMap<>();
        for (char ch : str.toCharArray()) {
            freq.put(ch, freq.getOrDefault(ch, 0) + 1);
        }

        PriorityQueue<Node> pq = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.freq, b.freq)
        );

        for (char ch : freq.keySet()) {
            pq.add(new Node(ch, freq.get(ch)));
        }

        while (pq.size() > 1) {
            Node left = pq.poll();
            Node right = pq.poll();
            pq.add(new Node(left.freq + right.freq, left, right));
        }

        System.out.println("\nHuffman Codes:");
        generateCodes(pq.poll(), "");

        sc.close();
    }
}


/*
Enter a string: hello

Huffman Codes:
h : 00
e : 01
o : 10
l : 11


javac Huffman.java
java Huffman



## Huffman Encoding – Theory

### 1. What is Huffman Encoding?

Huffman Encoding is a lossless data compression technique used to reduce the size of data by assigning variable-length binary codes to characters based on their frequency of occurrence.

Characters that occur more frequently are assigned shorter binary codes, while characters that occur less frequently are assigned longer binary codes.

Example: Instead of using the same number of bits for every character, Huffman Encoding assigns shorter codes to frequently occurring characters to save storage space.

### 2. Important Terminology

1\. Greedy Algorithm: An algorithm that makes the best possible choice at each step to achieve an optimal solution.

2\. Frequency: The number of times a character appears in the input string.

3\. Huffman Tree: A binary tree constructed using character frequencies to generate Huffman codes.

4\. Min-Heap: A data structure that always provides the element with the minimum frequency first.

5\. Binary Code: A sequence of 0s and 1s assigned to each character.

6\. Prefix Code: A code in which no character's binary code is the prefix of another character's code. This ensures unambiguous decoding.

### 3. How Huffman Encoding Works

Huffman Encoding follows the Greedy Strategy.

1. Calculate Frequency: Count the frequency of each character in the input string.
2. Create Min-Heap: Insert all characters into a min-heap according to their frequencies.
3. Select Minimum Frequencies: Remove the two nodes having the lowest frequencies.
4. Create New Node: Combine these two nodes by adding their frequencies.
5. Repeat: Insert the new node into the min-heap and repeat until only one node remains.
6. Generate Codes: Traverse the Huffman Tree. Assign `0` to the left branch and `1` to the right branch.
7. Encode: Replace each character in the input string with its corresponding binary code.

### 4. Example

Consider the following character frequencies:

| Character | Frequency |
| --------- | --------- |
| A         | 5         |
| B         | 2         |
| C         | 1         |

Tree construction:

- Combine C (1) and B (2) = 3.
- Combine the new node (3) and A (5) = 8.
- The final Huffman Tree is created.

Huffman Tree

Left branch = 0, Right branch = 1. The tree shown represents the stated frequencies.

Generated Huffman Codes:

| Character | Huffman Code |
| --------- | ------------ |
| A         | 1            |
| B         | 01           |
| C         | 00           |

### 5. Advantages of Huffman Encoding

- Reduces data storage space.
- Provides lossless data compression.
- Frequently occurring characters get shorter codes.
- Produces prefix-free codes for unambiguous decoding.
- Used in file compression and data transmission.

### 6. Time and Space Complexity

Let:

- `n` = Length of input string.
- `k` = Number of distinct characters.

| Operation             | Time Complexity |
| --------------------- | --------------- |
| Frequency Calculation | O(n)            |
| Building Huffman Tree | O(k log k)      |
| Generating Codes      | O(k)            |
| Encoding              | O(n)            |

Overall Time Complexity: \\(O(n+k\log k)\\)

Auxiliary Space Complexity: \\(O(k)\\), excluding the encoded output.

### 7. Result

Huffman Encoding is a Greedy Algorithm used for lossless data compression. It constructs a binary tree based on character frequencies and assigns variable-length prefix-free binary codes to reduce the storage space required for data.

Remember the main concept: Higher frequency = shorter code; lower frequency = longer code.
*/