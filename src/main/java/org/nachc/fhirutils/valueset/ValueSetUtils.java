package org.nachc.fhirutils.valueset;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.dstu3.model.ValueSet;
import org.nachc.fhirutils.file.FhirFileReader;
import org.nachc.tools.fhirtoomop.fhir.parser.valueset.ValueSetParser;

public class ValueSetUtils {

	public static List<ValueSet> getValueSets(File dir, boolean isRecursive) {
		List<ValueSet> valueSets = FhirFileReader.getFhirResources(dir, ValueSet.class, isRecursive);
		return valueSets;
	}
	
	public static List<String> getNames(List<ValueSet> valueSetList) {
		ArrayList<String> rtn = new ArrayList<>();
		for(ValueSet valueSet : valueSetList) {
			ValueSetParser parser = new ValueSetParser(valueSet);
			String name = parser.getName();
			rtn.add(name);
		}
		return rtn;
	}
}
