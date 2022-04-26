package nazo.utils;

import net.minecraft.network.play.client.C01PacketChatMessage;
import net.minecraft.util.ChatComponentText;
import net.minecraft.util.IChatComponent;

public class ChatUtils implements MCHook {

    public static void printChat(String text) {
        mc.thePlayer.addChatMessage(new ChatComponentText(text));
    }
    
    public static void printChatDebug(String text) {
    	mc.thePlayer.addChatMessage(new ChatComponentText("��4[DEBUG] > ��f"+text));
    }

    public static void printChatprefix(String text) {
        mc.thePlayer.addChatMessage(new ChatComponentText("��3[Nazo] > ��f" + text));
    }

    public static void sendChat_NoFilter(String text) {
        mc.thePlayer.sendQueue.addToSendQueue(new C01PacketChatMessage(text));
    }

    public static void sendChat(String text) {
        mc.thePlayer.sendChatMessage(text);
    }
}
