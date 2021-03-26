package mod.milkeyyy.modemenu.procedures;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;
import java.util.HashMap;

@ModemenuModElements.ModElement.Tag
public class ChangeWorldDifficulty1Procedure extends ModemenuModElements.ModElement {
	public ChangeWorldDifficulty1Procedure(ModemenuModElements instance) {
		super(instance, 19);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ModemenuMod.LOGGER.warn("Failed to load dependency entity for procedure ChangeWorldDifficulty1!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ModemenuMod.LOGGER.warn("Failed to load dependency x for procedure ChangeWorldDifficulty1!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ModemenuMod.LOGGER.warn("Failed to load dependency y for procedure ChangeWorldDifficulty1!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ModemenuMod.LOGGER.warn("Failed to load dependency z for procedure ChangeWorldDifficulty1!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ModemenuMod.LOGGER.warn("Failed to load dependency world for procedure ChangeWorldDifficulty1!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		{
			double _setval = (double) 1;
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.maingui_player_select_difficulty = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			Map<String, Object> $_dependencies = new HashMap<>();
			$_dependencies.put("entity", entity);
			$_dependencies.put("x", x);
			$_dependencies.put("y", y);
			$_dependencies.put("z", z);
			$_dependencies.put("world", world);
			ChangeWorldDifficultyProcedure.executeProcedure($_dependencies);
		}
		if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
			((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("[\u00A79ModEMenu\u00A7r] ") + ""
					+ (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ModemenuModVariables.PlayerVariables())).text_message_changedifficulty))
					+ "" + ("\u00A7aEasy\u00A7r") + "" + (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ModemenuModVariables.PlayerVariables())).text_message_changedifficulty2)))),
					(false));
		}
	}
}
