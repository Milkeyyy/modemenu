package mod.milkeyyy.modemenu.procedures;

import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;
import java.util.HashMap;

@ModemenuModElements.ModElement.Tag
public class ChangePlayerGamemode3Procedure extends ModemenuModElements.ModElement {
	public ChangePlayerGamemode3Procedure(ModemenuModElements instance) {
		super(instance, 10);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ModemenuMod.LOGGER.warn("Failed to load dependency entity for procedure ChangePlayerGamemode3!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			double _setval = (double) 3;
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.maingui_player_select_gamemode = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			ChangePlayerGamemodeProcedure.executeProcedure($_dependencies);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("[\u00A79ModEMenu\u00A7r] ") + ""
					+ (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ModemenuModVariables.PlayerVariables())).text_message_changegamemode))
					+ "" + ("\u00A77Spectator\u00A7r") + "" + (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ModemenuModVariables.PlayerVariables())).text_message_changegamemode2)))),
					(false));
		}
	}
}
