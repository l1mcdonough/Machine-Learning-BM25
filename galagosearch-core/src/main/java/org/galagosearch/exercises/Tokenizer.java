
/* Summary section
	•	The tokenizer still makes everything lowercase however it does not leave out apostrophes and keeps them as they are
	•	This will do a better job by not getting information that can be helpful. For example the crawler can now visit webpages 
	that have in apostrophe in the URL. This will also return more relevant results where an apostrophe can make a big difference.
	•	One problem with doing this is that sometimes when people search for something they don't always type the apostrophe so
	if they type in "oconnor" they wont get all the results they should get
	•	Test cases/sentences- "I'll eat with the O'Connors", "THIS Should BE all lowercase", "it's good"
*/
/*
Error explanation section
:  
If your code has errors, use this space for comments. 
A brief summary of what you did
A list of any 
problems still in your code
*/
package org.galagosearch.exercises;
import org.galagosearch.core.parse.TagTokenizer;
/**
* 
@author
Your name
*/
public class Tokenizer extends TagTokenizer {
	@Override
	protected String tokenSimpleFix(String token) {
		return token.toLowerCase();
	}
}