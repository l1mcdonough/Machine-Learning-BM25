
	/* Summary section 
		1) A document that is twice as long but contains the words just as much might be just as relevant
	2) Really long documents that contain the keywords the same amount of times as a much shorter document.
	These are more likely to contain a keywords the BM25 method penalizes long documents
	*/
	/*
	Error explanation section:  If your code has errs, use
	this space for comments. 
	A brief summary of what you did 
	A list of any problems still in your code
	*/
	package org.galagosearch.exercises;

import java.io.IOException;

import org.galagosearch.core.retrieval.structured.CountIterator;
import org.galagosearch.core.retrieval.structured.RequiredStatistics;
import org.galagosearch.core.retrieval.structured.ScoringFunctionIterator;
import org.galagosearch.tupleflow.Parameters;

/**
* @author Your name
*/
@RequiredStatistics (statistics = {"collectionLength", "documentCount","b","k_1"})
public class BM25Iterator extends ScoringFunctionIterator {
	Parameters parameters;
	public BM25Iterator(Parameters parameters, CountIterator iterator) throws IOException {
		// Implement the constructor
		super(iterator);
		this.parameters = parameters;
		
		}
	private double getParam(String name){
		return Double.parseDouble(parameters.get(name));
	}
	/**
	* @param count equals to fi
	* @param length equals to dl
	* Ignores ((k2+1)qfi)  / (k2+qfi) because the performance is less sensitive.
	* Only calculate ((k1+1)fi ) / (K + fi)
	*/
	
	@Override
	public double scoreCount(int fi, int dl) {
		double k1 = getParam("k_1");
		double b = getParam("b");
		double avdl = getParam("collectionLength")/getParam("documentCount");
		double K = k1 * ((1 - b) + b * dl / avdl);
		return ((k1 + 1) * fi) / (K + fi);
	// Implement this method
	}
}

