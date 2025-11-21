package components.logicgates;

/**
 * {@code LogicGates} represented with binaryTree.
 *
 * @convention <pre>
 * 0 <= height <= size <= (2^tr.height - 1) and if size > 0 then
 * size = 1 + left.size + right.size and
 * height = 1 + left.height + right.height and
 * op is not null,
 * left is not null,
 * right is not null,
 * left and right do not alias,
 * both left and right are valid logicGates.
 * LogicGates can only have no or both children.
 * </pre>
 * @correspondence <pre>
 * Represented using recursive tree structure, similar to BinaryTree.
 * If size = height = 0 then it is empty
 * Otherwise the logicGates is composed of Left LogicGate,
 * Right LogicGate and an Operator.
 * </pre>
 */
public class LogicGatesTree extends LogicGatesSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Logic Gate size.
     */
    private int size;

    /**
     * Logic Gate height.
     */
    private int height;

    /**
     * Left Gate.
     */
    private LogicGatesTree leftGate;

    /**
     * Right Gate.
     */
    private LogicGatesTree rightGate;

    /**
     * Operator.
     */
    private Operator operator;

    /**
     * Creator of Initial Representation.
     */
    private void createNewRep() {
        this.size = 0;
        this.height = 0;
        this.operator = null;
        this.leftGate = null;
        this.rightGate = null;
    }

    /*
     * Constructors -----------------------------------------------------------
     */

    /**
     * No argument constructor.
     */
    public LogicGatesTree() {
        this.createNewRep();
    }

    /*
     * Standard Methods -------------------------------------------------------
     */

    @Override
    public final LogicGates newInstance() {
        try {
            return this.getClass().getConstructor().newInstance();
        } catch (ReflectiveOperationException e) {
            throw new AssertionError(
                    "Cannot construct object of type " + this.getClass());
        }
    }

    @Override
    public final void clear() {
        this.createNewRep();
    }

    @Override
    public final void transferFrom(LogicGates source) {
        assert source != null : "Violation of: source is not null";
        assert source != this : "Violation of: source is not this";
        assert source instanceof LogicGatesTree : ""
                + "Violation of: source is of dynamic type SimpleReader1L";
        /*
         * This cast cannot fail since the assert above would have stopped
         * execution in that case.
         */
        LogicGatesTree localSource = (LogicGatesTree) source;
        this.size = localSource.size;
        this.height = localSource.height;
        this.operator = localSource.operator;
        this.leftGate = localSource.leftGate;
        this.rightGate = localSource.rightGate;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public final void assemble(Operator op, LogicGates first,
            LogicGates second) {
        assert this.operator != null : "Violation of: root is not null";
        assert first != null : "Violation of: first is not null";
        assert second != null : "Violation of: second is not null";
        assert first != this : "Violation of: first is not this";
        assert second != this : "Violation of: second is not this";
        assert first != second : "Violation of: first is not second";
        assert first instanceof LogicGatesTree : ""
                + "Violation of: left is a LogicGatesTree";
        assert second instanceof LogicGatesTree : ""
                + "Violation of: right is a LogicGatesTree";

        /*
         * TransferFrom is used in the below method even though that goes
         * against the kernel purity rule; however, I'm not too sure how else to
         * do move from localSource to this.
         */

        LogicGatesTree localFirst = (LogicGatesTree) first;
        LogicGatesTree localSecond = (LogicGatesTree) second;
        this.size = 1 + localFirst.size + localSecond.size;
        if (localFirst.height > localSecond.height) {
            this.height = 1 + localFirst.height;
        } else {
            this.height = 1 + localSecond.height;
        }
        this.operator = op;
        if (this.leftGate == null) {
            this.leftGate = new LogicGatesTree();
        }
        this.leftGate.transferFrom(localFirst);
        if (this.rightGate == null) {
            this.rightGate = new LogicGatesTree();
        }
        this.rightGate.transferFrom(localSecond);
    }

    @Override
    public final Operator disassemble(LogicGates first, LogicGates second) {
        assert first != null : "Violation of: first is not null";
        assert second != null : "Violation of: second is not null";
        assert first != this : "Violation of: first is not this";
        assert second != this : "Violation of: second is not this";
        assert first != second : "Violation of: first is not second";
        assert first instanceof LogicGatesTree : ""
                + "Violation of: left is a LogicGatesTree";
        assert second instanceof LogicGatesTree : ""
                + "Violation of: right is a LogicGatesTree";
        assert this.size != 0 : "Violation of: this /= empty_tree";

        Operator localOperator = this.operator;
        LogicGatesTree localFirst = (LogicGatesTree) first;
        LogicGatesTree localSecond = (LogicGatesTree) second;
        localFirst.transferFrom(this.leftGate);
        localSecond.transferFrom(this.rightGate);
        this.createNewRep();

        return localOperator;
    }

    @Override
    public final int size() {
        return this.size;
    }

    @Override
    public final int height() {
        return this.height;
    }

}
