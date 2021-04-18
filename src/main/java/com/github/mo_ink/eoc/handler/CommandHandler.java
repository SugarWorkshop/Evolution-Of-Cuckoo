package com.github.mo_ink.eoc.handler;

import com.github.mo_ink.eoc.commands.CommandTestGuiScreen;
import net.minecraftforge.fml.common.event.FMLServerStartingEvent;

public class CommandHandler {
	public static void registerCommands(FMLServerStartingEvent event) {
		event.registerServerCommand(new CommandTestGuiScreen());
	}
}
