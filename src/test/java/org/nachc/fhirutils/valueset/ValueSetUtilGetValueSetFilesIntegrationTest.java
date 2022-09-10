package org.nachc.fhirutils.valueset;

import java.io.File;
import java.util.List;

import org.hl7.fhir.dstu3.model.ValueSet;
import org.junit.Test;
import org.nachc.tools.fhirtoomop.fhir.parser.FhirResourceFile;
import org.nachc.tools.fhirtoomop.fhir.parser.valueset.ValueSetParser;

import com.nach.core.util.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValueSetUtilGetValueSetFilesIntegrationTest {

	private static final String DIR = "/fhir/valueset/hiv-cds/vocabulary/valueset/generated";

	@Test
	public void shouldGetNames() {
		log.info("Starting test...");
		File dir = FileUtil.getFile(DIR);
		List<FhirResourceFile<ValueSet>> valueSets = ValueSetUtil.getValueSetFiles(dir, false);
		log.info("Got " + valueSets.size() + " valueSets.");
		String msg = "\n\n";
		for(FhirResourceFile<ValueSet> valueSetFile : valueSets) {
			ValueSet valueSet = valueSetFile.getResource();
			ValueSetParser parser = new ValueSetParser(valueSet);
			msg += "\t" + parser.getName() + "\t" + valueSetFile.getFileName() + "\n";
		}
		log.info("Value sets: \n" + msg);
		log.info("Got " + valueSets.size() + " valueSets.");
		log.info("Done.");
	}
	
}
