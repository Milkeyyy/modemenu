package mod.milkeyyy.modemenu.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;
import java.util.HashMap;

@ModemenuModElements.ModElement.Tag
public class PlayerJoinTheWorldNotificationProcedure extends ModemenuModElements.ModElement {
	public PlayerJoinTheWorldNotificationProcedure(ModemenuModElements instance) {
		super(instance, 1);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ModemenuMod.LOGGER.warn("Failed to load dependency entity for procedure PlayerJoinTheWorldNotification!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("[\u00A79ModEMenu\u00A7r] ModEMenu \u00A7bv") + ""
					+ ((ModemenuModVariables.version)) + "" + (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ModemenuModVariables.PlayerVariables())).text_joinplayer_loaded)))),
					(false));
		}
	}

	@SubscribeEvent
	public void onPlayerLoggedIn(PlayerEvent.PlayerLoggedInEvent event) {
		Entity entity = event.getPlayer();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", entity.getPosX());
		dependencies.put("y", entity.getPosY());
		dependencies.put("z", entity.getPosZ());
		dependencies.put("world", entity.world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
