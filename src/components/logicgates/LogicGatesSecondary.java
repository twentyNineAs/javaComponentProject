package components.logicgates;

/**
 * Layered implementations of secondary methods for {@code LogicGates}.
 */
public abstract class LogicGatesSecondary implements LogicGates {

    /*
     * Public members ---------------------------------------------------------
     */

    /*
     * Common methods (from Object) -------------------------------------------
     */

    /**
     * toString Method.
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        if (this.height() > 1) {
            LogicGates left = new LogicGatesTree();
            LogicGates right = new LogicGatesTree();
            Operator op = this.disassemble(left, right);
            this.assemble(op, left, right);
            sb.append("(" + left.toString() + ", ");
            sb.append(op.toString() + ", ");
            sb.append(right.toString() + ")");
        } else {
            boolean val = this.compute();
            sb.append(val);
        }

        return sb.toString();
    }

    /**
     * equals Method.
     */
    @Override
    public final boolean equals(Object obj) {
        boolean equals = false;
        if (obj == null) {
            equals = false;
        }
        if (obj.getClass() != this.getClass()) {
            equals = false;
        } else {
            if (this.hashCode() == obj.hashCode()) {
                equals = true;
            }
        }

        return equals;
    }

    /**
     * hashCode Method.
     */
    @Override
    public int hashCode() {
        int hash = 1;
        final int prime = 79;

        if (this.size() > 0) {
            boolean compute = this.compute();
            hash = hash * prime + Boolean.hashCode(compute);
            LogicGates left = this.newInstance();
            LogicGates right = this.newInstance();
            Operator op = this.disassemble(left, right);
            hash = hash + left.hashCode();
            hash = hash + right.hashCode();
            this.assemble(op, left, right);
        }

        return hash;
    }

    /*
     * Other non-kernel methods -----------------------------------------------
     */

    /**
     * Reports the operator of {@code this}.
     *
     * @return the operator of {@code this}
     * @requires this \= empty
     * @ensures this = compose(operator, left, right)
     */
    @Override
    public Operator operator() {
        assert this.size() != 0;

        LogicGates left = new LogicGatesTree();
        LogicGates right = new LogicGatesTree();
        Operator op = this.disassemble(left, right);
        this.assemble(op, left, right);

        return op;
    }

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
    @Override
    public Operator replaceOperator(Operator op) {
        assert this.size() != 0;

        LogicGates left = new LogicGatesTree();
        LogicGates right = new LogicGatesTree();
        Operator oldOp = this.disassemble(left, right);
        this.assemble(op, left, right);

        return oldOp;
    }

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
    @Override
    public LogicGates replaceInput(LogicGates newInput, boolean leftGate) {
        assert this.size() != 0;

        LogicGates oldIn = new LogicGatesTree();

        if (leftGate) {
            LogicGates right = new LogicGatesTree();
            Operator op = this.disassemble(oldIn, right);
            this.assemble(op, newInput, right);
        } else {
            LogicGates left = new LogicGatesTree();
            Operator op = this.disassemble(left, oldIn);
            this.assemble(op, left, newInput);
        }

        return oldIn;
    }
}
