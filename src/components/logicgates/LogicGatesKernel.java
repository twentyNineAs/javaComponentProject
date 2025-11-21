package components.logicgates;

import components.standard.Standard;

/**
 * Logic Gates kernel component with its primary methods.
 */
public interface LogicGatesKernel extends Standard<LogicGates> {
    /**
     * Logic Operators to be used for the Gates.
     */
    enum Operator {
        /**
         * Negative, Or, And, Exclusive Or, Not Or, Not And Operators.
         */
        NEG, OR, AND, XOR, NOR, NAND
    }

    /**
     * Assembles in {@code this} a logic gate {@code Operator} and input values
     * {@code first} and {@code second}.
     *
     * @param op
     *            the logical operator
     * @param first
     *            the first input value
     * @param second
     *            the second input value
     * @replaces this
     * @ensures this = compose(operator, first, second);
     */
    void assemble(Operator op, LogicGates first, LogicGates second);

    /**
     * Disassembles {@code this} into the logic gate {@code Operator}, which is
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
    Operator disassemble(LogicGates first, LogicGates second);

    /**
     * Returns the size of {@code this}.
     *
     * @return the size
     * @ensures size = |this|
     */
    int size();

    /**
     * Returns the height of {@code this}.
     *
     * @return the height
     * @ensures height = ht(this)
     */
    int height();
}
