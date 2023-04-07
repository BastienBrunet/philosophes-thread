import java.io.File;
import java.io.IOException;
import java.nio.file.Files;

import org.junit.Test;

public class MoveTaskTest {

//	@Test
//	public void test() {
//		fail("Not yet implemented");
//	}

	@Test
	public void getTargetFolderTest() throws IOException {
		File targetFolder = new File("work/ecoute");

		Files.list(targetFolder.toPath())
				.forEach(f -> System.out.println(f.toAbsolutePath() + File.separator + f.getFileName()));
	}

}
