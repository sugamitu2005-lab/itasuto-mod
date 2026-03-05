// src/main/java/com/example/itast/ItastMod.java
@Mod.EventBusSubscriber(modid = "itast")
public class ItastMod {
    
    @SubscribeEvent
    public static void onPlayerTick(TickEvent.PlayerTickEvent event) {
        // プレイヤーが止まっているか、移動中かなどを判定して
        // 盤面処理を呼び出すエントリーポイントになります
    }
}
