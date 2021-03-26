package mod.milkeyyy.modemenu.procedures;

import net.minecraft.world.GameType;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;

@ModemenuModElements.ModElement.Tag
public class ChangePlayerGamemodeProcedure extends ModemenuModElements.ModElement {
	public ChangePlayerGamemodeProcedure(ModemenuModElements instance) {
		super(instance, 6);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ModemenuMod.LOGGER.warn("Failed to load dependency entity for procedure ChangePlayerGamemode!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if ((0 == ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModemenuModVariables.PlayerVariables())).maingui_player_select_gamemode))) {
			if (entity instanceof PlayerEntity)
				((PlayerEntity) entity).setGameType(GameType.SURVIVAL);
		} else {
			if ((1 == ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ModemenuModVariables.PlayerVariables())).maingui_player_select_gamemode))) {
				if (entity instanceof PlayerEntity)
					((PlayerEntity) entity).setGameType(GameType.CREATIVE);
			} else {
				if ((2 == ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ModemenuModVariables.PlayerVariables())).maingui_player_select_gamemode))) {
					if (entity instanceof PlayerEntity)
						((PlayerEntity) entity).setGameType(GameType.ADVENTURE);
				} else {
					if ((3 == ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ModemenuModVariables.PlayerVariables())).maingui_player_select_gamemode))) {
						if (entity instanceof PlayerEntity)
							((PlayerEntity) entity).setGameType(GameType.SPECTATOR);
					}
				}
			}
		}
	}
}
