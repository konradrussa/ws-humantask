package wsht.runtime.expressions.xpath.functions;

import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

import javax.xml.XMLConstants;
import javax.xml.namespace.NamespaceContext;

public class FunctionNamespaceResolver implements NamespaceContext {

	private final String _prefix;
	private final String _nsURI;
	private final List<String> _prefixes;

	public FunctionNamespaceResolver(String prefix, String nsURI) {
		if (prefix == null)
			throw new IllegalArgumentException("prefix may not be null");
		if (nsURI == null)
			throw new IllegalArgumentException("nsURI may not be null");

		_prefix = prefix;
		_nsURI = nsURI;
		_prefixes = Arrays.asList(prefix);
	}

	public String getNamespaceURI(String prefix) {
		if (prefix == null)
			throw new IllegalArgumentException("prefix may not be null");
		else if (_prefix.equals(prefix))
			return _nsURI;
		else if (XMLConstants.XML_NS_PREFIX.equals(prefix))
			return XMLConstants.XML_NS_URI;
		else if (XMLConstants.XMLNS_ATTRIBUTE.equals(prefix))
			return XMLConstants.XMLNS_ATTRIBUTE_NS_URI;
		else
			return null;
	}

	public String getPrefix(String nsURI) {
		if (nsURI == null)
			throw new IllegalArgumentException("nsURI may not be null");
		else if (nsURI.equals(_nsURI))
			return _prefix;
		else if (nsURI.equals(XMLConstants.XML_NS_URI))
			return XMLConstants.XML_NS_PREFIX;
		else if (nsURI.equals(XMLConstants.XMLNS_ATTRIBUTE_NS_URI))
			return XMLConstants.XMLNS_ATTRIBUTE;
		else
			return null;
	}

	public Iterator<String> getPrefixes(String nsURI) {
		String prefix = getPrefix(nsURI);
		if (_prefix.equals(prefix))
			return _prefixes.iterator();
		else if (prefix == null)
			return Collections.<String> emptyList().iterator();
		else
			return Arrays.asList(prefix).iterator();
	}


	@Override
	public final boolean equals(Object obj) {
		if (obj instanceof FunctionNamespaceResolver) {
			FunctionNamespaceResolver that = (FunctionNamespaceResolver) obj;
			return this._prefix.equals(that._prefix)
					&& this._nsURI.equals(that._nsURI);
		}
		return false;
	}

	@Override
	public int hashCode() {
		return _prefix.hashCode() ^ _nsURI.hashCode();
	}

	@Override
	public String toString() {
		StringBuilder buf = new StringBuilder(_prefix.length()
				+ _nsURI.length() + 10);
		if ("".equals(_prefix)) {
			buf.append("xmlns=\"").append(_nsURI).append("\"");
		} else {
			buf.append("xmlns:").append(_prefix).append("=\"").append(_nsURI)
					.append("\"");
		}
		return buf.toString();
	}
}
