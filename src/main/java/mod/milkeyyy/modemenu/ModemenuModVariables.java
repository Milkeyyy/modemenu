package mod.milkeyyy.modemenu;

import net.minecraftforge.fml.network.PacketDistributor;
import net.minecraftforge.fml.network.NetworkEvent;
import net.minecraftforge.fml.javafmlmod.FMLJavaModLoadingContext;
import net.minecraftforge.fml.event.lifecycle.FMLCommonSetupEvent;
import net.minecraftforge.eventbus.api.SubscribeEvent;
import net.minecraftforge.event.entity.player.PlayerEvent;
import net.minecraftforge.event.AttachCapabilitiesEvent;
import net.minecraftforge.common.util.LazyOptional;
import net.minecraftforge.common.util.FakePlayer;
import net.minecraftforge.common.capabilities.ICapabilitySerializable;
import net.minecraftforge.common.capabilities.CapabilityManager;
import net.minecraftforge.common.capabilities.CapabilityInject;
import net.minecraftforge.common.capabilities.Capability;

import net.minecraft.util.ResourceLocation;
import net.minecraft.util.Direction;
import net.minecraft.network.PacketBuffer;
import net.minecraft.nbt.INBT;
import net.minecraft.nbt.CompoundNBT;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;
import net.minecraft.client.Minecraft;

import java.util.function.Supplier;

public class ModemenuModVariables {
	public ModemenuModVariables(ModemenuModElements elements) {
		elements.addNetworkMessage(PlayerVariablesSyncMessage.class, PlayerVariablesSyncMessage::buffer, PlayerVariablesSyncMessage::new,
				PlayerVariablesSyncMessage::handler);
		FMLJavaModLoadingContext.get().getModEventBus().addListener(this::init);
	}

	private void init(FMLCommonSetupEvent event) {
		CapabilityManager.INSTANCE.register(PlayerVariables.class, new PlayerVariablesStorage(), PlayerVariables::new);
	}
	public static String builddate = "2021/03/10";
	public static String buildversion = "Test";
	public static String version = "1.0.0-test2";
	@CapabilityInject(PlayerVariables.class)
	public static Capability<PlayerVariables> PLAYER_VARIABLES_CAPABILITY = null;
	@SubscribeEvent
	public void onAttachCapabilities(AttachCapabilitiesEvent<Entity> event) {
		if (event.getObject() instanceof PlayerEntity && !(event.getObject() instanceof FakePlayer))
			event.addCapability(new ResourceLocation("modemenu", "player_variables"), new PlayerVariablesProvider());
	}
	private static class PlayerVariablesProvider implements ICapabilitySerializable<INBT> {
		private final LazyOptional<PlayerVariables> instance = LazyOptional.of(PLAYER_VARIABLES_CAPABILITY::getDefaultInstance);
		@Override
		public <T> LazyOptional<T> getCapability(Capability<T> cap, Direction side) {
			return cap == PLAYER_VARIABLES_CAPABILITY ? instance.cast() : LazyOptional.empty();
		}

		@Override
		public INBT serializeNBT() {
			return PLAYER_VARIABLES_CAPABILITY.getStorage().writeNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new),
					null);
		}

		@Override
		public void deserializeNBT(INBT nbt) {
			PLAYER_VARIABLES_CAPABILITY.getStorage().readNBT(PLAYER_VARIABLES_CAPABILITY, this.instance.orElseThrow(RuntimeException::new), null,
					nbt);
		}
	}

	private static class PlayerVariablesStorage implements Capability.IStorage<PlayerVariables> {
		@Override
		public INBT writeNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side) {
			CompoundNBT nbt = new CompoundNBT();
			nbt.putDouble("maingui_player_select_difficulty", instance.maingui_player_select_difficulty);
			nbt.putDouble("maingui_player_select_gamemode", instance.maingui_player_select_gamemode);
			nbt.putDouble("maingui_player_select_time", instance.maingui_player_select_time);
			nbt.putString("text_command_about_createdby", instance.text_command_about_createdby);
			nbt.putString("text_command_help_wip", instance.text_command_help_wip);
			nbt.putString("text_command_version_installedversion", instance.text_command_version_installedversion);
			nbt.putString("text_joinplayer_loaded", instance.text_joinplayer_loaded);
			nbt.putString("text_maingui_title_difficulty", instance.text_maingui_title_difficulty);
			nbt.putString("text_maingui_title_gamemode", instance.text_maingui_title_gamemode);
			nbt.putString("text_maingui_title_time", instance.text_maingui_title_time);
			nbt.putString("text_maingui_title_warntext1", instance.text_maingui_title_warntext1);
			nbt.putString("text_message_changedifficulty", instance.text_message_changedifficulty);
			nbt.putString("text_message_changedifficulty2", instance.text_message_changedifficulty2);
			nbt.putString("text_message_changegamemode", instance.text_message_changegamemode);
			nbt.putString("text_message_changegamemode2", instance.text_message_changegamemode2);
			nbt.putString("text_message_openguineedpermission", instance.text_message_openguineedpermission);
			nbt.putString("text_message_timeadd", instance.text_message_timeadd);
			nbt.putString("text_message_timeadd2", instance.text_message_timeadd2);
			nbt.putString("text_message_timeset", instance.text_message_timeset);
			nbt.putString("text_message_timeset2", instance.text_message_timeset2);
			nbt.putString("text_command_invalid_command", instance.text_command_invalid_command);
			return nbt;
		}

		@Override
		public void readNBT(Capability<PlayerVariables> capability, PlayerVariables instance, Direction side, INBT inbt) {
			CompoundNBT nbt = (CompoundNBT) inbt;
			instance.maingui_player_select_difficulty = nbt.getDouble("maingui_player_select_difficulty");
			instance.maingui_player_select_gamemode = nbt.getDouble("maingui_player_select_gamemode");
			instance.maingui_player_select_time = nbt.getDouble("maingui_player_select_time");
			instance.text_command_about_createdby = nbt.getString("text_command_about_createdby");
			instance.text_command_help_wip = nbt.getString("text_command_help_wip");
			instance.text_command_version_installedversion = nbt.getString("text_command_version_installedversion");
			instance.text_joinplayer_loaded = nbt.getString("text_joinplayer_loaded");
			instance.text_maingui_title_difficulty = nbt.getString("text_maingui_title_difficulty");
			instance.text_maingui_title_gamemode = nbt.getString("text_maingui_title_gamemode");
			instance.text_maingui_title_time = nbt.getString("text_maingui_title_time");
			instance.text_maingui_title_warntext1 = nbt.getString("text_maingui_title_warntext1");
			instance.text_message_changedifficulty = nbt.getString("text_message_changedifficulty");
			instance.text_message_changedifficulty2 = nbt.getString("text_message_changedifficulty2");
			instance.text_message_changegamemode = nbt.getString("text_message_changegamemode");
			instance.text_message_changegamemode2 = nbt.getString("text_message_changegamemode2");
			instance.text_message_openguineedpermission = nbt.getString("text_message_openguineedpermission");
			instance.text_message_timeadd = nbt.getString("text_message_timeadd");
			instance.text_message_timeadd2 = nbt.getString("text_message_timeadd2");
			instance.text_message_timeset = nbt.getString("text_message_timeset");
			instance.text_message_timeset2 = nbt.getString("text_message_timeset2");
			instance.text_command_invalid_command = nbt.getString("text_command_invalid_command");
		}
	}

	public static class PlayerVariables {
		public double maingui_player_select_difficulty = 0.0;
		public double maingui_player_select_gamemode = 0.0;
		public double maingui_player_select_time = 0.0;
		public String text_command_about_createdby = "";
		public String text_command_help_wip = "";
		public String text_command_version_installedversion = "";
		public String text_joinplayer_loaded = "";
		public String text_maingui_title_difficulty = "";
		public String text_maingui_title_gamemode = "";
		public String text_maingui_title_time = "";
		public String text_maingui_title_warntext1 = "";
		public String text_message_changedifficulty = "";
		public String text_message_changedifficulty2 = "";
		public String text_message_changegamemode = "";
		public String text_message_changegamemode2 = "";
		public String text_message_openguineedpermission = "";
		public String text_message_timeadd = "";
		public String text_message_timeadd2 = "";
		public String text_message_timeset = "";
		public String text_message_timeset2 = "";
		public String text_command_invalid_command = "";
		public void syncPlayerVariables(Entity entity) {
			if (entity instanceof ServerPlayerEntity)
				ModemenuMod.PACKET_HANDLER.send(PacketDistributor.PLAYER.with(() -> (ServerPlayerEntity) entity),
						new PlayerVariablesSyncMessage(this));
		}
	}
	@SubscribeEvent
	public void onPlayerLoggedInSyncPlayerVariables(PlayerEvent.PlayerLoggedInEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerRespawnedSyncPlayerVariables(PlayerEvent.PlayerRespawnEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void onPlayerChangedDimensionSyncPlayerVariables(PlayerEvent.PlayerChangedDimensionEvent event) {
		if (!event.getPlayer().world.isRemote())
			((PlayerVariables) event.getPlayer().getCapability(PLAYER_VARIABLES_CAPABILITY, null).orElse(new PlayerVariables()))
					.syncPlayerVariables(event.getPlayer());
	}

	@SubscribeEvent
	public void clonePlayer(PlayerEvent.Clone event) {
		if (event.isWasDeath()) {
			PlayerVariables original = ((PlayerVariables) event.getOriginal().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			PlayerVariables clone = ((PlayerVariables) event.getEntity().getCapability(PLAYER_VARIABLES_CAPABILITY, null)
					.orElse(new PlayerVariables()));
			clone.text_command_about_createdby = original.text_command_about_createdby;
			clone.text_command_help_wip = original.text_command_help_wip;
			clone.text_command_version_installedversion = original.text_command_version_installedversion;
			clone.text_joinplayer_loaded = original.text_joinplayer_loaded;
			clone.text_maingui_title_difficulty = original.text_maingui_title_difficulty;
			clone.text_maingui_title_gamemode = original.text_maingui_title_gamemode;
			clone.text_maingui_title_time = original.text_maingui_title_time;
			clone.text_maingui_title_warntext1 = original.text_maingui_title_warntext1;
			clone.text_message_changedifficulty = original.text_message_changedifficulty;
			clone.text_message_changedifficulty2 = original.text_message_changedifficulty2;
			clone.text_message_changegamemode = original.text_message_changegamemode;
			clone.text_message_changegamemode2 = original.text_message_changegamemode2;
			clone.text_message_openguineedpermission = original.text_message_openguineedpermission;
			clone.text_message_timeadd = original.text_message_timeadd;
			clone.text_message_timeadd2 = original.text_message_timeadd2;
			clone.text_message_timeset = original.text_message_timeset;
			clone.text_message_timeset2 = original.text_message_timeset2;
			clone.text_command_invalid_command = original.text_command_invalid_command;
		}
	}
	public static class PlayerVariablesSyncMessage {
		public PlayerVariables data;
		public PlayerVariablesSyncMessage(PacketBuffer buffer) {
			this.data = new PlayerVariables();
			new PlayerVariablesStorage().readNBT(null, this.data, null, buffer.readCompoundTag());
		}

		public PlayerVariablesSyncMessage(PlayerVariables data) {
			this.data = data;
		}

		public static void buffer(PlayerVariablesSyncMessage message, PacketBuffer buffer) {
			buffer.writeCompoundTag((CompoundNBT) new PlayerVariablesStorage().writeNBT(null, message.data, null));
		}

		public static void handler(PlayerVariablesSyncMessage message, Supplier<NetworkEvent.Context> contextSupplier) {
			NetworkEvent.Context context = contextSupplier.get();
			context.enqueueWork(() -> {
				if (!context.getDirection().getReceptionSide().isServer()) {
					PlayerVariables variables = ((PlayerVariables) Minecraft.getInstance().player.getCapability(PLAYER_VARIABLES_CAPABILITY, null)
							.orElse(new PlayerVariables()));
					variables.maingui_player_select_difficulty = message.data.maingui_player_select_difficulty;
					variables.maingui_player_select_gamemode = message.data.maingui_player_select_gamemode;
					variables.maingui_player_select_time = message.data.maingui_player_select_time;
					variables.text_command_about_createdby = message.data.text_command_about_createdby;
					variables.text_command_help_wip = message.data.text_command_help_wip;
					variables.text_command_version_installedversion = message.data.text_command_version_installedversion;
					variables.text_joinplayer_loaded = message.data.text_joinplayer_loaded;
					variables.text_maingui_title_difficulty = message.data.text_maingui_title_difficulty;
					variables.text_maingui_title_gamemode = message.data.text_maingui_title_gamemode;
					variables.text_maingui_title_time = message.data.text_maingui_title_time;
					variables.text_maingui_title_warntext1 = message.data.text_maingui_title_warntext1;
					variables.text_message_changedifficulty = message.data.text_message_changedifficulty;
					variables.text_message_changedifficulty2 = message.data.text_message_changedifficulty2;
					variables.text_message_changegamemode = message.data.text_message_changegamemode;
					variables.text_message_changegamemode2 = message.data.text_message_changegamemode2;
					variables.text_message_openguineedpermission = message.data.text_message_openguineedpermission;
					variables.text_message_timeadd = message.data.text_message_timeadd;
					variables.text_message_timeadd2 = message.data.text_message_timeadd2;
					variables.text_message_timeset = message.data.text_message_timeset;
					variables.text_message_timeset2 = message.data.text_message_timeset2;
					variables.text_command_invalid_command = message.data.text_command_invalid_command;
				}
			});
			context.setPacketHandled(true);
		}
	}
}
