package org.docksidestage.bizfw.basic.objanimal;
import org.docksidestage.bizfw.basic.objanimal.flier.FastFlier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author Longhao Yuan
 */

public class Bee extends Animal implements FastFlier {
    private static final Logger logger = LoggerFactory.getLogger(Dog.class);

    // ===================================================================================
    //                                                                         Constructor
    //                                                                         ===========
    public Bee() {
    }


    @Override
    public void fly() {
        // dummy implementation
        logger.debug("...Flying now");
    }

    // ===================================================================================
    //                                                                               Bark
    //                                                                              ======
    protected String getBarkWord() {
        return "bun";
    }
}
