package com.github.mo_ink.eoc.commands;

import com.github.mo_ink.eoc.EOC;
import com.github.mo_ink.eoc.network.PacketGuiScreen;
import com.github.mo_ink.eoc.network.PacketTestGuiScreen;
import net.minecraft.command.CommandBase;
import net.minecraft.command.CommandException;
import net.minecraft.command.ICommandSender;
import net.minecraft.entity.player.EntityPlayerMP;
import net.minecraft.server.MinecraftServer;

public class CommandTestGuiScreen extends CommandBase {

	@Override
	public String getName() {
		return "eoctestscreen";
	}

	@Override
	public String getUsage(ICommandSender sender) {
		return "commands.eoktestscreen.usage";
	}

	@Override
	public void execute(MinecraftServer server, ICommandSender sender, String[] args) throws CommandException {
		EntityPlayerMP player = CommandBase.getCommandSenderAsPlayer(sender);
		if(args.length == 1) {
			EOC.getNetwork().sendTo(new PacketGuiScreen(0, args[0]), player);
			return;
		}
		EOC.getNetwork().sendTo(new PacketTestGuiScreen(), player);
	}

	@Override
	public int getRequiredPermissionLevel() {
		return 4;
	}

}
