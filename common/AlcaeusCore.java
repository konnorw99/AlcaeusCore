package alcaeus.AlcaeusCore.common;

import java.util.logging.Logger;

import net.minecraft.client.Minecraft;
import net.minecraftforge.common.Configuration;
import alcaeus.AlcaeusCore.common.core.ModInformation;
import alcaeus.AlcaeusCore.common.core.RegistryAC;
import alcaeus.AlcaeusCore.common.handler.ConnectionHandler;
import alcaeus.AlcaeusCore.common.handler.GUIHandler;
import alcaeus.AlcaeusCore.common.handler.LocalizationHandler;
import alcaeus.AlcaeusCore.common.helper.ForgeLoadingHelper;
import alcaeus.AlcaeusCore.common.lib.ModBlocks;
import alcaeus.AlcaeusCore.common.lib.ModItems;
import alcaeus.AlcaeusCore.common.proxy.IProxyAC;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.event.FMLServerStartingEvent;
import cpw.mods.fml.common.network.NetworkMod;


@Mod(modid = ModInformation.MOD_ID, name = ModInformation.NAME, version = ModInformation.VERSION)
@NetworkMod(clientSideRequired = true, serverSideRequired = false)
public class AlcaeusCore {
	
	@Instance(ModInformation.MOD_ID)
	public static AlcaeusCore instance;
	
	public static final Logger LOGGER = Logger.getLogger(ModInformation.MOD_ID);
	
	@SidedProxy(clientSide = ModInformation.PATH_PROXY_CLIENT, serverSide = ModInformation.PATH_PROXY_SERVER)
	public static IProxyAC proxy;
	
	public static final Minecraft mcInstance = Minecraft.getMinecraft();
	
	@EventHandler
	public void serverStarting(FMLServerStartingEvent event) {
		//logInfo("Registering commands...");
		//TODO: Make and register a command handler
	}
	
	@EventHandler
	public void preInit(FMLPreInitializationEvent event) {
		LOGGER.setParent(FMLLog.getLogger());
		
		logInfo("Loading configuration...");
		Configuration config = new Configuration(event.getSuggestedConfigurationFile());
		config.load();
		
		
		
		config.save();
	}
	
	@EventHandler
	public void init(FMLInitializationEvent event) {
		logInfo("Registering connection handler...");
		ConnectionHandler.registerConnectionHandler();
		
		logInfo("Registering blocks...");
		ModBlocks.registerBlocks();
		
		logInfo("Registering items...");
		ModItems.registerItems();
		
		logInfo("Registering ore dictionary support...");
		RegistryAC.registerOreDictCompatibility();
		
		logInfo("Registering tile entities...");
		ModBlocks.registerTileEntities();
		
		logInfo("Registering GUI handler...");
		GUIHandler.registerGUIHandler();
		
		logInfo("Registering recipies...");
		RegistryAC.registerCraftingRecipes();
		RegistryAC.registerSmeltingRecipes();
		
		logInfo("Registering localizations...");
		LocalizationHandler.registerSimpleNames();
		
		proxy.registerRenderings();
		proxy.registerSounds();
		proxy.registerTickHander();
	}
	
	@EventHandler
	public void postInit(FMLPostInitializationEvent event) {
		ForgeLoadingHelper.registerModSpecificRecipies();
	}
	
	public static void logException(Throwable e, String msg) {
		LOGGER.severe(msg);
		e.printStackTrace();
	}
	
	public static void logInfo(String msg) {
		LOGGER.info(msg);
	}
	
	public static void logSevere(String msg) {
		LOGGER.severe(msg);
	}
	
	public static void logWarning(String msg) {
		LOGGER.warning(msg);
	}
	
}
