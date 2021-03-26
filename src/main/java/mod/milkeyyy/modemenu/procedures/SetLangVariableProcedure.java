package mod.milkeyyy.modemenu.procedures;

import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.EntityJoinWorldEvent;
import net.minecraftforge.common.MinecraftForge;

import net.minecraft.world.World;
import net.minecraft.util.text.TranslationTextComponent;
import net.minecraft.entity.Entity;

import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;
import java.util.HashMap;

@ModemenuModElements.ModElement.Tag
public class SetLangVariableProcedure extends ModemenuModElements.ModElement {
	public SetLangVariableProcedure(ModemenuModElements instance) {
		super(instance, 5);
		MinecraftForge.EVENT_BUS.register(this);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ModemenuMod.LOGGER.warn("Failed to load dependency entity for procedure SetLangVariable!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.maingui.title_gamemode").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_maingui_title_gamemode = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.maingui.title_difficulty").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_maingui_title_difficulty = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.maingui.title_time").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_maingui_title_time = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.maingui.warntext1").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_maingui_title_warntext1 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.message.openguineedpermission").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_message_openguineedpermission = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.message.changegamemode").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_message_changegamemode = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.message.changegamemode2").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_message_changegamemode2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.message.timeset").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_message_timeset = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.message.timeset2").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_message_timeset2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.message.timeadd").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_message_timeadd = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.message.timeadd2").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_message_timeadd2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.message.changedifficulty").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_message_changedifficulty = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.message.changedifficulty2").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_message_changedifficulty2 = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.command.invalidcommand").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_command_invalid_command = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.command_version.installedversion").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_command_version_installedversion = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.command_about.createdby").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_command_about_createdby = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.command_help.wip").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_command_help_wip = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
		{
			String _setval = (String) (new TranslationTextComponent("text.modemenu.joinplayernotice.loaded").getString());
			entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null).ifPresent(capability -> {
				capability.text_joinplayer_loaded = _setval;
				capability.syncPlayerVariables(entity);
			});
		}
	}

	@SubscribeEvent
	public void onEntityJoin(EntityJoinWorldEvent event) {
		World world = event.getWorld();
		Entity entity = event.getEntity();
		double i = entity.getPosX();
		double j = entity.getPosY();
		double k = entity.getPosZ();
		Map<String, Object> dependencies = new HashMap<>();
		dependencies.put("x", i);
		dependencies.put("y", j);
		dependencies.put("z", k);
		dependencies.put("world", world);
		dependencies.put("entity", entity);
		dependencies.put("event", event);
		this.executeProcedure(dependencies);
	}
}
