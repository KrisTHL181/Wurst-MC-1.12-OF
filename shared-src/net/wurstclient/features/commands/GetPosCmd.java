/*
 * Copyright © 2014 - 2018 | Wurst-Imperium | All rights reserved.
 *
 * This Source Code Form is subject to the terms of the Mozilla Public
 * License, v. 2.0. If a copy of the MPL was not distributed with this
 * file, You can obtain one at http://mozilla.org/MPL/2.0/.
 */
package net.wurstclient.features.commands;

import java.awt.Toolkit;
import java.awt.datatransfer.StringSelection;

import net.minecraft.util.math.BlockPos;
import net.wurstclient.compatibility.WMinecraft;
import net.wurstclient.events.ChatOutputListener.ChatOutputEvent;
import net.wurstclient.features.Cmd;
import net.wurstclient.features.HelpPage;
import net.wurstclient.utils.ChatUtils;

@HelpPage("Commands/getpos")
public final class GetPosCmd extends Cmd
{
	public GetPosCmd()
	{
		super("getpos",
			"Shows your current position or copies it to the clipboard.",
			"[copy]");
	}
	
	@Override
	public void call(String[] args) throws CmdException
	{
		if(args.length > 1)
			throw new CmdSyntaxError();
		BlockPos blockpos = new BlockPos(WMinecraft.getPlayer());
		String pos =
			blockpos.getX() + " " + blockpos.getY() + " " + blockpos.getZ();
		if(args.length == 0)
			ChatUtils.message("Position: " + pos);
		else if(args.length == 1 && args[0].equalsIgnoreCase("copy"))
		{
			Toolkit.getDefaultToolkit().getSystemClipboard()
				.setContents(new StringSelection(pos), null);
			ChatUtils.message("Position copied to clipboard.");
		}
	}
	
	@Override
	public String getPrimaryAction()
	{
		return "Get Position";
	}
	
	@Override
	public void doPrimaryAction()
	{
		wurst.commands.onSentMessage(new ChatOutputEvent(".getpos", true));
	}
}
