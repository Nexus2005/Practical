# Design and Analysis of Algorithms (DAA) – Complete Theory & Viva Notes

Comprehensive study guide covering core foundations, problem classification, algorithmic paradigms, complexities, recurrence relations, and oral exam preparation.

---

## Table of Contents
1. [Part 1 – Core Foundations of DAA](#part-1--core-foundations-of-daa)
2. [Part 2 – Problem-Solving and Complexity](#part-2--problem-solving-and-complexity)
3. [Part 3 – Important Algorithms You Must Know](#part-3--important-algorithms-you-must-know)
4. [Part 4 – Greedy Algorithms](#part-4--greedy-algorithms)
5. [Part 5 – Dynamic Programming](#part-5--dynamic-programming)
6. [Part 6 – Backtracking](#part-6--backtracking)
7. [Part 7 – Branch and Bound](#part-7--branch-and-bound)
8. [Part 8 – Amortized Analysis](#part-8--amortized-analysis)
9. [Part 9 – Advanced & Embedded Algorithm Concepts](#part-9--advanced--embedded-algorithm-concepts)
10. [Part 10 – Master Formula Sheet for Viva](#part-10--master-formula-sheet-for-viva)
11. [Part 11 – Comprehensive Algorithm Complexity Table](#part-11--comprehensive-algorithm-complexity-table)
12. [Part 12 – High-Priority Viva Questions & Answers](#part-12--high-priority-viva-questions--answers)

---

## Part 1 – Core Foundations of DAA

### 1. What is an Algorithm?
- **Definition**: An algorithm is a finite, unambiguous, step-by-step sequence of computational instructions designed to solve a well-defined computational problem or transform inputs into desired outputs.
- **Example (Addition of two numbers)**:
  1. Start.
  2. Input two numbers $A$ and $B$.
  3. Compute $\text{Sum} = A + B$.
  4. Display $\text{Sum}$.
  5. Stop.

#### Core Characteristics of a Valid Algorithm
- **Input**: Accepts zero or more externally supplied quantities.
- **Output**: Produces at least one well-defined result.
- **Definiteness**: Each instruction is clear, precise, and unambiguous.
- **Finiteness**: Terminates after a countable number of discrete steps for all valid inputs.
- **Effectiveness**: Every operation is elementary enough to be executed in finite time.
- **Correctness**: Computes the expected result for all valid instances.

---

### 2. What is DAA?
**DAA** stands for **Design and Analysis of Algorithms**:
- **Design**: Formulating systematic strategies (Greedy, Divide & Conquer, Dynamic Programming, Backtracking, Branch & Bound) to solve problems.
- **Analysis**: Mathematically quantifying an algorithm's performance in terms of:
  - **Time Complexity**: Number of basic operations performed as input size $n \to \infty$.
  - **Space Complexity**: Total auxiliary memory consumed during execution.
  - **Correctness**: Mathematical guarantee of producing the right output.
  - **Scalability**: Behavioral growth rate on massive input sets.

---

### 3. Algorithms as Technology
Algorithms serve as foundational technology because hardware efficiency is strictly bounded by algorithmic scalability. A superior algorithm running on slower hardware frequently outperforms a suboptimal algorithm on supercomputers as input size scales:
- **Search Engines**: Web crawling, PageRank, inverted indexing.
- **Navigation (GPS)**: Dijkstra’s and $A^*$ shortest path algorithms.
- **Cryptography**: RSA, Diffie-Hellman modular arithmetic, SHA hashing.
- **Networking & Social Graphs**: Max-flow, community detection, recommendation trees.

---

### 4. Evolution of Algorithms
$$\text{Manual Calculation} \to \text{Sorting/Searching} \to \text{Divide \& Conquer} \to \text{Greedy / DP} \to \text{Randomized / Approximation} \to \text{Quantum / AI}$$

---

### 5. Algorithm Design Paradigms

| Paradigm | Strategy | Key Examples |
| :--- | :--- | :--- |
| **Brute Force** | Exhaustively evaluate all combinatorial candidates | Linear search, traveling salesperson permutations |
| **Divide & Conquer** | Decompose into disjoint subproblems, solve recursively, combine | Merge Sort, Quick Sort, Binary Search |
| **Greedy** | Make the myopic locally optimal choice at each step | Fractional Knapsack, Huffman Coding, Dijkstra |
| **Dynamic Programming** | Decompose into overlapping subproblems, cache state solutions | 0/1 Knapsack, Matrix Chain, OBST, Floyd-Warshall |
| **Backtracking** | Build solution candidates incrementally; prune via dead-end rollback | N-Queens, Graph Coloring, Subset Sum, Sudoku |
| **Branch and Bound** | State-space tree search with cost bounds to prune non-optimal subtrees | 0/1 Knapsack (B&B), TSP, Assignment Problem |
| **Randomized** | Introduce pseudo-random decisions to avoid deterministic worst cases | Randomized QuickSort, Monte Carlo / Las Vegas tests |

---

### 6. Correctness of an Algorithm & Loop Invariants
An algorithm is **totally correct** if it:
1. **Terminates** on all valid inputs.
2. Is **partially correct**: whenever it halts, the output satisfies specification.

#### Loop Invariant Method
A logical assertion about algorithm state that remains invariant across loop iterations:
1. **Initialization**: The invariant is true prior to the first loop execution.
2. **Maintenance**: If true before an iteration, it remains true before the subsequent iteration.
3. **Termination**: When the loop concludes, the invariant provides the property proving correctness.

---

### 7. Iterative vs. Recursive Algorithms

| Feature | Iterative Algorithm | Recursive Algorithm |
| :--- | :--- | :--- |
| **Control Flow** | Loops (`for`, `while`) | Repeated self-invoking function calls |
| **Memory Stack** | Uses $O(1)$ constant call-stack space | Incurs call-stack overhead ($O(\text{depth})$ frames) |
| **Overhead** | Minimal CPU register manipulation | Context switching, parameter passing, return address pushing |
| **Ideal For** | Repetitive linear sequential operations | Hierarchical, divide-and-conquer, tree/graph traversals |

---

## Part 2 – Problem-Solving and Complexity

### 8. Problem Classification
- **Sorting Problems**: Permute sequences into monotonic order ($O(n \log n)$ lower bound for comparison sorts).
- **Searching Problems**: Locate keys in structured or unstructured collections.
- **Optimization Problems**: Maximize profit or minimize cost among feasible solutions.
- **Decision Problems**: Produce a discrete binary output (`Yes` or `No`).
- **Graph Problems**: Pathfinding, spanning trees, flows across network topologies.

---

### 9. Time Complexity & Order of Growth
Time complexity evaluates operation growth rate relative to input length $n$:

$$\mathcal{O}(1) < \mathcal{O}(\log n) < \mathcal{O}(n) < \mathcal{O}(n \log n) < \mathcal{O}(n^2) < \mathcal{O}(n^3) < \mathcal{O}(2^n) < \mathcal{O}(n!)$$

```
Operations (T)
  ^                                 / O(n!)
  |                                / O(2^n)
  |                               / O(n^2)
  |                             / O(n log n)
  |                           / O(n)
  |                     ____/ O(log n)
  |___________________/ O(1)
  +-------------------------------------> Input Size (n)
```

---

### 10. Cases of Analysis
- **Best Case ($T_{\min}(n)$)**: Minimum basic operations required over all inputs of size $n$.
- **Worst Case ($T_{\max}(n)$)**: Maximum guarantee on operation count across any arbitrary input of size $n$.
- **Average Case ($T_{\text{avg}}(n)$)**: Expected operations assuming inputs follow an assumed probability distribution.

---

### 11. Asymptotic Notations

#### A. Big $\mathcal{O}$ (Asymptotic Upper Bound)
$$f(n) = \mathcal{O}(g(n)) \iff \exists c > 0, n_0 > 0 \text{ such that } 0 \leq f(n) \leq c \cdot g(n), \forall n \geq n_0$$

#### B. Big $\Omega$ (Asymptotic Lower Bound)
$$f(n) = \Omega(g(n)) \iff \exists c > 0, n_0 > 0 \text{ such that } 0 \leq c \cdot g(n) \leq f(n), \forall n \geq n_0$$

#### C. Big $\Theta$ (Asymptotic Tight Bound)
$$f(n) = \Theta(g(n)) \iff \exists c_1, c_2 > 0, n_0 > 0 \text{ such that } c_1 g(n) \leq f(n) \leq c_2 g(n), \forall n \geq n_0$$

#### D. Little $o$ (Strict Upper Bound)
$$f(n) = o(g(n)) \iff \lim_{n \to \infty} \frac{f(n)}{g(n)} = 0$$

#### E. Little $\omega$ (Strict Lower Bound)
$$f(n) = \omega(g(n)) \iff \lim_{n \to \infty} \frac{f(n)}{g(n)} = \infty$$

---

### 12. Complexity Classes: P, NP, NP-Hard, and NP-Complete

```
+-------------------------------------------------------+
| NP-Hard                                              |
|         +-------------------------------------------+ |
|         | NP-Complete                               | |
|         |   (Both in NP and NP-Hard)                | |
| +-------+-------------------+                       | |
| | P (Solvable in poly-time) |                       | |
| |   (P ⊆ NP)                |                       | |
| +---------------------------+                       | |
|         +-------------------------------------------+ |
| NP (Verifiable in polynomial time)                   |
+-------------------------------------------------------+
```

| Class | Definition | Verification Time | Solution Time |
| :--- | :--- | :--- | :--- |
| **P** | Solvable by deterministic Turing machine in polynomial time | Polynomial ($\mathcal{O}(n^k)$) | Polynomial ($\mathcal{O}(n^k)$) |
| **NP** | Decision problem where a candidate certificate is verifiable in polynomial time | Polynomial ($\mathcal{O}(n^k)$) | Exponential / Unknown |
| **NP-Hard** | At least as hard as any problem in NP; every problem in NP reduces to it in poly-time | May not be in NP | Intractable / Unknown |
| **NP-Complete** | A problem that is both in **NP** and is **NP-Hard** | Polynomial ($\mathcal{O}(n^k)$) | Intractable / Unknown |

- **Polynomial Reduction ($A \leq_P B$)**: Transforming problem instance $A$ to instance $B$ in polynomial time such that $A$ is true if and only if $B$ is true.
- **Classic NP-Complete Problems**:
  - **3-SAT**: Satisfiability of Boolean CNF formula where each clause contains exactly 3 literals.
  - **Vertex Cover**: Identifying $\leq k$ vertices covering all edges in $G(V, E)$.
  - **Hamiltonian Cycle**: Determining whether a closed cycle visiting each node exactly once exists.

---

## Part 3 – Important Algorithms You Must Know

### 18. Fibonacci Series

#### Recurrence Relation:
$$F(n) = F(n-1) + F(n-2) \quad \text{with } F(0) = 0, F(1) = 1$$

#### Implementations & Complexities:

```python
# 1. Simple Recursion (Inefficient: redundant subtrees)
def fib_recursive(n):
    if n <= 1:
        return n
    return fib_recursive(n - 1) + fib_recursive(n - 2)
# Time: O(2^n), Space: O(n) stack

# 2. Iterative (Optimal space & time)
def fib_iterative(n):
    if n <= 1:
        return n
    a, b = 0, 1
    for _ in range(2, n + 1):
        a, b = b, a + b
    return b
# Time: O(n), Space: O(1)
```

---

### 19. N-Queens Problem
- **Problem**: Place $N$ non-attacking queens on an $N \times N$ chessboard such that no two queens share the same row, column, or diagonal.
- **Technique**: **Backtracking** (incremental depth-first state-space search).
- **Safety Conditions**: Two queens at $(r_1, c_1)$ and $(r_2, c_2)$ attack each other if:
  1. $c_1 = c_2$ (Same column)
  2. $|r_1 - r_2| = |c_1 - c_2|$ (Same diagonal)
- **Complexity**:
  - **Time**: $\mathcal{O}(N!)$ upper bound.
  - **Space**: $\mathcal{O}(N)$ recursion stack & position array.

```
Example 4-Queens Solution:
. Q . .
. . . Q
Q . . .
. . Q .
```

---

### 20. Huffman Encoding (Lossless Compression)
- **Technique**: **Greedy Algorithm** with Min-Priority Queue.
- **Concept**: Assigns variable-length prefix binary codes based on symbol frequencies. High-frequency characters receive shorter bit sequences.
- **Prefix Property**: No assigned code is a prefix of any other valid code (enables deterministic unambiguous decoding).

#### Algorithmic Steps:
1. Build leaf nodes for each symbol and push into a Min-Heap based on frequency.
2. While heap size $> 1$:
   - Extract two lowest-frequency nodes $u$ and $v$.
   - Create parent node with frequency $f(u) + f(v)$.
   - Reinsert parent into heap.
3. Label left edges `0` and right edges `1`.
4. Traverse from root to leaves to extract binary codes.

#### Total Bit Cost Formula:
$$B = \sum_{i=1}^{n} f_i \cdot l_i$$
- **Complexity**: $\mathcal{O}(n \log n)$ time, $\mathcal{O}(n)$ space.

---

### 21. Knapsack Problem Variants

#### A. Fractional Knapsack
- **Rule**: Items can be fractionally divided ($0 \leq x_i \leq 1$).
- **Technique**: **Greedy Algorithm**.
- **Strategy**: Calculate profit-to-weight ratio $R_i = \frac{P_i}{W_i}$. Sort items in non-increasing order of $R_i$. Greedily consume highest ratio items until capacity $W$ is saturated.
- **Time Complexity**: $\mathcal{O}(n \log n)$ (dominated by sorting).

#### B. 0/1 Knapsack
- **Rule**: Items are atomic; either fully taken ($x_i = 1$) or excluded ($x_i = 0$).
- **Technique**: **Dynamic Programming**.

#### DP Recurrence:
$$DP[i][w] = \begin{cases} 
DP[i-1][w] & \text{if } W_i > w \\ 
\max(DP[i-1][w], \, P_i + DP[i-1][w - W_i]) & \text{if } W_i \leq w 
\end{cases}$$

- **Base Cases**: $DP[0][w] = 0$, $DP[i][0] = 0$.
- **Complexity**:
  - **Time**: $\mathcal{O}(n \cdot W)$ (**Pseudo-polynomial**, dependent on numerical magnitude of $W$).
  - **Space**: $\mathcal{O}(n \cdot W)$, optimizable to $\mathcal{O}(W)$ using a 1D rolling array.

---

### 22. Quick Sort
- **Technique**: Divide and Conquer.
- **Mechanism**: Selects pivot, partitions array such that elements $\leq$ pivot are left and $>$ pivot are right, then recurses.
- **Deterministic**: Fixed pivot (e.g., first or last element).
  - Worst Case: Sorted array with extreme pivot yields $\mathcal{O}(n^2)$ degradations.
- **Randomized**: Uniformly selects random pivot element.
  - Expected Time: $\mathcal{O}(n \log n)$ on all inputs with high probability.
  - Worst Case: $\mathcal{O}(n^2)$ (astronomically low probability).

---

### 23. Merge Sort
- **Technique**: Divide and Conquer.
- **Mechanism**: Evenly bisects array into two halves, recursively sorts, and merges two sorted subarrays.
- **Recurrence**:
  $$T(n) = 2T(n/2) + \Theta(n) \implies \Theta(n \log n)$$
- **Guarantees**: $\mathcal{O}(n \log n)$ strictly across all best, average, and worst-case scenarios.
- **Auxiliary Memory**: $\mathcal{O}(n)$ contiguous merge buffer.

---

## Part 4 – Greedy Algorithms

### 25. Core Properties for Greedy Optimality
A problem is solvable by a greedy strategy if and only if it exhibits:
1. **Greedy Choice Property**: A globally optimal configuration can be assembled through sequence of locally optimal choices without retrospective rollback.
2. **Optimal Substructure**: The optimal solution to the problem encapsulates optimal solutions to its constituent subproblems.

### 26. Control Abstraction
```
Algorithm Greedy(C):
    solution = empty_set
    while not solution_complete(solution) and C is not empty:
        x = select_best_candidate(C)
        remove x from C
        if is_feasible(solution ∪ {x}):
            solution = solution ∪ {x}
    return solution
```

### 27. Activity Selection Problem
- **Objective**: Select maximum cardinality subset of mutually compatible activities.
- **Greedy Rule**: Sort activities in ascending order of **finish time** ($f_1 \leq f_2 \leq \dots \leq f_n$). Greedily select next activity starting after the finish time of the last scheduled activity.
- **Complexity**: $\mathcal{O}(n \log n)$ sorting + $\mathcal{O}(n)$ scan.

---

## Part 5 – Dynamic Programming

### 30. Core Paradigm & Approaches
Solves optimization problems with **Overlapping Subproblems** and **Optimal Substructure**:
- **Memoization (Top-Down)**: Retains recursive tree structure; checks a hash map or array cache before invoking recursive branches.
- **Tabulation (Bottom-Up)**: Solves base subproblems iteratively first, filling multidimensional lookup tables.

---

### 34. Matrix Chain Multiplication (MCM)
- **Goal**: Parenthesize product $A_1 \times A_2 \times \dots \times A_n$ with dimensions $p_{0}, p_{1}, \dots, p_{n}$ to minimize total scalar multiplications.

#### DP Recurrence:
$$m[i, j] = \begin{cases} 
0 & \text{if } i = j \\ 
\min_{i \leq k < j} \left( m[i, k] + m[k+1, j] + p_{i-1} p_k p_j \right) & \text{if } i < j 
\end{cases}$$

- **Complexity**: Time $\mathcal{O}(n^3)$, Space $\mathcal{O}(n^2)$.

---

## Part 6 – Backtracking

### 36. Backtracking Principles
Constructs candidate solutions in a **state-space tree** using depth-first search:
- If current partial state violates constraints, **prune** subtree immediately and **backtrack** to parent state.

```
                    Root (Level 0)
                   /      |      \
               Choice1  Choice2  Choice3
               /    \       |
           Valid  Invalid Prune!
                   (Backtrack)
```

### 38. Graph Coloring Problem
Assign at most $m$ colors to vertices of graph $G(V, E)$ such that no two adjacent vertices share the same color.
- **Chromatic Number ($\chi(G)$)**: Minimal color count required to legally color $G$.
- **Complexity**: $\mathcal{O}(m^V)$ in worst-case backtracking.

---

## Part 7 – Branch and Bound

### 41. Branch and Bound Mechanism
Specifically designed for combinatorial **optimization problems** over state-space trees:
1. **Branching**: Generate successors of the current active node (E-node).
2. **Bounding**: Calculate an upper/lower mathematical bound on the objective value achievable within that subtree.
3. **Pruning**: Discard node if its bound is worse than the current globally best feasible solution.

### 43. Exploration Strategies

| Strategy | Data Structure | Selection Logic | Analogy |
| :--- | :--- | :--- | :--- |
| **FIFO** | Standard Queue | Expands oldest unvisited live node | Breadth-First Search (BFS) |
| **LIFO** | Stack | Expands newest generated live node | Depth-First Search (DFS) |
| **Least Cost (LC)** | Min/Max-Priority Queue | Expands node with the most promising estimated bound | Best-First Search ($A^*$) |

---

### 45. Backtracking vs. Branch and Bound

| Feature | Backtracking | Branch and Bound |
| :--- | :--- | :--- |
| **Primary Domain** | Decision & Constraint Satisfaction problems | Combinatorial Optimization problems |
| **Tree Traversal** | Exclusively Depth-First Search (DFS) | BFS (FIFO), DFS (LIFO), or Best-First (LC) |
| **Pruning Mechanism**| Feasibility & bounding constraints | Quantitative Upper / Lower Cost Bounds |
| **Data Structures** | System Recursion Call-Stack | Priority Queue, FIFO Queue, or Stack |
| **Classic Use** | N-Queens, Sudoku, Subset Sum | TSP, 0/1 Knapsack optimization |

---

## Part 8 – Amortized Analysis

### 46. Definition
Guarantees the **average performance per operation** over a worst-case sequence of $n$ operations. Even if a sporadic operation is expensive (e.g., dynamic array reallocation), the sequence amortizes to cheap constant time.

### 47. The Three Amortized Methods

#### 1. Aggregate Method
Computes total cost for sequence of $n$ operations and divides by $n$:
$$\text{Amortized Cost} = \frac{T(n)}{n}$$

#### 2. Accounting Method (Banker's Method)
Assigns artificial amortized charges $\hat{c}_i$ to operations. Overcharged simple operations accumulate "credit" deposited in the data structure to pay for future expensive operations:
$$\sum_{i=1}^{n} \hat{c}_i \geq \sum_{i=1}^{n} c_i \quad (\text{Credit never negative})$$

#### 3. Potential Method (Physicist's Method)
Defines a potential function $\Phi(D)$ mapping data structure state $D$ to a real number:
$$\hat{c}_i = c_i + \Phi(D_i) - \Phi(D_{i-1})$$
- $c_i$: Actual cost of $i$-th operation
- $\Phi(D_i) - \Phi(D_{i-1})$: Change in potential energy

---

## Part 9 – Advanced & Embedded Algorithm Concepts

### 53. Randomized Algorithms
- **Las Vegas**: Always outputs the exact correct solution; execution time is a random variable (e.g., Randomized QuickSort).
- **Monte Carlo**: Bounded deterministic execution time; output has an adjustable non-zero probability of error (e.g., Miller-Rabin primality test).

### 54. Approximation Algorithms
Computes provably near-optimal solutions for NP-Hard optimization problems in polynomial time.
- **Approximation Ratio ($\rho$)**:
  $$\rho = \max \left( \frac{C}{C^*}, \frac{C^*}{C} \right)$$
  *(where $C^*$ is optimal cost and $C$ is approximation cost)*

### 55. Embedded Algorithms & CPU Utilization
Embedded systems prioritize strict resource limits (RAM, power consumption, deterministic deadline scheduling).
- **Periodic Task Utilization ($U$)**:
  $$U = \sum_{i=1}^{n} \frac{C_i}{T_i} \leq 1$$
  *(where $C_i$ is task execution time and $T_i$ is repetition period)*

---

## Part 10 – Master Formula Sheet for Viva

| Concept | Canonical Formula |
| :--- | :--- |
| **Fibonacci Recurrence** | $F(n) = F(n-1) + F(n-2), \quad F(0)=0, F(1)=1$ |
| **Binomial Coefficient (DP)** | $C(n, r) = C(n-1, r-1) + C(n-1, r)$ |
| **Fractional Knapsack Ratio** | $R_i = \frac{P_i}{W_i}$ |
| **0/1 Knapsack DP** | $DP[i][w] = \max(DP[i-1][w], \, P_i + DP[i-1][w-W_i])$ |
| **Matrix Chain Multiplication** | $m[i, j] = \min_{k} (m[i, k] + m[k+1, j] + p_{i-1}p_k p_j)$ |
| **Huffman Total Bit Cost** | $B = \sum_{i=1}^{n} f_i \cdot l_i$ |
| **Aggregate Amortized Cost** | $\text{Amortized Cost} = \frac{T(n)}{n}$ |
| **Potential Method Amortization**| $\hat{c}_i = c_i + \Phi(D_i) - \Phi(D_{i-1})$ |
| **Minimization Approximation** | $\rho = \frac{\text{Approximate Cost}}{\text{Optimal Cost}}$ |
| **N-Queens Diagonal Test** | $\|r_1 - r_2\| = \|c_1 - c_2\|$ |
| **CPU Task Utilization** | $U = \sum_{i=1}^{n} \frac{C_i}{T_i}$ |

---

## Part 11 – Comprehensive Algorithm Complexity Table

| Algorithm | Paradigm | Best Case | Average Case | Worst Case | Auxiliary Space |
| :--- | :--- | :--- | :--- | :--- | :--- |
| **Recursive Fibonacci** | Recursion | $\mathcal{O}(2^n)$ | $\mathcal{O}(2^n)$ | $\mathcal{O}(2^n)$ | $\mathcal{O}(n)$ (Call stack) |
| **Iterative / DP Fibonacci** | Iterative / DP | $\mathcal{O}(n)$ | $\mathcal{O}(n)$ | $\mathcal{O}(n)$ | $\mathcal{O}(1)$ |
| **Merge Sort** | Divide & Conquer | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n)$ |
| **Quick Sort (Deterministic)**| Divide & Conquer | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n^2)$ | $\mathcal{O}(\log n)$ stack |
| **Quick Sort (Randomized)** | Randomized D&C | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n^2)$ | $\mathcal{O}(\log n)$ stack |
| **Binary Search** | Divide & Conquer | $\mathcal{O}(1)$ | $\mathcal{O}(\log n)$ | $\mathcal{O}(\log n)$ | $\mathcal{O}(1)$ |
| **Huffman Encoding** | Greedy | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n)$ |
| **Fractional Knapsack** | Greedy | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(1)$ |
| **0/1 Knapsack (DP)** | Dynamic Prog. | $\mathcal{O}(n W)$ | $\mathcal{O}(n W)$ | $\mathcal{O}(n W)$ | $\mathcal{O}(n W)$ or $\mathcal{O}(W)$ |
| **Matrix Chain Mult.** | Dynamic Prog. | $\mathcal{O}(n^3)$ | $\mathcal{O}(n^3)$ | $\mathcal{O}(n^3)$ | $\mathcal{O}(n^2)$ |
| **Activity Selection** | Greedy | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(n \log n)$ | $\mathcal{O}(1)$ |
| **N-Queens** | Backtracking | $\mathcal{O}(N)$ | $\mathcal{O}(N!)$ | $\mathcal{O}(N!)$ | $\mathcal{O}(N)$ |
| **Graph Coloring** | Backtracking | $\mathcal{O}(V)$ | $\mathcal{O}(m^V)$ | $\mathcal{O}(m^V)$ | $\mathcal{O}(V)$ |
| **0/1 Knapsack (B&B)** | Branch & Bound | $\mathcal{O}(n \log n)$ | Exponential | $\mathcal{O}(2^n)$ | $\mathcal{O}(2^n)$ queue |
| **TSP (Branch & Bound)** | Branch & Bound | $\mathcal{O}(n^2)$ | Exponential | $\mathcal{O}(n!)$ | $\mathcal{O}(n!)$ priority queue |

---

## Part 12 – High-Priority Viva Questions & Answers

### Q1: What is the fundamental difference between Divide & Conquer and Dynamic Programming?
**Answer**: Divide & Conquer breaks a problem into **disjoint (independent)** subproblems, solves them recursively, and combines results (e.g., Merge Sort). Dynamic Programming addresses problems with **overlapping subproblems**; it computes each sub-solution once and stores it in a table to prevent redundant re-computation.

### Q2: Why is the time complexity of 0/1 Knapsack $\mathcal{O}(nW)$ called pseudo-polynomial?
**Answer**: $\mathcal{O}(nW)$ depends on the numeric value of $W$ (the capacity), not just the input size in bits. Since $W$ requires $\log_2 W$ bits to represent, the runtime is exponential with respect to the input representation length ($\mathcal{O}(n \cdot 2^k)$, where $k = \log_2 W$).

### Q3: Why is backtracking used in the N-Queens problem?
**Answer**: Backtracking incrementally constructs safe queen placements column by column. If placing a queen at row $r$ leads to a state where no subsequent queen can be safely placed, it prunes the remaining search space and retracts (backtracks) the queen at row $r$, trying the next position instead of exploring all $N^N$ board configurations.

### Q4: How do you verify if two queens lie on the same diagonal?
**Answer**: Two queens at board coordinates $(r_1, c_1)$ and $(r_2, c_2)$ share a diagonal if and only if the absolute vertical distance equals the absolute horizontal distance:
$$|r_1 - r_2| = |c_1 - c_2|$$

### Q5: What is the distinction between P, NP, NP-Hard, and NP-Complete?
**Answer**:
- **P**: Decision problems solvable in polynomial time ($\mathcal{O}(n^k)$).
- **NP**: Decision problems whose solutions are verifiable in polynomial time.
- **NP-Hard**: Problems at least as hard as any problem in NP (all NP problems reduce to it in polynomial time).
- **NP-Complete**: Problems that belong to **both NP and NP-Hard** (e.g., 3-SAT, Hamiltonian Cycle).

### Q6: What is a Loop Invariant and how does it prove correctness?
**Answer**: A loop invariant is a formal logical assertion true before and after each loop iteration. Correctness is proven in three steps:
1. **Initialization**: Invariant holds before first iteration.
2. **Maintenance**: If true before iteration $k$, it remains true before iteration $k+1$.
3. **Termination**: When the loop terminates, the invariant yields the desired algorithm post-condition.

### Q7: What is the difference between Las Vegas and Monte Carlo algorithms?
**Answer**:
- **Las Vegas**: Always produces the exact correct result; execution time is a random variable (e.g., Randomized QuickSort).
- **Monte Carlo**: Guarantees fixed deterministic execution time; output has a bounded probability of error (e.g., randomized primality testing).
