package components.logicgates;

import components.standard.Standard;

/**
 * Logic Gates kernel component with its primary methods.
 */
public interface LogicGatesKernel extends Standard<LogicGates> {

    /**
     * Assembles in {@code this} a logic gate {@code operator} and input values
     * {@code first} and {@code second}.
     *
     * @param operator
     *            the logical operator
     * @param first
     *            the first input value
     * @param second
     *            the second input value
     * @requires operation to be equal to one of the following operators: {AND;
     *           OR; NAND; NOR; XOR; NEG}
     * @replaces this
     * @ensures this = compose(operator, first, second);
     */
    void assemble(String operator, boolean first, boolean second);

    /**
     * Disassembles {@code this} into the logic gate {@code operator}, which is
     * returned as the value of the function, and input values {@code first} and
     * {@code second}.
     *
     * @param first
     *            the first input value
     * @param second
     *            the second input value
     * @return logical operator
     * @replaces left, right
     * @requires this /= empty
     * @ensures this = compose(disassemble, first, second);
     */
    String disassemble(boolean first, boolean second);

    /**
     * Computes the final boolean value for the entirety of {@code this}, and
     * returns said boolean.
     *
     * @return the final boolean value
     * @ensures compute = compute(first) operator compute(second)
     */
    boolean compute();

    /**
     * Returns the size of {@code this}.
     *
     * @return the size
     * @ensures size = |this|
     */
    int size();
}
