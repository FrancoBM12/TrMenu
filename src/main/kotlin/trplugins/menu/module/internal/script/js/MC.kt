package trplugins.menu.module.internal.script.js

import com.francobm.magicosmetics.api.MagicAPI
import org.bukkit.Bukkit
import org.bukkit.Material
import org.bukkit.entity.Player
import org.bukkit.inventory.ItemStack


/**
 * @author FrancoBM
 * @date 2022/03/18 00:51
 */
class MC {
    companion object {

        val INSTANCE = MC()

    }

    // magicApi.getEquipped("FrancoBM", HAT)
    fun getEquipped(name: String, type: String): ItemStack? {
        return MagicAPI.getEquipped(name, type)
    }

    fun getCosmetic(id: String): ItemStack? {
        return MagicAPI.getCosmeticItem(id);
    }

    fun hasCosmetic(id: String): Boolean {
        val item = getCosmetic(id)
        return !(item == null || item.type == Material.AIR)
    }

    fun hasEquipped(name: String, type: String): Boolean {
        val item = getEquipped(name, type)
        return !(item == null || item.type == Material.AIR)
    }

    fun hasCosmetic(name: String, id: String): Boolean? {
        return getPlayer(name)?.run { MagicAPI.hasCosmetic(this, id) }
    }

    fun getPlayerAllCosmeticsAvailable(name: String): Int? {
        return getPlayer(name)?.run { MagicAPI.getPlayerAllCosmeticsAvailable(this) }
    }

    fun getServerAllCosmeticsAvailable(): Int {
        return MagicAPI.getServerAllCosmeticsAvailable()
    }

    private fun getPlayer(player: String): Player? {
        return Bukkit.getPlayerExact(player)
    }


}