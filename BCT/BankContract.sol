// SPDX-License-Identifier: MIT
pragma solidity ^0.8.0;

contract BankContract {
    struct ClientAccount {
        uint256 clientId;
        address clientAddress;
        uint256 clientBalance;
    }

    ClientAccount[] public clients;
    mapping(address => uint256) private clientIndexPlusOne;
    mapping(address => uint256) public interestDate;

    uint256 public clientCounter;
    address payable public manager;

    modifier onlyManager() {
        require(msg.sender == manager, "Only manager can call this");
        _;
    }

    modifier onlyClient() {
        require(
            clientIndexPlusOne[msg.sender] > 0,
            "Only clients can call this"
        );
        _;
    }

    constructor() {
        manager = payable(msg.sender);
    }

    receive() external payable {}

    function setManager(address managerAddress)
        external
        onlyManager
        returns (string memory)
    {
        require(managerAddress != address(0), "Invalid manager address");
        manager = payable(managerAddress);
        return "Manager updated successfully";
    }

    function joinAsClient() external payable returns (string memory) {
        require(
            clientIndexPlusOne[msg.sender] == 0,
            "Already a client"
        );
        require(msg.value > 0, "Initial deposit must be greater than 0");

        interestDate[msg.sender] = block.timestamp;
        clients.push(
            ClientAccount({
                clientId: clientCounter,
                clientAddress: msg.sender,
                clientBalance: msg.value
            })
        );

        clientCounter++;
        clientIndexPlusOne[msg.sender] = clients.length;
        return "Joined successfully";
    }

    function deposit() external payable onlyClient {
        require(msg.value > 0, "Deposit must be greater than 0");

        uint256 index = clientIndexPlusOne[msg.sender] - 1;
        clients[index].clientBalance += msg.value;
    }

    function withdraw(uint256 amountInEther) external onlyClient {
        require(amountInEther > 0, "Amount must be greater than 0");

        uint256 amountInWei = amountInEther * 1 ether;
        uint256 index = clientIndexPlusOne[msg.sender] - 1;

        require(
            clients[index].clientBalance >= amountInWei,
            "Insufficient client balance"
        );
        require(
            address(this).balance >= amountInWei,
            "Insufficient contract funds"
        );

        clients[index].clientBalance -= amountInWei;
        payable(msg.sender).transfer(amountInWei);
    }

    function sendInterest() external payable onlyManager {
        uint256 interestAmount = clients.length * 1 ether;
        require(
            address(this).balance >= interestAmount,
            "Insufficient contract funds for interest"
        );

        for (uint256 i = 0; i < clients.length; i++) {
            address payable clientAddress = payable(clients[i].clientAddress);
            require(
                block.timestamp >= interestDate[clientAddress] + 10 seconds,
                "Interest is available after 10 seconds"
            );

            clientAddress.transfer(1 ether);
            interestDate[clientAddress] = block.timestamp;
        }
    }

    function getContractBalance() external view returns (uint256) {
        return address(this).balance;
    }
}
