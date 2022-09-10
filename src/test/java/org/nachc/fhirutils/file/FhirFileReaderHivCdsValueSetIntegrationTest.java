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

	private static final String DIR = "/fhir/valueset/hiv-cds/vocabulary/valueset/generated";
	
	@Test
	public void shouldCreateFhirObjects() {
		log.info("Starting test...");
		File dir = FileUtil.getFile(DIR);
		log.info("Got file: " + FileUtil.getCanonicalPath(dir));
		log.info("Exists: " + dir.exists());
		assertTrue(dir.exists());
		List<ValueSet> valueSets = FhirFileReader.getFhirResources(dir, ValueSet.class, false);
		log.info("Got " + valueSets.size() + " ValueSets");
		log.info("Done.");
	}
	
}
