package components.logicgates;

/**
 * {@code LogicGatesKernel} enhanced with secondary methods.
 */
public interface LogicGates extends LogicGatesKernel {

    /**
     * Reports the operator of {@code this}.
     *
     * @return the operator of {@code this}
     * @requires this \= empty
     * @ensures this = compose(operator, left, right)
     */
    String operator();

    /**
     * Replaces the operator of {@code this} with {@code op}, and returns the
     * old operator.
     *
     * @param op
     *            the new operator
     * @return the old operator
     * @requires this \= empty
     * @ensures (this = compose(op, left, right) and #this =
     *          compose(replaceOperator, left, right))
     */
    String replaceOperator(String op);

    /**
     * Returns the height of {@code this}.
     *
     * @return the height
     * @ensures height = ht(this)
     */
    int height();
}
