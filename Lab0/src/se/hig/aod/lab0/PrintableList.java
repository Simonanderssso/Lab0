package se.hig.aod.lab0;

/**
 * Extension of the {@link List}-interface to represent printable lists.
 * <p>
 *
 * @param <T> The data type that is to be stored in the list.
 * @author Hanna Holmgren
 */
public interface PrintableList<T> extends List<T> {

	/**
	 * Converts the list to a string with format "[element1, element2, ...]".
	 *
	 * @return String representation of the list to be printed
	 */
	public String toStringRecursive();

	/**
	 * Converts the list to a string with format "[lastElement, secondLastelement, ...]".
	 *
	 * @return String representation of the list to be printed
	 */
	public String toStringReverseRecursive();

}
