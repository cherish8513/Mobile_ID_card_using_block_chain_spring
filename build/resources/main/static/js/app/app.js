const express = require('express');
const infuraKey = '1e58d926f44f429fbc6ffaba4fd30f7b';
const url = 'https://kovan.infura.io/v3/1e58d926f44f429fbc6ffaba4fd30f7b';
const app = express();
var Web3 = require("web3");
web3 = new Web3(new Web3.providers.HttpProvider(url));
const server = require("http").createServer(app);
const bodyParser = require('body-parser');

server.listen(8080, () => {
    console.log("server is running on port 8080");
});

var Tx = require('ethereumjs-tx').Transaction;
const rootAccount = '0xB373858022e4Bd1De253418612a147482C189E2E';
const privateKey = new Buffer.from('ECA6D1CAEB8EC41359B8C5A224E955A32135432E36FE998862FE8B75F0D7A83D', 'hex');

var newUserAccountAdress = web3.eth.account.create(); 
/*
app.use(express.static("public"));
app.get("/", function (req, res) {
    res.sendFile(__dirname + "/public/html/index.html");
})*/

var objectAbi = [
    {
        "inputs": [],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "constructor"
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
                "name": "_fingerPrintPrivatekey",
                "type": "string"
            },
            {
                "name": "_facePhotoPrivatekey",
                "type": "string"
            },
            {
                "name": "_name",
                "type": "string"
            },
            {
                "name": "_addressInfo",
                "type": "string"
            },
            {
                "name": "_residentNumber",
                "type": "string"
            },
            {
                "name": "_publicationDate",
                "type": "string"
            },
            {
                "name": "_publisher",
                "type": "string"
            }
        ],
        "name": "setPersonDetail",
        "outputs": [],
        "payable": false,
        "stateMutability": "nonpayable",
        "type": "function"
    },
    {
        "constant": true,
        "inputs": [
            {
                "name": "_person",
                "type": "address"
            }
        ],
        "name": "getBlockInfo",
        "outputs": [
            {
                "name": "_approveBlockNO",
                "type": "uint256"
            },
            {
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
                "name": "_person",
                "type": "address"
            }
        ],
        "name": "getData",
        "outputs": [
            {
                "name": "_fingerPrintPrivatekey",
                "type": "string"
            },
            {
                "name": "_facePhotoPrivatekey",
                "type": "string"
            },
            {
                "name": "_name",
                "type": "string"
            },
            {
                "name": "_addressInfo",
                "type": "string"
            },
            {
                "name": "_residentNumber",
                "type": "string"
            },
            {
                "name": "_publisher",
                "type": "string"
            }
        ],
        "payable": false,
        "stateMutability": "view",
        "type": "function"
    }
];
var proofContract = new web3.eth.Contract(objectAbi, "0x5010Af5b0b8D1E33f7E3e7e17378609cd8273A4D");

function setPersonDetailToContract(_fingerPrintPrivatekey, _facePhotoPrivatekey,
_name, _addressInfo, _residentNumber, _publicationDate, _publisher) {

    web3.eth.getTransactionCount(newUserAccountAdress, (err, txCount) => {

        const txObject = {
            nonce: web3.utils.toHex(txCount),
            gasLimit: web3.utils.toHex(800000),
            gasPrice: web3.utils.toHex(web3.utils.toWei('10', 'gwei')),
            to: "0x5010Af5b0b8D1E33f7E3e7e17378609cd8273A4D",
            data: proofContract.methods.setPersonDetail(_fingerPrintPrivatekey, _facePhotoPrivatekey, _name, _addressInfo, _residentNumber
                , _publicationDate, _publisher).encodeABI()
        }

        const tx = new Tx(txObject, { chain: 'kovan', hardfork: 'petersburg' });
        tx.sign(privateKey);

        const serializedTx = tx.serialize();
        const raw = '0x' + serializedTx.toString('hex');

        web3.eth.sendSignedTransaction(raw, (err, txHash) => {
            console.log('err:', err, 'txHash: ', txHash);
        });

    });

    proofContract.methods.setPersonDetail(_fingerPrintPrivatekey, _facePhotoPrivatekey, _name, _addressInfo
        , _residentNumber, _publicationDate, _publisher).send({ from: newUserAccountAdress })
        .on("receipt", function (receipt) {
            console.log(receipt);

        })
        .on("error", function (err) {
            console.log(err);
        });
}

var fingerPrintPrivateKey;
var facePhotoPrivateKey;
var name;
var addressInfo;
var residentNumber;
var publicationDate;
var publisher;

proofContract.methods.getData(newUserAccountAdress).call(function(err, res) {

    if(!err) {

        fingerPrintPrivateKey = res[0];
        facePhotoPrivateKey = res[1];
        name = res[2];
        addressInfo = res[3];
        residentNumber = res[4];
        publicationDate = res[5];
        publisher = res[6];

    } else {
        console.log(err);
    }
});
