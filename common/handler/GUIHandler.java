package alcaeus.AlcaeusCore.common.handler;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import alcaeus.AlcaeusCore.common.AlcaeusCore;
import cpw.mods.fml.common.network.IGuiHandler;
import cpw.mods.fml.common.network.NetworkRegistry;

public class GUIHandler implements IGuiHandler {

	public static final void registerGUIHandler() {
		NetworkRegistry.instance().registerGuiHandler(AlcaeusCore.instance, new GUIHandler());
	}
	
	@Override
	public Object getServerGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

	@Override
	public Object getClientGuiElement(int ID, EntityPlayer player, World world,
			int x, int y, int z) {
		return null;
	}

}
