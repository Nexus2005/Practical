# Blockchain Technology – Complete Viva Preparation Notes

> **BE Computer Engineering | SPPU | Units I–V + Comprehensive Blockchain Lab Concepts**

---

## Table of Contents
1. [Unit I – Mathematical Foundation for Blockchain](#unit-i--mathematical-foundation-for-blockchain)
2. [Unit II – Introduction and Fundamentals of Blockchain](#unit-ii--introduction-and-fundamentals-of-blockchain)
3. [Unit III – Blockchain Platforms and Consensus](#unit-iii--blockchain-platforms-and-consensus)
4. [Unit IV – Cryptocurrency, Bitcoin, and Wallets](#unit-iv--cryptocurrency-bitcoin-and-wallets)
5. [Unit V – Ethereum Platform & Smart Contract Development](#unit-v--ethereum-platform--smart-contract-development)
6. [Core Blockchain Lab Concepts (Solidity & Web3)](#core-blockchain-lab-concepts-solidity--web3)
7. [Lab Application Case Studies](#lab-application-case-studies)
8. [Advanced Concepts, Attacks & Network Dynamics](#advanced-concepts-attacks--network-dynamics)
9. [Master Formula Sheet & Technical Values](#master-formula-sheet--technical-values)
10. [Top 40 Viva Questions & Detailed Model Answers](#top-40-viva-questions--detailed-model-answers)

---

## Unit I – Mathematical Foundation for Blockchain

### 1. What is Cryptography?
- **Definition**: The mathematical science of securing data and communications by transforming plaintext into unreadable ciphertext to prevent unauthorized access.
- **Pillars of Security**:
  - **Confidentiality**: Ensuring data is accessible exclusively to intended recipients.
  - **Integrity**: Guaranteeing data is not altered in transit.
  - **Authentication**: Verifying the true identity of interacting parties.
  - **Non-Repudiation**: Preventing signers from falsely denying transaction authorization.

---

### 2. Encryption vs. Decryption
- **Encryption**: Converting intelligible plaintext ($P$) into ciphertext ($C$) via an algorithm and cryptographic key ($K_e$):
  $$C = E(P, K_e)$$
- **Decryption**: Reverting ciphertext ($C$) back into plaintext ($P$) using a decryption key ($K_d$):
  $$P = D(C, K_d)$$

---

### 3. Symmetric vs. Asymmetric Cryptography

```
Symmetric Cryptography:
Plaintext ---> [ Encrypt ] ---> Ciphertext ---> [ Decrypt ] ---> Plaintext
                   ^                                ^
                   +------- Single Secret Key ------+

Asymmetric Cryptography:
Plaintext ---> [ Encrypt ] ---> Ciphertext ---> [ Decrypt ] ---> Plaintext
                   ^                                ^
             Receiver's Public Key            Receiver's Private Key
```

| Dimension | Symmetric Cryptography | Asymmetric Cryptography |
| :--- | :--- | :--- |
| **Keys Used** | Single shared secret key for encryption & decryption | Mathematical key pair: **Public Key** and **Private Key** |
| **Speed & Performance** | Extremely fast; minimal computational overhead | Slower due to modular arithmetic / exponentiation |
| **Key Distribution** | Difficult; sharing secret key across channels risks compromise | Safe; public key shared openly, private key kept offline |
| **Primary Use Cases** | Bulk file and stream data encryption (AES, DES) | Authentication, key exchange, digital signatures (RSA, ECC) |

---

### 4. Elliptic Curve Cryptography (ECC)
- **Concept**: Public-key cryptography based on the algebraic structure of elliptic curves over finite fields:
  $$y^2 = x^3 + ax + b \pmod{p}$$
- **Why Blockchain Uses ECC**:
  - Delivers equivalent cryptographic strength to RSA with significantly **smaller key sizes** (e.g., a 256-bit ECC key equals a 3072-bit RSA key).
  - Low computational overhead and minimal storage/bandwidth consumption.
  - Bitcoin and Ethereum use the **secp256k1** elliptic curve standard.

---

### 5. Cryptographic Hash Functions & SHA-256
A hash function maps an arbitrary-length input string to a fixed-length hexadecimal digest.

#### Five Core Properties of Secure Hashes:
1. **Deterministic**: Identical inputs always produce an identical hash digest.
2. **Fixed Output Length**: Always returns 256 bits (64 hexadecimal characters for SHA-256).
3. **Pre-image Resistance (One-Way)**: Computationally infeasible to reverse $H(x) \to x$.
4. **Second Pre-image Resistance**: Given $x$, infeasible to find $y \neq x$ such that $H(x) = H(y)$.
5. **Collision Resistance**: Infeasible to find any distinct pair $(x_1, x_2)$ where $H(x_1) = H(x_2)$.
6. **Avalanche Effect**: Flipping a single bit in the input radically alters $>50\%$ of output bits.

---

### 6. Digital Signatures & DSA
A digital signature validates transaction integrity, sender authenticity, and non-repudiation.

```
Signing (Sender):
Transaction Data ---> [ Hash ] ---> Digest ---> [ Sign with Private Key ] ---> Digital Signature

Verification (Receiver):
1. Signature + Sender Public Key ---> [ Verify ] ---> Computed Digest
2. Transaction Data              ---> [ Hash ]   ---> Original Digest
3. Computed Digest == Original Digest ? Valid : Invalid
```

- **ECDSA**: The Elliptic Curve Digital Signature Algorithm used by Bitcoin and Ethereum to authorize transactions.

---

### 7. Merkle Tree (Binary Hash Tree)

```
                       Merkle Root (Top Hash)
                             [ H_ABCD ]
                            /          \
                     [ H_AB ]          [ H_CD ]
                     /      \          /      \
                  [ H_A ]  [ H_B ]  [ H_C ]  [ H_D ]
                     |        |        |        |
                   Tx A     Tx B     Tx C     Tx D
```

- **Working**: Leaf nodes represent cryptographic hashes of individual transactions. Parent nodes represent hashes of concatenated children ($H_{AB} = \text{SHA256}(H_A \parallel H_B)$). This continues until a single **Merkle Root** resides in the block header.
- **Advantage**: Allows light clients to verify transaction inclusion using a logarithmic **Merkle Proof** ($\mathcal{O}(\log n)$ hashes) without downloading the entire block.
- **Viva Point**: Altering a single transaction cascades up the tree, invalidating the Merkle Root and signaling tampering instantly.

---

## Unit II – Introduction and Fundamentals of Blockchain

### 1. What is Blockchain?
A decentralized, append-only, distributed digital ledger consisting of cryptographically linked data records called **blocks**. Each block stores a timestamp, transaction payload, current nonce, and the cryptographic hash of the preceding block.

### 2. Centralized vs. Decentralized Architectures

```
   Centralized               Decentralized / Distributed
       (C)                      (N) --- (N)
     /  |  \                    / \     / \
   (U) (U) (U)                (N) - (N) - (N)
Single point of failure     Fault-tolerant mesh network
```

| Feature | Centralized Architecture | Decentralized Blockchain Architecture |
| :--- | :--- | :--- |
| **Control** | Single governing administrator / authority | Distributed across network consensus nodes |
| **Failure Tolerance** | Server outage disrupts entire ecosystem | High fault tolerance; individual node failures have zero impact |
| **Data Immutability** | Database administrator can alter/delete history | Cryptographic linkage makes historical edits tamper-evident |
| **Verification** | Opaque; requires blind institutional trust | Transparent; verifiable by running a full node |

---

### 3. Five Layers of Blockchain Architecture

```
+-------------------------------------------------------+
| 1. Application Layer   (DApps, Wallets, UI, Smart Contracts)
+-------------------------------------------------------+
| 2. Execution Layer     (EVM, Bytecode execution, State transition)
+-------------------------------------------------------+
| 3. Semantic Layer      (Transaction formats, UTXO / Account rules)
+-------------------------------------------------------+
| 4. Propagation Layer   (P2P network discovery, Gossip protocols)
+-------------------------------------------------------+
| 5. Consensus Layer     (PoW, PoS, PBFT, block finality rules)
+-------------------------------------------------------+
```

---

### 4. Node Classifications
- **Full Node**: Downloads and independently validates every block and transaction against protocol rules.
- **Light Node (SPV)**: Stores only block headers; verifies inclusion via Merkle proofs.
- **Mining / Validator Node**: Assembles candidate blocks and solves PoW puzzles or proposes blocks via PoS stake.

---

## Unit III – Blockchain Platforms and Consensus

### 1. Platform Taxonomy

| Platform Category | Network Accessibility | Governance Model | Representative Platforms |
| :--- | :--- | :--- | :--- |
| **Public (Permissionless)** | Completely open to any node without credentials | Fully decentralized | Bitcoin, Ethereum |
| **Private (Permissioned)** | Strictly restricted to authenticated participants | Single enterprise | Hyperledger Fabric |
| **Consortium** | Pre-selected federation of organizations | Shared multi-party governance | R3 Corda, B2B Banking networks |
| **Hybrid** | Public state verification with private data execution | Mixed | Government registries, Healthcare |

---

### 2. Major Enterprise Platforms
- **Bitcoin**: First peer-to-peer electronic cash network based on PoW and UTXO model.
- **Ethereum**: Turing-complete programmable blockchain with EVM for smart contract execution.
- **Hyperledger Fabric**: Linux Foundation's modular permissioned enterprise framework with private channels and pluggable consensus (no native cryptocurrency).
- **R3 Corda**: Financial services DLT recording legal agreements directly between trading counterparties without a global broadcast ledger.
- **IOTA**: Distributed ledger engineered for IoT utilizing a **DAG** (Directed Acyclic Graph) architecture called the **Tangle**.

---

### 3. Consensus Mechanisms

#### A. Proof of Work (PoW)
- Miners race to compute a block header hash smaller than a target difficulty:
  $$\text{SHA256}(\text{SHA256}(\text{BlockHeader} \parallel \text{Nonce})) < \text{Target}$$
- **Drawback**: High energy consumption and hardware centralization.

#### B. Proof of Stake (PoS)
- Pseudo-randomly selects block validators weighted by economic collateral (**stake**).
- Malicious behavior (e.g., double signing) triggers capital forfeiture (**slashing**).

#### C. Other Consensus Models:
- **Proof of Elapsed Time (PoET)**: Enforces random wait times inside hardware-enforced Trusted Execution Environments (Intel SGX). Used in Hyperledger Sawtooth.
- **Proof of Burn (PoB)**: Miners burn coins to unspendable addresses to earn lottery tickets for block production.
- **Proof of Activity (PoA)**: Hybrid where miners mine empty headers (PoW) and stakeholders sign off (PoS).

---

### 4. Byzantine Fault Tolerance (BFT)
Originates from the **Byzantine Generals Problem** (coordinating action over unreliable channels with traitorous actors). A system is Byzantine Fault Tolerant if it functions reliably despite up to $f$ arbitrary or malicious failures:
$$N \geq 3f + 1$$

---

## Unit IV – Cryptocurrency, Bitcoin, and Wallets

### 1. Coin vs. Token
- **Coin**: Native foundational asset of an independent Layer-1 blockchain (e.g., BTC on Bitcoin, ETH on Ethereum).
- **Token**: Smart contract-issued digital asset existing on an existing host blockchain (e.g., ERC-20, ERC-721 on Ethereum).

### 2. Cryptocurrency Wallets
A cryptocurrency wallet stores **private keys**, not coins. Coins reside permanently on the distributed ledger.

| Wallet Type | Description | Security / Convenience Trade-off | Examples |
| :--- | :--- | :--- | :--- |
| **Hot Wallet** | Connected to the internet | High convenience; vulnerable to online exploits | MetaMask, Coinbase App |
| **Cold Wallet** | Private keys isolated offline | Maximum security; ideal for long-term storage | Ledger, Trezor, Paper Wallets |
| **Custodial** | Third party holds private keys | Convenient recovery; counterparty insolvency risk | Binance, Exchange accounts |
| **Non-Custodial** | User has sole custody of seed phrase | Total autonomy; zero recovery if keys are lost | MetaMask, Trust Wallet |

- **BIP-39 Mnemonic Seed Phrase**: A 12- or 24-word string derived from cryptographic entropy used to deterministically generate all master private and public keys.

---

### 3. Ethereum Gas Mechanics
- **Gas**: Abstract unit measuring computational resources required by an EVM transaction.
- **Gas Limit**: Maximum gas units the sender authorizes for transaction execution (standard ETH transfer = 21,000 gas).
- **Gas Price**: Price per gas unit offered by the sender, denominated in **Gwei**:
  $$1 \text{ ETH} = 10^9 \text{ Gwei} = 10^{18} \text{ Wei}$$
- **Total Transaction Fee Equation**:
  $$\text{Fee (ETH)} = \text{Gas Consumed} \times \text{Effective Gas Price}$$

---

## Unit V – Ethereum Platform & Smart Contract Development

### 1. Ethereum Network Types
- **Mainnet**: Production public ledger where operations use real ETH.
- **Public Testnets (Sepolia, Holesky)**: Public simulation networks using valueless faucet ETH for developer testing.
- **Local Private Blockchains**: Fast isolated sandbox chains running locally (Hardhat, Ganache).

### 2. EVM, Bytecode, and ABI

```
Solidity Source (.sol) ---> [ solc Compiler ] ---> Bytecode (0x608060...)  ---> Executed by EVM
                                             ---> ABI (.json)           ---> Web App / DApp UI
```

- **Bytecode**: Hexadecimal EVM opcode instructions stored permanently in contract storage on-chain.
- **ABI (Application Binary Interface)**: JSON schema documenting callable function signatures, parameter types, and return values, enabling front-ends (via Web3.js / Ethers.js) to encode function calls.

---

## Core Blockchain Lab Concepts (Solidity & Web3)

### 1. Global Transaction Context Variables
- `msg.sender` (`address`): Account or contract address that directly invoked the currently executing function.
- `msg.value` (`uint256`): Volume of native Ether transferred with the call, expressed in **Wei**.
- `address(this).balance` (`uint256`): Total Ether balance currently held by the smart contract.

---

### 2. Function State Mutability & Visibility

#### Mutability Modifiers:
- `view`: Reads contract storage but modifies no state variables. Consumes **0 gas** when called off-chain via `eth_call`.
- `pure`: Neither reads nor alters blockchain storage (e.g., mathematical formulas).
- `payable`: Explicitly authorizes the function to receive native Ether.

#### Visibility Specifiers:

| Visibility | Internal Contract Call | Derived (Child) Contracts | External Transaction Calls |
| :--- | :---: | :---: | :---: |
| `public` | Yes | Yes | Yes |
| `private` | Yes | No | No |
| `internal` | Yes | Yes | No |
| `external` | Only via `this.f()` | Only via `this.f()` | Yes (Gas optimized for large calldata) |

---

### 3. Reentrancy & Condition Checking: `require()`
- Evaluates boolean conditions. If evaluated to `false`, execution terminates, remaining gas is refunded, and state modifications revert:
  ```solidity
  require(msg.sender == owner, "Unauthorized caller");
  ```

---

### 4. Custom Function Modifiers
Reusable preconditions wrapped around function bodies via the merge placeholder `_;`:
```solidity
modifier onlyOwner() {
    require(msg.sender == owner, "Only owner can call");
    _; // Function execution resumes here
}
```

---

### 5. Fallback vs. Receive Functions

| Feature | `receive() external payable` | `fallback() external [payable]` |
| :--- | :--- | :--- |
| **Trigger Condition** | Plain Ether transfers with completely empty calldata | Unrecognized function calls OR Ether transfers with calldata |
| **Parameters / Return** | None allowed | Accepts calldata bytes and returns bytes |
| **Payable Required?** | Must always be declared `payable` | Optional; required only if accepting ETH |

---

## Lab Application Case Studies

### 1. Bank Account Smart Contract (`BankContract.sol`)
Demonstrates secure deposit, withdrawal, and balance queries:
```solidity
// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankContract {
    address public owner;
    mapping(address => uint256) private balances;

    constructor() {
        owner = msg.sender;
    }

    function deposit() public payable {
        require(msg.value > 0, "Deposit must be > 0");
        balances[msg.sender] += msg.value;
    }

    function withdraw(uint256 _amount) public {
        require(balances[msg.sender] >= _amount, "Insufficient funds");
        balances[msg.sender] -= _amount;
        payable(msg.sender).transfer(_amount);
    }

    function getContractBalance() public view returns (uint256) {
        return address(this).balance;
    }
}
```

---

### 2. Decentralized Ballot Contract (`Ballot.sol`)
Implements tamper-evident voting with duplicate-vote prevention:
- **Election State Machine**: Enforced via Solidity `enum State { Created, Voting, Ended }`.
- **Double-Voting Prevention**: Evaluates a boolean flag stored in a voter registry mapping:
  ```solidity
  struct Voter {
      string voterName;
      bool voted;
      uint256 voteChoice;
  }
  mapping(address => Voter) public voterRegister;
  ```

---

## Advanced Concepts, Attacks & Network Dynamics

### 1. 51% Attack (Majority Attack)
If an entity controls $>50\%$ of hashing power in PoW (or total stake in PoS), they can:
- Reorganize blocks and execute **double-spending**.
- Censor transactions and block valid confirmation.
- *They cannot*: Forge signatures, steal private keys, or modify historical transactions before their reorganization depth.

### 2. Forks: Soft vs. Hard
- **Soft Fork**: Backward-compatible protocol upgrade. Un-upgraded nodes still recognize new blocks as valid.
- **Hard Fork**: Non-backward-compatible rules change splitting the network into two distinct branches unless 100% of nodes upgrade (e.g., ETH / ETC split).

---

## Master Formula Sheet & Technical Values

| Property / Concept | Technical Value / Formulation |
| :--- | :--- |
| **SHA-256 Digest Output** | $256 \text{ bits} = 32 \text{ bytes} = 64 \text{ hexadecimal characters}$ |
| **Bitcoin Hard Supply Cap** | $21,000,000 \text{ BTC}$ |
| **Ether to Wei Conversion** | $1 \text{ ETH} = 10^{18} \text{ Wei}$ |
| **Ether to Gwei Conversion**| $1 \text{ ETH} = 10^9 \text{ Gwei}$ |
| **Gwei to Wei Conversion** | $1 \text{ Gwei} = 10^9 \text{ Wei}$ |
| **Standard ETH Transfer Gas** | $21,000 \text{ Gas Units}$ |
| **Transaction Fee Formula** | $\text{Fee} = \text{Gas Consumed} \times \text{Effective Gas Price}$ |
| **Byzantine Fault Bound** | $N \geq 3f + 1$ |
| **Merkle Tree Proof Depth** | $\mathcal{O}(\log_2 n)$ |

---

## Top 40 Viva Questions & Detailed Model Answers

#### Q1: What is blockchain in one sentence?
**Answer**: Blockchain is a distributed, cryptographically linked append-only ledger that allows mutually untrusted participants to maintain consensus on a shared state without a central authority.

#### Q2: What is the purpose of SHA-256 in Bitcoin?
**Answer**: SHA-256 secures block linking (each block references the prior block's hash), creates transaction identifiers (TxID), powers Merkle Trees, and defines the mining challenge in Proof of Work.

#### Q3: Why is ECC preferred over RSA in blockchain?
**Answer**: ECC provides equivalent cryptographic security with much smaller key lengths (256-bit ECC $\approx$ 3072-bit RSA), saving bandwidth, storage, and computation across distributed nodes.

#### Q4: What is a Merkle Root and why is it crucial?
**Answer**: A Merkle Root is the single cryptographic root digest of all transactions in a block. It enables lightweight nodes to verify transactions using logarithmic Merkle proofs without downloading the entire blockchain.

#### Q5: What is the difference between a coin and a token?
**Answer**: A coin is the native currency of an independent Layer-1 blockchain (e.g., BTC, ETH). A token is a digital asset issued through smart contracts on an existing blockchain (e.g., ERC-20).

#### Q6: What is the difference between Public and Private Blockchains?
**Answer**: Public blockchains (Bitcoin) are permissionless, fully decentralized, and open to anyone. Private blockchains (Hyperledger Fabric) are permissioned and governed by a single organization with restricted access.

#### Q7: What is Proof of Work (PoW)?
**Answer**: PoW is a consensus mechanism where miners expend computational power finding a nonce that yields a block header hash below the network's difficulty target.

#### Q8: What is Proof of Stake (PoS) and how does it prevent malicious actions?
**Answer**: PoS selects block validators proportional to their staked cryptocurrency. Dishonest actions trigger automatic slashing, burning the validator's economic collateral.

#### Q9: What is Gas in Ethereum?
**Answer**: Gas is an internal pricing metric that measures the computational effort required to execute instructions and smart contracts on the EVM, preventing infinite loops and spam.

#### Q10: What is the difference between `view` and `pure` functions in Solidity?
**Answer**: `view` can read state variables from storage but cannot modify them; `pure` can neither read nor modify storage variables (it only operates on parameters and local variables).

#### Q11: What is `msg.sender` in Solidity?
**Answer**: `msg.sender` is a global variable representing the immediate address that invoked the currently executing smart contract function.

#### Q12: Why is the `payable` keyword mandatory to receive Ether?
**Answer**: In Solidity, functions reject incoming Ether transfers by default. Declaring `payable` instructs the compiler to accept and credit native ETH to the contract balance.

#### Q13: What happens when a `require()` statement fails?
**Answer**: The transaction reverts, all state modifications made during execution are rolled back to their prior values, and unconsumed gas is refunded to the sender.

#### Q14: What is the difference between `receive()` and `fallback()` functions?
**Answer**: `receive()` is executed on plain ETH transfers with empty calldata. `fallback()` is triggered when function selectors do not match or when arbitrary calldata is passed.

#### Q15: How does a smart contract prevent double voting in an e-voting DApp?
**Answer**: It maintains a boolean flag `voted` mapped to each voter's wallet address (`voterRegister[msg.sender].voted`). When a vote is cast, `require(!voterRegister[msg.sender].voted)` ensures only uncast ballots are accepted.

#### Q16: What is the Byzantine Generals Problem?
**Answer**: A fundamental computer science problem modeling how distributed nodes can agree on a unified strategy over an unreliable network when some nodes are faulty or malicious.

#### Q17: What is a 51% attack?
**Answer**: When an attacker controls more than half of the network's hash rate or staked assets, allowing them to reorganize recent blocks, double-spend their own coins, and censor transactions.

#### Q18: What is a Seed Phrase?
**Answer**: A human-readable sequence of 12 or 24 words that deterministically derives all private and public keys for a cryptocurrency wallet under BIP-39.

#### Q19: What is MetaMask?
**Answer**: A non-custodial browser extension and mobile wallet that manages Ethereum private keys, signs transactions, and bridges Web browsers to the EVM via JSON-RPC providers.

#### Q20: What is the Application Binary Interface (ABI)?
**Answer**: A standard JSON specification detailing a smart contract's functions, parameter types, and events, allowing external applications (DApps) to encode calls and decode responses.
