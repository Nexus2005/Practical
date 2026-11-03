pragma solidity ^0.4.19;

contract MyContract {
    address private owner;

    constructor() public {
        owner = msg.sender;
    }

    function getOwner() public view returns (address) {
        return owner;
    }

    function getBalance() public view returns (uint256) {
        return owner.balance;
    }

    function deposit() external payable {
        require(msg.value == 2 ether, "Please send exactly two ethers");
    }

    function withdraw() external {
        require(msg.sender == owner, "Only the owner can withdraw");
        msg.sender.transfer(address(this).balance);
    }
}
