package components.logicgates;

/**
 * Layered implementations of secondary methods for {@code LogicGates}
 */
public abstract class LogicGatesSecondary implements LogicGates {

    /*
     * Public members ---------------------------------------------------------
     */

    /*
     * Common methods (from Object) -------------------------------------------
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

    @Override
    public final boolean equals(Object obj) {
        boolean equals = false;
        if (obj == null) {
            equals = false;
        }
        if (obj.getClass() != this.getClass()) {
            equals = false;
        } else {
            if (this.toString().equals(obj.toString())) {
                equals = true;
            }
        }

        return equals;
    }

    /*
     * Other non-kernel methods -----------------------------------------------
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

    @Override
    public Operator replaceOperator(Operator op) {
        assert this.size() != 0;

        LogicGates left = new LogicGatesTree();
        LogicGates right = new LogicGatesTree();
        Operator oldOp = this.disassemble(left, right);
        this.assemble(op, left, right);

        return oldOp;
    }

    @Override
    public LogicGates replaceInput(LogicGates newInput, boolean leftGate) {
        assert this.size() != 0;

        LogicGates oldIn = new LogicGatesTree();

        if (leftGate) {
            LogicGates right = new LogicGatesTree();
            Operator op = this.disassemble(oldIn, right);
            this.assemble(op, oldIn, right);
        } else {
            LogicGates left = new LogicGatesTree();
            Operator op = this.disassemble(left, oldIn);
            this.assemble(op, left, oldIn);
        }

        return oldIn;
    }
}
