import components.simplewriter.SimpleWriter;
import components.simplewriter.SimpleWriter1L;

/**
 * For assignment two, an attempt to showcase logicGates design.
 *
 * Although this is a very barebones version of the idea, it should provide a
 * basis for what I am aiming for. I want to create a component that can store
 * and compute multiple logic gates outputs. Ideally you can directly input
 * boolean values, or input another logic gates values in order to create one
 * big logical operation, sort of like a binary tree.
 */
public final class LogicGates {

    /**
     * Private constructor so this utility class can't be instantiated.
     */
    private LogicGates() {
    }

    /**
     * A method to compute x AND y.
     *
     * @param x
     *            first boolean
     * @param y
     *            second boolean
     * @return b the computed value of x and y
     */
    public static boolean and(boolean x, boolean y) {
        boolean b = x && y;
        return b;
    }

    /**
     * A method to compute x OR y.
     *
     * @param x
     *            first boolean
     * @param y
     *            second boolean
     * @return b the computed value of x and y
     */
    public static boolean or(boolean x, boolean y) {
        boolean b = x || y;
        return b;
    }

    /**
     * Main Method.
     *
     * @param args
     *            command line arguments
     */
    public static void main(String[] args) {
        SimpleWriter out = new SimpleWriter1L();
        boolean a = false;
        boolean b = true;
        boolean c = true;

        boolean d = and(a, b);
        boolean e = or(a, c);
        boolean f = and(d, e);
        out.println(f);

        out.close();
    }
}
