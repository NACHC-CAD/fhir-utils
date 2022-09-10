package org.nachc.fhirutils.file;

import static org.junit.Assert.assertTrue;

import java.io.File;
import java.util.List;

import org.hl7.fhir.dstu3.model.ValueSet;
import org.junit.Test;

import com.nach.core.util.file.FileUtil;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class FhirFileReaderHivCdsValueSetIntegrationTest {

	private static final String DIR = "/fhir/valueset/hiv-cds/vocabulary/valueset";
	
	@Test
	public void shouldCreateFhirObjects() {
		log.info("Starting test...");
		File dir;
		List<ValueSet> valueSets;
		// list of value sets, not recursive
		dir = FileUtil.getFile(DIR + "/generated");
		log.info("Got file: " + FileUtil.getCanonicalPath(dir));
		log.info("Exists: " + dir.exists());
		assertTrue(dir.exists());
		valueSets = FhirFileReader.getFhirResources(dir, ValueSet.class, false);
		log.info("Got " + valueSets.size() + " ValueSets");
		assertTrue(valueSets.size() == 79);
		// list of value sets, recursive
		dir = FileUtil.getFile(DIR);
		log.info("Got file: " + FileUtil.getCanonicalPath(dir));
		log.info("Exists: " + dir.exists());
		assertTrue(dir.exists());
		valueSets = FhirFileReader.getFhirResources(dir, ValueSet.class, true);
		log.info("Got " + valueSets.size() + " ValueSets");
		assertTrue(valueSets.size() == 84);
		log.info("Done.");
	}
	
}
