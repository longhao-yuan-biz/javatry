/*
 * Copyright 2019-2019 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND,
 * either express or implied. See the License for the specific language
 * governing permissions and limitations under the License.
 */
package org.docksidestage.bizfw.basic.buyticket;

/**
 * @author jflute
 */
public class TicketBooth {

    // ===================================================================================
    //                                                                          Definition
    //                                                                          ==========
    private static final int MAX_QUANTITY = 10;
    private static final int ONE_DAY_PRICE = 7400; // when 2019/06/15
    private static final int TWO_DAY_PRICE = 13200; // when 2020/04/23
    private static final int FOUR_DAY_PRICE = 22400; // when 2020/04/23

    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private int quantity = MAX_QUANTITY;
    private Integer salesProceeds;
    private Integer price;
    private boolean isAlreadyIn = false;
    private Integer change;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBooth() {
    }

    // ===================================================================================
    //                                                                          Buy Ticket
    //                                                                          ==========
    public void buyOneDayPassport(int handedMoney) {
        if (quantity <= 0) {
            throw new TicketSoldOutException("Sold out");
        }
        if (handedMoney < ONE_DAY_PRICE) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + ONE_DAY_PRICE;
            --quantity;
        } else {
            salesProceeds = ONE_DAY_PRICE;
            --quantity;
        }
    }

    public int buyTwoDayPassport(int handedMoney) {
        if (quantity <= 1) {
            throw new TicketSoldOutException("Sold out");
        }

        if (handedMoney < TWO_DAY_PRICE) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + handedMoney;
            quantity -=2;
        } else {
            salesProceeds = TWO_DAY_PRICE;
            quantity -=2;
        }
        int change = handedMoney - TWO_DAY_PRICE;
        return change;
    }

    public void buyPassport(int handedMoney, int DAY) {
        if (quantity <=  0 && DAY ==1) {
            throw new TicketSoldOutException("Sold out");
        }
        if (quantity <=  1 && DAY ==2) {
            throw new TicketSoldOutException("Sold out");
        }
        if (quantity <=  3 && DAY ==4) {
            throw new TicketSoldOutException("Sold out");
        }

        if (handedMoney < ONE_DAY_PRICE && DAY ==1) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        if (handedMoney < TWO_DAY_PRICE && DAY ==2) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        if (handedMoney < FOUR_DAY_PRICE && DAY ==4) {
            throw new TicketShortMoneyException("Short money: " + handedMoney);
        }
        if (salesProceeds != null) {
            salesProceeds = salesProceeds + handedMoney;

        } else if(DAY == 1){
            salesProceeds = ONE_DAY_PRICE;
            price = ONE_DAY_PRICE;
            --quantity;
            change = handedMoney - price;
        }else if(DAY == 2){
            salesProceeds = TWO_DAY_PRICE;
            price = TWO_DAY_PRICE;
            quantity -=2;
            change = handedMoney - price;
        }else{
            salesProceeds = FOUR_DAY_PRICE;
            price = FOUR_DAY_PRICE;
            quantity -=4;
            change = handedMoney - price;
        }
        }

    public void doInPark(){
        isAlreadyIn = true;
    }

    public static class TicketSoldOutException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketSoldOutException(String msg) {
            super(msg);
        }
    }

    public static class TicketShortMoneyException extends RuntimeException {

        private static final long serialVersionUID = 1L;

        public TicketShortMoneyException(String msg) {
            super(msg);
        }
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public int getQuantity() {
        return quantity;
    }

    public Integer getSalesProceeds() {
        return salesProceeds;
    }
    public Integer getDisplayPrice() {
        return price;
    }
    public Integer getChange() {
        return change;
    }

    public boolean isAlreadyIn() {
        return isAlreadyIn;
    }
}
