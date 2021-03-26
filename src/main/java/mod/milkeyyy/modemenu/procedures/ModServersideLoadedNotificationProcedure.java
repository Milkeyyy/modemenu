package mod.milkeyyy.modemenu.procedures;

import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.common.MinecraftForge;
import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;
import java.util.Collections;

@ModemenuModElements.ModElement.Tag
public class ModServersideLoadedNotificationProcedure extends ModemenuModElements.ModElement {
	public ModServersideLoadedNotificationProcedure(ModemenuModElements instance) {
		super(instance, 22);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		ModemenuMod.LOGGER.warn((("The current version (") + "" + ((ModemenuModVariables.version)) + ""
				+ (") of ModEMenu is not recommended for use on servers due to language issues.")));
	}

	@OnlyIn(Dist.DEDICATED_SERVER)
	@Override
	public void init(FMLCommonSetupEvent event) {
		this.executeProcedure(Collections.emptyMap());
	}
}
