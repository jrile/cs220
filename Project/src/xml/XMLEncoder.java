package xml;

import java.util.HashMap;

/**
 * I wrote this class to make it easier to encode and decode ENTITIES, because
 * some(ie 6) symbols just don't work in entities and must be encoded. This is
 * not true for ATTRIBUTES which are encased in quotes and can accommodate any
 * symbols. You would use this when WRITING XML -- pass your entities thru
 * "encode" before writing.
 */
public class XMLEncoder {

	private static HashMap<String, String> codes;

	/**
	 * See this cool static block -- this allows you to do complicated
	 * initialization of static variables -- remember this -- it will be handy
	 * later in the project
	 */
	static {
		codes = new HashMap<String, String>();
		codes.put("\"", "&quot;");
		codes.put("&", "&amp;");
		codes.put("'", "&apos;");
		codes.put("<", "&lt;");
		codes.put(">", "&gt;");
	}

	/**
	 * This is cool too! A private constructor! This is very cool -- think about
	 * this -- this prevents ANY body (outside of this very class from
	 * instantiating this class, since no one else can access private members.
	 * This is actually what we want since all methods are static
	 */
	private XMLEncoder() {
	}

	public static String encode(String input) {
		for (String x : codes.keySet()) {
			input = input.replace(x, codes.get(x));
		}
		return input;
	}

}