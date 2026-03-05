// src/main/java/com/example/itast/logic/DiceHandler.java
package com.example.itast.logic;

import net.minecraft.world.entity.player.Player;
import net.minecraft.network.chat.Component;
import java.util.Random;

public class DiceHandler {
    private static final Random RANDOM = new Random();

    // サイコロを振るメソッド
    public static void rollDice(Player player) {
        int result = RANDOM.nextInt(6) + 1; // 1〜6の乱数
        player.sendSystemMessage(Component.literal("サイコロの目: " + result));
        
        // 出た目の数だけ移動を開始する（簡易版：テレポート）
        movePlayer(player, result);
    }

    private static void movePlayer(Player player, int steps) {
        // 本来は「道（レールや特定のブロック）」を辿る処理が必要ですが、
        // 最初は「向いている方向にsteps分だけ進む」という処理でテストします
        double targetX = player.getX() + (player.getLookAngle().x * steps);
        double targetZ = player.getZ() + (player.getLookAngle().z * steps);
        
        player.teleportTo(targetX, player.getY(), targetZ);
        player.sendSystemMessage(Component.literal(steps + "マス移動しました！"));
    }
}
