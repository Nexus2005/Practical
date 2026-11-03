import java.util.*;

public class FractionalKnapsack {

    // Class to store item details
    static class Item {
        double weight, profit, ratio;

        Item(double weight, double profit) {
            this.weight = weight;
            this.profit = profit;
            this.ratio = profit / weight;
        }
    }

    // Fractional Knapsack Method
    static double fractionalKnapsack(Item items[], double capacity) {

        // Sort items by decreasing profit/weight ratio
        Arrays.sort(items, (a, b) ->
            Double.compare(b.ratio, a.ratio));

        double totalProfit = 0;

        for (Item item : items) {

            if (capacity >= item.weight) {
                // Take complete item
                totalProfit += item.profit;
                capacity -= item.weight;
            } else {
                // Take fractional item
                totalProfit += item.profit *
                               (capacity / item.weight);
                break;
            }
        }

        return totalProfit;
    }

    // Main Method
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of items: ");
        int n = sc.nextInt();

        Item items[] = new Item[n];

        for (int i = 0; i < n; i++) {

            System.out.print("Enter weight of item " + (i + 1) + ": ");
            double weight = sc.nextDouble();

            System.out.print("Enter profit of item " + (i + 1) + ": ");
            double profit = sc.nextDouble();

            items[i] = new Item(weight, profit);
        }

        System.out.print("Enter knapsack capacity: ");
        double capacity = sc.nextDouble();

        if (n <= 0 || capacity < 0) {
            System.out.println("Invalid input");
        } else {
            double result = fractionalKnapsack(items, capacity);
            System.out.println("Maximum Profit = " + result);
        }

        sc.close();
    }
}


/*
Enter number of items: 3

Enter weight of item 1: 10
Enter profit of item 1: 60

Enter weight of item 2: 20
Enter profit of item 2: 100

Enter weight of item 3: 30
Enter profit of item 3: 120

Enter knapsack capacity: 50

Maximum Profit = 240.0



javac FractionalKnapsack.java
java FractionalKnapsack

















## Fractional Knapsack – Theory

### 1. What is Fractional Knapsack?

Fractional Knapsack is an optimization problem in which we are given a set of items, each having a weight and profit, and a knapsack with limited capacity.

The objective is to select items in such a way that the total profit is maximized without exceeding the knapsack capacity.

In this method, we can take either the complete item or a fraction of an item.

It uses the Greedy Strategy to obtain the maximum profit.

### 2. Important Terminology

1\. Greedy Algorithm: An algorithm that selects the best possible option at each step to achieve an optimal solution.

2\. Knapsack Capacity: The maximum weight that the knapsack can carry.

3\. Weight: The amount of space or capacity occupied by an item.

4\. Profit: The value or benefit obtained by selecting an item.

5\. Profit-to-Weight Ratio: The ratio of profit to the weight of an item. It helps determine which item should be selected first.

Formula:

\\[ Ratio = \frac{Profit}{Weight} \\]

6\. Fractional Selection: The process of selecting a portion of an item when its complete weight cannot fit into the remaining capacity.

### 3. How Fractional Knapsack Works

The Fractional Knapsack problem follows the Greedy Strategy.

1. Input: Accept the number of items, their weights, profits and knapsack capacity.
2. Calculate Ratio: Calculate the profit-to-weight ratio for each item.
3. Sorting: Sort all items in descending order of their profit-to-weight ratio.
4. Select Items: Select the item having the highest ratio first.
5. Check Capacity: If the complete item fits, take the entire item.
6. Fractional Selection: If the item does not fit, take only the required fraction of it.
7. Calculate Profit: Add the profit of selected items to get the maximum total profit.

### 4. Example

Consider the following items:

| Item   | Weight | Profit | Ratio (Profit/Weight) |
| ------ | ------ | ------ | --------------------- |
| Item 1 | 10     | 60     | 6                     |
| Item 2 | 20     | 100    | 5                     |
| Item 3 | 30     | 120    | 4                     |

Knapsack Capacity = 50

Step 1: Calculate the profit-to-weight ratio of each item.

Step 2: Sort items in descending order of their ratios.

Order: Item 1 → Item 2 → Item 3.

Step 3: Select items according to their ratios.

- Take complete Item 1: Weight = 10, Profit = 60.
- Take complete Item 2: Weight = 20, Profit = 100.
- Remaining capacity = 20.
- Take 20/30 fraction of Item 3.

Step 4: Calculate total profit.

\\[ Maximum\ Profit = 60 + 100 + (120 \times \frac{20}{30}) \\]

\\[ \boxed{Maximum\ Profit = 240} \\]

Maximum Profit = 240

### 5. Advantages of Fractional Knapsack

- Provides maximum profit using a Greedy Strategy.
- Simple and easy to implement.
- Efficient sorting-based approach.
- Allows fractional selection of items.
- Suitable for resource allocation problems.

### 6. Time and Space Complexity

| Operation                     | Time Complexity |
| ----------------------------- | --------------- |
| Calculate Profit/Weight Ratio | O(n)            |
| Sort Items                    | O(n log n)      |
| Select Items                  | O(n)            |

Overall Time Complexity: \\(O(n\log n)\\)

Space Complexity: \\(O(n)\\), including storage of item details.

Where `n` = Number of items.

### 7. Difference Between Fractional and 0/1 Knapsack

| Fractional Knapsack                       | 0/1 Knapsack                                           |
| ----------------------------------------- | ------------------------------------------------------ |
| Uses Greedy Method.                       | Commonly uses Dynamic Programming.                     |
| Items can be divided.                     | Items cannot be divided.                               |
| Complete or partial item can be selected. | Complete item or no item is selected.                  |
| Greedy strategy gives optimal solution.   | Greedy strategy does not always give optimal solution. |

### 8. Result

The Fractional Knapsack problem is successfully solved using the Greedy Method by selecting items according to their profit-to-weight ratios to obtain maximum profit within the given knapsack capacity.

Main concept to remember: Always select the item having the highest profit-to-weight ratio first. Take a fraction of the item when its complete weight cannot fit into the remaining capacity.
*/