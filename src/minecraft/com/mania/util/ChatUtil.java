package com.mania.util;

import com.mania.MCHook;
import com.mania.Mania;

import net.minecraft.util.text.TextComponentString;

public class ChatUtil implements MCHook {
	
	public static void printClient(String message) {
		//mc.player.addChatMessage(new TextComponentString(String.format("��9[%s]%s", Mania.name, message)));
	}
	
	public static void printDebug(String message) {
		//mc.player.addChatMessage(new TextComponentString(String.format("��4[DEBUG]��f%s", message)));
	}

}
