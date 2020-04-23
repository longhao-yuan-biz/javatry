package org.docksidestage.bizfw.basic.buyticket;

public class TicketBuyResult {
    // ===================================================================================
    //                                                                           Attribute
    //                                                                           =========
    private final Ticket ticket;

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public TicketBuyResult(Ticket ticket) {
        this.ticket = ticket;
    }

    // ===================================================================================
    //                                                                            Accessor
    //                                                                            ========
    public Ticket getTicket() {
        return ticket;
    }
}
