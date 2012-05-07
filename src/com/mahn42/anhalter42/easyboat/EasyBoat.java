/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahn42.anhalter42.easyboat;

import org.bukkit.plugin.java.JavaPlugin;

/**
 *
 * @author andre
 */
public class EasyBoat extends JavaPlugin {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
    }
    
    @Override
    public void onEnable() { 
        this.getServer().getPluginManager().registerEvents(new VehicleListener(this), this);
    }
}
