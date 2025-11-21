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
    Operator operator();

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
    Operator replaceOperator(Operator op);

    /**
     * Replace one of the inputs of {@code this} with {@code newInput}, and
     * returns the old input. Determines which input to change by value of
     * {@code leftGate}, with true being left and false being right.
     *
     * @param newInput
     *            the new input
     * @param leftGate
     *            whether to replace left or right input
     * @return the old input
     * @requires this \= empty
     * @ensures (this = compose(op, newInput, right) OR this = compose(op, left,
     *          newInput))
     */
    LogicGates replaceInput(LogicGates newInput, boolean leftGate);

    /**
     * Computes the final boolean value for the entirety of {@code this}, and
     * returns said boolean.
     *
     * @return the final boolean value
     * @ensures compute = compute(first) operator compute(second)
     */
    boolean compute();
}
