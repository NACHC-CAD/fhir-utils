package org.nachc.fhirutils.valueset;

import java.io.File;
import java.util.List;

import org.hl7.fhir.dstu3.model.ValueSet;
import org.junit.Test;

import com.nach.core.util.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class ValueSetUtilsIntegrationTest {

	private static final String DIR = "/fhir/valueset/hiv-cds/vocabulary/valueset/generated";

	@Test
	public void shouldGetNames() {
		log.info("Starting test...");
		File dir = FileUtil.getFile(DIR);
		List<ValueSet> valueSets = ValueSetUtils.getValueSets(dir, false);
		List<String> names = ValueSetUtils.getNames(valueSets);
		log.info("Got " + names.size() + " names.");
		for(String name : names) {
			log.info("\t" + name);
		}
		log.info("Got " + names.size() + " names.");
		log.info("Done.");
	}
	
}
