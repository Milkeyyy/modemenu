
package mod.milkeyyy.modemenu.gui;

import org.lwjgl.opengl.GL11;

import net.minecraftforge.api.distmarker.OnlyIn;
import net.minecraftforge.api.distmarker.Dist;

import net.minecraft.world.World;
import net.minecraft.util.text.StringTextComponent;
import net.minecraft.util.text.ITextComponent;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.client.gui.widget.button.Button;
import net.minecraft.client.gui.screen.inventory.ContainerScreen;
import net.minecraft.client.Minecraft;

import mod.milkeyyy.modemenu.ModemenuModVariables;
import mod.milkeyyy.modemenu.ModemenuMod;

import com.mojang.blaze3d.matrix.MatrixStack;

@OnlyIn(Dist.CLIENT)
public class MainGUIGuiWindow extends ContainerScreen<MainGUIGui.GuiContainerMod> {
	private World world;
	private int x, y, z;
	private PlayerEntity entity;
	public MainGUIGuiWindow(MainGUIGui.GuiContainerMod container, PlayerInventory inventory, ITextComponent text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.xSize = 176;
		this.ySize = 166;
	}

	@Override
	public void render(MatrixStack ms, int mouseX, int mouseY, float partialTicks) {
		this.renderBackground(ms);
		super.render(ms, mouseX, mouseY, partialTicks);
		this.renderHoveredTooltip(ms, mouseX, mouseY);
	}

	@Override
	protected void drawGuiContainerBackgroundLayer(MatrixStack ms, float par1, int par2, int par3) {
		GL11.glColor4f(1, 1, 1, 1);
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeScreen();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	public void tick() {
		super.tick();
	}

	@Override
	protected void drawGuiContainerForegroundLayer(MatrixStack ms, int mouseX, int mouseY) {
		this.font.drawString(ms, "" + ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModemenuModVariables.PlayerVariables())).text_maingui_title_gamemode) + "", -119, -29, -1);
		this.font.drawString(ms, "" + ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModemenuModVariables.PlayerVariables())).text_maingui_title_difficulty) + "", -119, 7, -1);
		this.font.drawString(ms, "" + ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModemenuModVariables.PlayerVariables())).text_maingui_title_time) + "", -119, 43, -1);
		this.font.drawString(ms, "ModEMenu v" + (ModemenuModVariables.version) + "", -119, 178, -10066330);
		this.font.drawString(ms, "" + ((entity.getCapability(ModemenuModVariables.PLAYER_VARIABLES_CAPABILITY, null)
				.orElse(new ModemenuModVariables.PlayerVariables())).text_maingui_title_warntext1) + "", -119, 169, -10066330);
		this.font.drawString(ms, "" + (ModemenuModVariables.buildversion) + " Build (" + (ModemenuModVariables.builddate) + ")", -119, 187,
				-10066330);
	}

	@Override
	public void onClose() {
		super.onClose();
		Minecraft.getInstance().keyboardListener.enableRepeatEvents(false);
	}

	@Override
	public void init(Minecraft minecraft, int width, int height) {
		super.init(minecraft, width, height);
		minecraft.keyboardListener.enableRepeatEvents(true);
		this.addButton(new Button(this.guiLeft + -65, this.guiTop + -20, 54, 20, new StringTextComponent("Creative"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(0, x, y, z));
			MainGUIGui.handleButtonAction(entity, 0, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + -20, 54, 20, new StringTextComponent("Adventure"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(1, x, y, z));
			MainGUIGui.handleButtonAction(entity, 1, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + -119, this.guiTop + -20, 54, 20, new StringTextComponent("Survival"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(2, x, y, z));
			MainGUIGui.handleButtonAction(entity, 2, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + -20, 54, 20, new StringTextComponent("Spectator"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(3, x, y, z));
			MainGUIGui.handleButtonAction(entity, 3, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + -119, this.guiTop + 16, 54, 20, new StringTextComponent("Peaceful"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(4, x, y, z));
			MainGUIGui.handleButtonAction(entity, 4, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + -65, this.guiTop + 16, 54, 20, new StringTextComponent("Easy"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(5, x, y, z));
			MainGUIGui.handleButtonAction(entity, 5, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 16, 54, 20, new StringTextComponent("Normal"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(6, x, y, z));
			MainGUIGui.handleButtonAction(entity, 6, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 16, 54, 20, new StringTextComponent("Hard"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(7, x, y, z));
			MainGUIGui.handleButtonAction(entity, 7, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + -119, this.guiTop + 52, 54, 20, new StringTextComponent("Day"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(8, x, y, z));
			MainGUIGui.handleButtonAction(entity, 8, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + -65, this.guiTop + 52, 54, 20, new StringTextComponent("Night"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(9, x, y, z));
			MainGUIGui.handleButtonAction(entity, 9, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + -11, this.guiTop + 52, 54, 20, new StringTextComponent("Midnight"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(10, x, y, z));
			MainGUIGui.handleButtonAction(entity, 10, x, y, z);
		}));
		this.addButton(new Button(this.guiLeft + 42, this.guiTop + 52, 54, 20, new StringTextComponent("+1000"), e -> {
			ModemenuMod.PACKET_HANDLER.sendToServer(new MainGUIGui.ButtonPressedMessage(11, x, y, z));
			MainGUIGui.handleButtonAction(entity, 11, x, y, z);
		}));
	}
}
