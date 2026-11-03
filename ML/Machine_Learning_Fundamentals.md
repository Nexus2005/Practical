# Machine Learning Fundamentals & Practical Viva Notes

Comprehensive theory, formulas, algorithms, preprocessing techniques, and evaluation metrics for Machine Learning practicals and oral exams.

---

## 1. Machine Learning Fundamentals

### 1.1 What is Machine Learning?
- **Definition**: Machine Learning (ML) is a branch of Artificial Intelligence that allows computers to learn patterns from data and make predictions or decisions without being explicitly programmed for every single task.
- **Example**: Instead of hand-coding thousands of complex rules to detect spam emails, we train a model on a dataset containing examples of spam and legitimate emails. The model identifies underlying patterns and automatically predicts whether an incoming email is spam.

### 1.2 What is Artificial Intelligence?
- **Definition**: Artificial Intelligence (AI) is the broader discipline of computer science focused on building systems and machines capable of performing tasks that normally require human intelligence (e.g., learning, visual perception, reasoning, problem-solving, and decision-making).
- **Hierarchy & Relationship**:
  - **AI** is the umbrella field.
  - **Machine Learning (ML)** is a subset of AI.
  - **Deep Learning (DL)** is a specialized subset of ML based on multi-layered neural networks.

```
+-------------------------------------------------------+
| Artificial Intelligence (AI)                          |
|   +-------------------------------------------------+ |
|   | Machine Learning (ML)                           | |
|   |   +-------------------------------------------+ | |
|   |   | Deep Learning (DL)                        | | |
|   |   +-------------------------------------------+ | |
|   +-------------------------------------------------+ |
+-------------------------------------------------------+
```

### 1.3 Types of Machine Learning

#### 1. Supervised Learning
The algorithm learns from **labelled data** where the ground-truth target is provided for each input.
- **Example**: Predicting whether an email is spam or not spam; predicting house prices.
- **Algorithms**:
  - K-Nearest Neighbours (KNN)
  - Support Vector Machine (SVM)
  - Linear Regression & Logistic Regression
  - Decision Trees & Random Forests
  - Artificial Neural Networks (ANN)

#### 2. Unsupervised Learning
The model works with **unlabelled data**, identifying inherent structures, groupings, or patterns without predefined targets.
- **Example**: Customer market segmentation based on purchasing behaviour.
- **Algorithms**:
  - K-Means Clustering
  - Hierarchical (Agglomerative) Clustering
  - Principal Component Analysis (PCA)

#### 3. Semi-Supervised Learning
Combines a small volume of labelled data with a large amount of unlabelled data. The labelled instances guide and bootstrap pattern discovery across the unlabelled majority.

#### 4. Reinforcement Learning
An autonomous agent interacts with an environment in discrete time steps, learning an optimal policy by receiving **rewards** for beneficial actions and **penalties** for detrimental actions.
- **Example**: Training a robot to navigate an obstacle course; game-playing agents (AlphaGo).

---

### 1.4 Classification vs Regression vs Clustering

| Concept | Meaning | Output Type | Example |
| :--- | :--- | :--- | :--- |
| **Classification** | Predicts a discrete category or class label | Categorical / Discrete | Spam / Not Spam, Diabetic / Non-Diabetic |
| **Regression** | Predicts a continuous numerical value | Continuous Numerical | Predicting Uber fare (e.g., ₹250.50), House Price |
| **Clustering** | Groups similar data points without labels | Cluster ID / Grouping | Customer segmentation |

> **Key Rule of Thumb:**
> - **Classification** $\rightarrow$ Category
> - **Regression** $\rightarrow$ Continuous Number
> - **Clustering** $\rightarrow$ Natural Groups

---

### 1.5 Dataset, Features, and Target
- **Dataset**: The complete collection of records used to train, validate, and evaluate an ML model.
- **Features ($X$)**: Independent input variables used by the model to infer patterns.
- **Target ($y$)**: Dependent ground-truth output variable the model aims to predict.
- **Example (Uber Fare Prediction)**:
  - **Features ($X$)**: Pickup coordinates, dropoff coordinates, passenger count, pickup hour, day of the week.
  - **Target ($y$)**: Fare amount (`fare_amount`).

---

### 1.6 Training and Testing Data
- **Training Data**: Portion of data used to adjust model parameters during training.
- **Testing Data**: Independent, unseen portion held out to evaluate generalization performance.
- **Standard Partition (80/20)**:
  $$\text{Training Size} = 0.8N$$
  $$\text{Testing Size} = 0.2N$$
  *(where $N$ is total sample count)*

---

### 1.7 What is a Model?
A model is a mathematical construct or function learned from training data that maps feature inputs $X$ to predictions $\hat{y} = f(X)$.

---

### 1.8 Parameters vs Hyperparameters

| Dimension | Parameters | Hyperparameters |
| :--- | :--- | :--- |
| **Definition** | Learned automatically from data during training | Configured before training starts to guide learning |
| **How Set** | Optimized via loss minimization / gradient descent | Set manually or tuned via Grid/Random Search |
| **Examples** | - Weights ($w$) & biases ($b$) in Neural Networks<br>- Slope ($m$) & intercept ($c$) in Linear Regression | - $K$ in KNN<br>- Number of clusters $K$ in K-Means<br>- `n_estimators`, `max_depth` in Random Forest<br>- Learning rate ($\alpha$), epochs, batch size in ANN |

---

### 1.9 Overfitting, Underfitting, and Good Fit

```
Underfitting (High Bias)         Good Fit (Optimal)         Overfitting (High Variance)
       o        o                      o     o                         o       o
     /   \   /                       /   ---   \                      / \     / \
    /     \ /                       /               \                    /   \   /   \
  Too simple; misses trend       Balances accuracy & generalization     Captures noise & outliers
```

- **Overfitting**: The model memorizes training samples including random noise.
  - *Symptom*: High train accuracy (e.g., 99%), poor test accuracy (e.g., 65%).
- **Underfitting**: The model is overly simplistic and cannot capture fundamental relationships.
  - *Symptom*: Poor train accuracy (e.g., 55%), poor test accuracy (e.g., 52%).
- **Good Fit**: Strong, balanced performance on both training and unseen test sets.

---

### 1.10 Bias and Variance Trade-off
- **Bias**: Error stemming from overly simplistic model assumptions (leads to underfitting).
- **Variance**: Error stemming from extreme sensitivity to fluctuations in the training set (leads to overfitting).
- **Trade-off**: As model complexity increases, bias decreases while variance increases. The goal is to find the sweet spot minimizing total expected error.

---

## 2. Data Preprocessing & Feature Engineering

### 2.1 Why Preprocessing is Essential
Raw real-world datasets often suffer from:
- Missing entries and null values
- Duplicate records
- Inconsistent scales and units
- Categorical text columns unreadable by mathematical algorithms
- Distorted outlier distributions

Preprocessing standardizes the data quality so algorithms can converge properly.

### 2.2 Data Cleaning Commands in Pandas

```python
import pandas as pd

df.head()              # Displays first 5 rows
df.tail()              # Displays last 5 rows
df.shape               # Tuple of (rows, columns)
df.info()              # Columns, data types, non-null counts, memory usage
df.describe()          # Summary statistics (mean, std, min, quartiles, max)
df.isnull().sum()       # Count of null values per feature
df.dropna()            # Drops records with missing entries
df.drop_duplicates()   # Drops redundant duplicate rows
```

### 2.3 Handling Missing Values
1. **Row Deletion (`dropna`)**: Viable when missingness is low (< 3-5%) and sample size is large.
2. **Mean Imputation**:
   $$\bar{x} = \frac{\sum_{i=1}^{n} x_i}{n}$$
   *Used for symmetric, normally distributed numerical data.*
3. **Median Imputation**: Middle value of sorted data.
   *Preferred for skewed numerical data because it resists extreme outliers.*
4. **Mode Imputation**: Most frequent category.
   *Used for missing categorical values.*

---

### 2.4 Duplicate Records
Duplicate observations bias the model by artificially inflating the importance of repeated instances.
```python
# Check count of duplicates
df.duplicated().sum()

# Drop duplicate rows in-place
df.drop_duplicates(inplace=True)
```

---

### 2.5 Categorical Encoding

#### Label Encoding
Maps categories to integer ranks ($0, 1, 2, \dots$).
- Best suited for ordinal data (e.g., Low=0, Medium=1, High=2).

#### One-Hot Encoding
Converts categorical variables into $k$ distinct binary indicators ($0$ or $1$).
```python
# One-hot encode categorical features
df_encoded = pd.get_dummies(df, drop_first=True)
```

---

### 2.6 Feature Scaling

#### 1. Standardization (`StandardScaler`)
Centers data around zero mean with unit standard deviation:
$$z = \frac{x - \mu}{\sigma}$$
- $\mu$: Mean of feature
- $\sigma$: Standard deviation
- Produces values centered at 0 with $\sigma = 1$.

#### 2. Normalization (`MinMaxScaler`)
Compresses features into a bounded range, typically $[0, 1]$:
$$x' = \frac{x - x_{\min}}{x_{\max} - x_{\min}}$$

> **Critical Note:** Algorithms relying on spatial distances or gradient updates (**KNN, SVM, K-Means, Neural Networks**) are highly sensitive to feature scales and require scaling.

---

### 2.7 Train-Test Split & Data Leakage

```python
from sklearn.model_selection import train_test_split

X_train, X_test, y_train, y_test = train_test_split(
    X, y, test_size=0.2, random_state=42, stratify=y
)
```
- `test_size=0.2`: 20% reserved for testing, 80% for training.
- `random_state=42`: Seeds pseudo-random generator for identical reproducible splits.
- `stratify=y`: Preserves identical target class ratios in train and test splits (essential for imbalanced datasets).

#### Data Leakage Prevention
Never fit scalers or imputers on the whole dataset before splitting!
```python
# CORRECT WORKFLOW:
from sklearn.preprocessing import StandardScaler
scaler = StandardScaler()

X_train_scaled = scaler.fit_transform(X_train)  # Compute mean/std on train only
X_test_scaled  = scaler.transform(X_test)       # Apply train mean/std to test
```

---

### 2.8 Outlier Detection: Interquartile Range (IQR) Method

$$IQR = Q3 - Q1$$
- $Q1$ = 25th percentile
- $Q3$ = 75th percentile

$$\text{Lower Limit} = Q1 - 1.5 \times IQR$$
$$\text{Upper Limit} = Q3 + 1.5 \times IQR$$

Any observation where $x < \text{Lower Limit}$ or $x > \text{Upper Limit}$ is flagged as an outlier.

---

### 2.9 Pearson Correlation Coefficient ($r$)

$$r = \frac{\operatorname{Cov}(X, Y)}{\sigma_X \sigma_Y}$$
- Ranges strictly between $[-1, +1]$:
  - $+1$: Perfect positive linear correlation
  - $0$: No linear relationship
  - $-1$: Perfect negative linear correlation

> **Reminder:** *Correlation does not imply causation.*

---

## 3. Classification Algorithms

### 3.1 K-Nearest Neighbours (KNN)
- **Concept**: Non-parametric, instance-based **"lazy learner"**. Does not train an explicit parametric model during `fit()`; instead, it stores training coordinates and defers computation until prediction time.
- **Workflow**:
  1. Pick hyperparameter $K$.
  2. Compute Euclidean distance from test sample to all training points.
  3. Sort distances and pick the top $K$ nearest points.
  4. Perform majority voting for classification (or average for regression).

#### Euclidean Distance Formula:
$$d(x, y) = \sqrt{\sum_{i=1}^{n} (x_i - y_i)^2}$$

#### Impact of $K$:
- Very small $K$ (e.g., $K=1$): Extremely sensitive to noise and outliers (overfitting).
- Large $K$: Oversmooths boundaries, incorporates points from foreign classes (underfitting).
- **Best Practice**: Use odd numbers for $K$ in binary tasks to avoid ties.

```python
from sklearn.neighbors import KNeighborsClassifier
knn = KNeighborsClassifier(n_neighbors=5)
knn.fit(X_train, y_train)
y_pred = knn.predict(X_test)
```

---

### 3.2 Support Vector Machine (SVM)
- **Concept**: Identifies an optimal decision boundary (**hyperplane**) that separates classes with the **maximum geometric margin**.
- **Key Terminology**:
  - **Hyperplane**: Linear boundary defined by $w^T x + b = 0$.
  - **Support Vectors**: Crucial data points lying closest to the margin boundary. The optimal hyperplane depends solely on these points.
  - **Margin**: Perpendicular distance between support vector boundaries:
    $$\text{Margin} = \frac{2}{\|w\|}$$

#### Optimization Problem (Hard Margin):
$$\min_{w, b} \frac{1}{2} \|w\|^2 \quad \text{subject to} \quad y_i(w^T x_i + b) \geq 1 \quad \forall i$$

#### Kernel Trick:
Maps non-linearly separable inputs into higher-dimensional Hilbert spaces where a linear separation exists.
- Common Kernels: Linear, Polynomial, Radial Basis Function (**RBF** / Gaussian), Sigmoid.

```python
from sklearn.svm import SVC
svm = SVC(kernel='linear', C=1.0)
svm.fit(X_train, y_train)
y_pred = svm.predict(X_test)
```

---

### 3.3 KNN vs SVM Summary

| Feature | K-Nearest Neighbours (KNN) | Support Vector Machine (SVM) |
| :--- | :--- | :--- |
| **Model Type** | Lazy learner / instance-based | Eager learner / boundary-based |
| **Decision Rule** | Local neighbourhood majority vote | Global maximum margin hyperplane |
| **Inference Speed** | Slow for large datasets ($O(N \cdot d)$) | Fast ($O(d)$ dot product against support vectors) |
| **Key Parameters** | Number of neighbours $K$, distance metric | Regularization $C$, Kernel function, $\gamma$ |
| **Memory Footprint**| Stores complete training dataset | Stores only support vectors |

---

## 4. Regression Algorithms

### 4.1 What is Regression?
Supervised learning task predicting a **continuous real-valued quantity** (e.g., Uber trip fare, house pricing, revenue).

### 4.2 Linear Regression
Models relationships using a linear equation minimizing the sum of squared residuals (**Ordinary Least Squares**).

#### Equations:
- **Simple Linear Regression**:
  $$y = mx + c$$
- **Multiple Linear Regression**:
  $$y = b_0 + b_1 x_1 + b_2 x_2 + \dots + b_n x_n$$

#### Cost Function (Mean Squared Error):
$$MSE = \frac{1}{n} \sum_{i=1}^{n} (y_i - \hat{y}_i)^2$$

```python
from sklearn.linear_model import LinearRegression
lr = LinearRegression()
lr.fit(X_train, y_train)
y_pred = lr.predict(X_test)
```

---

### 4.3 Random Forest (Ensemble Learning)
- **Concept**: An ensemble of diverse, de-correlated **Decision Trees** trained via **Bagging (Bootstrap Aggregation)**.
- **Bootstrap Sampling**: Sampling $N$ instances with replacement from the original dataset.
- **Random Feature Subspace**: At each node split, only a random subset of features is evaluated, reducing inter-tree correlation.
- **Aggregation**:
  - **Regression**: Mean prediction across all trees:
    $$\hat{y} = \frac{1}{N} \sum_{i=1}^{N} T_i(x)$$
  - **Classification**: Majority vote (mode).

```python
from sklearn.ensemble import RandomForestRegressor
rf = RandomForestRegressor(n_estimators=100, max_depth=10, random_state=42)
rf.fit(X_train, y_train)
y_pred = rf.predict(X_test)
```

---

### 4.4 Linear Regression vs Logistic Regression
- **Linear Regression**: Predicts a continuous scalar value ($y \in (-\infty, +\infty)$).
- **Logistic Regression**: A **classification** algorithm that outputs probabilities bounded in $[0, 1]$ via the **Sigmoid (logistic) function**:
  $$\sigma(z) = \frac{1}{1 + e^{-z}}$$

---

## 5. Clustering Algorithms (Unsupervised)

### 5.1 K-Means Clustering
Partitions $N$ unlabeled points into $K$ compact, spherical clusters centered at centroids $\mu_j$.

#### Objective Function (WCSS / Inertia):
$$WCSS = \sum_{j=1}^{K} \sum_{x_i \in C_j} \|x_i - \mu_j\|^2$$

#### Algorithmic Steps:
1. Specify cluster count $K$.
2. Initialize $K$ centroids randomly (or via K-Means++).
3. Assign each point to its nearest centroid (Euclidean distance).
4. Recompute centroids as the mean of assigned points:
   $$\mu_j = \frac{1}{|C_j|} \sum_{x \in C_j} x$$
5. Repeat steps 3–4 until centroids stabilize (convergence).

#### Finding Optimal $K$ (Elbow Method):
Plot WCSS (Inertia) against ascending values of $K$. The inflection point where the rate of decrease abruptly slows forms an "elbow", indicating the optimal $K$.

```python
from sklearn.cluster import KMeans
kmeans = KMeans(n_clusters=3, init='k-means++', random_state=42, n_init=10)
kmeans.fit(X)
cluster_labels = kmeans.labels_
```

---

### 5.2 Hierarchical Clustering
Builds a hierarchy of nested clusters represented visually by a tree diagram called a **Dendrogram**.

#### Approaches:
1. **Agglomerative (Bottom-Up)**: Each point starts as an individual cluster; nearest pairs iteratively merge until one root cluster remains.
2. **Divisive (Top-Down)**: Starts with one root cluster containing all samples, recursively bisecting until singletons remain.

#### Linkage Criteria:
- **Single Linkage**: Shortest distance between points:
  $$D(A, B) = \min_{a \in A, b \in B} d(a, b)$$
- **Complete Linkage**: Maximum distance between points:
  $$D(A, B) = \max_{a \in A, b \in B} d(a, b)$$
- **Average Linkage**: Mean distance across all cross-cluster pairs.
- **Ward's Linkage**: Minimizes the total within-cluster variance increase upon merging.

```python
from sklearn.cluster import AgglomerativeClustering
hc = AgglomerativeClustering(n_clusters=3, metric='euclidean', linkage='ward')
labels = hc.fit_predict(X)
```

---

### 5.3 Principal Component Analysis (PCA)
- **Definition**: Unsupervised linear dimensionality reduction technique that projects correlated high-dimensional features onto orthogonal axes (**Principal Components**) capturing maximal variance.
- **Role in Clustering**: PCA does not cluster data; it reduces high-dimensional spaces (e.g., 20 features) down to 2 or 3 components so cluster distributions can be plotted on 2D scatter plots.

---

## 6. Artificial Neural Networks (ANN)

### 6.1 Architecture & Neuron Mechanics
An artificial neuron models a biological counterpart:
1. Multiplies inputs $x_i$ by synaptic weights $w_i$.
2. Sums weighted values and adds scalar bias $b$:
   $$z = \sum_{i=1}^{n} w_i x_i + b = w^T x + b$$
3. Applies non-linear activation function $f(z)$ to produce activation $a$:
   $$a = f(z)$$

```
Inputs (x)      Weights (w)
  x1 ----------> w1 \
  x2 ----------> w2 --->  SUM (w^T x + b)  ---> Activation f(z) ---> Output (a)
  xn ----------> wn /        + Bias (b)
```

### 6.2 Common Activation Functions

| Function | Mathematical Formulation | Output Range | Primary Usage |
| :--- | :--- | :--- | :--- |
| **Sigmoid** | $f(z) = \frac{1}{1 + e^{-z}}$ | $(0, 1)$ | Binary classification output layer |
| **ReLU** | $f(z) = \max(0, z)$ | $[0, \infty)$ | Hidden layers (avoids vanishing gradients) |
| **Tanh** | $f(z) = \frac{e^z - e^{-z}}{e^z + e^{-z}}$ | $(-1, 1)$ | Zero-centered hidden layers |
| **Softmax**| $P(y=i) = \frac{e^{z_i}}{\sum_j e^{z_j}}$ | $(0, 1), \sum P = 1$ | Multi-class classification output layer |

---

### 6.3 Loss Functions

#### 1. Mean Squared Error (Regression):
$$MSE = \frac{1}{n}\sum_{i=1}^{n} (y_i - \hat{y}_i)^2$$

#### 2. Binary Cross-Entropy (Binary Classification):
$$L = -\frac{1}{n} \sum_{i=1}^{n} \left[ y_i \ln(p_i) + (1 - y_i)\ln(1 - p_i) \right]$$

---

### 6.4 Forward Propagation vs Backpropagation

| Phase | Direction | Purpose | Operation |
| :--- | :--- | :--- | :--- |
| **Forward Pass** | Input $\to$ Output | Computes predictions $\hat{y}$ and loss $L$ | Evaluates $z = w^T x + b$ and $a = f(z)$ layer by layer |
| **Backpropagation** | Output $\to$ Input | Computes loss gradients with respect to weights | Applies calculus **Chain Rule**: $\frac{\partial L}{\partial w} = \frac{\partial L}{\partial a} \cdot \frac{\partial a}{\partial z} \cdot \frac{\partial z}{\partial w}$ |

---

### 6.5 Training Hyperparameters & Regularization
- **Epoch**: One complete feedforward and backpropagation pass across the entire training set.
- **Batch Size**: Number of training samples evaluated before triggering a weight update.
- **Iteration**: Single parameter update step:
  $$\text{Iterations per Epoch} = \frac{\text{Total Training Samples}}{\text{Batch Size}}$$
- **Optimizers**: Algorithms adjusting weights based on gradients (e.g., SGD, RMSprop, **Adam**).
- **Dropout**: Regularization layer temporarily dropping a random fraction (e.g., 20%) of neurons during training to prevent co-adaptation.
- **Early Stopping**: Halts training once validation loss ceases to improve, counteracting overfitting.

---

## 7. Gradient Descent & Optimization

### 7.1 What is Gradient Descent?
An iterative first-order optimization algorithm that steps model parameters proportional to the negative gradient of the loss function to reach a local or global minimum.

### 7.2 Parameter Update Rule:
$$\theta_{\text{new}} = \theta_{\text{old}} - \alpha \nabla J(\theta)$$
- $\theta$: Model weights/biases
- $\alpha$: **Learning Rate** (step size)
- $\nabla J(\theta)$: Gradient vector of loss function $J$

```
Loss J(θ)
  |      \
  |       \   <-- Negative gradient step (-α ∇J)
  |        \_
  |          \___
  |              \__   <-- Minimum (∇J = 0)
  +-------------------------- Parameters θ
```

- **Learning Rate Dynamics**:
  - *Too small*: Slow convergence, risk of getting stuck in saddle points.
  - *Too large*: Oscillation, overshooting, divergence.

### 7.3 Variants of Gradient Descent
1. **Batch Gradient Descent**: Computes gradients across the entire dataset per update. Precise but computationally heavy.
2. **Stochastic Gradient Descent (SGD)**: Updates parameters per individual training record. Very fast and noisy; can jump out of shallow local minima.
3. **Mini-Batch Gradient Descent**: Evaluates small batches (e.g., 32, 64, 128 samples). Best balance of vectorization speed and gradient stability.

---

## 8. Model Evaluation Metrics & Formulas

### 8.1 The Confusion Matrix (Binary Classification)

| | Predicted Positive ($\hat{y} = 1$) | Predicted Negative ($\hat{y} = 0$) |
| :---: | :---: | :---: |
| **Actual Positive ($y = 1$)** | **TP** (True Positive) | **FN** (False Negative) *(Type II Error)* |
| **Actual Negative ($y = 0$)** | **FP** (False Positive) *(Type I Error)* | **TN** (True Negative) |

---

### 8.2 Classification Formulas

#### 1. Accuracy
Overall proportion of correctly classified instances:
$$\text{Accuracy} = \frac{TP + TN}{TP + TN + FP + FN}$$

#### 2. Error Rate (Misclassification Rate)
$$\text{Error Rate} = \frac{FP + FN}{TP + TN + FP + FN} = 1 - \text{Accuracy}$$

#### 3. Precision (Positive Predictive Value)
Out of all instances predicted as positive, how many were truly positive:
$$\text{Precision} = \frac{TP}{TP + FP}$$
*Prioritize when False Positives are costly (e.g., Spam Filtering).*

#### 4. Recall / Sensitivity (True Positive Rate)
Out of all actual positive instances, how many did the model capture:
$$\text{Recall} = \frac{TP}{TP + FN}$$
*Prioritize when False Negatives are dangerous (e.g., Cancer Diagnosis, Fraud).*

#### 5. Specificity (True Negative Rate)
$$\text{Specificity} = \frac{TN}{TN + FP}$$

#### 6. F1-Score
Harmonic mean balancing precision and recall:
$$F_1 = 2 \times \frac{\text{Precision} \times \text{Recall}}{\text{Precision} + \text{Recall}}$$

---

### 8.3 Regression Evaluation Formulas

#### 1. Mean Absolute Error (MAE):
$$\text{MAE} = \frac{1}{n} \sum_{i=1}^{n} |y_i - \hat{y}_i|$$
*Measures average error magnitude in original units; robust to extreme outliers.*

#### 2. Mean Squared Error (MSE):
$$\text{MSE} = \frac{1}{n} \sum_{i=1}^{n} (y_i - \hat{y}_i)^2$$
*Penalizes larger errors heavily due to squaring.*

#### 3. Root Mean Squared Error (RMSE):
$$\text{RMSE} = \sqrt{\frac{1}{n} \sum_{i=1}^{n} (y_i - \hat{y}_i)^2}$$
*Restores error metric to original target units while maintaining penalty for large errors.*

#### 4. $R^2$ Score (Coefficient of Determination):
$$R^2 = 1 - \frac{SS_{\text{res}}}{SS_{\text{tot}}} = 1 - \frac{\sum (y_i - \hat{y}_i)^2}{\sum (y_i - \bar{y})^2}$$
- $R^2 = 1.0$: Model explains 100% of variance.
- $R^2 = 0.0$: Model performs no better than predicting the mean $\bar{y}$.
- $R^2 < 0.0$: Model performs worse than the simple horizontal mean line.

---

### 8.4 Metric Selection Guide

| Algorithm / Problem | Recommended Evaluation Metrics |
| :--- | :--- |
| **KNN / SVM / ANN (Classification)** | Accuracy, Confusion Matrix, Precision, Recall, F1-Score, ROC-AUC |
| **Linear Regression / Random Forest** | $R^2$ Score, MAE, MSE, RMSE |
| **K-Means / Hierarchical Clustering** | WCSS / Inertia, Silhouette Score, Dendrogram inspection |

---

## 9. Advanced ML Concepts & Viva Questions

### 9.1 Distance Metrics
- **Euclidean ($L_2$ Norm)**:
  $$d(x, y) = \sqrt{\sum (x_i - y_i)^2}$$
- **Manhattan ($L_1$ Norm / City Block)**:
  $$d(x, y) = \sum |x_i - y_i|$$
- **Minkowski ($L_p$ Metric)**:
  $$d(x, y) = \left( \sum |x_i - y_i|^p \right)^{1/p}$$

### 9.2 Silhouette Score (Clustering Validation)
Measures cluster compactness and separation:
$$S = \frac{b - a}{\max(a, b)}$$
- $a$: Mean intra-cluster distance of sample to its own cluster members.
- $b$: Mean nearest-cluster distance of sample to points in closest neighbouring cluster.
- Score ranges $[-1, +1]$:
  - $\approx +1$: Dense, well-separated cluster assignment.
  - $\approx 0$: Overlapping cluster boundaries.
  - Negative: Sample placed in wrong cluster.

### 9.3 Regularization Techniques ($L_1$ vs $L_2$)
- **Lasso ($L_1$)**:
  $$\text{Loss} + \lambda \sum |w_j|$$
  *Forces uninformative weights strictly to zero, acting as built-in feature selection.*
- **Ridge ($L_2$)**:
  $$\text{Loss} + \lambda \sum w_j^2$$
  *Shrinks weights asymptotically toward zero without zeroing them, handling collinearity.*

### 9.4 Scikit-Learn API Conventions
- `fit(X, y)`: Learns parameters (e.g., coefficients, cluster centroids, scaling mean/std) from training data.
- `transform(X)`: Applies previously learned transformation parameters to new dataset.
- `fit_transform(X)`: Learns parameters and applies transformation in a single efficient step.
- `predict(X)`: Generates target predictions using the fitted parameters.

---

## 10. Practical Python Reference Libraries

| Library | Primary Responsibility | Key Sub-modules / Classes |
| :--- | :--- | :--- |
| **NumPy** | High-performance numerical arrays and matrix math | `np.array`, `np.mean`, `np.sqrt` |
| **Pandas** | Tabular DataFrame manipulation and CSV reading | `pd.read_csv`, `df.groupby`, `df.describe` |
| **Matplotlib / Seaborn** | Data visualization, distributions, correlation matrices | `plt.plot`, `sns.heatmap`, `sns.boxplot` |
| **Scikit-Learn** | ML estimators, preprocessing, validation, metrics | `StandardScaler`, `KNeighborsClassifier`, `SVC`, `KMeans` |
| **TensorFlow / Keras** | Multi-layer Deep Learning architectures | `Sequential`, `Dense`, `Dropout`, `EarlyStopping` |

---

## 11. Quick Revision Formula Sheet

| Metric / Concept | Mathematical Formulation |
| :--- | :--- |
| **Mean** | $\bar{x} = \frac{\sum x_i}{n}$ |
| **Standardization ($Z$-score)** | $z = \frac{x - \mu}{\sigma}$ |
| **Min-Max Normalization** | $x' = \frac{x - x_{\min}}{x_{\max} - x_{\min}}$ |
| **IQR (Interquartile Range)** | $IQR = Q3 - Q1$ |
| **Outlier Thresholds** | $\text{Upper} = Q3 + 1.5(IQR), \quad \text{Lower} = Q1 - 1.5(IQR)$ |
| **Euclidean Distance** | $d = \sqrt{\sum_{i=1}^{n}(x_i - y_i)^2}$ |
| **Linear Regression** | $y = mx + c$ |
| **Sigmoid Function** | $\sigma(z) = \frac{1}{1 + e^{-z}}$ |
| **ReLU Function** | $f(z) = \max(0, z)$ |
| **Gradient Descent Step** | $\theta_{\text{new}} = \theta_{\text{old}} - \alpha \nabla J(\theta)$ |
| **Accuracy** | $\frac{TP + TN}{TP + TN + FP + FN}$ |
| **Error Rate** | $\frac{FP + FN}{TP + TN + FP + FN} = 1 - \text{Accuracy}$ |
| **Precision** | $\frac{TP}{TP + FP}$ |
| **Recall / Sensitivity** | $\frac{TP}{TP + FN}$ |
| **Specificity** | $\frac{TN}{TN + FP}$ |
| **F1-Score** | $2 \times \frac{\text{Precision} \times \text{Recall}}{\text{Precision} + \text{Recall}}$ |
| **MAE** | $\frac{1}{n} \sum \|y_i - \hat{y}_i\|$ |
| **MSE** | $\frac{1}{n} \sum (y_i - \hat{y}_i)^2$ |
| **RMSE** | $\sqrt{\frac{1}{n} \sum (y_i - \hat{y}_i)^2}$ |
| **$R^2$ Score** | $1 - \frac{\sum (y_i - \hat{y}_i)^2}{\sum (y_i - \bar{y})^2}$ |
| **K-Means WCSS** | $\sum_{j=1}^{K} \sum_{x_i \in C_j} \|x_i - \mu_j\|^2$ |
| **Silhouette Score** | $S = \frac{b - a}{\max(a, b)}$ |
