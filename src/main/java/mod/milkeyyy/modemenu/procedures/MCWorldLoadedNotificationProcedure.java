package mod.milkeyyy.modemenu.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.world.WorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.IWorld;

import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;
import java.util.HashMap;

@ModemenuModElements.ModElement.Tag
public class MCWorldLoadedNotificationProcedure extends ModemenuModElements.ModElement {
	public MCWorldLoadedNotificationProcedure(ModemenuModElements instance) {
		super(instance, 23);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		ModemenuMod.LOGGER.warn((("The current version (") + "" + ((ModemenuModVariables.version)) + ""
				+ (") of ModEMenu is not recommended for use on servers due to language-related issues.")));
	}

	@SubscribeEvent
	public void onWorldLoad(WorldEvent.Load event) {
		IWorld world = event.getWorld();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("world", world);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
