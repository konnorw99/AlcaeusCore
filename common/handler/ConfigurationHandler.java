package alcaeus.AlcaeusCore.common.handler;

import java.io.File;

import net.minecraftforge.common.Configuration;
import alcaeus.AlcaeusCore.common.AlcaeusCore;
import alcaeus.AlcaeusCore.common.core.ModInformation;

public class ConfigurationHandler {
	
	private static File configurationFile = new File(AlcaeusCore.mcInstance.mcDataDir.getAbsolutePath() + "/config/" + ModInformation.MOD_ID + ".cfg");
	
	public static final void loadConfiguration() {
		Configuration config = new Configuration(configurationFile);
		
		
	}

}
