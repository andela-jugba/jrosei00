/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vendingmachine.service;

import vendingmachine.ui.VendingMachineIO;

/**
 *
 * @author apprentice
 */
public class VendingMachineServiceLayerImpl implements VendingMachineServiceLayer {

    int Payment;
    int Cost;
    public VendingMachineIO io;

    public VendingMachineServiceLayerImpl(VendingMachineIO io) {

        this.io = io;
    }

    //Assuring there is enough $$
    public void sufficientFunds() {
        if (Payment < Cost) {
        }
        throw new InsufficientFundsException("Nope. Need more money!");
       
        }

    }

    public void Change() {
        int Change = math.BigDecimal.subtract(Payment, Cost);
    }

    public void changeToCoins() {

        int Change;
        int numQuarters;
        int Dimes;
        int Nickels;
        int Pennies;

        if (Change % 25 != 0) {
            {
                else (Change % 10 != 0);
                {
                    else (Change % 5 != 0);
                }
                else if (Change % 1);
            }
        }

    }

}

/*
1. Insert payment
2. Select item
3. if insertedamount < cost--> print insufficient funds
4. insertedamount > cost--> inventory -- 
5. Change()=sub(payment, cost)
6. shit ton of modulos Change%25 != 0, then
 */
