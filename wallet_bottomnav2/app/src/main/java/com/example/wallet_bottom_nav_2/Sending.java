package com.example.wallet_bottom_nav_2;

import androidx.appcompat.app.AppCompatActivity;

import org.web3j.crypto.Credentials;
import org.web3j.protocol.Web3j;
import org.web3j.protocol.http.HttpService;
import org.web3j.tx.gas.ContractGasProvider;
import org.web3j.tx.gas.DefaultGasProvider;

public class Sending extends AppCompatActivity {

    // Contact address been taken from deployed contract
//    private static final String CONTRACT_ADDRESS_1 = "0x1c3757e6b7d806e57d0cd101f9321b2ca64df33b";
    // contract deploy (1) - receive https://ropsten.etherscan.io/tx/0x55c8bf353538810d3a8fa278dc62f76270e22edbb61fc4d931138f7fadfafef0
//    private static final String CONTRACT_ADDRESS_2 = "0xaa2f5e124e02d3754cae6da58849b8e831731689";
    // contract deploy (2) - send https://ropsten.etherscan.io/tx/0x66656006037c93aedda93594dea43b36c7ec9bb2aa6fa6eed6fc760751a0a5e3
    private static final String ADMIN_PRIVATE_KEY = "0x7ac230ac21701c6f96d0a59d5eaca738e30753e9e928542b990518daffd0dc48";

    public static void main(String[] args) throws Exception {
        Web3j web3 = Web3j.build(new HttpService());
        ContractGasProvider gasProvider;
        gasProvider = new DefaultGasProvider();
        Credentials credentials = Credentials.create(ADMIN_PRIVATE_KEY);
//        Sending sending = Sending.load(CONTRACT_ADDRESS_1, web3, credentials, gasProvider);
//        Sending sending = Sending.load(CONTRACT_ADDRESS_2, web3, credentials, gasProvider);
    }
}
