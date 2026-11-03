# Experiment: MetaMask Installation and Ether Spent per Transaction

## Aim

To install MetaMask and study the amount of Ether spent on an Ethereum transaction.

## Theory

MetaMask is a cryptocurrency wallet that allows users to manage Ethereum accounts
and interact with blockchain applications. It is available as a browser extension
and as a mobile application.

MetaMask can be used to:

- Create or import an Ethereum account.
- Store and manage account keys.
- View account balances and transaction history.
- Send and receive Ether and supported tokens.
- Connect to decentralised applications (DApps).
- Approve account signatures and blockchain transactions.

When a user performs an operation that changes blockchain data, MetaMask displays
a transaction confirmation window. The transaction normally requires:

- **Value:** Ether sent to the recipient, if any.
- **Gas limit:** Maximum gas units that the transaction may consume.
- **Gas price:** Amount paid for each unit of gas.
- **Network fee:** The amount paid to the network for processing the transaction.

The basic transaction fee can be calculated as:

```text
Transaction fee = Gas used x Gas price
```

In Ethereum's EIP-1559 fee model, the total fee is generally based on the gas used,
the base fee, and the optional priority fee (tip). MetaMask displays the estimated
network fee before the user confirms the transaction.

The total Ether deducted from the sender can be represented as:

```text
Total Ether deducted = Ether sent + Transaction fee
```

If a transaction fails after consuming gas, the gas fee may still be charged. The
Ether value sent by the transaction is normally returned when the transaction
execution fails, but the consumed gas is not returned.

## Requirements

- Google Chrome, Mozilla Firefox, Microsoft Edge, or another supported browser.
- An internet connection.
- The official MetaMask browser extension.
- A test network or local blockchain for practice.
- Never use a real wallet or real Ether for a classroom demonstration unless
  explicitly authorised.

## Installation Process

### Step 1: Open the official MetaMask website

Open the official website:

<https://metamask.io/>

Use the official website to reach the browser-extension download page. Avoid
installing extensions from unknown links or advertisements.

### Step 2: Select the browser

Choose the browser being used, such as Chrome, Firefox, or Edge.

### Step 3: Verify the extension

Before installing, verify:

- The publisher is MetaMask or Consensys.
- The extension is downloaded from the official browser store or the official
  MetaMask website.
- The extension permissions and reviews appear reasonable.

Never install a similarly named or unofficial wallet extension.

### Step 4: Add the extension

Click **Add to Chrome**, **Add to Firefox**, or the equivalent button. Review the
requested permissions and confirm the installation.

### Step 5: Open MetaMask

After installation, select the MetaMask icon from the browser toolbar. Click
**Get started**.

### Step 6: Create or import a wallet

Choose one of the following options:

- **Create a new wallet** to create a new account.
- **Import an existing wallet** only if the recovery phrase is available.

Never share the recovery phrase with anyone, including support staff. MetaMask
support will not ask for it.

### Step 7: Choose privacy settings

Review the privacy and usage settings. Select **I Agree** or **No Thanks** as
appropriate. The wallet can be created with either choice.

### Step 8: Create a password

Create a strong local MetaMask password and accept the terms of use. This password
protects the wallet on the current browser profile. It is not a replacement for
the secret recovery phrase.

### Step 9: Secure the recovery phrase

MetaMask displays a secret recovery phrase. Write it down offline and store it in
a secure location. Do not:

- Take a screenshot of the phrase.
- Store it in email, chat, cloud storage, or a code repository.
- Share it with another person.
- Enter it into an unknown website.

Confirm the phrase when MetaMask asks for verification.

### Step 10: Finish setup

Complete the wallet setup. The account address and balance are then visible in
MetaMask.

For practice, switch to a test network or connect MetaMask to a local blockchain.
Do not use real Ether for testing.

## Studying Ether Spent per Transaction

1. Open MetaMask and select the account.
2. Select the required network.
3. Use a test account or test Ether for the experiment.
4. Perform a transaction, such as sending a small amount of test Ether.
5. Review the confirmation screen before approving it.
6. Record the displayed gas limit, gas price, estimated fee, and Ether value.
7. Confirm the transaction.
8. Open the transaction details after it is submitted.
9. Record the final gas used, effective gas price, and actual network fee.
10. Compare the estimated fee shown by MetaMask with the final fee shown in the
    transaction details or block explorer.

### Observation table

| Parameter | Observation |
|---|---:|
| Network | ______________________________ |
| Sender account | ______________________________ |
| Recipient account | ______________________________ |
| Ether value sent | __________________ ETH |
| Gas limit | __________________ |
| Gas used | __________________ |
| Gas price / effective gas price | __________________ Gwei |
| Estimated network fee | __________________ ETH |
| Actual network fee | __________________ ETH |
| Total Ether deducted | __________________ ETH |
| Transaction status | Successful / Failed |
| Transaction hash | ______________________________ |

### Calculation

```text
Network fee in ETH = Gas used x Effective gas price in Gwei / 1,000,000,000

Total Ether deducted = Ether value sent + Network fee
```

For example, if a transaction uses 21,000 gas at 20 Gwei:

```text
Network fee = 21,000 x 20 / 1,000,000,000
            = 0.00042 ETH
```

If the transaction sends `0.001 ETH`, then:

```text
Total Ether deducted = 0.001 + 0.00042
                     = 0.00142 ETH
```

This is an example only. The actual fee depends on the network and transaction.

## Result

MetaMask was installed successfully. A test transaction was performed and the
Ether spent was studied by comparing the Ether value sent with the actual network
fee.

## Precautions

- Install MetaMask only from the official source.
- Verify the network and recipient address before confirming a transaction.
- Keep the secret recovery phrase offline and private.
- Use a test network or local blockchain for demonstrations.
- Never approve an unfamiliar transaction or signature request.
- Check the final transaction details using a trusted block explorer.
- Remember that blockchain transactions are generally irreversible.

## Installation Snapshots

Add your own screenshots below. Do not include your secret recovery phrase,
private key, password, or personal account details in any screenshot.

### Snapshot 1: Official MetaMask download page

`[Insert screenshot here]`

### Snapshot 2: Browser extension installation page

`[Insert screenshot here]`

### Snapshot 3: MetaMask welcome page

`[Insert screenshot here]`

### Snapshot 4: Create or import wallet page

`[Insert screenshot here]`

### Snapshot 5: MetaMask account dashboard

`[Insert screenshot here]`

### Snapshot 6: Transaction confirmation showing gas fee

`[Insert screenshot here]`

### Snapshot 7: Completed transaction details

`[Insert screenshot here]`

