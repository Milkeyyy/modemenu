package mod.milkeyyy.modemenu.procedures;

import net.minecraft.world.server.ServerWorld;
import net.minecraft.world.World;
import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.math.vector.Vector3d;
import net.minecraft.util.math.vector.Vector2f;
import net.minecraft.entity.Entity;
import net.minecraft.command.ICommandSource;
import net.minecraft.command.CommandSource;

import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;

@ModemenuModElements.ModElement.Tag
public class ChangeWorldTimeProcedure extends ModemenuModElements.ModElement {
	public ChangeWorldTimeProcedure(ModemenuModElements instance) {
		super(instance, 12);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ModemenuMod.LOGGER.warn("Failed to load dependency entity for procedure ChangeWorldTime!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ModemenuMod.LOGGER.warn("Failed to load dependency x for procedure ChangeWorldTime!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ModemenuMod.LOGGER.warn("Failed to load dependency y for procedure ChangeWorldTime!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ModemenuMod.LOGGER.warn("Failed to load dependency z for procedure ChangeWorldTime!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ModemenuMod.LOGGER.warn("Failed to load dependency world for procedure ChangeWorldTime!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((0 == ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModemenuModVariables.PlayerVariables())).maingui_player_select_time))) {
			if (world instanceof ServerWorld)
				((ServerWorld) world).setDayTime((int) 1000);
		} else {
			if ((1 == ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new ModemenuModVariables.PlayerVariables())).maingui_player_select_time))) {
				if (world instanceof ServerWorld)
					((ServerWorld) world).setDayTime((int) 13000);
			} else {
				if ((2 == ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
						.orElse(new ModemenuModVariables.PlayerVariables())).maingui_player_select_time))) {
					if (world instanceof ServerWorld)
						((ServerWorld) world).setDayTime((int) 17000);
				} else {
					if ((3 == ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new ModemenuModVariables.PlayerVariables())).maingui_player_select_time))) {
						if (world instanceof ServerWorld) {
							((World) world).getServer().getCommandManager()
									.handleCommand(
											new CommandSource(ICommandSource.DUMMY, new Vector3d(x, y, z), Vector2f.ZERO, (ServerWorld) world, 4, "",
													new StringTextComponent(""), ((World) world).getServer(), null).withFeedbackDisabled(),
											"time add 1000");
						}
					}
				}
			}
		}
	}
}
