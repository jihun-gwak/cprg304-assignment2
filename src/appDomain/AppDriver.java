package appDomain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import implementations.MyStack;

public class AppDriver {

	public static void main(String[] args) throws IOException {
		//String filename = args[0];
		String filename = "res/sample1.xml";
		
		if (filename.length() < 1) {
			return;
		}
		
		// Read the file
		try (BufferedReader reader = new BufferedReader(new FileReader(filename))) {
			String line;
			MyStack<String> tagStack = new MyStack<String>();
			
			while ((line = reader.readLine()) != null) {
				// Skip self-closing tags or lines that don't contain tags
				// We may need to re-factor to check for malformed self-closing tags.
				if (!line.contains("<") || line.contains("/>")) {
					continue;
				}
				
				// Find start of tag
				int tagStartIndex = line.indexOf("<");
				String tagName = "";
				for (int i = tagStartIndex + 1; i < line.length(); i++) {
					char tagChar = line.charAt(i);
					// Check if there is a space (indicating start of properties)
					// or if there is a closing character (indicating end of tag)
					if (tagChar == ' ' || tagChar == '>') {
						break;
					}
					
					tagName += tagChar;
				}
				
				// Ignore this tag
				if (tagName == "?xml") {
					continue;
				}
				
				// Pop off the stack
				if (tagName.charAt(0) == '/') {
					if (!tagStack.peek().equals(tagName.substring(1))) {
						// Need a better error message for this
						// This occurs when a tag is trying to be closed that isn't on the
						// top of the stack
						System.out.println("Error: " + tagStack.peek() + " != " + tagName.substring(1));
					}
					tagStack.pop();
					continue;
				}
				
				// Add to the stack
				tagStack.push(tagName);
			}
		}
	}
	
}
