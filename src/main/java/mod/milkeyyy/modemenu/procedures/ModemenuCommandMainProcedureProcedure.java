package mod.milkeyyy.modemenu.procedures;

import net.minecraftforge.fml.network.NetworkHooks;

import net.minecraft.world.IWorld;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.util.math.BlockPos;
import net.minecraft.network.PacketBuffer;
import net.minecraft.inventory.container.INamedContainerProvider;
import net.minecraft.inventory.container.Container;
import net.minecraft.entity.player.ServerPlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.Entity;

import mod.milkeyyy.modemenu.gui.MainGUIGui;
import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuModElements;
import mod.milkeyyy.modemenu.ModemenuMod;

import java.util.Map;
import java.util.HashMap;

import io.netty.buffer.Unpooled;

@ModemenuModElements.ModElement.Tag
public class ModemenuCommandMainProcedureProcedure extends ModemenuModElements.ModElement {
	public ModemenuCommandMainProcedureProcedure(ModemenuModElements instance) {
		super(instance, 3);
	}

	public static void executeProcedure(Map<String, Object> dependencies) {
		if (dependencies.get("entity") == null) {
			if (!dependencies.containsKey("entity"))
				ModemenuMod.LOGGER.warn("Failed to load dependency entity for procedure ModemenuCommandMainProcedure!");
			return;
		}
		if (dependencies.get("cmdparams") == null) {
			if (!dependencies.containsKey("cmdparams"))
				ModemenuMod.LOGGER.warn("Failed to load dependency cmdparams for procedure ModemenuCommandMainProcedure!");
			return;
		}
		if (dependencies.get("x") == null) {
			if (!dependencies.containsKey("x"))
				ModemenuMod.LOGGER.warn("Failed to load dependency x for procedure ModemenuCommandMainProcedure!");
			return;
		}
		if (dependencies.get("y") == null) {
			if (!dependencies.containsKey("y"))
				ModemenuMod.LOGGER.warn("Failed to load dependency y for procedure ModemenuCommandMainProcedure!");
			return;
		}
		if (dependencies.get("z") == null) {
			if (!dependencies.containsKey("z"))
				ModemenuMod.LOGGER.warn("Failed to load dependency z for procedure ModemenuCommandMainProcedure!");
			return;
		}
		if (dependencies.get("world") == null) {
			if (!dependencies.containsKey("world"))
				ModemenuMod.LOGGER.warn("Failed to load dependency world for procedure ModemenuCommandMainProcedure!");
			return;
		}
		Entity entity = (Entity) dependencies.get("entity");
		HashMap cmdparams = (HashMap) dependencies.get("cmdparams");
		double x = dependencies.get("x") instanceof Integer ? (int) dependencies.get("x") : (double) dependencies.get("x");
		double y = dependencies.get("y") instanceof Integer ? (int) dependencies.get("y") : (double) dependencies.get("y");
		double z = dependencies.get("z") instanceof Integer ? (int) dependencies.get("z") : (double) dependencies.get("z");
		IWorld world = (IWorld) dependencies.get("world");
		if ((((new Object() {
			public String getText() {
				String param = (String) cmdparams.get("0");
				if (param != null) {
					return param;
				}
				return "";
			}
		}.getText())).equals(""))) {
			if ((entity.hasPermissionLevel((int) 4))) {
				{
					Entity _ent = entity;
					if (_ent instanceof ServerPlayerEntity) {
						BlockPos _bpos = new BlockPos((int) x, (int) y, (int) z);
						NetworkHooks.openGui((ServerPlayerEntity) _ent, new INamedContainerProvider() {
							@Override
							public ITextComponent getDisplayName() {
								return new StringTextComponent("MainGUI");
							}

							@Override
							public Container createMenu(int id, PlayerInventory inventory, PlayerEntity player) {
								return new MainGUIGui.GuiContainerMod(id, inventory, new PacketBuffer(Unpooled.buffer()).writeBlockPos(_bpos));
							}
						}, _bpos);
					}
				}
			} else {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity)
							.sendStatusMessage(
									new StringTextComponent((("[\u00A79ModEMenu\u00A7r] ") + ""
											+ (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
													.orElse(new ModemenuModVariables.PlayerVariables())).text_message_openguineedpermission)))),
									(false));
				}
			}
		} else {
			if ((((new Object() {
				public String getText() {
					String param = (String) cmdparams.get("0");
					if (param != null) {
						return param;
					}
					return "";
				}
			}.getText())).equals("version"))) {
				if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
					((PlayerEntity) entity).sendStatusMessage(new StringTextComponent((("[\u00A79ModEMenu\u00A7r] ") + ""
							+ (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
									.orElse(new ModemenuModVariables.PlayerVariables())).text_command_version_installedversion))
							+ "" + ((ModemenuModVariables.version)))), (false));
				}
			} else {
				if ((((new Object() {
					public String getText() {
						String param = (String) cmdparams.get("0");
						if (param != null) {
							return param;
						}
						return "";
					}
				}.getText())).equals("about"))) {
					if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
						((PlayerEntity) entity)
								.sendStatusMessage(
										new StringTextComponent((("[\u00A79ModEMenu\u00A7r] ") + ""
												+ (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new ModemenuModVariables.PlayerVariables())).text_command_version_installedversion))
												+ "" + ((ModemenuModVariables.version)) + ""
												+ (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
														.orElse(new ModemenuModVariables.PlayerVariables())).text_command_about_createdby)))),
										(false));
					}
				} else {
					if ((((new Object() {
						public String getText() {
							String param = (String) cmdparams.get("0");
							if (param != null) {
								return param;
							}
							return "";
						}
					}.getText())).equals("help"))) {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent(
													(("[\u00A79ModEMenu\u00A7r] ") + ""
															+ (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
																	.orElse(new ModemenuModVariables.PlayerVariables())).text_command_help_wip)))),
											(false));
						}
					} else {
						if (entity instanceof PlayerEntity && !entity.world.isRemote()) {
							((PlayerEntity) entity)
									.sendStatusMessage(
											new StringTextComponent((("[\u00A79ModEMenu\u00A7r] ") + ""
													+ (((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
															.orElse(new ModemenuModVariables.PlayerVariables())).text_command_invalid_command)))),
											(false));
						}
					}
				}
			}
		}
	}
}
