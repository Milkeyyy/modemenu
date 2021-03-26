package mod.milkeyyy.modemenu.procedures;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;

@ModemenuModElements.ModElement.Tag
public class ClosePlayerGUIProcedure extends ModemenuModElements.ModElement {
	public ClosePlayerGUIProcedure(ModemenuModElements instance) {
		super(instance, 24);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ModemenuMod.LOGGER.warn("Failed to load dependency entity for procedure ClosePlayerGUI!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		if (entity instanceof PlayerEntity)
			((PlayerEntity) entity).closeScreen();
	}
}
