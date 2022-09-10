package org.nachc.fhirutils.file;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.hl7.fhir.instance.model.api.IBaseResource;

import com.nach.core.util.fhir.parser.FhirJsonParser;
import com.nach.core.util.file.FileUtil;

import ca.uhn.fhir.context.FhirContext;

public class FhirFileReader {

	private static FhirContext ctx = FhirContext.forDstu3();

	public static <T extends IBaseResource> List<T> getFhirResources(File dir, Class<T> cls, boolean isRecursive) {
		ArrayList<T> rtn = new ArrayList<T>();
		return getFhirResources(dir, cls, isRecursive, rtn);
	}

	
	public static <T extends IBaseResource> List<T> getFhirResources(File dir, Class<T> cls, boolean isRecursive, ArrayList<T> rtn) {
		File[] files = dir.listFiles();
		for(File file : files) {
			if(file.isDirectory() == false) {
				String json = FileUtil.getAsString(file);
				if(json == null || json.trim().length() == 0) {
					continue;
				}
				try {
					T fhirObject = FhirJsonParser.parse(json, cls);
					rtn.add(fhirObject);
				} catch(Exception exp) {
					continue;
				}
			} else {
				if(isRecursive) {
					getFhirResources(file, cls, isRecursive, rtn);
				}
			}
		}
		return rtn;
	}

}
