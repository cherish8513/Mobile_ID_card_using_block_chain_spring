const abi =[
           	{
           		"inputs": [],
           		"payable": false,
           		"stateMutability": "nonpayable",
           		"type": "constructor"
           	},
           	{
           		"constant": true,
           		"inputs": [
           			{
           				"internalType": "address",
           				"name": "_person",
           				"type": "address"
           			}
           		],
           		"name": "getBlockInfo",
           		"outputs": [
           			{
           				"internalType": "uint256",
           				"name": "_approveBlockNO",
           				"type": "uint256"
           			},
           			{
           				"internalType": "uint256",
           				"name": "_refLimitBlockNo",
           				"type": "uint256"
           			}
           		],
           		"payable": false,
           		"stateMutability": "view",
           		"type": "function"
           	},
           	{
           		"constant": true,
           		"inputs": [
           			{
           				"internalType": "address",
           				"name": "_person",
           				"type": "address"
           			}
           		],
           		"name": "getData",
           		"outputs": [
           			{
           				"internalType": "string",
           				"name": "_fingerPrintPrivatekey",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_facePhotoPrivatekey",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_name",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_addressInfo",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_residentNumber",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_publicationDate",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_publisher",
           				"type": "string"
           			}
           		],
           		"payable": false,
           		"stateMutability": "view",
           		"type": "function"
           	},
           	{
           		"constant": false,
           		"inputs": [],
           		"name": "setAllow",
           		"outputs": [],
           		"payable": false,
           		"stateMutability": "nonpayable",
           		"type": "function"
           	},
           	{
           		"constant": false,
           		"inputs": [
           			{
           				"internalType": "string",
           				"name": "_fingerPrintPrivatekey",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_facePhotoPrivatekey",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_name",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_addressInfo",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_residentNumber",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_publicationDate",
           				"type": "string"
           			},
           			{
           				"internalType": "string",
           				"name": "_publisher",
           				"type": "string"
           			}
           		],
           		"name": "setPersonDetail",
           		"outputs": [],
           		"payable": false,
           		"stateMutability": "nonpayable",
           		"type": "function"
           	}
           ];
const contract_address
var Web3 = require('web3');
var web3 = new Web3();
web3.setProvider(new Web3.providers.HttpProvider('http://localhost:8545'));
//차재언이 진행중