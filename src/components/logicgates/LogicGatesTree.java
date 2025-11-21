package components.logicgates;

import components.binarytree.BinaryTree;
import components.binarytree.BinaryTree1;

/**
 * {@code LogicGates} represented with binaryTree.
 *
 * @correspondence
 *
 *
 *
 * @convention
 */
public class LogicGatesTree extends LogicGatesSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /**
     * Underlying Representation.
     */
    private BinaryTree<Boolean> rep;

    /**
     * Logic Gate size.
     */
    private int size;

    /**
     * Logic Gate height.
     */
    private int height;

    /**
     * Creator of Initial Representation.
     */
    private void createNewRep() {
        this.rep = new BinaryTree1<>();
        this.size = 0;
        this.height = 0;
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
        this.rep = localSource.rep;
        this.size = localSource.size;
        this.height = localSource.height;
        localSource.createNewRep();
    }

    /*
     * Kernel methods ---------------------------------------------------------
     */

    @Override
    public void assemble(Operator op, LogicGates first, LogicGates second) {
        throw new UnsupportedOperationException(
                "Unimplemented method 'assemble'");
    }

    @Override
    public Operator disassemble(LogicGates first, LogicGates second) {
        throw new UnsupportedOperationException(
                "Unimplemented method 'disassemble'");
    }

    @Override
    public boolean compute() {
        throw new UnsupportedOperationException(
                "Unimplemented method 'compute'");
    }

    @Override
    public int size() {
        throw new UnsupportedOperationException("Unimplemented method 'size'");
    }

    @Override
    public int height() {
        throw new UnsupportedOperationException(
                "Unimplemented method 'height'");
    }

}
