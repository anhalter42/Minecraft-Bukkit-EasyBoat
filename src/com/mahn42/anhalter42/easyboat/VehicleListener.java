/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mahn42.anhalter42.easyboat;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Vehicle;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.vehicle.VehicleDestroyEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.util.Vector;

/**
 *
 * @author andre
 */
class VehicleListener implements Listener {

    public VehicleListener(EasyBoat aThis) {
    }
    
    @EventHandler
    public void vehicleDestroy(VehicleDestroyEvent aEvent) {
        Vehicle lVehicle = aEvent.getVehicle();
        EntityType lET = lVehicle.getType();
        if ( lET == EntityType.BOAT ) {
            if (aEvent.getAttacker() == null) {
                lVehicle.setVelocity(new Vector(0,0,0));
                aEvent.setCancelled(true);
            } else {
                lVehicle.remove();
                aEvent.setCancelled(true);
                ItemStack boatStack = new ItemStack(Material.BOAT, 1);
                Location loc = lVehicle.getLocation();
                loc.getWorld().dropItemNaturally(loc, boatStack);
            }
        }
    } 
}
