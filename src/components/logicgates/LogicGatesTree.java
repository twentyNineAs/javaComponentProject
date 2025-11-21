package components.logicgates;

/**
 * {@code LogicGates} represented with binaryTree.
 */
public class LogicGatesTree extends LogicGatesSecondary {

    /*
     * Private members --------------------------------------------------------
     */

    /*
     * Constructors -----------------------------------------------------------
     */

    /*
     * Standard Methods -------------------------------------------------------
     */

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

    @Override
    public void clear() {
        throw new UnsupportedOperationException("Unimplemented method 'clear'");
    }

    @Override
    public LogicGates newInstance() {
        throw new UnsupportedOperationException(
                "Unimplemented method 'newInstance'");
    }

    @Override
    public void transferFrom(LogicGates arg0) {
        throw new UnsupportedOperationException(
                "Unimplemented method 'transferFrom'");
    }

}
